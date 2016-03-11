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

import com.gll.model.uxfeed.AnnotationModel;
import com.gll.service.uxfeed.AnnotationService;

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

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/annotations/{annotationId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AnnotationModel> getSinglRecord(@PathVariable("userId") int userId, @PathVariable("websiteId") int websiteId, @PathVariable("annotationId") int annotationId) {
		System.out.println("Fetching AnnotationModel with annotationId " + annotationId);
		AnnotationModel annotationModel = annotationService.display(annotationId);
		if (annotationModel == null) {
			System.out.println("AnnotationModel with annotationId " + annotationId + " not found");
			return new ResponseEntity<AnnotationModel>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AnnotationModel>(annotationModel, HttpStatus.OK);
	}

	// -------------------Create a Record -----------------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/annotations", method = RequestMethod.POST)
	public ResponseEntity<Void> save(@PathVariable("userId") int userId, @PathVariable("websiteId") int websiteId, @RequestBody AnnotationModel annotationModel, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating AnnotationModel " + annotationModel.getAnnotationText());

		if (annotationService.display(annotationModel.getAnnotationId()) != null) {
			System.out.println("A AnnotationModel with name " + annotationModel.getAnnotationText() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		annotationService.save(annotationModel);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/users/{userId}/websites/{websiteId}/annotations").buildAndExpand(annotationModel.getAnnotationId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Record -------------------------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/annotations/{annotationId}", method = RequestMethod.PUT)
	public ResponseEntity<AnnotationModel> update(@PathVariable("userId") int userId,	@PathVariable("websiteId") int websiteId, @PathVariable("annotationId") int annotationId, @RequestBody AnnotationModel annotationModel) {
		System.out.println("Updating AnnotationModel " + annotationId);
		AnnotationModel currentAnnotationModel = annotationService.display(annotationId);
		System.out.println("Going to update AnnotationModel : " + currentAnnotationModel);
		if (currentAnnotationModel == null) {
			System.out.println("AnnotationModel with annotationId " + annotationId + " not found");
			return new ResponseEntity<AnnotationModel>(HttpStatus.NOT_FOUND);
		}

		currentAnnotationModel.setAnnotationId(annotationModel.getAnnotationId());
		currentAnnotationModel.setUserId(annotationModel.getUserId());
		currentAnnotationModel.setWebsiteId(annotationModel.getWebsiteId());
		currentAnnotationModel.setAnnotationText(annotationModel.getAnnotationText());
		
		annotationService.update(currentAnnotationModel);
		return new ResponseEntity<AnnotationModel>(currentAnnotationModel, HttpStatus.OK);
	}

	// ------------------- Delete a Record ----------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/annotations/{annotationId}", method = RequestMethod.DELETE)
	public ResponseEntity<AnnotationModel> delete(@PathVariable("userId") int userId, @PathVariable("websiteId") int websiteId, @PathVariable("annotationId") int annotationId) {
		System.out.println("Fetching & Deleting AnnotationModel with annotationId " + annotationId);
		AnnotationModel annotationModel = annotationService.display(annotationId);
		if (annotationModel == null) {
			System.out.println("Unable to delete. AnnotationModel with annotationId " + annotationId + " not found");
			return new ResponseEntity<AnnotationModel>(HttpStatus.NOT_FOUND);
		}
		annotationService.delete(annotationId);
		return new ResponseEntity<AnnotationModel>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All ---------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/annotations/", method = RequestMethod.DELETE)
	public ResponseEntity<AnnotationModel> deleteAll() {
		System.out.println("Deleting All AnnotationModels");
		annotationService.delete(1);
		return new ResponseEntity<AnnotationModel>(HttpStatus.NO_CONTENT);
	}

}