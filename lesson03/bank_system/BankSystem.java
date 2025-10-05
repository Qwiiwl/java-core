package bank_system;

import java.util.ArrayList;
import java.util.List;

public class BankSystem {
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account acc) {
        accounts.add(acc);
    }

    public void deleteAccount(int number) {
        accounts.removeIf(a -> a.getAccountNumber() == number);
    }

    public void replenishAccount(int number, double sum) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == number) {
                acc.setBalance(acc.getBalance() + sum);
                return;
            }
        }
    }

    public void transferMoneyBetweenAccounts(int from, int to, double sum) {
        Account accFrom = null;
        Account accTo = null;

        for (Account acc : accounts) {
            if (acc.getAccountNumber() == from) accFrom = acc;
            if (acc.getAccountNumber() == to) accTo = acc;
        }

        if (accFrom != null && accTo != null && accFrom.getBalance() >= sum) {
            accFrom.setBalance(accFrom.getBalance() - sum);
            accTo.setBalance(accTo.getBalance() + sum);
        } else {
            System.out.println("Ошибка перевода!");
        }
    }

    public void showAllAccounts() {
        for (Account acc : accounts) {
            System.out.println(acc.getAccountInfo());
        }
    }
}
