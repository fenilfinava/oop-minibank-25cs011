public class Driver {
    public static void main(String[] args) {
        String[] tests = {"abc", "password12", "Abcd1234!", "Admin@2026"};
        for (String p : tests) {
            System.out.println(p + " -> " + PasswordChecker.strength(p));
        }
    }
}
