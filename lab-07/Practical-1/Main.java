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
