package Bank_Kata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Account implements AccountService{

    private final List<Transaction> transactions = new ArrayList<>();
    private int balance = 0; // Track the current balance

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        transactions.add(new Transaction(amount, new Date()));
        balance += amount; // Update balance
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (balance - amount < 0) {
            throw new IllegalArgumentException("Insufficient funds. Withdrawal would result in negative balance.");
        }
        transactions.add(new Transaction(-amount, new Date()));
        balance -= amount; // Update balance
    }

    public void printStatement() {
        System.out.println("Date       || Amount  || Balance");
        int runningBalance = 0;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        for (Transaction transaction : transactions) {
            runningBalance += transaction.getAmount();
            String date = formatter.format(transaction.getDate());
            System.out.printf("%s || %6d  || %6d\n", date, transaction.getAmount(), runningBalance);
        }
    }
}