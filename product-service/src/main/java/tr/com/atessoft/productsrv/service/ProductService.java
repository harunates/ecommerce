package tr.com.atessoft.productsrv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tr.com.atessoft.productsrv.dto.ProductRequest;
import tr.com.atessoft.productsrv.dto.ProductResponse;
import tr.com.atessoft.productsrv.exception.AppException;
import tr.com.atessoft.productsrv.exception.AppExceptionBadRequest;
import tr.com.atessoft.productsrv.exception.AppExceptionNotFound;
import tr.com.atessoft.productsrv.model.Product;
import tr.com.atessoft.productsrv.repository.ProductRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

	private final ProductRepository productRepository;

	public ProductResponse createProduct(ProductRequest req) throws AppException {
		if (ObjectUtils.isEmpty(req.getTitle()))
			throw new AppExceptionBadRequest("'title' is required!");
		if (ObjectUtils.isEmpty(req.getPrice()))
			throw new AppExceptionBadRequest("'price' is required!");
		if (req.getQuantity() == null)
			req.setQuantity(0);

		Product product = buildEntity(req);

		Product created = productRepository.save(product);
		log.info("Product {} created!", product.getId());
		return mapToProductResponse(created);
	}

	public ProductResponse updateProduct(ProductRequest req, Long id) throws AppException {
		Optional<Product> productOptional = productRepository.findById(id);
		if (!productOptional.isPresent())
			throw new AppExceptionNotFound();

		Product product = productOptional.get();

		if (!ObjectUtils.isEmpty(req.getTitle()))
			product.setTitle(req.getTitle());
		if (!ObjectUtils.isEmpty(req.getBody_html()))
			product.setBody_html(req.getBody_html());
		if (!ObjectUtils.isEmpty(req.getImg()))
			product.setImg(req.getImg());
		if (!ObjectUtils.isEmpty(req.getTags()))
			product.setTags(req.getTags());
		if (!ObjectUtils.isEmpty(req.getVendor()))
			product.setVendor(req.getVendor());
		if (!ObjectUtils.isEmpty(req.getProduct_type()))
			product.setProduct_type(req.getProduct_type());
		if (!ObjectUtils.isEmpty(req.getCost()))
			product.setCost(req.getCost());
		if (!ObjectUtils.isEmpty(req.getPrice()))
			product.setPrice(req.getPrice());
		if (!ObjectUtils.isEmpty(req.getCompare_at_price()))
			product.setCompare_at_price(req.getCompare_at_price());
		if (!ObjectUtils.isEmpty(req.getQuantity()))
			product.setQuantity(req.getQuantity());
		if (!ObjectUtils.isEmpty(req.getSku()))
			product.setSku(req.getSku());
		if (!ObjectUtils.isEmpty(req.getBarcode()))
			product.setBarcode(req.getBarcode());

		Product updated = productRepository.save(product);
		log.info("Product {} updated!", id);
		return mapToProductResponse(updated);
	}

	public List<ProductResponse> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(this::mapToProductResponse).toList();
	}

	public ProductResponse getProduct(Long id) throws AppException {
		Optional<Product> product = productRepository.findById(id);
		if (!product.isPresent())
			throw new AppExceptionNotFound();
		return mapToProductResponse(product.get());
	}

	public void deleteProduct(Long id) throws AppException {
		Optional<Product> productOptional = productRepository.findById(id);
		if (!productOptional.isPresent())
			throw new AppExceptionNotFound();

		productRepository.deleteById(id);
		log.info("Product {} deleted!", id);
	}

	private ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder().id(product.getId()).title(product.getTitle()).body_html(product.getBody_html())
				.img(product.getImg()).tags(product.getTags()).vendor(product.getVendor())
				.product_type(product.getProduct_type()).cost(product.getCost()).price(product.getPrice())
				.compare_at_price(product.getCompare_at_price()).quantity(product.getQuantity()).sku(product.getSku())
				.barcode(product.getBarcode()).created_at(product.getCreated_at()).build();
	}

	private Product buildEntity(ProductRequest req) {
		Product product = Product.builder().title(req.getTitle()).body_html(req.getBody_html()).img(req.getImg())
				.tags(req.getTags()).vendor(req.getVendor()).product_type(req.getProduct_type()).cost(req.getCost())
				.price(req.getPrice()).compare_at_price(req.getCompare_at_price()).quantity(req.getQuantity())
				.sku(req.getSku()).barcode(req.getBarcode()).build();
		return product;
	}

}
