package com.tasks.service;

import org.springframework.stereotype.Service;

import com.tasks.model.Tasks;
import com.tasks.model.Template;
import com.tasks.service.generic.GenericService;

@Service
public interface TasksService  extends GenericService<Tasks>{

}
