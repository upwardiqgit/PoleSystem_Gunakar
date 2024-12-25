package com.upwardiq.guna.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.upwardiq.guna.Service.UserService;
import com.upwardiq.guna.Service.VoteService;

@Controller
public class VoteController {

	@Autowired
	private VoteService voteService;
	@Autowired
	private UserService service;
	
}
