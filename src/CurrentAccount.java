import java.io.Serial;

public class CurrentAccount extends BankAccount {
    protected double overDraftLimit;
    @Serial
    private static final long serialVersionUID = 1L;

    public CurrentAccount(String ownerName, String accountNumber, double initialAmount, double overDraftLimit) {
        super(ownerName, accountNumber, initialAmount);
        if (overDraftLimit < 0) {
            throw new IllegalArgumentException("Overdraft limit cannot be negative");
        }
        this.overDraftLimit = overDraftLimit;

    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive or greater than zero");
            return;
        }
        if (balance - amount < -overDraftLimit) {
            System.out.println("Sir, you cannot go below the overdraft limit of " + overDraftLimit);
            return;
        }
        balance -= amount;
        System.out.println("Successfully deducted " + amount + " |New Balance: " + balance);
    }

    public double getOverDraftLimit() {
        return overDraftLimit;
    }
}
