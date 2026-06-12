abstract class BankAccount {
    protected String ownerName;
    protected  String accountNumber;
    protected double balance;

    public BankAccount(String ownerName,String accountNumber, double initialBalance){
        this.ownerName =ownerName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount){
        if(amount <=0){
            System.out.println("Amount must be greater than 0");
            return;
        }
        balance+=amount;
        System.out.println("Deposited: " + amount + " | New balance: "+ balance);
    }

    public double getBalance(){
        return balance;
    }

    public abstract void withdraw(double amount);
}
