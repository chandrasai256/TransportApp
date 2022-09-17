package com.stackroute.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.model.Places;
import com.stackroute.repo.PlacesRepository;

@Service
@Transactional
public class PlacesServiceImpl implements PlacesService {

	@Autowired
	PlacesRepository placesRepository;
	
	@Override
	public Places findByPlaceNames(String placeName) {
		
		return placesRepository.findByPlaceName(placeName);
		
	}

	@Override
	public Places addPlaces(Places places) {
		return placesRepository.save(places);
	}

	@Override
	public List<Places> getAllPlaces() {
		return placesRepository.findAll();
	}

}
