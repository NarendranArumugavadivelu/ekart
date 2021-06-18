package com.cooper.farming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cooper.farming.exception.FarmingServiceException;
import com.cooper.farming.service.UserService;
import com.cooper.farming.vo.ErrorVO;
import com.cooper.farming.vo.UserVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = "/api/login")
public class LoginController {
	
	@Autowired
	private UserService userService;

	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	@Operation(summary = "Login the user by username and password", description = "Get the user details by username and password")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully retrieved the user details by username and password", content = @Content(schema = @Schema(implementation = UserVO.class))),
			@ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorVO.class)))
	})
	public @ResponseBody UserVO createUser(@RequestBody UserVO userVO) throws FarmingServiceException {
		return userService.getUserByNameAndPassword(userVO.getUserName(), userVO.getPassword());
	}
}
