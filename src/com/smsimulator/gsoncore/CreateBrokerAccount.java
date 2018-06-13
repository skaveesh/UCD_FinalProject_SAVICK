package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateBrokerAccount {

@SerializedName("createBrokerAccountFromName")
@Expose
private CreateBrokerAccountFromName createBrokerAccountFromName;

/**
* No args constructor for use in serialization
*
*/
public CreateBrokerAccount() {
}

/**
*
* @param createBrokerAccountFromName
*/
public CreateBrokerAccount(CreateBrokerAccountFromName createBrokerAccountFromName) {
super();
this.createBrokerAccountFromName = createBrokerAccountFromName;
}

public CreateBrokerAccountFromName getCreateBrokerAccountFromName() {
return createBrokerAccountFromName;
}

public void setCreateBrokerAccountFromName(CreateBrokerAccountFromName createBrokerAccountFromName) {
this.createBrokerAccountFromName = createBrokerAccountFromName;
}

}