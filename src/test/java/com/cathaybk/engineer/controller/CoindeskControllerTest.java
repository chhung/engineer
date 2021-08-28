package com.cathaybk.engineer.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.cathaybk.engineer.application.CoindeskService;
import com.cathaybk.engineer.application.ThirdPartyService;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
class CoindeskControllerTest {

	//@MockBean
	@Autowired
	CoindeskService coin;
	
	@Autowired
    MockMvc mockMvc;
	
	@Autowired
	ThirdPartyService coindesk;
	
	@Test
	void testGetCurrencyMapping() {
        String response = "";
		try {
			response = mockMvc.perform(
					get("/api/v1/currentprice").characterEncoding("UTF-8").accept(MediaType.APPLICATION_JSON).content("application/json"))
					.andExpect(status().isOk())
					.andDo(print()).andReturn().getResponse().getContentAsString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("response=" + response);
	}

	@Test
	void testGetCurrentPrice() {
		String response = "";
		try {
			response = mockMvc.perform(
					get("/api/v1/delete/GBP").characterEncoding("UTF-8").accept(MediaType.APPLICATION_JSON).content("application/json"))
					.andExpect(status().isOk())
					.andDo(print()).andReturn().getResponse().getContentAsString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("response=" + response);
	}

	@Test
	void testDeleteByCode() {
        String response = "";
		try {
			response = mockMvc.perform(
					get("/api/v1/delete/GBP").characterEncoding("UTF-8").accept(MediaType.APPLICATION_JSON).content("application/json"))
					.andExpect(status().isOk())
					.andDo(print()).andReturn().getResponse().getContentAsString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("response=" + response);
	}

	@Test
	void testUpdateByCode() {
        String response = "";
		try {
			response = mockMvc.perform(
					get("/api/v1/update/USD?chinese=修改成功").characterEncoding("UTF-8").accept(MediaType.APPLICATION_JSON).content("application/json"))
					.andExpect(status().isOk())
					.andDo(print()).andReturn().getResponse().getContentAsString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("response=" + response);
	}

	@Test
	void testSave() {
		String response = "";
		try {
			response = mockMvc.perform(
					post("/api/v1/save").characterEncoding("UTF-8").content("{\r\n"
							+ "    \"code\":\"NZD\",\r\n"
							+ "    \"chinese\":\"紐西蘭幣\"\r\n"
							+ "}").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andDo(print()).andReturn().getResponse().getContentAsString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("response=" + response);
	}
	

}
