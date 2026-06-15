import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.loadAccounts();
        SavingsAccount savingsAccount = new SavingsAccount("Ibukunoluwa Ogunfowokan", "09876543555", 2000, 2, 200);

        CurrentAccount currentAccount = new CurrentAccount("ibukunoluwa Ogunfowokan", "0024703795", 2000, 200);

        try {
            LocalDate date = LocalDate.parse("2026-08-01");
            FixedDepositAccount fixedDepositAccount = new FixedDepositAccount("Ibukun Ogunfowokan", "8168406592", 6000, 2, date);
            bank.addAccount(fixedDepositAccount);


        } catch (IllegalArgumentException e) {
            System.out.println("Failed to create account" + e.getMessage());

        }
        bank.addAccount(savingsAccount);
        bank.addAccount(currentAccount);

        bank.listAccount();
        System.out.println("Trying to withdraw from fixed deposit account...");

        System.out.println("tring to break the savings by withdrawing more than i should...");
        savingsAccount.withdraw(5000);
        bank.saveAccounts();
    }
}