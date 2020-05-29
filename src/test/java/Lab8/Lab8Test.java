package Lab8;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Lab8Test {

    private static final int COUNT_ACCOUNTS = 100;
    private static final int MAX_AMOUNT = 1000;
    private static final int MIN_AMOUNT = 1;
    private List<Account> accounts = new ArrayList<>();
    private int totalNumberOfMoney = 0;
    private Bank bank = new Bank();

    @BeforeEach
    public void init() {
        Random random = new Random();
        for (int i = 0; i < COUNT_ACCOUNTS; i++) {
            int balance = random.nextInt(MAX_AMOUNT - MIN_AMOUNT + 1) + MIN_AMOUNT;
            totalNumberOfMoney += balance;
            accounts.add(new Account("Account " + i, new BigDecimal(balance)));
        }
        System.out.println("Total number of money == " + totalNumberOfMoney);
    }

    @Test
    public void test() throws InterruptedException {
        int numberOfOperations = 900;
        ExecutorService service = Executors.newFixedThreadPool(20);
        CountDownLatch latch = new CountDownLatch(numberOfOperations);
        Bank bank = new Bank();
        Random random = new Random();
        for (int i = 0; i < numberOfOperations; i++) {
            service.submit(() -> {
                Account from = accounts.get(random.nextInt(COUNT_ACCOUNTS));
                Account to = accounts.get(random.nextInt(COUNT_ACCOUNTS));
                bank.transfer(from,to, new BigDecimal(7));
                latch.countDown();
            });
        }
        latch.await();
        BigDecimal result = new BigDecimal(0);
        for (Account account : accounts) {
            result = result.add(account.getBalance());
        }
        System.out.println("Number of money after transactions = " + result.intValue());
        assertEquals(totalNumberOfMoney, result.intValue());
    }

}
