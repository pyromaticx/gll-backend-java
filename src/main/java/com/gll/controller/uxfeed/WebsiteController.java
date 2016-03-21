package com.gll.controller.uxfeed;

import java.util.List;

import org.apache.log4j.Logger;
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

import com.gll.model.security.UserModel;
import com.gll.model.uxfeed.WebsiteModel;
import com.gll.service.uxfeed.WebsiteService;


@RestController
public class WebsiteController {
 
	private static final Logger logger = Logger.getLogger(WebsiteController.class);

    @Autowired
    WebsiteService websiteService; 
 
     
    //-------------------Retrieve All -----------------------------------
     
    @RequestMapping(value = "/users/{userId}/websites", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WebsiteModel>> getAllRecords(@PathVariable("userId") int userId) {
        List<WebsiteModel> websiteList = websiteService.getAllWebsite();
        if(websiteList.isEmpty()){
            return new ResponseEntity<List<WebsiteModel>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<WebsiteModel>>(websiteList, HttpStatus.OK);
    }
 
 
    //-------------------Retrieve Single Record------------------------------------------------
     
    @RequestMapping(value = "/users/{userId}/websites/{websiteId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WebsiteModel> getSinglRecord(@PathVariable("userId") int userId, @PathVariable("websiteId") int websiteId) {
        System.out.println("Fetching WebsiteModel with websiteId " + websiteId);
        WebsiteModel websiteModel = websiteService.getWebsite(websiteId);
        if (websiteModel == null) {
            System.out.println("WebsiteModel with websiteId " + websiteId + " not found");
            return new ResponseEntity<WebsiteModel>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<WebsiteModel>(websiteModel, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a Record--------------------------------------------------------
     
    @RequestMapping(value = "/users/{userId}/websites", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody WebsiteModel websiteModel,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating WebsiteModel " + websiteModel.getDomainName());
        
        if (websiteService.getWebsite(websiteModel.getUserId()) != null) {
            System.out.println("A WebsiteModel with name " + websiteModel.getDomainName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        websiteService.postWebsite(websiteModel);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/users/{userId}/websites").buildAndExpand(websiteModel.getUserId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
     
    //------------------- Update a Record -------------------------------
     
    @RequestMapping(value = "/users/{userId}/websites/{websiteId}", method = RequestMethod.PUT)
    public ResponseEntity<WebsiteModel> update(@PathVariable("userId") int userId, @PathVariable("websiteId") int websiteId, @RequestBody WebsiteModel websiteModel) {
        System.out.println("Updating WebsiteModel " + websiteId);
        WebsiteModel currentWebsiteModel = websiteService.getWebsite(websiteId);
         System.out.println("Going to update WebsiteModel : " + currentWebsiteModel);
        if (currentWebsiteModel==null) {
            System.out.println("WebsiteModel with websiteId " + websiteId + " not found");
            return new ResponseEntity<WebsiteModel>(HttpStatus.NOT_FOUND);
        }
 
        currentWebsiteModel.setUserId(websiteModel.getUserId());
        currentWebsiteModel.setWebsiteId(websiteModel.getWebsiteId());
        currentWebsiteModel.setDomainName(websiteModel.getDomainName());
         
        websiteService.putWebsite(currentWebsiteModel);
        return new ResponseEntity<WebsiteModel>(currentWebsiteModel, HttpStatus.OK);
    }
 
    //------------------- Delete a Record --------------------------------------------------------
     
    @RequestMapping(value = "/users/{userId}/websites/{websiteId}", method = RequestMethod.DELETE)
    public ResponseEntity<WebsiteModel> delete(@PathVariable("userId") int userId, @PathVariable("websiteId") int websiteId) {
        System.out.println("Fetching & Deleting WebsiteModel with websiteId " + websiteId);
        WebsiteModel websiteModel = websiteService.getWebsite(websiteId);
        if (websiteModel == null) {
            System.out.println("Unable to delete. WebsiteModel with websiteId " + websiteId + " not found");
            return new ResponseEntity<WebsiteModel>(HttpStatus.NOT_FOUND);
        }
        websiteService.deleteWebsite(websiteId);
        return new ResponseEntity<WebsiteModel>(HttpStatus.NO_CONTENT);
    }
 
     
    //------------------- Delete All --------------------------------------------
     
    @RequestMapping(value = "/users/{userId}/websites", method = RequestMethod.DELETE)
    public ResponseEntity<WebsiteModel> deleteAll() {
        System.out.println("Deleting All WebsiteModels");
        websiteService.deleteWebsite(1);
        return new ResponseEntity<WebsiteModel>(HttpStatus.NO_CONTENT);
    }
 
}