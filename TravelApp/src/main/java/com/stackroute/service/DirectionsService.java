package com.stackroute.service;

import java.util.List;

import com.stackroute.model.Directions;

public interface DirectionsService {
	
	public Directions addDirections(Directions directions);	
	public List<Integer> findByOringinAndDestination(String origin, String destination);
	public List<Directions> getAllDirections();
}
