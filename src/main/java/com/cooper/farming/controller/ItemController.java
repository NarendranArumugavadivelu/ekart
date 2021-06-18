package com.cooper.farming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cooper.farming.service.ItemService;
import com.cooper.farming.vo.ErrorVO;
import com.cooper.farming.vo.ItemsVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = "/api/items")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	
	@PreAuthorize("hasAnyAuthority('Admin') OR hasAnyAuthority('Farmer')")
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	@Operation(summary = "Fetch the list of items.", description = "Fetch the list of items.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetched the list of items", content = @Content(schema = @Schema(implementation = ItemsVO.class))),
			@ApiResponse(responseCode = "404", description = "No category found", content = @Content(schema = @Schema(implementation = ErrorVO.class)))
	})
	public @ResponseBody ItemsVO getItems() {
		return itemService.getItems();
	}
}
