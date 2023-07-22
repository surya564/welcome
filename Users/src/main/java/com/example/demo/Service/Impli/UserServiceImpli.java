package com.example.demo.Service.Impli;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ExeceptionHandling.ResourceNotFoundException;
import com.example.demo.Models.Users;
import com.example.demo.Payloads.UsersDto;
import com.example.demo.Repositorry.UserRepository;
import com.example.demo.Service.UserService;

@Service
public class UserServiceImpli implements UserService {

	@Autowired

	UserRepository repo;

	
	@Autowired
	
	ModelMapper modelmapper;
	
	@Override
	public UsersDto AddUsers(UsersDto usersdto) {

		Users user = this.dtotousers(usersdto);

		Users saveduser = this.repo.save(user);

		return this.usertodto(saveduser);
	}

	@Override
	public UsersDto UpdateUsers(UsersDto usersdto, int id) {

		Users user = this.repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Users", "id", id));

		user.setName(usersdto.getName());
		user.setEmail(usersdto.getEmail());
		user.setPassword(usersdto.getPassword());
		user.setAbout(usersdto.getAbout());

		Users UpdateUser = this.repo.save(user);

		UsersDto userdto1 = this.usertodto(UpdateUser);

		return userdto1;
	}

	@Override
	public void DeleteUsers(int id) {

		Users users = this.repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Users", "id", id));

		this.repo.delete(users);
	}

	@Override
	public List<UsersDto> GetAllUsers() {

		List<Users> users = this.repo.findAll();

		List<UsersDto> usersdto = users.stream().map(user -> this.usertodto(user)).collect(Collectors.toList());

		return usersdto;
	}

	@Override
	public UsersDto GetByUserId(int id) {

		Users user = this.repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Users", "id", id));

		return this.usertodto(user);
	}
	
	public UsersDto getByEmail(String Email) {
		
	Users user = this.repo.findByEmail(Email).orElseThrow(()-> new ResourceNotFoundException("email", "email", Email));
	
	return this.usertodto(user);
	}

	public Users dtotousers(UsersDto userdto) {

		Users user = this.modelmapper.map(userdto, Users.class);

//		user.setId(userdto.getId());
//		user.setName(userdto.getName());
//		user.setEmail(userdto.getEmail());
//		user.setPassword(userdto.getPassword());
//		user.setAbout(userdto.getAbout());

		return user;
	}

	public UsersDto usertodto(Users user) {

		UsersDto usersdto = this.modelmapper.map(user, UsersDto.class);
//
//		usersdto.setId(user.getId());
//		usersdto.setName(user.getName());
//		usersdto.setEmail(user.getEmail());
//		usersdto.setPassword(user.getPassword());
//		usersdto.setAbout(user.getAbout());

		return usersdto;
	}
}
