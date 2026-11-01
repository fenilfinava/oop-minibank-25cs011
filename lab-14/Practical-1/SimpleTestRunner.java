public class SimpleTestRunner {
    public static void main(String[] args) {
        ItemService service = new ItemService();
        int initialCount = service.count();

        service.addItem(new Item("T1", "Scale", 20.0));
        if (service.count() == initialCount + 1) {
            System.out.println("Test 1 Passed: Add increases count");
        } else {
            System.out.println("Test 1 Failed");
        }

        boolean caught = false;
        try {
            service.addItem(new Item("T2", "Invalid", -10.0));
        } catch (IllegalArgumentException e) {
            caught = true;
        }

        if (caught) {
            System.out.println("Test 2 Passed: Invalid price throws exception");
        } else {
            System.out.println("Test 2 Failed");
        }
    }
}
