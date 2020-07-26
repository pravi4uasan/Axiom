package com.axiom.interview;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.axiom.interview.domain.Mobile;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

@SpringBootTest
@AutoConfigureMockMvc
class InterviewApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	@SneakyThrows
	public void testSearchSample1() {
		
		MvcResult result1 = mvc.perform(MockMvcRequestBuilders
				.get("/mobile/search?priceEur=200")).andReturn();
		
		ObjectMapper mapper1 = new ObjectMapper();
		List<Mobile> mobiles1 = mapper1.readValue(result1.getResponse().getContentAsString(), new TypeReference<List<Mobile>>() {
		});
		assert(10 == mobiles1.size());
		
		MvcResult result2 = mvc.perform(MockMvcRequestBuilders
				.get("/mobile/search?sim=eSim")).andReturn();
		
		ObjectMapper mapper2 = new ObjectMapper();
		List<Mobile> mobiles2 = mapper2.readValue(result2.getResponse().getContentAsString(), new TypeReference<List<Mobile>>() {
		});
		assert(0 == mobiles2.size());
		
		MvcResult result3 = mvc.perform(MockMvcRequestBuilders
				.get("/mobile/search?announceDate=1999&price=200")).andReturn();
		
		ObjectMapper mapper3 = new ObjectMapper();
		List<Mobile> mobiles3 = mapper3.readValue(result3.getResponse().getContentAsString(), new TypeReference<List<Mobile>>() {
		});
		assert(6 == mobiles3.size());
		
	}
	
}
