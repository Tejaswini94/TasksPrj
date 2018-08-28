package com.tasks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tasks.model.Template;
import com.tasks.service.generic.GenericService;

@Service
public interface TemplateService extends GenericService<Template>{

	public List<Template> findByUserId(String userId);
}