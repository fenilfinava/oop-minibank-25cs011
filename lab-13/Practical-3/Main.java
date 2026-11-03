// Practical: lab-13 - Practical-3 (Main.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class Main {
    public static void main(String[] args) {
        GenericStack<String> sStack = new GenericStack<>();
        sStack.push("Java");
        sStack.push("Python");
        System.out.println("Popped string: " + sStack.pop());

        GenericStack<Integer> iStack = new GenericStack<>();
        iStack.push(100);
        iStack.push(200);
        System.out.println("Popped integer: " + iStack.pop());
    }
}
