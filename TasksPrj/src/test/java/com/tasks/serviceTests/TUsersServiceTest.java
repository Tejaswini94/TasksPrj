package com.tasks.serviceTests;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.tasks.model.TUsers;
import com.tasks.repository.TUsersRepository;

@RunWith(MockitoJUnitRunner.class)
public class TUsersServiceTest {	
	
	@Mock
	TUsersRepository tuserRepository;
	
	@Test
	  public void testone(){
		TUsers tuser = new TUsers();
		tuser.setUserId("1");
		tuser.setFullName("Tejaswini");
	    when(tuserRepository.findByUserId("1")).thenReturn(tuser);
	    assertEquals("Tejaswini", tuserRepository.findByUserId("1").getFullName());

	  }

}
