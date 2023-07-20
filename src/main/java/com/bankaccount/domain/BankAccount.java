package com.bankaccount.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Brandon Ekoto
 * 
 *
 */
public class BankAccount {

	private double balance;
    private List<Transaction> transactions;

    public BankAccount() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid deposit amount");
        }
        balance += amount;
        transactions.add(new Transaction(TransactionType.DEPOSIT, amount, balance));
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            throw new IllegalArgumentException("Invalid withdrawal amount");
        }
        balance -= amount;
        transactions.add(new Transaction(TransactionType.WITHDRAWAL, -amount, balance));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public double getBalance() {
        return balance;
    }
}
