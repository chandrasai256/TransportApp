package com.stackroute.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.model.Directions;
@Repository
public interface DirectionsRepository extends JpaRepository<Directions, Integer>{
	public List<Directions> findByOriginAndDestination(String origin, String destination);
}
