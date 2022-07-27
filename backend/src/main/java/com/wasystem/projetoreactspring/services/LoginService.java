package com.wasystem.projetoreactspring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.wasystem.projetoreactspring.entities.Login;
import com.wasystem.projetoreactspring.repositories.LoginRepository;

@Service
public class LoginService {

	final LoginRepository loginRepository;
	
	public LoginService(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}
	
	//Salva no banco
	@Transactional
	public Login save(Login login) {
		return loginRepository.save(login);
	}
	
	public boolean existsByUserName(String userName) {
		return loginRepository.existsByUserName(userName);
	}
	
	public boolean existsByEmailUser(String userEmail) {
		return loginRepository.existsByEmailUser(userEmail);
	}

	public List<Login> findAll(){
		return loginRepository.findAll();
		
	}

	public java.util.Optional<Login> findByUserName(String userName) {
		return loginRepository.findByUserName(userName);
	}

	@Transactional
	public void delete(Login login) {
		loginRepository.delete(login);		
	}
	
}
