import model.*;
import util.AnnotationValidator;

public class MiniBank {
    public static void main(String[] args) {
        SavingsAccount badAccount = new SavingsAccount("Invalid", -100, 500);
        String[] errors = AnnotationValidator.validate(badAccount);

        for (String err : errors) {
            System.out.println("Validation Error: " + err);
        }

        SavingsAccount goodAccount = new SavingsAccount("Valid", 5000, 500);
        String[] goodErrors = AnnotationValidator.validate(goodAccount);
        System.out.println("Valid account errors count: " + goodErrors.length);
    }
}
