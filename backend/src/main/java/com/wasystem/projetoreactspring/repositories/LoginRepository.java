package com.wasystem.projetoreactspring.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wasystem.projetoreactspring.entities.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{

	boolean existsByUserName(String userName);

	boolean existsByEmailUser(String emailUser);

	Optional<Login> findByUserName(String userName);
	
}
