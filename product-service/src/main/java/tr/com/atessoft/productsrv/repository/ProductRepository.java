package tr.com.atessoft.productsrv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.com.atessoft.productsrv.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
