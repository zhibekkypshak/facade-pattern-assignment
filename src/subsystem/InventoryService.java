package subsystem;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {

    private final Map<String, Integer> stock = new HashMap<>();

    public InventoryService() {
        stock.put("Laptop", 5);
        stock.put("Keyboard", 10);
        stock.put("Mouse", 20);
    }

    public boolean checkStock(String product, int quantity) {
        System.out.println("Checking stock for " + product);

        if (quantity <= 0) {
            System.out.println("Invalid quantity!");
            return false;
        }

        int available = stock.getOrDefault(product, 0);

        if (available < quantity) {
            System.out.println("Not enough stock.");
            return false;
        }

        System.out.println("Stock is available.");
        return true;
    }

    public void reserveStock(String product, int quantity) {
        int currentStock = stock.getOrDefault(product, 0);
        stock.put(product, currentStock - quantity);

        System.out.println(
                "Reserved " + quantity + " units of " + product + "."
        );
    }

    public void releaseStock(String product, int quantity) {
        int currentStock = stock.getOrDefault(product, 0);
        stock.put(product, currentStock + quantity);

        System.out.println(
                "Released " + quantity + " units of " + product + " back to stock."
        );
    }
}

