package com.tasks.serviceTests;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.tasks.model.Tasks;
import com.tasks.model.Template;
import com.tasks.service.TasksService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TasksServiceTest {
  @Mock 
  TasksService tasksService;

  @Test
  public void testone(){
    when(tasksService.findAll()).thenReturn(getTasks());
    assertEquals(2, tasksService.findAll().size());

  }
  
  private List<Tasks> getTasks() {
    List<Tasks> a = new ArrayList<>();
    a.add(new Tasks(1, "test desc", "active", new Date(), new Date(), 20, new ArrayList<>(), new Template(1, "temp sub", 12, 5, 1), new ArrayList<>()));
    a.add(new Tasks(2, "test desc", "active", new Date(), new Date(), 20, new ArrayList<>(), new Template(1, "temp sub", 12, 5, 1), new ArrayList<>()));
    return a;

  }
}