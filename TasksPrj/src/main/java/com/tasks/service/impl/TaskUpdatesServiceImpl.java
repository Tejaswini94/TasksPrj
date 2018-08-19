package com.tasks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tasks.model.TaskUpdates;
import com.tasks.repository.TaskUpdatesRepository;
import com.tasks.repository.TasksRepository;
import com.tasks.service.TaskUpdatesService;

public class TaskUpdatesServiceImpl implements TaskUpdatesService {
	@Autowired
	TaskUpdatesRepository repository;
	@Override
	public TaskUpdates save(TaskUpdates entity) {
		return repository.saveAndFlush(entity); 
	}

	@Override
	public TaskUpdates update(TaskUpdates entity) {
		return repository.saveAndFlush(entity);
	}

	@Override
	public void delete(TaskUpdates entity) {
		repository.delete(entity);

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteInBatch(List<TaskUpdates> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public TaskUpdates find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskUpdates> findAll() {
		return repository.findAll();
	}

}
