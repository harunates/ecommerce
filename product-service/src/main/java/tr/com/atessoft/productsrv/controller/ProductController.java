package tr.com.atessoft.productsrv.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tr.com.atessoft.productsrv.dto.ProductRequest;
import tr.com.atessoft.productsrv.dto.ProductResponse;
import tr.com.atessoft.productsrv.exception.AppException;
import tr.com.atessoft.productsrv.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@CrossOrigin
public class ProductController {

	private final ProductService productService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductResponse createProduct(@RequestBody ProductRequest productRequest) throws AppException {
		return productService.createProduct(productRequest);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProductResponse updateProduct(@RequestBody ProductRequest productRequest, @PathVariable Long id)
			throws AppException {
		return productService.updateProduct(productRequest, id);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ProductResponse> getAllProducts() throws AppException {
		return productService.getAllProducts();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProductResponse getProduct(@PathVariable Long id) throws AppException {
		return productService.getProduct(id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable Long id) throws AppException {
		productService.deleteProduct(id);
	}

}
