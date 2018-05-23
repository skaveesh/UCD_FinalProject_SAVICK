package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Authorization {

@SerializedName("username")
@Expose
private String username;
@SerializedName("password")
@Expose
private String password;

/**
* No args constructor for use in serialization
*
*/
public Authorization() {
}

/**
*
* @param username
* @param password
*/
public Authorization(String username, String password) {
super();
this.username = username;
this.password = password;
}

public String getUsername() {
return username;
}

public void setUsername(String username) {
this.username = username;
}

public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}

}