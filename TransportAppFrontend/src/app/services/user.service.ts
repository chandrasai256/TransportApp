import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  registerURL = "http://localhost:8181/register"

  usersURL = "http://localhost:8181/users"

  updateURL = "http://localhost:8181/update"

  constructor(private httpClient: HttpClient) { }

  // CRUD Operations

  //Create - Post
  createUser(user: any){
    return this.httpClient.post(`${this.registerURL}`, user)
  }

  //Read - Get
  getUserId(userName: string){
    return this.httpClient.get(`http://localhost:8181/users/userNames/${userName}`)
  }

  getUser(userId: number){
    return this.httpClient.get(`http://localhost:8181/users/${userId}`)
  }

  //Update - Put
  updateUser(user: any, userId: number){
    return this.httpClient.put(`http://localhost:8181/update/${userId}`, user)
  }

  //Delete - Delete
  deleteUser(userId: number){
    return this.httpClient.delete(`http://localhost:8181/users/${userId}`)
  }
}
