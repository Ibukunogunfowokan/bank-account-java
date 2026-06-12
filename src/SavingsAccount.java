public class SavingsAccount extends BankAccount {
    protected double interestRate;
    protected double minimumAmount;

    public SavingsAccount(String ownerName, String accountNumber, double initialBalance, double interestRate, double minimumAmount) {
        super(ownerName, accountNumber, initialBalance);
        this.interestRate = interestRate;
        this.minimumAmount = minimumAmount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (balance - amount < minimumAmount) {
            System.out.println("Failed to withdraw! Minimum balance requirement is " + minimumAmount);
            return;
        }
        balance -= amount;
        System.out.println("Successfully withdrawn " + amount + " |New balance: " + balance);
    }

    public void applyInterest() {

        double interest = balance * interestRate / 100;
        balance += interest;

        System.out.println("Sucessfully added interest rate of " + interestRate + "%" + " |New Balance: " + balance);
    }

    public double getInterestRate() {
        return interestRate;
    }
}



