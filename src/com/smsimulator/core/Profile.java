package com.smsimulator.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-18.
 */
public class Profile {
    private String name;
    private double bankBalance;
    private List<BankTransaction> depositTransactionList = new ArrayList<>();
    private List<BankTransaction> withdrawTransactionList = new ArrayList<>();

    public Profile(String name, double bankBalance, List<BankTransaction> depositTransactionList, List<BankTransaction> withdrawTransactionList) {
        this.name = name;
        this.bankBalance = bankBalance;
        this.depositTransactionList = depositTransactionList;
        this.withdrawTransactionList = withdrawTransactionList;
    }

    public String getName() {
        return name;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public List<BankTransaction> getDepositTransactionList() {
        return depositTransactionList;
    }

    public List<BankTransaction> getWithdrawTransactionList() {
        return withdrawTransactionList;
    }
}
