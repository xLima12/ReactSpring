package com.wasystem.projetoreactspring.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wasystem.projetoreactspring.entities.Login;
import com.wasystem.projetoreactspring.services.LoginService;

@RestController
@CrossOrigin(origins = "*", maxAge = 50)
@RequestMapping(value = "/login")
public class LoginController {

	final LoginService loginService;
	
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	//Gravar
	@PostMapping
	public ResponseEntity<Object> saveUserLogin(@RequestBody Login login){
		if(loginService.existsByUserName(login.getUserName())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Este nome de usuário já está em uso!!!");
		}
		
		if(loginService.existsByEmailUser(login.getEmailUser())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Este email já está em uso!!!");
		}
		
		var loginEntities = new Login();
		BeanUtils.copyProperties(login, loginEntities);
		loginEntities.setDateCreate(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(loginService.save(loginEntities));
	}
	
	//Listagem total
	@GetMapping
	public ResponseEntity<List<Login>> getAllLogin(){
		return ResponseEntity.status(HttpStatus.OK).body(loginService.findAll());
	}
	
	//Listagem unica
	@GetMapping("/{userName}")
	public ResponseEntity<Object> getOneLogin(@PathVariable(value = "userName") String userName){
		Optional<Login> loginOptional = loginService.findByUserName(userName);
		if(!loginOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não cadastrado!!!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(loginOptional.get());
	}
	
	//Deletar usuário
	@DeleteMapping("/{userName}")
	public ResponseEntity<Object> deleteLogin(@PathVariable(value = "userName") String userName){
		Optional<Login> loginOptional = loginService.findByUserName(userName);
		if(!loginOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não cadastrado!!!");
		}
		loginService.delete(loginOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso!!!");
	}
	
	//Atualizar usuário
	@PutMapping("/{userName}")
	public ResponseEntity<Object> updateLogin(@PathVariable(value = "userName") String userName, @RequestBody Login login){
		Optional<Login> loginOptional = loginService.findByUserName(userName);
		if(!loginOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não cadastrado!!!");
		}
		var loginEntities = new Login();
		BeanUtils.copyProperties(login, loginEntities);
		loginEntities.setId(loginOptional.get().getId());
		loginEntities.setDateCreate(loginOptional.get().getDateCreate());
		return ResponseEntity.status(HttpStatus.OK).body(loginService.save(loginEntities));
	}
	
}
