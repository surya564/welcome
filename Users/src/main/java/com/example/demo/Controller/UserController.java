package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

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
import com.example.demo.Payloads.UsersDto;
import com.example.demo.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	
	UserService service;
	
	
	@PostMapping("/insert")
	public ResponseEntity<UsersDto> AddUsers (@Valid @RequestBody UsersDto userdto){
		
		UsersDto usersdto = this.service.AddUsers(userdto);
		
		return new ResponseEntity<>(usersdto,HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<UsersDto> UpdateUser( @Valid @RequestBody UsersDto userdto,@PathVariable int id){
		
		UsersDto updateUser = this.service.UpdateUsers(userdto, id);
		
		return ResponseEntity.ok(updateUser);
	}
	

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteUser( @Valid @PathVariable int id){
		
	           this.service.DeleteUsers(id);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully :" +id, true),HttpStatus.OK);
	}
	
	
	@GetMapping("/getallusers")
	public ResponseEntity<List<UsersDto>> getAllUsers(){
	
		return ResponseEntity.ok(this.service.GetAllUsers());
	}
	
	
	
	@GetMapping("{id}")
	public ResponseEntity<UsersDto> GetUserById(@Valid @PathVariable int id){
		
		return ResponseEntity.ok(this.service.GetByUserId(id));
	}
	
	
}
