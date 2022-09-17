import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FavoritesService {

  addingURL = "http://localhost:8181/favorites/addFavorites"

  gettingURL = "http://localhost:8181/favorites/"

  deletingURL = "http://localhost:8181/favorites/deleteFav"

  constructor(private httpClient: HttpClient) { }

  //add to favs
  addToFavorites(favorite: any) {
    return this.httpClient.post(`${this.addingURL}`, favorite);
  }

  //get user favs
  getUserFavorites(userId: number) {
    return this.httpClient.get(`http://localhost:8181/favorites/${userId}`);
  }

  //remove from favs
  removeFromFavorites(userId: number, favPlace: string) {
    return this.httpClient.delete(`http://localhost:8181/favorites/deleteFav/${userId}/${favPlace}`);
  }

}
