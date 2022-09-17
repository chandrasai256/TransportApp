package com.stackroute.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.stackroute.model.Favorites;
import com.stackroute.model.FavoritesComposite;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, FavoritesComposite> {
	List<Favorites> findByFavoritesCompositeUserId(Integer userId);
}
