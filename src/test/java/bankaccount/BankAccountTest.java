package bankaccount;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bankaccount.domain.BankAccount;
import com.bankaccount.domain.Transaction;
import com.bankaccount.domain.TransactionType;
import com.bankaccount.service.StatementPrinter;

public class BankAccountTest {
	
	private BankAccount bankAccount;
	private StatementPrinter printer;

    @BeforeEach
    public void setup() {
        bankAccount = new BankAccount();
        printer = new StatementPrinter();
    }

    @Test
    public void testDeposit() {
        bankAccount.deposit(100.0);
        Assertions.assertEquals(100.0, bankAccount.getBalance());
    }
    
    @Test
    public void testDepositWithZero() {
        
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
        	bankAccount.deposit(0);
        });
        
    }

    @Test
    public void testWithdraw() {
        bankAccount.deposit(100.0);
        bankAccount.withdraw(50.0);
        Assertions.assertEquals(50.0, bankAccount.getBalance());
    }

    @Test
    public void testWithdrawWithInsufficientBalance() {
        bankAccount.deposit(100.0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(150.0);
        });
    }

    @Test
    public void testGetTransactions() {
        bankAccount.deposit(100.0);
        bankAccount.withdraw(50.0);
        List<Transaction> transactions = bankAccount.getTransactions();
        Assertions.assertEquals(2, transactions.size());
        Assertions.assertEquals(TransactionType.DEPOSIT, transactions.get(0).getType());
        Assertions.assertEquals(100.0, transactions.get(0).getAmount());
        Assertions.assertEquals(100.0, transactions.get(0).getBalance());
        Assertions.assertEquals(TransactionType.WITHDRAWAL, transactions.get(1).getType());
        Assertions.assertEquals(-50.0, transactions.get(1).getAmount());
        Assertions.assertEquals(50.0, transactions.get(1).getBalance());
    }
    
    @Test
    public void testPrintAccountStatement() {
        bankAccount.deposit(100.0);
        bankAccount.withdraw(50.0);
        bankAccount.withdraw(50.0);
       printer.printStatement(bankAccount);
    }

}
