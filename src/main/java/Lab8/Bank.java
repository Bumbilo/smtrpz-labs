package Lab8;

import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    // For thread safe()
    private ReentrantLock lock = new ReentrantLock();

    public void transfer(Account from, Account to, BigDecimal amount) {
        boolean transfer = false;
        try {
            if (lock.tryLock()) { // If thread is free to enter
                boolean flag = from.debit(amount);
                if (flag) {
                    to.credit(amount);
                }
                transfer = true;
            } else {
                transfer(from, to, amount);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (transfer) {
                lock.unlock();
            }
        }
    }
}
