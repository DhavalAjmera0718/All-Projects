import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { jwtDecode } from 'jwt-decode';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceSisService {

  constructor(private httpclient: HttpClient) { }



  // CALL SERVER TO GENERET TOKEN 



  authUrl = "http://localhost:8090/auth"
  adminUrl= "http://localhost:8090/admin"

/*********************************************[ For AUTHENTICATION ] **************************************************************/
  TokenGeneration(loginData: any) //:Observable<any>
  {

    return this.httpclient.post(this.authUrl + "/login1" ,loginData)


  }

  LoginUser(loginData: any) {
    localStorage.setItem("jwtToken", loginData)
    const decodedData: any = jwtDecode(loginData);
    const username = decodedData.user_name;
    
    console.log( "Decoded Authorities---->" + decodedData.authorities)
    const authorities = decodedData.authorities[0]; // Extracting authorities from token payload
    const payload = { username, authorities }; // Creating payload object
    
    localStorage.setItem('username', username);
    localStorage.setItem('role', authorities);
    // window.location.reload();
    return payload;
    // return true;
    // this.httpclient.post(this.basUrl + "/login1" , loginData , {responseType : 'text'})
  }

  // TO  CHECK USER IS LOGGED IN OR NOT
  isLoggedIn() {
    let tokenVerified = localStorage.getItem("jwtToken")
    if (tokenVerified == undefined || tokenVerified === '' || tokenVerified == null) {
      return false;
    }
    else {
      return true;
    }
  }


  LogOut() {
    localStorage.removeItem('jwtToken')
    return true;
  }

  getToken() {
    return localStorage.getItem('jwtToken')
  }

/************************************************* NOW WE HAVE TO GET DATA TO CHECK AUTHANTICATION  ************************************************************/
getAllUserData() :Observable<any>
{
  return this.httpclient.get(this.adminUrl+"/getAllUser" , {responseType : 'json'})
}

DeleteUserByid_FromAdmin(id:any)
{
  return this.httpclient.delete(this.adminUrl+"/deleteUser/"+id , {responseType :'text'})
}

}
