package bank;

import java.util.Random;

public class SavingAccount extends BankAccount {
    private int depositBox;
    private int boxAccessCode;


    public SavingAccount(String holder, String SSN, double balance) {
        super(holder, SSN, balance);
        accNumber = "1" + accNumber;
        createteDepositBox();
        createAccessCode();

    }

    private void createAccessCode() {
        Random random = new Random();
        boxAccessCode = random.nextInt(8999) + 1000;
    }

    private void createteDepositBox() {
        Random random = new Random();
        depositBox = random.nextInt(899) + 100;
    }


    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("ACCOUNT TYPE: Savings");
        System.out.println("Safety deposit box: " + getDepositBox() + " Access code: " + getBoxAccessCode());

    }

    @Override
    public void setRate() {
        rate = getBaseRate() - 0.25;

    }



    public int getDepositBox() {
        return depositBox;
    }

    public int getBoxAccessCode() {
        return boxAccessCode;
    }
}
