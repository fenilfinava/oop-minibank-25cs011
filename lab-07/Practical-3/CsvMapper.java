// Practical: lab-07 - Practical-3 (CsvMapper.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import java.lang.reflect.Field;

public class CsvMapper {
    public static <T> T mapRow(Class<T> clazz, String[] headers, String[] data) {
        try {
            T obj = clazz.getDeclaredConstructor().newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                if (f.isAnnotationPresent(Column.class)) {
                    Column col = f.getAnnotation(Column.class);
                    for (int i = 0; i < headers.length; i++) {
                        if (headers[i].equalsIgnoreCase(col.name()) && i < data.length) {
                            f.setAccessible(true);
                            f.set(obj, data[i]);
                            break;
                        }
                    }
                }
            }
            return obj;
        } catch (Exception e) {
            return null;
        }
    }
}
