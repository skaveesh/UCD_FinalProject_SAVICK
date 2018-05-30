package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateBankAccount {

    @SerializedName("createBankAccountFromName")
    @Expose
    private CreateBankAccountFromName createBankAccountFromName;

    /**
     * No args constructor for use in serialization
     */
    public CreateBankAccount() {
    }

    /**
     * @param createBankAccountFromName
     */
    public CreateBankAccount(CreateBankAccountFromName createBankAccountFromName) {
        super();
        this.createBankAccountFromName = createBankAccountFromName;
    }

    public CreateBankAccountFromName getCreateBankAccountFromName() {
        return createBankAccountFromName;
    }

    public void setCreateBankAccountFromName(CreateBankAccountFromName createBankAccountFromName) {
        this.createBankAccountFromName = createBankAccountFromName;
    }

}