package com.au.aums.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.au.aums.dao.OppurtunityRepository;
import com.au.aums.model.Oppurtunities;
import com.au.aums.model.dto.OppurtunityDTO;
import com.au.aums.model.dto.OppurtunityDTO;
import com.au.aums.service.OppurtunityService;
import com.au.aums.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OppurtunityController {
	
	
	@Autowired
	OppurtunityService oppService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	OppurtunityRepository oppRepository;
	
	@GetMapping(path = "/api/allowed/getOppurtunities")
	public ResponseEntity<List<Oppurtunities>> getOppurtunities() {
		
		List<Oppurtunities> result = null;
		result = oppService.getAll();
		if(result.size()>0)
			return new ResponseEntity<>(result, HttpStatus.OK);
		return new ResponseEntity<>(result, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
	}

	@PostMapping(path = "/api/allowed/addOppurtunity")
	public ResponseEntity<Oppurtunities> addOppurtunity(@RequestBody OppurtunityDTO oppDTO) {
		
		Oppurtunities opp =new Oppurtunities();
	
		opp.setClient(oppDTO.getClient());
		opp.setDate(oppDTO.getDate());
		opp.setDemand(oppDTO.getDemand());
		opp.setUser(userService.getUser(oppDTO.getEmail()));
		opp.setDescription(oppDTO.getDescription());
		opp.setLocation(oppDTO.getLocation());
		opp.setMinExp(oppDTO.getMinExp());
		opp.setSkill(oppDTO.getSkill());
		
		return new ResponseEntity<>(oppService.addOppurtunity(opp), HttpStatus.OK);

	}
	
	@PutMapping(path = "/api/allowed/updateOppurtunity")
	public ResponseEntity<Oppurtunities> updateOppurtunity(@RequestBody OppurtunityDTO oppDTO) {
		
		Oppurtunities opp =oppService.getOppurtunity(oppDTO.getId());
		opp.setClient(oppDTO.getClient());
		opp.setDate(oppDTO.getDate());
		opp.setDemand(oppDTO.getDemand());
		opp.setUser(userService.getUser(oppDTO.getEmail()));
		opp.setDescription(oppDTO.getDescription());
		opp.setLocation(oppDTO.getLocation());
		opp.setMinExp(oppDTO.getMinExp());
		opp.setSkill(oppDTO.getSkill());
		
		return new ResponseEntity<>(oppService.addOppurtunity(opp), HttpStatus.OK);

	}
	
	@GetMapping(path = "/api/allowed/search/{col}/{place}")
	public ResponseEntity<List<Oppurtunities>>  searchBy(@PathVariable("col") String col, @PathVariable("place") String place) {
		List<Oppurtunities> result = null;
		result = oppService.searchBy(col, place);
		return new ResponseEntity<>(result, HttpStatus.OK);

	}
	
	@DeleteMapping(path = "/api/allowed/delete/{oppId}")
	public ResponseEntity<?>  deleteBy(@PathVariable("oppId") Integer oppId) {
		oppService.deleteBy(oppId);
		return new ResponseEntity<>( HttpStatus.OK);
	}

	
}
