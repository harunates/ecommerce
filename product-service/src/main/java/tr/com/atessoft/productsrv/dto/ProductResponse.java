package tr.com.atessoft.productsrv.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(Include.NON_NULL)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
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
	private Date created_at;
}
