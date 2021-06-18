package com.cooper.farming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cooper.farming.service.RoleService;
import com.cooper.farming.vo.ErrorVO;
import com.cooper.farming.vo.RolesVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = "/api/roles")
public class RoleController {
	
	@Autowired
	private RoleService roleService;

	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	@Operation(summary = "Fetch the list of user roles.", description = "Fetch the list of user roles.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetched the list of user roles", content = @Content(schema = @Schema(implementation = RolesVO.class))),
			@ApiResponse(responseCode = "404", description = "No user roles found", content = @Content(schema = @Schema(implementation = ErrorVO.class)))
	})
	public @ResponseBody RolesVO getRoles() {
		return roleService.getRoles();
	}
}
