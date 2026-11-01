package util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import model.annotation.Positive;
import model.annotation.MaxLength;

public class AnnotationValidator {
    public static String[] validate(Object obj) {
        List<String> errors = new ArrayList<>();
        Class<?> clazz = obj.getClass();

        while (clazz != null && clazz != Object.class) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    Object val = field.get(obj);
                    if (field.isAnnotationPresent(Positive.class)) {
                        Positive pos = field.getAnnotation(Positive.class);
                        if (val instanceof Number num && num.longValue() <= 0) {
                            errors.add(pos.message());
                        }
                    }
                    if (field.isAnnotationPresent(MaxLength.class)) {
                        MaxLength ml = field.getAnnotation(MaxLength.class);
                        if (val != null && val.toString().length() > ml.value()) {
                            errors.add(field.getName() + " exceeds max length " + ml.value());
                        }
                    }
                } catch (IllegalAccessException e) {
                }
            }
            clazz = clazz.getSuperclass();
        }
        return errors.toArray(new String[0]);
    }
}
