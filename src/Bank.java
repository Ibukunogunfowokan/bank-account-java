import java.io.*;
import java.util.ArrayList;

public class Bank {
    private ArrayList<BankAccount> bankAccounts;

    public Bank() {
        this.bankAccounts = new ArrayList<>();
    }

    public void addAccount(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
        System.out.println("Account added: " + bankAccount.accountNumber);
    }

    public BankAccount findAccount(String accountNumber) {
        for (BankAccount account : bankAccounts) {
            if (account.accountNumber.equals(accountNumber)) {
                return account;
            }
        }
        System.out.println("No account found");
        return null;
    }

    public void loadAccounts() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("accounts.dat"))) {
            this.bankAccounts = (ArrayList<BankAccount>) in.readObject();


        } catch (ClassNotFoundException e) {
            System.out.println("No saved accounts found");

        } catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }

    public void saveAccounts() {
        try (ObjectOutputStream out = new ObjectOutputStream((new FileOutputStream("accounts.dat")))) {
            out.writeObject(bankAccounts);

        } catch (FileNotFoundException e) {
            System.out.println("No saved accounts found");

        } catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }

    public void listAccount() {
        if (bankAccounts.isEmpty()) {
            System.out.println("No accounts in the array");

        }

        for (BankAccount bankAccount : bankAccounts) {
            System.out.println(bankAccount.accountNumber + " | " + bankAccount.ownerName + " |Balance: " + bankAccount.getBalance());

        }

    }

}
