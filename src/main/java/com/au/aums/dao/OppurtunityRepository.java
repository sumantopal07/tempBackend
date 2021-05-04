
package com.au.aums.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.aums.model.Oppurtunities;



@Repository
public interface OppurtunityRepository extends JpaRepository<Oppurtunities,Integer>{
	List<Oppurtunities> findByClient(String keyword);
	List<Oppurtunities> findBySkill(String keyword);
	List<Oppurtunities> findByLocation(String keyword);
	
	Oppurtunities findByOppId(int keyword);
	
}
