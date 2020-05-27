package bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(Files.newBufferedReader(Paths.get("original.csv")))){
            while (br.ready()){
                String input = br.readLine();
                String[] inputItems = input.split(",");
                switch (inputItems[2]) {
                    case "Savings":
                        accounts.add(new SavingAccount(inputItems[0], inputItems[1], Double.parseDouble(inputItems[3])));
                        break;
                    case "Checking":
                        accounts.add(new CheckingAccount(inputItems[0], inputItems[1], Double.parseDouble(inputItems[3])));
                        break;
                    default:
                        System.out.println("ERROR!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (BankAccount acc: accounts) {
            acc.showInfo();
            acc.compound();
            System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-");
        }



    }
}
