package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.example.demo.Payloads.ApiResponse;
import com.example.demo.Payloads.CategoryDao;
import com.example.demo.Payloads.UsersDto;
import com.example.demo.Service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class CategoriesController {

	
	@Autowired
	
	CategoryService service;
	
	
	@PostMapping("/Addcategory")
	public ResponseEntity<CategoryDao> AddCategory(@Valid @RequestBody CategoryDao categorydao){
		
		CategoryDao categoryDao1 = this.service.AddCategory(categorydao);
		
		
		return new ResponseEntity<>(categoryDao1,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/updateCategory/{categoryid}")
	public ResponseEntity<CategoryDao> UpdateCategoryDao(@Valid @PathVariable int categoryid, @RequestBody CategoryDao categorydao){
		
		CategoryDao categorydao1 = this.service.UpdateCategory(categorydao, categoryid);
		
		return ResponseEntity.ok(categorydao1);
	}
	
	
	@DeleteMapping("/updatecategories/{id}")
	public ResponseEntity<ApiResponse> DeleteCategories(@Valid @PathVariable int categoryid){
		
		 this.service.DeleteCategory(categoryid);
		 
		 return new ResponseEntity<ApiResponse>(new ApiResponse("categories deleted successfully",true),HttpStatus.OK);
	}
	
	
	@GetMapping("/getallCategories")
	public ResponseEntity<List<CategoryDao>> getAllUsers(){
	
		return ResponseEntity.ok(this.service.getAllCategory());
	}
	
	
	
	@GetMapping("/categories/{id}")
	public ResponseEntity<CategoryDao> GetUserById(@Valid @PathVariable int categoryid){
		
		return ResponseEntity.ok(this.service.getById(categoryid));
	}
	

}
