package com.upwardiq.guna.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upwardiq.guna.Entity.Vote;
import com.upwardiq.guna.Repository.VoteRepo;



@Service
public class VoteService implements Voteserviceinter{

	@Autowired
	private VoteRepo repo;

	public Object geetALl() {
		// TODO Auto-generated method stub
		return null;
	}

	public void recordVote(Long voteId) {
		// TODO Auto-generated method stub
		
	}
	

	

	
}
