package com.jpt.restservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.jpt.restservice.entity.User;
import com.jpt.restservice.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	
/*	@PreAuthorize("hasRole('ROLE_USER')")*/
	@RequestMapping(value="/users/" ,method=RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers(){
		System.out.println("sdfdfsdf");
		 List<User> users = userService.getAllUsers();
		 System.out.println(">"+users.size());
	        if(users.isEmpty()){
	            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		
	}
	
	//-------------------Retrieve Single User--------------------------------------------------------
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        Optional<User> user = userService.findById(id);
      
        if (!user.isPresent()) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user.get(), HttpStatus.OK);
    }
    
    
    //-------------------Create a User--------------------------------------------------------
    
    @RequestMapping(value = "/user/", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody User user,UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getFirstName());
 
        if (userService.isUserExist(user)) {
            System.out.println("A User with name " + user.getFirstName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        userService.saveUser(user);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    
    //------------------- Update a User --------------------------------------------------------
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        System.out.println("Updating User " + id);
         
        Optional<User> currentUser = userService.findById(id);
         
        if (!currentUser.isPresent()) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
 
        User updateUser=currentUser.get();
        updateUser.setAge(user.getAge());
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
         
        userService.updateUser(updateUser);
        return new ResponseEntity<User>(updateUser, HttpStatus.OK);
    }
    
    
    //------------------- Delete a User --------------------------------------------------------
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);
 
        Optional<User> user = userService.findById(id);
        if (!user.isPresent()) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
 
        userService.deleteUserById(user.get());
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
 
	
}
