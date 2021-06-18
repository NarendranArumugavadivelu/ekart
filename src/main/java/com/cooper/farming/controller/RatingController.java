package com.cooper.farming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cooper.farming.service.RatingService;
import com.cooper.farming.vo.ErrorVO;
import com.cooper.farming.vo.RatingsVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = "/api/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;

	@PreAuthorize("hasAnyAuthority('Farmer') OR hasAnyAuthority('Retailer')")
	@GetMapping(path = "/user/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@Operation(summary = "Get the list of ratings of a particular user.", description = "Get the list of ratings of a particular user.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetched the list of ratings of a particular user.", content = @Content(schema = @Schema(implementation = RatingsVO.class))),
			@ApiResponse(responseCode = "404", description = "No bids found", content = @Content(schema = @Schema(implementation = ErrorVO.class)))
	})
	public @ResponseBody RatingsVO getRatings(@PathVariable(name = "userId", required = true) int userId) {
		return ratingService.getRatings(userId);
	}
}
