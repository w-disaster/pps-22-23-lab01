import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest extends BaseBankAccountTest {

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, 0);
    }

    @Test
    void testInitialBalance() {
        checkBalance(0);
    }

    @Test
    void testDeposit() {
        checkDeposit(100, 100);
    }

    @Test
    void testWrongDeposit() {
        checkWrongDeposit(100, 100);
    }

    @Test
    void testWithdraw() {
        checkWithdrawAfterDeposit(100, 70, 30);
    }

    @Test
    void testWrongWithdraw() {
        checkWrongWithdrawAfterDeposit(100, 70, 100);
    }
}
