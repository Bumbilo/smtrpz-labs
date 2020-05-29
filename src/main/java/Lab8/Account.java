package Lab8;

import java.math.BigDecimal;

public class Account {
    private String name;
    private BigDecimal balance;

    public Account(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public boolean debit(BigDecimal amount) {
        if (amount.compareTo(balance) > 0) {// return false if account doesn't have enough money
            return false;
        }
        balance = balance.subtract(amount);
        return true;
    }

    public void credit(BigDecimal amount) {
        balance = balance.add(amount);
    }
}
