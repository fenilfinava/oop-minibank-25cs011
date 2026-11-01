public class MiniBank {
    public static void main(String[] args) {
        System.out.println("Valid mobile (9876543210): " + Validator.isValidMobile("9876543210"));
        System.out.println("Invalid mobile (12345): " + Validator.isValidMobile("12345"));
        System.out.println("Valid email (test@bank.com): " + Validator.isValidEmail("test@bank.com"));
        System.out.println("Valid PAN (ABCDE1234F): " + Validator.isValidPan("ABCDE1234F"));
        System.out.println("Valid IFSC (SBIN0001234): " + Validator.isValidIfsc("SBIN0001234"));

        Command cmd = CommandParser.parse("DEPOSIT AC0001 500");
        System.out.println("Parsed Command: " + cmd.type() + ", Account: " + cmd.accountNumber() + ", Amount: " + cmd.amount());

        Account acc = new Account("Alice", 10000);
        System.out.print(StatementFormatter.buildStatement(acc));
    }
}
