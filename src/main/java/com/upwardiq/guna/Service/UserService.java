package com.upwardiq.guna.Service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upwardiq.guna.Entity.User;
import com.upwardiq.guna.Repository.UserRepo;
import com.upwardiq.guna.dto.LoginDto;


@Service
public class UserService implements Userserviceinter{


	@Autowired
	private UserRepo repo;
	@Override
	public void saveUser(User user) {
		
		repo.save(user);
	}
	public Optional<User> checkUserDetailsByUseridandPassword(LoginDto logindto) {
		Optional<User> user = repo.findByUseridAndPassword(logindto.getUserid(),logindto.getPassword());
		return user;
	}
	
	
}
