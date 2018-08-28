package com.tasks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tasks.model.Tasks;
import com.tasks.model.Template;
import com.tasks.service.generic.GenericService;

@Service
public interface TasksService  extends GenericService<Tasks>{
	public List<Tasks> findAll(String userId);
}
