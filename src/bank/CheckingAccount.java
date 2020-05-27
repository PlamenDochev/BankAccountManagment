package bank;

import java.util.Random;

public class CheckingAccount extends BankAccount {
    private long cardNumber;
    private int cardPin;

    public CheckingAccount(String holder, String SSN, double balance) {
        super(holder, SSN, balance);
        accNumber = "2" + accNumber;
        generateCardNumber();
        genereteCardPin();
    }

    private void genereteCardPin() {
        Random random = new Random();
        cardPin = random.nextInt(8999) + 1000;
    }

    private void generateCardNumber() {
        Random random = new Random();
        cardNumber = random.nextInt() + 100_000_000_000L;
    }



    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("ACCOUNT TYPE: Checking");
        System.out.println("Debit card number: " + getCardNumber() + " Debit card PIN: " + getCardPin());
    }

    @Override
    public void setRate() {
        rate = getBaseRate() * 0.15;
    }


    public long getCardNumber() {
        return cardNumber;
    }

    public int getCardPin() {
        return cardPin;
    }
}
