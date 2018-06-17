package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreatePlayerAccount {

@SerializedName("createPlayerAccountForName")
@Expose
private CreatePlayerAccountForName createPlayerAccountForName;

/**
* No args constructor for use in serialization
*
*/
public CreatePlayerAccount() {
}

/**
*
* @param createPlayerAccountForName
*/
public CreatePlayerAccount(CreatePlayerAccountForName createPlayerAccountForName) {
super();
this.createPlayerAccountForName = createPlayerAccountForName;
}

public CreatePlayerAccountForName getCreatePlayerAccountForName() {
return createPlayerAccountForName;
}

public void setCreatePlayerAccountForName(CreatePlayerAccountForName createPlayerAccountForName) {
this.createPlayerAccountForName = createPlayerAccountForName;
}

}