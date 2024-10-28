package tr.com.atessoft.productsrv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tr.com.atessoft.productsrv.dto.InventoryRequest;
import tr.com.atessoft.productsrv.dto.InventorySet;
import tr.com.atessoft.productsrv.dto.LineItemDto;
import tr.com.atessoft.productsrv.exception.AppException;
import tr.com.atessoft.productsrv.exception.AppExceptionNotFound;
import tr.com.atessoft.productsrv.model.Product;
import tr.com.atessoft.productsrv.repository.ProductRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

	private final ProductRepository productRepository;

	@Transactional
	public boolean isAvailable(List<LineItemDto> lineItems) throws AppException {
		// check if all items in stocks
		for (LineItemDto dto : lineItems) {
			Optional<Product> productOptional = productRepository.findById(dto.getId());
			if (!productOptional.isPresent())
				throw new AppExceptionNotFound();

			Product product = productOptional.get();
			if (product.getQuantity() < dto.getQuantity())
				return false; // out of stock
		}

		// adjust quantities
		for (LineItemDto dto : lineItems) {
			adjust(InventoryRequest.builder().id(dto.getId()).adjustment(-dto.getQuantity()).build());
		}
		return true;
	}

	public void adjust(InventoryRequest req) throws AppException {
		Optional<Product> productOptional = productRepository.findById(req.getId());
		if (!productOptional.isPresent())
			throw new AppExceptionNotFound();

		Product product = productOptional.get();
		product.setQuantity(product.getQuantity() + req.getAdjustment());
		productRepository.save(product);
	}

	public void set(InventorySet set) throws AppException {
		Optional<Product> productOptional = productRepository.findById(set.getId());
		if (!productOptional.isPresent())
			throw new AppExceptionNotFound();

		Product product = productOptional.get();
		product.setQuantity(set.getQuantity());
		productRepository.save(product);
	}
}
