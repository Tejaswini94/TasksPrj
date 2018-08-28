package com.tasks.controllerTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.tasks.model.TUsers;
import com.tasks.service.TUsersService;
import com.tasks.service.TasksService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TUsersController.class)
@AutoConfigureMockMvc
public class TUsersControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TUsersService service;
	
	String userJson="{\"userId\":\"testuser\",\"fullName\":\"test this user\",\"emailId\":\"test@a.com\",\"password\":\"tester\",\"role\":\"User\"}";
	TUsers user=new TUsers("tester2", "tester india", "test2@a.com", "abcd123", "Admin", null);
	
	@Test
	public void retrieveDetailsForUser() throws Exception {

		Mockito.when(
				service.find(Mockito.anyString())).thenReturn(user);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/tasks/users/").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{userId:tester2,fullName:tester india,emailId:test2@a.com,password:abcd123,role:Admin}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}
		Assert.assertFalse(expected, result.getResponse()
				.getContentAsString().toLowerCase().indexOf(expected.toLowerCase())>-1);
		//JSONAssert.assertEquals(expected, result.getResponse()
			//	.getContentAsString(), false);
	}
	
	
}




