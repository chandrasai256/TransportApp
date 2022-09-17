package com.stackroute.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.model.Directions;
import com.stackroute.repo.DirectionsRepository;

@Service
@Transactional
public class DirectionsServiceImpl implements DirectionsService{

	@Autowired
	DirectionsRepository directionsRepository;

	@Override
	public Directions addDirections(Directions directions) {
		
		return this.directionsRepository.save(directions);
	}

	@Override
	public List<Directions> getAllDirections() {
		return directionsRepository.findAll();
	}

	@Override
	public List<Integer> findByOringinAndDestination(String origin, String destination) {
		List<Directions> reqDirections = directionsRepository.findByOriginAndDestination(origin, destination);
		List<Integer> dirIds = new ArrayList<>();
		for (Directions directions : reqDirections) {
			dirIds.add(directions.getDirId());
		}
		return dirIds;
	}
	
}
