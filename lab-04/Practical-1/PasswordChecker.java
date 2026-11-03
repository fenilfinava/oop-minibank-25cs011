// Practical: lab-04 - Practical-1 (PasswordChecker.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class PasswordChecker {
    public static String strength(String pw) {
        int passed = 0;
        if (pw.length() >= 8) passed++;
        if (pw.matches(".*[A-Z].*")) passed++;
        if (pw.matches(".*[0-9].*")) passed++;
        if (pw.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*")) passed++;

        if (passed <= 1) return "Weak";
        if (passed <= 3) return "Medium";
        return "Strong";
    }
}
