package com.tasks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.model.TUsers;
import com.tasks.model.Tasks;
import com.tasks.service.TUsersService;
import com.tasks.service.TasksService;

@RestController
@RequestMapping("/usertasks")
public class TasksController {
	@Autowired
	private TasksService service;
	
	@GetMapping("/{userId}")
	public List<Tasks> findAll(@PathVariable String userId){
		System.out.println("Get request");
		List<Tasks> list=service.findAll(userId);
		System.out.println(list);
		return list;
	}
	
	@PostMapping("/{userId}")
	public Tasks save(@PathVariable String userId, @RequestBody Tasks task) {
		Tasks task1=service.save(task);
		System.out.println("save task"+task1.getTaskid());
		return task1;
	}
	
	/*@PostMapping("/{id}")
	public TUsers login(TUsers tuser) {
		TUsers user = service.find(tuser.getUserId());
		if(user.getPassword().equals(tuser.getPassword()))
			return user;
		else
			return null;
	}
	*/
}
