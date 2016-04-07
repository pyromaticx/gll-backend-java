package com.gll.v3.controller;


import java.util.HashMap;
import java.util.Map;

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

import com.gll.domain.AnnotationModel;
import com.gll.domain.Poll;
import com.gll.repository.AnnotationService;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
public class AnnotationController {

	private static final Logger logger = Logger.getLogger(AnnotationController.class);

	@Autowired
	AnnotationService annotationService;

	// -------------------Retrieve All -----------------------------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/annotations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieves all the Annotations", response=Poll.class, responseContainer="List")
	public ResponseEntity<Page<AnnotationModel>> displayAll(@PathVariable("userId") int userId, @PathVariable("websiteId") int websiteId, Pageable pageable) {
		Page<AnnotationModel> annotationList = annotationService.findAll(pageable);
		if (!annotationList.hasContent()) {
			return new ResponseEntity<Page<AnnotationModel>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Page<AnnotationModel>>(annotationList, HttpStatus.OK);
	}

	// -------------------Retrieve Single Record -----------------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/annotations/{pinId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AnnotationModel> getSinglRecord(@PathVariable("userId") long userId, @PathVariable("websiteId") long websiteId, @PathVariable("pinId") long pinId) {
		logger.info("********************: Fetching AnnotationModel with pinId " + pinId);
		AnnotationModel annotationModel = annotationService.findOne(pinId);
		if (annotationModel == null) {
			logger.info("AnnotationModel with annotationId " + pinId + " not found");
			return new ResponseEntity<AnnotationModel>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AnnotationModel>(annotationModel, HttpStatus.OK);
	}

	// -------------------Create a Record -----------------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/annotations", method = RequestMethod.POST)
	public ResponseEntity<Void> save(@PathVariable("userId") long userId, @PathVariable("websiteId") long websiteId, @RequestBody AnnotationModel annotationModel, UriComponentsBuilder ucBuilder) {
	
		if (annotationService.findOne(annotationModel.getPinId()) != null) {
			logger.info("A AnnotationModel with name " + annotationModel.getText() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		annotationService.save(annotationModel);

		HttpHeaders headers = new HttpHeaders();
	
		Map<String,Long> map = new HashMap<String,Long>();
		map.put("userId", annotationModel.getUserId());
		map.put("websiteId", annotationModel.getWebsiteId());
		map.put("pinId", annotationModel.getPinId());

		headers.setLocation(ucBuilder.path("/users/{userId}/websites/{websiteId}/annotations").buildAndExpand(map).toUri());
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Record -------------------------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/annotations/{annotationId}", method = RequestMethod.PUT)
	public ResponseEntity<AnnotationModel> update(@PathVariable("userId") long userId,	@PathVariable("websiteId") long websiteId, @PathVariable("pinId") long pinId, @RequestBody AnnotationModel annotationModel) {
		logger.info("Updating AnnotationModel " + pinId);
		AnnotationModel currentAnnotationModel = annotationService.findOne(pinId);
		logger.info("Going to update AnnotationModel : " + currentAnnotationModel);
		if (currentAnnotationModel == null) {
			logger.info("AnnotationModel with pinId " + pinId + " not found");
			return new ResponseEntity<AnnotationModel>(HttpStatus.NOT_FOUND);
		}
		annotationService.save(annotationModel);
		return new ResponseEntity<AnnotationModel>(annotationModel, HttpStatus.OK);
	}

	// ------------------- Delete a Record ----------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/annotations/{pinId}", method = RequestMethod.DELETE)
	public ResponseEntity<AnnotationModel> delete(@PathVariable("userId") long userId, @PathVariable("websiteId") long websiteId, @PathVariable("pinId")  long pinId) {
		logger.info("Fetching & Deleting AnnotationModel with pinId " + pinId);
		AnnotationModel annotationModel = annotationService.findOne(pinId);
		if (annotationModel == null) {
			logger.info("Unable to delete. AnnotationModel with pinId " + pinId + " not found");
			return new ResponseEntity<AnnotationModel>(HttpStatus.NOT_FOUND);
		}
		annotationService.delete(pinId);
		return new ResponseEntity<AnnotationModel>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All ---------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/annotations", method = RequestMethod.DELETE)
	public ResponseEntity<AnnotationModel> deleteAll() {
		logger.info("Deleting All AnnotationModels");
		annotationService.deleteAll();
		return new ResponseEntity<AnnotationModel>(HttpStatus.NO_CONTENT);
	}

}