package com.au.aums.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.au.aums.dao.OppurtunityRepository;
import com.au.aums.model.Oppurtunities;
import com.au.aums.model.dto.EditOpp;
import com.au.aums.model.dto.OppurtunityDTO;
import com.au.aums.service.OppurtunityService;

@RestController
public class OppurtunityController {
	
	
	@Autowired
	OppurtunityService oppService;
	
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
		opp.setUser(oppDTO.getUser());
		opp.setDescription(oppDTO.getDescription());
		opp.setLocation(oppDTO.getLocation());
		opp.setMinExp(oppDTO.getMinExp());
		opp.setSkill(oppDTO.getSkill());
		
		return new ResponseEntity<>(oppService.addOppurtunity(opp), HttpStatus.OK);

	}
	
	@PatchMapping(path = "/api/allowed/updateOppurtunity")
	public ResponseEntity<String> updateOppurtunity(@RequestBody EditOpp oppDTO) {
		
		Oppurtunities opp =oppService.getOppurtunity(oppDTO.getId());
	
		opp.setClient(oppDTO.getClient());
		opp.setDate(oppDTO.getDate());
		opp.setDemand(oppDTO.getDemand());
		opp.setUser(oppDTO.getUser());
		opp.setDescription(oppDTO.getDescription());
		opp.setLocation(oppDTO.getLocation());
		opp.setMinExp(oppDTO.getMinExp());
		opp.setSkill(oppDTO.getSkill());
		
		oppService.addOppurtunity(opp);
		return new ResponseEntity<>("oppurtunity updated successfully", HttpStatus.OK);

	}
	
	@GetMapping(path = "/api/allowed/search/{col}/{place}")
	public ResponseEntity<List<Oppurtunities>>  searchBy(@PathVariable("col") String col, @PathVariable("place") String place) {
		List<Oppurtunities> result = null;
		result = oppService.searchBy(col, place);
		return new ResponseEntity<>(result, HttpStatus.OK);

	}
	
	@DeleteMapping(path = "/api/allowed/delete/")
	public ResponseEntity<String>  deleteBy(@RequestBody Integer oppId) {
		oppRepository.deleteById(oppRepository.findByOppId(oppId).getOppId());
		return new ResponseEntity<>("deleted", HttpStatus.OK);
	}

	
}
