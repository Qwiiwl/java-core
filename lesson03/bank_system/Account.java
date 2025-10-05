package bank_system;

public class Account {
    private int accountNumber;
    private String fio;
    private double balance;

    public Account(int accountNumber, String fio, double balance) {
        this.accountNumber = accountNumber;
        this.fio = fio;
        this.balance = balance;
    }

    public int getAccountNumber() { return accountNumber; }
    public String getFio() { return fio; }
    public double getBalance() { return balance; }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountInfo() {
        return "Счет №" + accountNumber + ", " + fio + ", Баланс: " + balance + "₽";
    }
}
