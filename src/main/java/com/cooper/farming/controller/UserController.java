package com.cooper.farming.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cooper.farming.exception.FarmingServiceException;
import com.cooper.farming.service.UserService;
import com.cooper.farming.vo.ErrorVO;
import com.cooper.farming.vo.UserVO;
import com.cooper.farming.vo.UsersVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	@Operation(summary = "Insert a new user.", description = "Persist a new user and generate user id.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "User created", content = @Content(schema = @Schema(implementation = UserVO.class))),
			@ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorVO.class)))
	})
	public @ResponseBody UserVO createUser(@RequestBody @Valid UserVO userVO) throws FarmingServiceException {
		return userService.createUser(userVO);
	}
	
	@PreAuthorize("hasAnyAuthority('Farmer') OR hasAnyAuthority('Retailer')")
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	@Operation(summary = "Get the retailers or farmers in particular city.", description = "Get the retailers or farmers in particular city.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetched the retailers or farmers in particular city", content = @Content(schema = @Schema(implementation = UsersVO.class))),
			@ApiResponse(responseCode = "404", description = "No retailers or farmers found", content = @Content(schema = @Schema(implementation = ErrorVO.class)))
	})
	public @ResponseBody UsersVO getUsersByCityAndRole(@RequestParam(name = "city", required = true) String city, @RequestParam(name = "role", required = true) String role) {
		return userService.getUsersByCityAndRole(city, role);
	}
}
