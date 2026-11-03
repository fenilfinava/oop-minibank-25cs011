// Practical: lab-07 - Practical-1 (Main.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SignupForm form1 = new SignupForm("", "verylongpassword123");
        List<String> errors = FormValidator.validate(form1);
        for (String err : errors) {
            System.out.println("Validation Error: " + err);
        }
    }
}
