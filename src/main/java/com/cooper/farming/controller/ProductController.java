package com.cooper.farming.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cooper.farming.exception.FarmingServiceException;
import com.cooper.farming.service.ProductService;
import com.cooper.farming.vo.ErrorVO;
import com.cooper.farming.vo.ProductVO;
import com.cooper.farming.vo.ProductsVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = "/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@PreAuthorize("hasAnyAuthority('Farmer')")
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	@Operation(summary = "Insert a new product.", description = "Persist a new product and generate user id.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Product created", content = @Content(schema = @Schema(implementation = ProductVO.class))),
			@ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorVO.class)))
	})
	public @ResponseBody ProductVO createProduct(@RequestBody @Valid ProductVO productVO) throws FarmingServiceException {
		return productService.createProduct(productVO);
	}
	
	@PreAuthorize("hasAnyAuthority('Farmer')")
	@GetMapping(path = "/user/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@Operation(summary = "Get the list of products posted by farmer", description = "Get the list of products posted by farmer")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetched the list of products posted by farmer", content = @Content(schema = @Schema(implementation = ProductsVO.class))),
			@ApiResponse(responseCode = "404", description = "No products found for the farmer", content = @Content(schema = @Schema(implementation = ErrorVO.class)))
	})
	public ProductsVO getMyProducts(@PathVariable(name = "userId", required = true) int userId) {
		return productService.getProductsByUserId(userId);
	}
	
	@PreAuthorize("hasAnyAuthority('Retailer')")
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	@Operation(summary = "Get the list of products available in retailer city", description = "Get the list of products available in retailer city")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetched the list of products available in retailer city", content = @Content(schema = @Schema(implementation = ProductsVO.class))),
			@ApiResponse(responseCode = "404", description = "No products found in retailer city", content = @Content(schema = @Schema(implementation = ErrorVO.class)))
	})
	public ProductsVO getProducts(@RequestParam(name = "city", required = true) String city) {
		return productService.getProductsByCity(city);
	}
	
}
