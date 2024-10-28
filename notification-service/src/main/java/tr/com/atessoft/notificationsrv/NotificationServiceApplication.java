package tr.com.atessoft.notificationsrv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import lombok.extern.slf4j.Slf4j;
import tr.com.atessoft.notificationsrv.event.OrderCreatedEvent;

@SpringBootApplication
@Slf4j
public class NotificationServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    @KafkaListener(topics = "notificationTopic")
    public void handleNotification(OrderCreatedEvent orderCreatedEvent) {
        // Send out an email notification
        log.info("Received Notification for Order - {}", orderCreatedEvent.getId());
    }
}
