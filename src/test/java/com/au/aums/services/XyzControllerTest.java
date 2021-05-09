package com.au.aums.services;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.au.aums.dao.OppurtunityRepository;
import com.au.aums.enums.Role;
import com.au.aums.model.User;
import com.au.aums.model.dto.LoginResponseDTO;
import com.au.aums.model.dto.UserDTO;
import com.au.aums.security.IJwtTokenProviderService;
import com.au.aums.service.TrendService;
import com.au.aums.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.mockito.Mockito.when;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class XyzControllerTest {
	@Autowired
	MockMvc mockMvc;

	@MockBean
	TrendService trendService;
	
	@MockBean
	UserService userService;
	

	@MockBean
	IJwtTokenProviderService jwtTokenProviderService;
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
//	@MockBean
//	IJwtTokenProviderService ijwt;

	String url = "/api/restriction/";

	@MockBean
	private OppurtunityRepository opp;

	static Logger log = LoggerFactory.getLogger(TrendsServicesTest.class);

//	@Before
//	public void setUp() throws Exception {
//		mockMvc = MockMvcBuilders.standaloneSetup(trendService).build();
//	}

//	@Test
//	@DisplayName("dflnadflknadflknadflknadf")
//	public void sdfsdf() throws Exception {
////		SkillDTO skill1 = new SkillDTO();
////		SkillDTO skill2 = new SkillDTO("React", 1l);
////		skill1.setSkill("java");
////		skill1.setTotal(2l);
////
////		List<SkillDTO> skills = new ArrayList<SkillDTO>();
////		skills.add(skill1);
////		skills.add(skill2);
////
////		log.info(skill2.getSkill());
////		log.info(skill2.getTotal() + "");
//
//		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/allowed/login"))
//				.andReturn();
//		assertThat(result).isNotNull();
//		System.out.println("==========================================");
//
//		System.out.println(MockMvcRequestBuilders.get("/api/allowed/login"));
//		System.out.println(result);
//		System.out.println(result.getResponse().getContentAsString());
//		System.out.println("==========================================");
//	}
	
    @Test
    public void testPost() throws Exception {
    	UserDTO user = new UserDTO();
    	user.setEmail("sumantopal07@gmail.com");
    	
    	User resUser = new User();
    	resUser.setEmail("sumantopal07@gmail.com");
    	resUser.setUserId(1);
		
    	LoginResponseDTO l = new LoginResponseDTO();
    	l.setAccessToken(jwtTokenProviderService.createToken(user.getEmail(), Role.ROLE_ADMIN));
		l.setEmail(user.getEmail());
		//when(userService.getUser("sumantopal07@gmail.com")).thenReturn(resUser);
		
        mockMvc.perform(post("/api/allowed/login")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isNotFound()).andReturn(); 
//        MvcResult mvcResult = mockMvc.perform(
//				post(url)
//				.contentType("application/json")
//				.content(objectMapper.writeValueAsString(user))
//			).andExpect(status().isOk()).andReturn();
    }

	

}