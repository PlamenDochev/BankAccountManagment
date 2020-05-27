package bank;

import java.util.Random;

public abstract class BankAccount implements IRate {
    private String holder;
    private String SSN;
    private double balance;
    protected String accNumber;
    protected double rate;
    static int index = 10000;

    public BankAccount(String holder, String SSN, double balance) {
        this.holder = holder;
        this.SSN = SSN;
        this.balance = balance;
        index++;
        this.accNumber = generateAccNumber();
        setRate();

    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Depositing: " + amount);
        printBalance();
    }

    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawing: " + amount);
        printBalance();
    }

    public void transfer(String toWhere, double amount) {
        balance -= amount;
        System.out.println("Transferring " + amount + " to " + toWhere);
        printBalance();
    }

    public void printBalance() {
        System.out.println("Your balane is now: " + balance);
    }

    public void showInfo() {
        System.out.println("NAME:  " + holder + "\nACCOUNT NUMBER: " + accNumber + "\nBALANCE: " + balance + "\nTHE RATE IS: " + rate + "%");
    }

    public abstract void setRate();

    public String generateAccNumber() {
        Random random1 = new Random();
        int uniqueFive = index;
        int num = random1.nextInt(899) + 100;
        String lastTwo = SSN.substring(SSN.length() - 2);
        return lastTwo + uniqueFive + num;
    }

    public void compound() {
        double accruedInterest = balance * (rate / 100);
        balance += accruedInterest;
        System.out.println("Accrued interest: " + accruedInterest);
        printBalance();
    }
}
