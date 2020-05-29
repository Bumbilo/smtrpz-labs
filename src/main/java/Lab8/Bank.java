package Lab8;

import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    private ReentrantLock lock = new ReentrantLock();

    public void transfer(Account from, Account to, BigDecimal amount) {
        boolean transfer = false;
        try {
            if (lock.tryLock()) {
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
