package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginPlayer {

    @SerializedName("authorization")
    @Expose
    private Authorization authorization;

    /**
     * No args constructor for use in serialization
     *
     */
    public LoginPlayer() {
    }

    /**
     *
     * @param authorization
     */
    public LoginPlayer(Authorization authorization) {
        super();
        this.authorization = authorization;
    }

    public Authorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }

}