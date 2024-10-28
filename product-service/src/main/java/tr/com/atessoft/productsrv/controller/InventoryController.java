package tr.com.atessoft.productsrv.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tr.com.atessoft.productsrv.dto.InventoryRequest;
import tr.com.atessoft.productsrv.dto.InventorySet;
import tr.com.atessoft.productsrv.dto.LineItemDto;
import tr.com.atessoft.productsrv.exception.AppException;
import tr.com.atessoft.productsrv.service.InventoryService;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {

	private final InventoryService inventoryService;

	@PostMapping("/available")
	@ResponseStatus(HttpStatus.OK)
	public boolean isAvailable(@RequestBody List<LineItemDto> lineItems) throws AppException {
		return inventoryService.isAvailable(lineItems);
	}

	@PostMapping("/adjust")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void adjust(@RequestBody InventoryRequest inventoryRequest) throws AppException {
		inventoryService.adjust(inventoryRequest);
	}

	@PutMapping("/set")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void set(@RequestBody InventorySet inventorySet) throws AppException {
		inventoryService.set(inventorySet);
	}
}