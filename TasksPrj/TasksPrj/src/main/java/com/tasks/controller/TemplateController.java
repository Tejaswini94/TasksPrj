package com.tasks.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.dto.TemplateDTO;
import com.tasks.model.TUsers;
import com.tasks.model.Tasks;
import com.tasks.model.Template;
import com.tasks.service.TUsersService;
import com.tasks.service.TasksService;
import com.tasks.service.TemplateService;

@RestController
@RequestMapping("/templates")
public class TemplateController {
	@Autowired
	private TemplateService service;
	
	private TemplateDTO convertToDto(Template template) {
		TemplateDTO dto=new TemplateDTO();
		dto.setDuration(template.getDuration());
		dto.setFrequency(template.getFrequency());
		dto.setPriority(template.getPriority());
		dto.setSubject(template.getSubject());
		//dto.setTaskList(template.getTaskList());
		dto.setTemplateType(template.getTemplateType());
		return dto;
	}
	
	@GetMapping("/{userId}")
	public List<TemplateDTO> findAll(@PathVariable String userId){
		System.out.println("Get template request");
		List<Template> list=service.findByUserId(userId);
		List<TemplateDTO> dtos=new ArrayList<>();
		list.forEach(t1->{
			TemplateDTO dto=convertToDto(t1);
			dtos.add(dto);
		});
		System.out.println(dtos);
		return dtos;
	}
	
	@PostMapping("/{userId}")
	public Template save(@PathVariable String userId, @RequestBody Template template) {
		System.out.println("save task"+template.getTemplateId()+" for "+userId);
		return service.save(template);
	}
	
	
}