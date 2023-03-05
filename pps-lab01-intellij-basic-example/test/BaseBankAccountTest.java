import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseBankAccountTest {

    protected AccountHolder accountHolder;
    protected BankAccount bankAccount;

    protected void checkBalance(final double balance) {
        assertEquals(balance, bankAccount.getBalance());
    }

    protected void checkDeposit(final double amount, final double expected) {
        bankAccount.deposit(accountHolder.getId(), amount);
        assertEquals(expected, bankAccount.getBalance());
    }

    protected void checkWrongDeposit(final double amount, final double expected) {
        bankAccount.deposit(accountHolder.getId(), amount);
        bankAccount.deposit(2, 50);
        assertEquals(expected, bankAccount.getBalance());
    }

    protected void checkWithdrawAfterDeposit(final double depositAmount, final double withdrawAmount,
                                     final double expected) {
        bankAccount.deposit(accountHolder.getId(), depositAmount);
        bankAccount.withdraw(accountHolder.getId(), withdrawAmount);
        assertEquals(expected, bankAccount.getBalance());
    }

    protected void checkWrongWithdrawAfterDeposit(final double depositAmount, final double withdrawAmount,
                                          final double expected) {
        bankAccount.deposit(accountHolder.getId(), depositAmount);
        bankAccount.withdraw(2, withdrawAmount);
        assertEquals(expected, bankAccount.getBalance());
    }

}
