package com.upwardiq.guna.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upwardiq.guna.Entity.Vote;



@Repository
public interface VoteRepo extends JpaRepository<Vote,Long>{

	
}
