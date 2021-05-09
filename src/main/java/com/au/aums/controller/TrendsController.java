
package com.au.aums.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.au.aums.model.dto.ClientDTO;
import com.au.aums.model.dto.DescriptionDTO;
import com.au.aums.model.dto.LocationDTO;
import com.au.aums.model.dto.SkillDTO;
import com.au.aums.service.TrendService;
import com.au.aums.service.impl.TrendServiceImpl;

@RestController
public class TrendsController {

	@Autowired
	TrendService trendService;

	
	@GetMapping(path = "/api/restriction/skill")
	public ResponseEntity<List<SkillDTO>> skills() {
		return new ResponseEntity<>(trendService.skill(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/api/restriction/client")
	public ResponseEntity<List<ClientDTO>> client() {
		return new ResponseEntity<>(trendService.client(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/api/restriction/location")
	public ResponseEntity<List<LocationDTO>> location() {
		return new ResponseEntity<>(trendService.location(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/api/restriction/description")
	public ResponseEntity<List<DescriptionDTO>> description() {
		return new ResponseEntity<>(trendService.description(), HttpStatus.OK);
	}

}
