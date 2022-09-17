package com.stackroute.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.model.Places;
@Repository
public interface PlacesRepository extends JpaRepository<Places, String> {

	public Places findByPlaceName(String placeName);
	
}
