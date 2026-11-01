package repository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import model.annotation.Id;

public class Repository<T> {
    private HashMap<String, T> data = new HashMap<>();

    public T save(T entity) {
        Class<?> clazz = entity.getClass();
        String key = null;

        while (clazz != null && clazz != Object.class) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                if (f.isAnnotationPresent(Id.class)) {
                    f.setAccessible(true);
                    try {
                        Object val = f.get(entity);
                        if (val != null) {
                            key = val.toString();
                        }
                    } catch (IllegalAccessException e) {
                    }
                    break;
                }
            }
            if (key != null) break;
            clazz = clazz.getSuperclass();
        }

        if (key != null) {
            data.put(key, entity);
        }
        return entity;
    }

    public T findById(String id) {
        return data.get(id);
    }

    public ArrayList<T> findAll() {
        return new ArrayList<>(data.values());
    }

    @SafeVarargs
    public final void saveAll(T... items) {
        for (T item : items) {
            save(item);
        }
    }

    public static <N extends Number> double average(N[] values) {
        if (values == null || values.length == 0) return 0.0;
        double sum = 0.0;
        for (N v : values) {
            sum += v.doubleValue();
        }
        return sum / values.length;
    }
}
