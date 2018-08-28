package com.tasks.controllerTests;

import static org.junit.Assert.assertFalse;

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
import org.springframework.http.MediaType;

import com.tasks.controller.TasksController;
import com.tasks.model.Tasks;
import com.tasks.service.TasksService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TasksController.class)
@AutoConfigureMockMvc
public class TasksControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TasksService service;
	
	String taskJson="{\"taskid\":2,\"taskType\":0,\"description\":\"The UI creation job for walmart to be started\",\"status\":\"0\",\"stdate\":\"2018-08-17T18:30:00.000+0000\",\"enddate\":\"2018-08-27T18:30:00.000+0000\",\"percentComplete\":0,\"taskUsers\":[{\"userId\":\"vish\",\"fullName\":\"Vishal Vadhera\",\"emailId\":\"vadhera.vishalk@gmail.com\",\"password\":\"infoworld\",\"role\":\"Admin\"}],\"template\":{\"templateId\":1,\"subject\":\"Create UI for walmart project\",\"duration\":20,\"templateType\":1,\"frequency\":1,\"priority\":1}}";
	Tasks task=null;//new Tasks(1000, "full subject",20,1,3,1);
	
	@Test
	public void retrieveDetailsForTask() throws Exception {

		Mockito.when(
				service.find(Mockito.anyLong())).thenReturn(task);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/tasks/usertasks/vish").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{taskid:2,taskType:0,description:\"The UI creation job for walmart to be started\",status:0,stdate:2018-08-17T18:30:00.000+0000,enddate:2018-08-27T18:30:00.000+0000,percentComplete:0,taskUsers:[{userId:vish,fullName:\"Vishal Vadhera\",emailId:vadhera.vishalk@gmail.com,password:infoworld,role:Admin}],template:{templateId:1,subject:\"Create UI for walmart project\",duration:20,templateType:1,frequency:1,priority:1}}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}
//		assertFalse(result.getResponse()
//				.getContentAsString().toLowerCase().indexOf(expected.toLowerCase())>-1);
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	
}