package com.stackroute.service;

import java.util.List;

import com.stackroute.model.Users;


public interface UserService {

						public void saveUser(Users usr);
						public List<Users> findAllUsers();
						public void deleteUsersById(int id);
						public Users findById(int id);
						public int findByUserName(String userName);
						public void updateUser(Users usr); 
						
	
}
