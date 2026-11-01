import java.util.ArrayList;
import java.util.List;

public class ItemService {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        if (item.getPrice() < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public int count() {
        return items.size();
    }
}
