package com.stackroute.controller;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stackroute.model.Users;
import com.stackroute.service.UserService;

import com.stackroute.util.JWTUtil;

import com.stackroute.model.AuthRequest;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping
public class HomeController {
	
	@Autowired
	UserService userService;
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JWTUtil myUtil;
	
	//Read data
	@GetMapping("/users")
	public List<Users> users(){
		return userService.findAllUsers();
		}
	@GetMapping("/users/{userId}")
	public ResponseEntity<Users> get(@PathVariable Integer userId)
	{		
		System.out.println("Finding user"+userId);
			try {
				Users users = userService.findById(userId);
				return new ResponseEntity<Users>(users,HttpStatus.OK);
			} catch (NoSuchElementException e)  {
				return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
			}
	}
	@GetMapping("/users/userNames/{userName}")
	public int getUserId(@PathVariable String userName) {
		try {
			int userId = userService.findByUserName(userName);
			return userId;
		} catch (NoSuchElementException e)  {
			return -1;
		}
	}
	//Create
	@PostMapping("/register")
	public void add(@RequestBody Users usr)
	{	
		System.out.println("New User");
		userService.saveUser(usr);
		
	}
	//Update
	@PutMapping("/update/{userId}")
	public ResponseEntity<Users> update(@RequestBody Users usr,@PathVariable Integer userId){
		try 
		{
			Users existUser = userService.findById(userId);
			existUser.setUserName(usr.getUserName());
			existUser.setPassword(usr.getPassword());
			existUser.setCity(usr.getCity());
			existUser.setEmail(usr.getEmail());
			existUser.setPhoneNo(usr.getPhoneNo());
			userService.updateUser(existUser);
			return new ResponseEntity<Users>(HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}
		
	}
	//Delete
	@DeleteMapping("/users/{userId}")
	public void delete(@PathVariable Integer userId) {
		userService.deleteUsersById(userId);
	
	}

	
	  @PostMapping("/login") 
	  public String generateToken(@RequestBody AuthRequest authrequest) throws Exception{ 
		  try{ authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authrequest.getUserName(),
			   authrequest.getPassword())); 
		  } catch(Exception e) { 
			  throw new Exception("Invalid username and password"); 
		  }
		  return myUtil.generateToken(authrequest.getUserName()); 
	  }	
	
}
