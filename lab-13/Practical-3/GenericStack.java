// Practical: lab-13 - Practical-3 (GenericStack.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import java.util.EmptyStackException;

public class GenericStack<T> {
    private Object[] elements = new Object[10];
    private int size = 0;

    public void push(T item) {
        if (size == elements.length) {
            Object[] next = new Object[elements.length * 2];
            System.arraycopy(elements, 0, next, 0, elements.length);
            elements = next;
        }
        elements[size++] = item;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T val = (T) elements[--size];
        elements[size] = null;
        return val;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
