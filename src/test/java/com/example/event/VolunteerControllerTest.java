package com.example.event;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.event.entities.Volunteer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class VolunteerControllerTest {
	
	@Autowired
	   WebApplicationContext webApplicationContext;
	
	@Test
	   public void createVolunteer() throws Exception {
		MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	      String uri = "/volunteer";
	      Volunteer v = new Volunteer();
	      v.setMobile("1234");
	      v.setEmail("dalia@gmail.com");
	      String inputJson = mapToJson(v);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();   
	      int status = mvcResult.getResponse().getStatus();
	      String content = mvcResult.getResponse().getContentAsString();
	      Assert.assertTrue(content.contains("dalia@gmail.com"));
	      assertEquals(200, status);

	   }
	protected String mapToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	   }

}
