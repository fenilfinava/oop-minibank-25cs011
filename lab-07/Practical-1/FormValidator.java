// Practical: lab-07 - Practical-1 (FormValidator.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FormValidator {
    public static List<String> validate(Object obj) {
        List<String> errors = new ArrayList<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            try {
                Object val = f.get(obj);
                if (f.isAnnotationPresent(NotBlank.class)) {
                    if (val == null || val.toString().trim().isEmpty()) {
                        errors.add(f.getName() + " cannot be blank");
                    }
                }
                if (f.isAnnotationPresent(MaxLength.class)) {
                    MaxLength ml = f.getAnnotation(MaxLength.class);
                    if (val != null && val.toString().length() > ml.value()) {
                        errors.add(f.getName() + " exceeds max length of " + ml.value());
                    }
                }
            } catch (IllegalAccessException e) {
            }
        }
        return errors;
    }
}
