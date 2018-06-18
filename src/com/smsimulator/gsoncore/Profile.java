package com.smsimulator.gsoncore;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.smsimulator.core.BankTransaction;

public class Profile {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("balance")
    @Expose
    private double bankBalance;
    @SerializedName("depositTransaction")
    @Expose
    private List<BankTransaction> depositTransaction = null;
    @SerializedName("withdrawTransaction")
    @Expose
    private List<BankTransaction> withdrawTransaction = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(double bankBalance) {
        this.bankBalance = bankBalance;
    }

    public List<BankTransaction> getDepositTransaction() {
        return depositTransaction;
    }

    public void setDepositTransaction(List<BankTransaction> depositTransaction) {
        this.depositTransaction = depositTransaction;
    }

    public List<BankTransaction> getWithdrawTransaction() {
        return withdrawTransaction;
    }

    public void setWithdrawTransaction(List<BankTransaction> withdrawTransaction) {
        this.withdrawTransaction = withdrawTransaction;
    }

}