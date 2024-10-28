package tr.com.atessoft.ordersrv.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import lombok.RequiredArgsConstructor;
import tr.com.atessoft.ordersrv.dto.OrderRequest;
import tr.com.atessoft.ordersrv.event.OrderCreatedEvent;
import tr.com.atessoft.ordersrv.model.Order;
import tr.com.atessoft.ordersrv.repository.OrderRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

	private final OrderRepository orderRepository;
	private final WebClient.Builder webClientBuilder;
	private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

	public String createOrder(OrderRequest orderRequest) {
		try {
			// Call Inventory service, and create order if product is available
			boolean allProductsAvailable = webClientBuilder.build().post()
					.uri("http://product-service/api/v1/inventory/available").bodyValue(orderRequest.getLineItems())
					.retrieve().bodyToMono(Boolean.class).block();

			if (allProductsAvailable) {
				Order order = new Order();
				order.setOrderNumber(UUID.randomUUID().toString());
				double price = new Random().nextDouble(100) + 10;// connect products database required
				String priceStr = price + "";
				order.setTotalPrice(priceStr.substring(0, Math.min(5, priceStr.length())));
				order.setStatus("preparing");
				ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
				order.setLineItems(ow.writeValueAsString(orderRequest.getLineItems()));

				orderRepository.save(order);

				// Send order to the kafka topic
				kafkaTemplate.send("notificationTopic", new OrderCreatedEvent(order.getId()));

				return "Order Created Successfully!";
			} else {
				throw new IllegalArgumentException("Product is not available, please try again later!");
			}
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Something went wrong!");
		}
	}

}
