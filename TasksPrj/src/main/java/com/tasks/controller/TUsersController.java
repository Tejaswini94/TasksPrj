package com.tasks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.model.TUsers;
import com.tasks.model.Tasks;
import com.tasks.service.TUsersService;

@RestController
@RequestMapping("/users")
public class TUsersController {
	@Autowired
	private TUsersService service;
	
	@GetMapping("/")
	public List<TUsers> findAll(){
		System.out.println("Get request");
		List<TUsers> list=service.findAll();
		System.out.println(list);
		return list;
	}
	
	@PostMapping("/")
	public @ResponseBody ResponseEntity<String> save(@RequestBody TUsers user) {
		System.out.println("save user"+user.getFullName());
		TUsers user1=service.save(user);
		if(user1!=null)
			return new ResponseEntity<String>(user1.getRole(),HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("Error",HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody TUsers tuser) {
		System.out.println("Login request");
		TUsers user = service.find(tuser.getUserId());
		if(user.getPassword().equals(tuser.getPassword()))
			return "Yes";
		else
			return "No";
	}
	
}
