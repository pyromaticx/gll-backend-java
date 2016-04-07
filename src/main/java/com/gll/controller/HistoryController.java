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

import com.gll.model.HistoryModel;
import com.gll.service.HistoryService;

@RestController
public class HistoryController {

	private static final Logger logger = Logger.getLogger(HistoryController.class);

	@Autowired
	HistoryService historyService;

	// -------------------Retrieve All -----------------------------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/history", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<HistoryModel>> displayAll(@PathVariable("userId") int userId, @PathVariable("websiteId") int websiteId) {
		List<HistoryModel> historyList = historyService.displayAll();
		if (historyList.isEmpty()) {
			return new ResponseEntity<List<HistoryModel>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<HistoryModel>>(historyList, HttpStatus.OK);
	}

	// -------------------Retrieve Single Record -----------------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/history/{historyId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HistoryModel> getSinglRecord(@PathVariable("userId") int userId, @PathVariable("websiteId") int websiteId, @PathVariable("historyId") int historyId) {
		System.out.println("Fetching HistoryModel with historyId " + historyId);
		HistoryModel historyModel = historyService.display(historyId);
		if (historyModel == null) {
			System.out.println("HistoryModel with historyId " + historyId + " not found");
			return new ResponseEntity<HistoryModel>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<HistoryModel>(historyModel, HttpStatus.OK);
	}

	// -------------------Create a Record -----------------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/history", method = RequestMethod.POST)
	public ResponseEntity<Void> save(@PathVariable("userId") int userId, @PathVariable("websiteId") int websiteId, @RequestBody HistoryModel historyModel, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating HistoryModel " + historyModel.getHistoryId());

		if (historyService.display(historyModel.getHistoryId()) != null) {
			System.out.println("A HistoryModel with Id " + historyModel.getHistoryId() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		historyService.save(historyModel);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/users/{userId}/websites/{websiteId}/history").buildAndExpand(historyModel.getHistoryId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Record -------------------------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/history/{historyId}", method = RequestMethod.PUT)
	public ResponseEntity<HistoryModel> update(@PathVariable("userId") int userId,	@PathVariable("websiteId") int websiteId, @PathVariable("historyId") int historyId, @RequestBody HistoryModel historyModel) {
		System.out.println("Updating HistoryModel " + historyId);
		HistoryModel currentHistoryModel = historyService.display(historyId);
		System.out.println("Going to update HistoryModel : " + currentHistoryModel);
		if (currentHistoryModel == null) {
			System.out.println("HistoryModel with historyId " + historyId + " not found");
			return new ResponseEntity<HistoryModel>(HttpStatus.NOT_FOUND);
		}

		currentHistoryModel.setHistoryId(historyModel.getHistoryId());
		currentHistoryModel.setUserId(historyModel.getUserId());
		currentHistoryModel.setWebsiteId(historyModel.getWebsiteId());
		currentHistoryModel.setDateTime(historyModel.getDateTime());
		
		historyService.update(currentHistoryModel);
		return new ResponseEntity<HistoryModel>(currentHistoryModel, HttpStatus.OK);
	}

	// ------------------- Delete a Record ----------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/history/{historyId}", method = RequestMethod.DELETE)
	public ResponseEntity<HistoryModel> delete(@PathVariable("userId") int userId, @PathVariable("websiteId") int websiteId, @PathVariable("historyId") int historyId) {
		System.out.println("Fetching & Deleting HistoryModel with historyId " + historyId);
		HistoryModel historyModel = historyService.display(historyId);
		if (historyModel == null) {
			System.out.println("Unable to delete. HistoryModel with historyId " + historyId + " not found");
			return new ResponseEntity<HistoryModel>(HttpStatus.NOT_FOUND);
		}
		historyService.delete(historyId);
		return new ResponseEntity<HistoryModel>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All ---------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/history", method = RequestMethod.DELETE)
	public ResponseEntity<HistoryModel> deleteAll() {
		System.out.println("Deleting All HistoryModels");
		historyService.delete(1);
		return new ResponseEntity<HistoryModel>(HttpStatus.NO_CONTENT);
	}

}