
package com.au.aums.service;

import java.util.List;

import com.au.aums.model.Oppurtunities;
import com.au.aums.model.User;

public interface OppurtunityService {
	
	
	Oppurtunities addOppurtunity(Oppurtunities opp);
	List<Oppurtunities> searchBy(String col, String place);
	List<Oppurtunities> getAll();
	Oppurtunities getOppurtunity(int keyword);
	void deleteBy(Integer keyword);
}
