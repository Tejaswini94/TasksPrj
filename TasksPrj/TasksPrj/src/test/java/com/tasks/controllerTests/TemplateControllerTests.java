package com.tasks.controllerTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
	
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.tasks.controller.TemplateController;
import com.tasks.model.TUsers;
import com.tasks.model.Template;
import com.tasks.service.TUsersService;
import com.tasks.service.TasksService;
import com.tasks.service.TemplateService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TemplateController.class)
@AutoConfigureMockMvc
public class TemplateControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TemplateService service;
	
	String templateJson="{\"templateId\":0,\"subject\":\"Create UI for client\",\"duration\":20,\"user\":null,\"templateType\":1,\"status\":null,\"frequency\":1,\"recurringFrequency\":\"DAILY\",\"priority\":1,\"tPriority\":\"Low\"";
	Template template=new Template(1000, "full subject",20,1,3,1);
	
	@Test
	public void retrieveDetailsForTemplate() throws Exception {

		Mockito.when(
				service.find(Mockito.anyLong())).thenReturn(template);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/tasks/templates/vish").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{templateId:0,subject:Create UI for walmart project,duration:20,user:null,templateType:1,status:yet to start,frequency:1,recurringFrequency:DAILY,priority:1,tPriority:Low}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}
		Assert.assertTrue(expected, result.getResponse()
				.getContentAsString().toLowerCase().indexOf(expected.toLowerCase())>-1);
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	
}