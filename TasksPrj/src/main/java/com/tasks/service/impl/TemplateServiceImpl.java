package com.tasks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tasks.model.Template;
import com.tasks.repository.TemplateRepository;
import com.tasks.service.TemplateService;

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

}
