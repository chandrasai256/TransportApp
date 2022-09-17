package com.stackroute.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.model.Places;
import com.stackroute.service.PlacesService;

@RestController
@RequestMapping("/places")
@CrossOrigin(origins = "*")
public class PlacesController {

	@Autowired
	PlacesService placesService;
	
	//Add New Place
	@PostMapping("/")
	public ResponseEntity<Places> addNewPlace(@RequestBody Places places) {
		return new ResponseEntity<Places>(placesService.addPlaces(places), HttpStatus.CREATED);
	}
	
	//Get By Name
	@GetMapping("/{placeName}")
	public ResponseEntity<Places> findPlaceByEntityPlaceName(@PathVariable String placeName) {
		try {
			Places place = placesService.findByPlaceNames(placeName);
			return new ResponseEntity<Places>(place, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Places>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/")
	public ResponseEntity<List<Places>> getAllPlaces(){
		return new ResponseEntity<List<Places>>(placesService.getAllPlaces(), HttpStatus.OK);
	}
	
}
