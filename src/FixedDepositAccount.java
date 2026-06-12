import java.time.LocalDate;

public class FixedDepositAccount extends BankAccount {
    protected double interestRate;
    protected LocalDate maturityDate;

    public FixedDepositAccount(String ownerName, String accountNumber, double initialAmount, double interestRate, LocalDate maturityDate) {

        super(ownerName, accountNumber, initialAmount);

        if (interestRate <= 0) {
            throw new IllegalArgumentException("Interest rate must be greater than 0");
        }

        this.interestRate = interestRate;

        if (maturityDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Maturity date cannot be in the past");
        }
        this.maturityDate = maturityDate;

    }

    @Override
    public void withdraw(double amount) {
        if (!isMatured()) {
            System.out.println("Can't withdraw before maturity Date");
            return;
        }
        if (amount <= 0) {
            System.out.println("Can't withdraw 0 or negative amount");
            return;
        }
        if (balance - amount < 0) {
            System.out.println("Can't withdraw. Insufficient funds");
            return;
        }
        balance -= amount;
        System.out.println("Successfully withdrew " + amount + " |Current balance: " + balance);
    }

    public void applyInterest() {

        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Added interest " + interest + " |New Balance " + balance);
    }

    public boolean isMatured() {
        return LocalDate.now().isAfter(maturityDate) || LocalDate.now().isEqual(maturityDate);
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }


}
