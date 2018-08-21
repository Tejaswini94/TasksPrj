package com.tasks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasks.model.TUsers;
import com.tasks.repository.TUsersRepository;
import com.tasks.service.TUsersService;
@Service
public class TUsersServiceImpl implements TUsersService {
	@Autowired
	TUsersRepository repository; 
	@Override
	public TUsers save(TUsers entity) {
		return repository.saveAndFlush(entity);
	}

	@Override
	public TUsers update(TUsers entity) {
		return repository.saveAndFlush(entity);
	}

	@Override
	public void delete(TUsers entity) {
		repository.delete(entity);
	}

	@Override
	public void delete(Long id) {
	}

	public void delete(String id) {
		repository.deleteById(id);
	}

	@Override
	public void deleteInBatch(List<TUsers> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public TUsers find(Long id) {
		return null;
	}
	
	@Override
	public TUsers find(String userId) {
		return repository.findByUserId(userId);
	}

	@Override
	public List<TUsers> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
