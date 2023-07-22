package com.example.demo.Repositorry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
