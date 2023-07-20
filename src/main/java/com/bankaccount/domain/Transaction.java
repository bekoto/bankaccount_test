package com.bankaccount.domain;

import java.time.LocalDate;

/**
 * 
 * @author Brandon Ekoto
 * this class for managing each operation of account
 *
 */
public class Transaction {
	private TransactionType type;
    private LocalDate date;
    private double amount;
    private double balance;

    public Transaction(TransactionType type, double amount, double balance) {
        this.type = type;
        this.date = LocalDate.now();
        this.amount = amount;
        this.balance = balance;
    }

    public TransactionType getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }
}
