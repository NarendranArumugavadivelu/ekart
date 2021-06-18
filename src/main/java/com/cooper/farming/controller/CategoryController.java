package com.cooper.farming.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cooper.farming.exception.FarmingServiceException;
import com.cooper.farming.service.CategoryService;
import com.cooper.farming.vo.CategoriesVO;
import com.cooper.farming.vo.CategoryVO;
import com.cooper.farming.vo.ErrorVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = "/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@PreAuthorize("hasAnyAuthority('Admin')")
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	@Operation(summary = "Insert a new category of item.", description = "Persist a new category and generate its id.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Category created", content = @Content(schema = @Schema(implementation = CategoryVO.class))),
			@ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorVO.class)))
	})
	public @ResponseBody CategoryVO createCategory(@RequestBody @Valid CategoryVO categoryVO) throws FarmingServiceException {
		return categoryService.createCategory(categoryVO);
	}
	
	@PreAuthorize("hasAnyAuthority('Admin')")
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	@Operation(summary = "Fetch the list of categorties.", description = "Fetch the list of categories.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetched the list of categories", content = @Content(schema = @Schema(implementation = CategoriesVO.class))),
			@ApiResponse(responseCode = "404", description = "No category found", content = @Content(schema = @Schema(implementation = ErrorVO.class)))
	})
	public @ResponseBody CategoriesVO getCategories() {
		return categoryService.getCategories();
	}
}
