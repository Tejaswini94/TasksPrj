package com.tasks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasks.model.Template;
import com.tasks.repository.TemplateRepository;
import com.tasks.service.TemplateService;
@Service
public class TemplateServiceImpl implements TemplateService {
	@Autowired
	TemplateRepository repository;
	@Override
	public Template save(Template entity) {
		return repository.saveAndFlush(entity);
	}

	@Override
	public Template update(Template entity) {
		return repository.saveAndFlush(entity);
	}

	@Override
	public void delete(Template entity) {
		repository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id.intValue());
	}

	@Override
	public void deleteInBatch(List<Template> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Template find(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id.intValue()).get();
	}

	@Override
	public List<Template> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<Template> findByUserId(String userId) {
		return repository.findAllByUserId(userId);
	}

}
