package com.cooper.farming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cooper.farming.exception.FarmingServiceException;
import com.cooper.farming.service.BidsService;
import com.cooper.farming.vo.BidVO;
import com.cooper.farming.vo.BidsVO;
import com.cooper.farming.vo.ErrorVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = "/api/bids")
public class BidsController {
	
	@Autowired
	private BidsService bidsService;
	
	@PreAuthorize("hasAnyAuthority('Retailer')")
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	@Operation(summary = "Insert a new bid for a product", description = "Insert a new bid for a product")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Saved the bid for a product", content = @Content(schema = @Schema(implementation = BidVO.class))),
			@ApiResponse(responseCode = "400", description = "Invalid Input", content = @Content(schema = @Schema(implementation = ErrorVO.class)))
	})
	public @ResponseBody BidsVO saveBid(@RequestBody BidVO bidVO) throws FarmingServiceException {
		return bidsService.saveOrUpdateBid(bidVO);
	}

	@PreAuthorize("hasAnyAuthority('Farmer')")
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	@Operation(summary = "Get the list of bids of a particular product.", description = "Get the list of bids of a particular product.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetched the list of bids of a particular product.", content = @Content(schema = @Schema(implementation = BidsVO.class))),
			@ApiResponse(responseCode = "404", description = "No bids found", content = @Content(schema = @Schema(implementation = ErrorVO.class)))
	})
	public @ResponseBody BidsVO getBidsByProductId(@RequestParam(name = "productId", required = true) int productId) {
		return bidsService.findBidsByProductId(productId);
	}
	
	@PreAuthorize("hasAnyAuthority('Farmer')")
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	@Operation(summary = "Update the bid status to ACCEPTED or REJECTED", description = "Update the bid status to ACCEPTED or REJECTED")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Update the bid for a product", content = @Content(schema = @Schema(implementation = BidVO.class))),
			@ApiResponse(responseCode = "400", description = "Invalid Input", content = @Content(schema = @Schema(implementation = ErrorVO.class)))
	})
	public @ResponseBody BidsVO updateBid(@RequestBody BidVO bidVO) throws FarmingServiceException {
		return bidsService.saveOrUpdateBid(bidVO);
	}
	
	@PreAuthorize("hasAnyAuthority('Retailer')")
	@GetMapping(path = "/user/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@Operation(summary = "Get the list of bids for a particular user", description = "Get the list of bids for a particular user")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully fetched the list of bids for a particular user", content = @Content(schema = @Schema(implementation = BidsVO.class))),
			@ApiResponse(responseCode = "404", description = "No bids found", content = @Content(schema = @Schema(implementation = ErrorVO.class)))
	})
	public @ResponseBody BidsVO getBids(@PathVariable(name = "userId", required = true) int userId) throws FarmingServiceException {
		return bidsService.getBidsByUserId(userId);
	}
}
