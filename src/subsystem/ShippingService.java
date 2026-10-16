package subsystem;

public class ShippingService {

    public boolean arrangeShipping(String product, int quantity) {
        if (product == null || product.isBlank() || quantity <= 0) {
            System.out.println("Shipping failed: invalid order details.");
            return false;
        }

        System.out.println("Preparing shipment for " + product);
        System.out.println("Quantity: " + quantity);
        System.out.println("Shipping has been arranged.");
        return true;
    }
}

