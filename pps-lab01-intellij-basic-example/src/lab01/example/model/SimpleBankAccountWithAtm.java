package lab01.example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount {

    public static final double FEE = 1.0;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    public void deposit(int userID, double amount) {
        super.deposit(userID, amount - FEE);
    }

    @Override
    public void withdraw(int userID, double amount) {
        super.withdraw(userID, amount + FEE);
    }
}
