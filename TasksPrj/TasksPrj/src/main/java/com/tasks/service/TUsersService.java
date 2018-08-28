package com.tasks.service;

import org.springframework.stereotype.Service;

import com.tasks.model.TUsers;
import com.tasks.model.Template;
import com.tasks.service.generic.GenericService;

@Service
public interface TUsersService  extends GenericService<TUsers>{
	public TUsers find(String userId);
}
