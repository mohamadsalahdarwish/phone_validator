package com.jumia.phonevalidation.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jumia.phonevalidation.service.PhoneService;
import com.jumia.phonevalidation.ui.model.request.InMemorySearchRequest;
import com.jumia.phonevalidation.ui.model.response.PhoneGridResponse;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/phones")
public class PhoneListController {

	@Autowired
	PhoneService phoneService;

	@ApiOperation(value = "Load Phone Data")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Phone Data retrieved successfully") })
	@GetMapping(produces =   MediaType.APPLICATION_JSON_VALUE )
	public PhoneGridResponse getPhones(@RequestParam(value = "page", defaultValue = "0") int pageNo) {
		return phoneService.getPhoneList(pageNo);
	}
	
	
	
	@ApiOperation(value = "Filter Data By Filed")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Data retrieved successfully") })
	@PostMapping(path = "/filterbyfield", consumes = MediaType.APPLICATION_JSON_VALUE , produces = 
					MediaType.APPLICATION_JSON_VALUE )
	public PhoneGridResponse getPhonesByfiledKeyword(@RequestBody InMemorySearchRequest inMemorySearchRequest) {
		return phoneService.filterPhoneListByField(inMemorySearchRequest);
	}
}
