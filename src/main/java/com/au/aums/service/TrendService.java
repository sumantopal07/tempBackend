package com.au.aums.service;

import java.util.List;

import com.au.aums.model.dto.ClientDTO;
import com.au.aums.model.dto.DescriptionDTO;
import com.au.aums.model.dto.LocationDTO;
import com.au.aums.model.dto.SkillDTO;

public interface TrendService {
	
	
	List<SkillDTO> skill();
	List<ClientDTO> client();
	List<LocationDTO> location();
	List<DescriptionDTO> description();
	
}
