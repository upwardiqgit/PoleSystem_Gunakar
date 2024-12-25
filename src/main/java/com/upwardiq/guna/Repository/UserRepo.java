package com.upwardiq.guna.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.upwardiq.guna.Entity.User;


@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	
	
}
