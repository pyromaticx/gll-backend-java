package com.gll.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gll.model.UserModel;
import com.gll.service.UserService;
 

@RestController
public class UserController {
 
    @Autowired
    UserService userService;  //Service which will do all data retrieval/manipulation work
 
     
    //-------------------Retrieve All UserModels--------------------------------------------------------
     
    @RequestMapping(value = "/users/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserModel>> listAllUser() {
        List<UserModel> userList = userService.getAllUser();
        if(userList.isEmpty()){
            return new ResponseEntity<List<UserModel>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<UserModel>>(userList, HttpStatus.OK);
    }
 
 
    //-------------------Retrieve Single UserModel--------------------------------------------------------
     
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserModel> getUserModel(@PathVariable("id") int id) {
        System.out.println("Fetching UserModel with id " + id);
        UserModel userModel = userService.getUser(id);
        if (userModel == null) {
            System.out.println("UserModel with id " + id + " not found");
            return new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<UserModel>(userModel, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a UserModel--------------------------------------------------------
     
    @RequestMapping(value = "/users/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUserModel(@RequestBody UserModel userModel,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating UserModel " + userModel.getName());
        
        if (userService.getUser(userModel.getId()) != null) {
            System.out.println("A UserModel with name " + userModel.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        userService.postUser(userModel);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/users/{id}").buildAndExpand(userModel.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
     
    //------------------- Update a UserModel --------------------------------------------------------
     
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserModel> updateUserModel(@PathVariable("id") int id, @RequestBody UserModel UserModel) {
        System.out.println("Updating UserModel " + id);
         
        UserModel currentUserModel = userService.getUser(id);
         
        if (currentUserModel==null) {
            System.out.println("UserModel with id " + id + " not found");
            return new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND);
        }
 
        currentUserModel.setId(UserModel.getId());
        currentUserModel.setName(UserModel.getName());
        currentUserModel.setEmail(UserModel.getEmail());
         
        userService.putUser(currentUserModel);
        return new ResponseEntity<UserModel>(currentUserModel, HttpStatus.OK);
    }
 
    //------------------- Delete a UserModel --------------------------------------------------------
     
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UserModel> deleteUserModel(@PathVariable("id") Integer id) {
        System.out.println("Fetching & Deleting UserModel with id " + id);
 
        UserModel UserModel = userService.getUser(id);
        if (UserModel == null) {
            System.out.println("Unable to delete. UserModel with id " + id + " not found");
            return new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND);
        }
 
        userService.deleteUser(id.toString());
        return new ResponseEntity<UserModel>(HttpStatus.NO_CONTENT);
    }
 
     
    //------------------- Delete All UserModels --------------------------------------------------------
     
    @RequestMapping(value = "/users/", method = RequestMethod.DELETE)
    public ResponseEntity<UserModel> deleteAllUserModels() {
        System.out.println("Deleting All UserModels");
 
        userService.deleteUser("1");
        return new ResponseEntity<UserModel>(HttpStatus.NO_CONTENT);
    }
 
}