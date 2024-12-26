package com.upwardiq.guna.Service;

import java.util.List;

import com.upwardiq.guna.Entity.Vote;

public interface Voteserviceinter {

	List<String> getAllNames();
	List<Vote> geetALl();
	void recordVote(Long voteId);
}
