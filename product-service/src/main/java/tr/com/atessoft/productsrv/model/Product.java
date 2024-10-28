package tr.com.atessoft.productsrv.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String body_html;
	private String img;
	private String tags;
	private String vendor;
	private String product_type;
	private String cost;
	private String price;
	private String compare_at_price;
	private Integer quantity;
	private String sku;
	private String barcode;
	@CreationTimestamp
	private Date created_at;
}
