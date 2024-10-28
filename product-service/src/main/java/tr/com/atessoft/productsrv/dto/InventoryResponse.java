package tr.com.atessoft.productsrv.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryResponse {
	private Long id;
	private boolean available;
}
