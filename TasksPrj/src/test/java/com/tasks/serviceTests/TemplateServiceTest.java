package com.tasks.serviceTests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.tasks.model.Tasks;
import com.tasks.model.Template;
import com.tasks.repository.TemplateRepository;
import com.tasks.service.TemplateService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TemplateServiceTest {
  @Mock 
  TemplateRepository repository;
  
  @Test
  public void testone(){
    when(repository.findAllByUserId("1")).thenReturn(getTemplates());
    assertEquals(3, repository.findAllByUserId("1").size());

  }
  
  private List<Template> getTemplates() {
    List<Template> a = new ArrayList<>();
    a.add(new Template(1, "temp sub", 12, 5, 1));
    a.add(new Template(2, "temp sub", 15, 6, 0));
    a.add(new Template(3, "temp sub", 6, 0, -1));
    return a;

  }

}
