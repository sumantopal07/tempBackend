package com.au.aums.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.aums.dao.OppurtunityRepository;
import com.au.aums.model.Oppurtunities;
import com.au.aums.service.OppurtunityService;

@Service
@Transactional
public class OppurtunityServiceImpl implements OppurtunityService {

	@Autowired
	OppurtunityRepository oppRepository;

	@Override
	public Oppurtunities addOppurtunity(Oppurtunities opp) {
		return oppRepository.save(opp);
	}

	@Override
	public List<Oppurtunities> searchBy(String col, String keyword) {
		List<Oppurtunities> list = new ArrayList<>();
		if (col.equals("client"))
			list = oppRepository.findByClient(keyword);
		if (col.equals("location"))
			list = oppRepository.findByLocation(keyword);
		if (col.equals("skills"))
			list = oppRepository.findBySkill(keyword);
		return list;
	}

	@Override
	public List<Oppurtunities> getAll() {
		return oppRepository.findAll();
	}

	@Override
	public Oppurtunities getOppurtunity(int keyword) {
		return oppRepository.findByOppId(keyword);
	}

	@Override
	public void deleteBy(Integer keyword) {
		oppRepository.deleteById(oppRepository.findByOppId(keyword).getOppId());
		return ;
	}

}
