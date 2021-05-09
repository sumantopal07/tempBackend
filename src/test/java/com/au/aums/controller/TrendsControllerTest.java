package com.au.aums.controller;

import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.au.aums.dao.OppurtunityRepository;
import com.au.aums.dao.UserRepository;
import com.au.aums.enums.Role;
import com.au.aums.security.IJwtTokenProviderService;
import com.au.aums.security.JwtTokenFilter;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class TrendsControllerTest {
	@Autowired
	MockMvc mvc;

	@MockBean
	IJwtTokenProviderService jwtTokenProviderService;

	@MockBean
	UserRepository userRepository;

	@MockBean
	JwtTokenFilter filter;

	@Autowired
	private ObjectMapper objectMapper;

	String url = "/api/restriction/";

	@MockBean
	private OppurtunityRepository opp;

	static Logger log = LoggerFactory.getLogger(TrendsControllerTest.class);

	@Test
	public void client() throws Exception {
		doNothing().when(filter).doFilterInternal(
				(HttpServletRequest)notNull()
				,(HttpServletResponse)notNull()
		,(FilterChain)notNull());
		when(jwtTokenProviderService.createToken("john", Role.ROLE_ADMIN)).thenReturn("Bearer xyz");

		String token = jwtTokenProviderService.createToken("john",Role.ROLE_ADMIN);
 
		when(jwtTokenProviderService.parseToken((HttpServletRequest)notNull()))
		.thenReturn(token); 
		when(jwtTokenProviderService.validateToken(token))
		.thenReturn(true); 
//		
//		System.out.println(token);
		mvc.perform(MockMvcRequestBuilders.get("/api/restriction/client").header("Authorization", token))
				.andExpect(status().isOk());
	}

}
