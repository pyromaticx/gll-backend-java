package com.gll.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.gll.model.AnnotationModel;
import com.gll.service.AnnotationService;

@RestController
public class AnnotationController {

	private static final Logger logger = Logger.getLogger(AnnotationController.class);

	@Autowired
	AnnotationService annotationService;

	// -------------------Retrieve All -----------------------------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/annotations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AnnotationModel>> displayAll(@PathVariable("userId") int userId, @PathVariable("websiteId") int websiteId) {
		List<AnnotationModel> annotationList = annotationService.displayAll();
		if (annotationList.isEmpty()) {
			return new ResponseEntity<List<AnnotationModel>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AnnotationModel>>(annotationList, HttpStatus.OK);
	}

	// -------------------Retrieve Single Record -----------------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/annotations/{pinId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AnnotationModel> getSinglRecord(@PathVariable("userId") int userId, @PathVariable("websiteId") int websiteId, @PathVariable("pinId") int pinId) {
		logger.info("********************: Fetching AnnotationModel with pinId " + pinId);
		AnnotationModel annotationModel = annotationService.display(pinId);
		if (annotationModel == null) {
			logger.info("AnnotationModel with annotationId " + pinId + " not found");
			return new ResponseEntity<AnnotationModel>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AnnotationModel>(annotationModel, HttpStatus.OK);
	}

	// -------------------Create a Record -----------------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/annotations", method = RequestMethod.POST)
	public ResponseEntity<Void> save(@PathVariable("userId") int userId, @PathVariable("websiteId") int websiteId, @RequestBody AnnotationModel annotationModel, UriComponentsBuilder ucBuilder) {
	
		if (annotationService.display(annotationModel.getPinId()) != null) {
			logger.info("A AnnotationModel with name " + annotationModel.getText() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		annotationService.save(annotationModel);

		HttpHeaders headers = new HttpHeaders();
	
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("userId", annotationModel.getUserId());
		map.put("websiteId", annotationModel.getWebsiteId());
		map.put("pinId", annotationModel.getPinId());

		headers.setLocation(ucBuilder.path("/users/{userId}/websites/{websiteId}/annotations").buildAndExpand(map).toUri());
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Record -------------------------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/annotations/{annotationId}", method = RequestMethod.PUT)
	public ResponseEntity<AnnotationModel> update(@PathVariable("userId") int userId,	@PathVariable("websiteId") int websiteId, @PathVariable("pinId") int pinId, @RequestBody AnnotationModel annotationModel) {
		logger.info("Updating AnnotationModel " + pinId);
		AnnotationModel currentAnnotationModel = annotationService.display(pinId);
		logger.info("Going to update AnnotationModel : " + currentAnnotationModel);
		if (currentAnnotationModel == null) {
			logger.info("AnnotationModel with pinId " + pinId + " not found");
			return new ResponseEntity<AnnotationModel>(HttpStatus.NOT_FOUND);
		}

		/*currentAnnotationModel.setPinId(annotationModel.getPinId());
		currentAnnotationModel.setUserId(annotationModel.getUserId());
		currentAnnotationModel.setWebsiteId(annotationModel.getWebsiteId());
		currentAnnotationModel.setText(annotationModel.getText());*/
		
		annotationService.update(annotationModel);
		return new ResponseEntity<AnnotationModel>(annotationModel, HttpStatus.OK);
	}

	// ------------------- Delete a Record ----------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/annotations/{pinId}", method = RequestMethod.DELETE)
	public ResponseEntity<AnnotationModel> delete(@PathVariable("userId") int userId, @PathVariable("websiteId") int websiteId, @PathVariable("pinId") int pinId) {
		logger.info("Fetching & Deleting AnnotationModel with pinId " + pinId);
		AnnotationModel annotationModel = annotationService.display(pinId);
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
		annotationService.delete(1);
		return new ResponseEntity<AnnotationModel>(HttpStatus.NO_CONTENT);
	}

}