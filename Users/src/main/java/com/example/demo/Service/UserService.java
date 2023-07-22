package com.example.demo.Service;

import java.util.List;

import com.example.demo.Payloads.UsersDto;

public interface UserService {


	UsersDto AddUsers(UsersDto usersdto);
	

	
    

    
    
	List<UsersDto> GetAllUsers();
    
    



	UsersDto UpdateUsers(UsersDto usersdto, int id);


	void DeleteUsers(int id);


	UsersDto GetByUserId(int id);

}
