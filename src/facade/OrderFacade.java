package facade;

import subsystem.InventoryService;
import subsystem.PaymentProcessor;
import subsystem.ShippingService;
import subsystem.NotificationService;

public class OrderFacade {

    private final InventoryService inventoryService;
    private final PaymentProcessor paymentProcessor;
    private final ShippingService shippingService;
    private final NotificationService notificationService;

    public OrderFacade() {
        inventoryService = new InventoryService();
        paymentProcessor = new PaymentProcessor();
        shippingService = new ShippingService();
        notificationService = new NotificationService();
    }

    public void placeOrder(String product, int quantity, double amount) {
        System.out.println("=== Starting Order Process ===");

        if (!inventoryService.checkStock(product, quantity)) {
            notificationService.sendFailure(product);
            System.out.println("=== Order Failed ===");
            return;
        }

        inventoryService.reserveStock(product, quantity);

        if (!paymentProcessor.processPayment(amount)) {
            inventoryService.releaseStock(product, quantity);
            notificationService.sendFailure(product);
            System.out.println("=== Order Failed ===");
            return;
        }

        if (!shippingService.arrangeShipping(product, quantity)) {
            paymentProcessor.refundPayment(amount);
            inventoryService.releaseStock(product, quantity);
            notificationService.sendFailure(product);
            System.out.println("=== Order Failed ===");
            return;
        }

        notificationService.sendConfirmation(product);
        System.out.println("=== Order Completed Successfully ===");
    }
}