package com.stackroute.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.model.Users;
import com.stackroute.repo.UserRepo;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public void saveUser(Users usr) {
		userRepo.save(usr);
		
	}

	@Override
	public List<Users> findAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public void deleteUsersById(int id) {
		userRepo.deleteById(id);
		
	}

	@Override
	public Users findById(int id) {
		Optional<Users> userRec=userRepo.findById(id);  
		if(userRec.isPresent())	{	
			return userRec.get();
		}
		return null;
	}

	@Override
	public void updateUser(Users usr) {
		userRepo.save(usr);
		
	}

	@Override
	public int findByUserName(String userName) {
		Users user = userRepo.findByUserName(userName);
		return user.getId();
	}


}
