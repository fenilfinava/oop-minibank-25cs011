public class Main {
    public static void main(String[] args) {
        ItemService service = new ItemService();
        service.addItem(new Item("IT01", "Notebook", 50.0));
        service.addItem(new Item("IT02", "Pen", 15.0));

        System.out.println("Items listed in catalog (" + service.count() + "):");
        for (Item item : service.getItems()) {
            System.out.println("  " + item);
        }
    }
}
