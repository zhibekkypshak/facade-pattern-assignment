
public class InventoryService {

    public boolean checkStock(String product, int quantity) {
        System.out.println("Checking stock for " + product);

        if (quantity <= 0) {
            System.out.println("Invalid quantity!");
            return false;
        }

        System.out.println("Stock is available.");
        return true;
    }

    public void releaseStock(String product, int quantity) {
        System.out.println("Releasing " + quantity + " units of " + product + " back to stock.");
    }
}

