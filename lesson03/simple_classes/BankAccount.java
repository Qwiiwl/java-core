package simple_classes;

public class BankAccount {
    private String fio;
    private int accountNumber;
    private double balance;

    public BankAccount(String fio, int accountNumber, double balance) {
        this.fio = fio;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double sum) {
        balance += sum;
    }

    public void withdraw(double sum) {
        if (balance >= sum) {
            balance -= sum;
        } else {
            System.out.println("Недостаточно средств!");
        }
    }

    public double getBalance() {
        return balance;
    }
}
