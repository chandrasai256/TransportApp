package com.stackroute.service;

import java.util.List;

import com.stackroute.model.Places;

public interface PlacesService {

	public Places addPlaces(Places places);
	public Places findByPlaceNames(String placeName);
	public List<Places> getAllPlaces();
	
}
