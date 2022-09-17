import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  
  hide = true;
  
  constructor(private userService: UserService) { }

  user={
    userName: "",
    password: "",
    city: "",
    email: "",
    phoneNo: ""
  }

  ngOnInit(): void {
  }

  onSubmit(){
    if(this.user.userName==='' || this.user.userName===null
    || this.user.password==='' || this.user.password===null
    || this.user.city==='' || this.user.city===null
    || this.user.email==='' || this.user.email===null
    || this.user.phoneNo==='' || this.user.phoneNo===null) {
      alert("Please enter all the details")
    } else {
      this.userService.createUser(this.user).subscribe(
        data=>{
          alert("New User Created Successfully :)")
          location.href=''
        }, error => {
          alert("Something went wrong !! Unable to create new user \n Try a different user name")
          console.log(error)
        }
      )
    }
  }

}
