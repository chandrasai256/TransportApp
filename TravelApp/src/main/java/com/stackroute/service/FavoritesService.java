package com.stackroute.service;

import java.util.List;

import com.stackroute.model.Favorites;
import com.stackroute.model.FavoritesComposite;

public interface FavoritesService {
	public List<Favorites> findByFavoritesCompositeUserId(Integer userId);
	public Favorites addToFavorites(Favorites favorites);
	public Favorites removeFromFavorites(Favorites favorites);
	List<Favorites> getAll();
}
