package com.upwardiq.guna.Controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.upwardiq.guna.Entity.User;
import com.upwardiq.guna.Service.UserService;
import com.upwardiq.guna.Service.VoteService;
import com.upwardiq.guna.dto.VoteRequest;

import jakarta.servlet.http.HttpSession;

@Controller
public class VoteController {

	@Autowired
	private VoteService voteService;
	@Autowired
	private UserService service;
	
	@PostMapping("/submit-vote")
	@ResponseBody
	public String submitVote(@RequestBody VoteRequest voteRequest, HttpSession session) {
	    // Get the logged-in user ID from session
	    Long userId = (Long) session.getAttribute("loggedInUserId");
	    if (userId == null) {
	        return "notLoggedIn";
	    }

	    Optional<User> userOptional = service.findByUserid(userId);
	    if (userOptional.isEmpty()) {
	        return "userNotFound";
	    }

	    User user = userOptional.get();
	    if (user.isHasVoted()) {
	        return "alreadyVoted"; // User already voted
	    }

	    try {
	        // Record vote
	        voteService.recordVote(voteRequest.getVoteId());

	        // Mark user as having voted
	        user.setHasVoted(true);
	        service.saveUser(user);

	        return "success";
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "error";
	    }
	}

}
