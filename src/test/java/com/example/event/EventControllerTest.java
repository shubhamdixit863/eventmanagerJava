package com.example.event;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.event.entities.Event;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;

@SpringBootTest
public class EventControllerTest {
	
	@Autowired
	   WebApplicationContext webApplicationContext;
	
	
	
	@Test
	   public void createEvent() throws Exception {
		MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	      String uri = "/event";
	      Event event = new Event();
	      event.setEvent_id(1);
	      event.setDescription("Test");
	      String inputJson = mapToJson(event);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();   
	      int status = mvcResult.getResponse().getStatus();
	      String content = mvcResult.getResponse().getContentAsString();
	      Assert.assertTrue(content.contains("Test"));
	      assertEquals(200, status);

	   }
	
	@Test
	   public void getEventList() throws Exception {
		
	      MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	      String uri = "/event";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      
	      String content = mvcResult.getResponse().getContentAsString();
	      System.out.println(content);

	   }
	
	@Test
	   public void updateEventById() throws Exception {
		Event event = new Event();
	      event.setEvent_id(1);
	      event.setDescription("Test");
	      String inputJson = mapToJson(event);
	      MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	      String uri = "/event";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	    	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	    	         .content(inputJson)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      
	      String content = mvcResult.getResponse().getContentAsString();
	      System.out.println(content);

	   }
	@Test
	   public void deleteEventbyId() throws Exception {
		
	      MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	      String uri = "/event/1";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      
	      String content = mvcResult.getResponse().getContentAsString();
	      System.out.println(content);

	   }
	
	

	protected String mapToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	   }
}
