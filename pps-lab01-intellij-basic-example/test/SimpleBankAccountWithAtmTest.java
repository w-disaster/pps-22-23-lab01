import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.*;

import static lab01.example.model.SimpleBankAccountWithAtm.FEE;

public class SimpleBankAccountWithAtmTest extends BaseBankAccountTest {

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Luca", "Fabri", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testInitialBalance() {
        checkBalance(0);
    }

    @Test
    void testDepositAtm() {
        checkDeposit(100, 100 - FEE);
    }

    @Test
    void testWrongDepositAtm() {
        checkWrongDeposit(100, 100 - FEE);
    }

    @Test
    void testWithdrawAtm() {
        checkWithdrawAfterDeposit(100, 70, 30 - 2 * FEE);
    }

    @Test
    void testWrongWithdrawAtm() {
        checkWrongWithdrawAfterDeposit(100, 70, 100 - FEE);
    }

}
