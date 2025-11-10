/**
 * Lab 4 - BankAccount
 * Author: Edisson Ajciginac
 * Author: Servando Lozoya
 *  A bank account class wich stores an account number, the current balance, and a statement of the transaccions.
 * Uses StringBuilder for the statement and Calendar for timestamps.
 */

import java.util.Calendar;

public class BankAccount {

    // Instance variables
    private String accountNumber;       // account number
    private double balance;             // balance
    private StringBuilder transactions; // accumulates the transactions

    /** Default constructor = 0*/
    public BankAccount() {
        this.accountNumber = "00000000";
        this.balance = 0.0;
        this.transactions = new StringBuilder();
    }

    /**
     * Overloaded constructor, starts with the given amount
     * @param amount initial balance if - = 0
     */
    public BankAccount(double amount) {
        this.accountNumber = "00000000";
        this.balance = amount >= 0 ? amount : 0.0;
        this.transactions = new StringBuilder();
    }

    /**
     * Deposits money in positive nummbers
     * Records the day and time of the transaction.
     * @param amount money to deposit
     */
    public void deposit(double amount) {
        if (amount >= 0) {
            balance += amount;
            log("DEPOSIT", amount, balance);
        } else {
            // rejected operation is still recorded
            log("DEPOSIT-REJECTED", amount, balance);
        }
    }

    /**
     * Withdraws money if theres money
     * Records the time of  transaccion
     * @param amount money to withdraw
     */
    public void withdraw(double amount) {
        if (amount >= 0 && balance >= amount) {
            balance -= amount;
            log("WITHDRAW", amount, balance);
        } else {
            // rejected operation is still recorded
            log("WITHDRAW-REJECTED", amount, balance);
        }
    }

    /**
     * Returns the current balance
     * @return current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns all transactions
     * @return statement text
     */
    public String getStatement() {
        return transactions.toString();
    }

    //helper to append a timestamped line to the statement 
    private void log(String type, double amount, double newBalance) {
        Calendar c = Calendar.getInstance();
        int y = c.get(Calendar.YEAR);
        int m = c.get(Calendar.MONTH) + 1; //Calendar
        int d = c.get(Calendar.DAY_OF_MONTH);
        int hh = c.get(Calendar.HOUR_OF_DAY);
        int mm = c.get(Calendar.MINUTE);
        int ss = c.get(Calendar.SECOND);

        transactions.append(pad(y, 4)).append("-")
                    .append(pad(m, 2)).append("-")
                    .append(pad(d, 2)).append(" ")
                    .append(pad(hh, 2)).append(":")
                    .append(pad(mm, 2)).append(":")
                    .append(pad(ss, 2)).append(" | ")
                    .append(type).append(" ")
                    .append(amount).append(" | BAL: ")
                    .append(newBalance).append("\n");
    }

    private String pad(int v, int width) {
        String s = "" + v;
        while (s.length() < width) s = "0" + s;
        return s;
    }

}
