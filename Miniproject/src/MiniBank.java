import model.*;
import util.*;
import static util.Validator.isValidMobile;

public class MiniBank {
    public static void main(String[] args) {
        BankInfo info = new BankInfo("MiniBank", "Main Branch");
        System.out.println("=== " + info.name() + " (" + info.branch() + ") ===");

        SavingsAccount sa = new SavingsAccount("Alice", 10000, 1000);
        System.out.println("Savings yearly interest: Rs. " + sa.yearlyInterest());

        WithdrawRule basicRule = new WithdrawRule() {
            public boolean allow(Account account, long amount) {
                return account.canWithdraw(amount);
            }
        };

        WithdrawRule lambdaRule = (account, amount) -> account.canWithdraw(amount);

        System.out.println("Anonymous rule allow 2000: " + basicRule.allow(sa, 2000));
        System.out.println("Lambda rule allow 2000: " + lambdaRule.allow(sa, 2000));

        System.out.println("Static import mobile check: " + isValidMobile("9876543210"));
    }
}
