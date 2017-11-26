package test;

import test.FailedTestException;
import banking.User;
import banking.InputException;
import banking.Account;

public class TestUser {
    public void testDeposit() throws FailedTestException {
        Account Acc = new Account("Test", 18);
        try {Acc.addMoney(100);} catch (InputException e) {throw new FailedTestException();}
        try {Acc.withdrawMoney(50);} catch (InputException e) {throw new FailedTestException();}

        if (Acc.getTotal() != 50)
            throw new FailedTestException();
    }

    public void testDepositNegative() throws FailedTestException {
        boolean thrown = false;

        Account Acc = new Account("Test", 18);

        try {
            Acc.addMoney(-1);
        } catch (InputException e) {
            thrown = true;
        }
        if (!thrown)
            throw new FailedTestException();
    }

    public void testWithdraw() throws FailedTestException {
        Account Acc = new Account("Test", 18);
        try {Acc.addMoney(100);} catch (InputException e) {throw new FailedTestException();}

        boolean thrown = false;
        try {
            Acc.withdrawMoney(50);
        } catch (InputException e) {
            thrown = true;
        }
        if (Acc.getTotal() != 50 || thrown)
            throw new FailedTestException();
    }

    public void testWithdrawNegative() throws FailedTestException {
        Account Acc = new Account("Test", 18);
        try {Acc.addMoney(100);} catch (InputException e) {throw new FailedTestException();}
        boolean thrown = false;
        try {
            try {
                Acc.withdrawMoney(-1);
            } catch (InputException e) {
                throw new FailedTestException();
            }
        } catch (FailedTestException ee) {
            thrown = true;
        }
        if (!thrown)
            throw new FailedTestException();
    }
}
