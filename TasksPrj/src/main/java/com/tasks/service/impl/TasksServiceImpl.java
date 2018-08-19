package com.tasks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tasks.model.Tasks;
import com.tasks.repository.TasksRepository;
import com.tasks.service.TasksService;

public class TasksServiceImpl implements TasksService {
	@Autowired
	TasksRepository repository;
	@Override
	public Tasks save(Tasks entity) {
		return repository.saveAndFlush(entity);
	}

	@Override
	public Tasks update(Tasks entity) {
		return repository.saveAndFlush(entity);
	}

	@Override
	public void delete(Tasks entity) {
		repository.delete(entity);

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteInBatch(List<Tasks> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Tasks find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tasks> findAll() {
		return repository.findAll();
	}

}
