package com.example.demo.Repositorry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

	String findByEmail(String email);

}
