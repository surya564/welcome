package com.example.demo.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@NoArgsConstructor

@Setter

@Getter

@Table(name = "Users_Table")

public class Users {

	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "Users_Id")
	
	private int id;
	
	@Column(name = "Users_Name",nullable = false, length = 40)
	
	private String Name;
	
	@Column(length = 40)
	
	private String Email;
	
	@Column(length = 20)
	private String Password;
	
    @NotNull
    
	private String About;
//    
//    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private List<Post> posts = new ArrayList<>();
//	
	
	
}
