package com.example.demo.Payloads;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UsersDto {

	
	private int id;
	
	@NotEmpty
	@Size(min = 8, message = "Username must be min of 4 characters")
	private String Name;
	
	
	@Email(message = "Email address is not vaild !!")
	private String Email;

	
	@NotEmpty
	@Size(min =4, max = 10, message = "password must be min of 3 char and max of 10 character")

	private String Password;
	
	
	@NotEmpty
	private String About;
}
