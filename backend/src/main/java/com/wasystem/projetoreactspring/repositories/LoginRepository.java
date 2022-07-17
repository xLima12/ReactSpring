package com.wasystem.projetoreactspring.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wasystem.projetoreactspring.entities.Login;

public interface LoginRepository extends JpaRepository<Login, Long>{
	@Query("SELECT obj FROM Login obj WHERE obj.id")
	Page<Login> findLogin(String passW, String user, Pageable pageable);
}
