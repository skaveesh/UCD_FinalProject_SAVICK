package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateBrokerAccountFromName {

@SerializedName("name")
@Expose
private String name;

/**
* No args constructor for use in serialization
*
*/
public CreateBrokerAccountFromName() {
}

/**
*
* @param name
*/
public CreateBrokerAccountFromName(String name) {
super();
this.name = name;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

}