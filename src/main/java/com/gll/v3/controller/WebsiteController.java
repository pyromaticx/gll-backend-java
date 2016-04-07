package com.gll.v3.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.gll.domain.WebsiteModel;
import com.gll.repository.WebsiteService;

@RestController
public class WebsiteController {
 
	private static final Logger logger = Logger.getLogger(WebsiteController.class);

    @Autowired
    WebsiteService websiteService; 
 
     
    //-------------------Retrieve All -----------------------------------
     
    @RequestMapping(value = "/users/{userId}/websites", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<WebsiteModel>> getAllRecords(@PathVariable("userId") long userId, Pageable pageable) {
        Page<WebsiteModel> websiteList = websiteService.findAll(pageable);
        if(!websiteList.hasContent()){
            return new ResponseEntity<Page<WebsiteModel>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Page<WebsiteModel>>(websiteList, HttpStatus.OK);
    }
 
 
    //-------------------Retrieve Single Record------------------------------------------------
     
    @RequestMapping(value = "/users/{userId}/websites/{websiteId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WebsiteModel> getSinglRecord(@PathVariable("userId") long userId, @PathVariable("websiteId") long websiteId) {
        logger.info("Fetching WebsiteModel with websiteId " + websiteId);
        WebsiteModel websiteModel = websiteService.findOne(websiteId);
        if (websiteModel == null) {
            logger.info("WebsiteModel with websiteId " + websiteId + " not found");
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
 
        websiteService.save(websiteModel);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/users/{userId}/websites").buildAndExpand(websiteModel.getUserId()).toUri());
        return new ResponseEntity<WebsiteModel>(headers, HttpStatus.CREATED);
    }
 
     
    //------------------- Update a Record -------------------------------
     
    @RequestMapping(value = "/users/{userId}/websites/{websiteId}", method = RequestMethod.PUT)
    public ResponseEntity<WebsiteModel> update(@PathVariable("userId") long userId, @PathVariable("websiteId") long websiteId, @RequestBody WebsiteModel websiteModel) {
        logger.info("Updating WebsiteModel " + websiteId);
        WebsiteModel currentWebsiteModel = websiteService.findOne(websiteId);
         logger.info("Going to update WebsiteModel : " + currentWebsiteModel);
        if (currentWebsiteModel==null) {
            logger.info("WebsiteModel with websiteId " + websiteId + " not found");
            return new ResponseEntity<WebsiteModel>(HttpStatus.NOT_FOUND);
        }
        websiteService.save(currentWebsiteModel);
        return new ResponseEntity<WebsiteModel>(currentWebsiteModel, HttpStatus.OK);
    }
 
    //------------------- Delete a Record --------------------------------------------------------
     
    @RequestMapping(value = "/users/{userId}/websites/{websiteId}", method = RequestMethod.DELETE)
    public ResponseEntity<WebsiteModel> delete(@PathVariable("userId") long userId, @PathVariable("websiteId") long websiteId) {
        logger.info("Fetching & Deleting WebsiteModel with websiteId " + websiteId);
        WebsiteModel websiteModel = websiteService.findOne(websiteId);
        if (websiteModel == null) {
            logger.info("Unable to delete. WebsiteModel with websiteId " + websiteId + " not found");
            return new ResponseEntity<WebsiteModel>(HttpStatus.NOT_FOUND);
        }
        websiteService.delete(websiteId);
        return new ResponseEntity<WebsiteModel>(HttpStatus.NO_CONTENT);
    }
 
     
    //------------------- Delete All --------------------------------------------
     
    @RequestMapping(value = "/users/{userId}/websites", method = RequestMethod.DELETE)
    public ResponseEntity<WebsiteModel> deleteAll() {
        System.out.println("Deleting All WebsiteModels");
        websiteService.deleteAll();
        return new ResponseEntity<WebsiteModel>(HttpStatus.NO_CONTENT);
    }
 
}