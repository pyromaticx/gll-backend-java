package com.gll.controller;

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

import com.gll.model.WebsiteModel;
import com.gll.service.WebsiteService;


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
    public ResponseEntity<WebsiteModel> save(@RequestBody WebsiteModel websiteModel,    UriComponentsBuilder ucBuilder) {
        logger.info("Creating WebsiteModel " + websiteModel.getDomainName());
        WebsiteModel temp = websiteService.findByDomainName(websiteModel.getDomainName());
        if (temp != null) {
            logger.info("A WebsiteModel with name " + websiteModel.getDomainName() + " already exist");
            return new ResponseEntity<WebsiteModel>(temp, HttpStatus.ALREADY_REPORTED);
        }
 
        websiteService.postWebsite(websiteModel);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/users/{userId}/websites").buildAndExpand(websiteModel.getUserId()).toUri());
        return new ResponseEntity<WebsiteModel>(headers, HttpStatus.CREATED);
    }
     
    //------------------- Update a Record -------------------------------
     
    @RequestMapping(value = "/users/{userId}/websites/{websiteId}", method = RequestMethod.PUT)
    public ResponseEntity<WebsiteModel> update(@PathVariable("userId") int userId, @PathVariable("websiteId") int websiteId, @RequestBody WebsiteModel websiteModel) {
        logger.info("Updating WebsiteModel " + websiteId);
        WebsiteModel currentWebsiteModel = websiteService.getWebsite(websiteId);
        System.out.println("****************************** : " + currentWebsiteModel);
         logger.debug("Going to update WebsiteModel : " + currentWebsiteModel);
        if (currentWebsiteModel==null) {
            logger.debug("WebsiteModel with websiteId " + websiteId + " not found");
            return new ResponseEntity<WebsiteModel>(HttpStatus.NOT_FOUND);
        }
 
        currentWebsiteModel.setUserId(websiteModel.getUserId());
        currentWebsiteModel.setWebsiteId(websiteModel.getWebsiteId());
        currentWebsiteModel.setDomainName(websiteModel.getDomainName());
        currentWebsiteModel.setRootDomain(websiteModel.getRootDomain());
         
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