package com.upwardiq.guna.Service;

import java.util.Optional;

import com.upwardiq.guna.Entity.User;
import com.upwardiq.guna.dto.LoginDto;

public interface Userserviceinter {

	public void saveUser(User user);

	Optional<User> checkUserDetailsByUseridandPassword(LoginDto logindto);
	Optional<User> findByUserid(long userId);
}
