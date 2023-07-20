package com.bankaccount.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.bankaccount.domain.BankAccount;
import com.bankaccount.domain.Transaction;

/**
 * 
 * @author Brandon Ekoto
 *
 */
public class StatementPrinter {

	final DateTimeFormatter formatter;
	
	

	
	
	public StatementPrinter() {
		super();
		formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	}



	public void printStatement(BankAccount account) {
	   
	   if(account == null) {
		   throw new IllegalArgumentException("");
	   }
	   
	   List<Transaction> operations = account.getTransactions();
	   double balance  =  0;
	   System.out.println("Le journal des opérations de votre compte : " );
	   System.out.println("Date --- Amount -- Solde " );
	   for(Transaction o : operations) {
		   balance += o.getAmount();
		   System.out.println(formatter.format(o.getDate()) + "____" + (o.getAmount() > 0 ? "+" : "-") + Math.abs(o.getAmount()) + "___"+ balance);
	   }
	  
   }
}
