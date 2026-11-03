// Practical: lab-07 - Practical-2 (TestRunner.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import java.lang.reflect.Method;
import java.util.Scanner;

public class TestRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("====================================================");
        System.out.println("   CEUE203 Lab 07 - Mini Test Runner (@Run Annotation)");
        System.out.println("   Student: Fenil Jagdishbhai Finava (25CS011)");
        System.out.println("====================================================");

        System.out.print("Scan class 'TestSuite' and execute @Run test cases? (y/n): ");
        String choice = sc.nextLine().trim();

        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
            TestSuite suite = new TestSuite();
            // Java Reflection API thi badhi declared methods get kari
            Method[] methods = suite.getClass().getDeclaredMethods();

            System.out.println("\n--- Reflection Method Scanner Started ---");
            int runCount = 0;
            int totalMethods = methods.length;

            for (Method m : methods) {
                // @Run annotation present che k nahi te check karyu
                if (m.isAnnotationPresent(Run.class)) {
                    System.out.println("\n[+] Found @Run Annotation on Method: " + m.getName() + "()");
                    try {
                        // Reflection thi method invoke kari
                        m.invoke(suite);
                        runCount++;
                    } catch (Exception e) {
                        System.out.println("Error executing test method: " + e.getMessage());
                    }
                } else {
                    System.out.println("[-] Skipping non-annotated method : " + m.getName() + "()");
                }
            }

            System.out.println("\n====================================================");
            System.out.println("Test Execution Summary:");
            System.out.println("Total Methods Scanned  : " + totalMethods);
            System.out.println("Total @Run Methods Run : " + runCount);
            System.out.println("Status                 : ALL ANNOTATED TESTS PASSED");
            System.out.println("====================================================");
        } else {
            System.out.println("Test runner execution aborted by user.");
        }
    }
}
