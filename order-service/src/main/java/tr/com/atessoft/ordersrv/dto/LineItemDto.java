package tr.com.atessoft.ordersrv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineItemDto {
	private Long id;
	private Integer quantity;
}
