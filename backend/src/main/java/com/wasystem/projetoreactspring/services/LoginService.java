package com.wasystem.projetoreactspring.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wasystem.projetoreactspring.entities.Login;
import com.wasystem.projetoreactspring.repositories.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository repository;
	
	public Page<Login> findLogin(String userPass, String userName, Pageable pageable) {
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		String user = userName.equals("") ? "" : userName.toString();
		String passW = userPass.equals("") ? "" : userPass.toString();
		
		
		return repository.findLogin(passW, user, pageable);
	}
	
}
