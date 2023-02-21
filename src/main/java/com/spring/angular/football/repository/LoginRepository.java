package com.spring.angular.football.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.angular.football.model.LoginPlayer;

@Repository
public interface LoginRepository extends JpaRepository<LoginPlayer, String>{
	
	 LoginPlayer findByUsername(String username);
	
}
