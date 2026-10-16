# Online Order Processing — Facade Pattern

## Project Description

This project demonstrates the Facade Design Pattern in Java.

The system processes online orders by coordinating inventory management, payment processing, shipping, and customer notifications through one simple interface: `OrderFacade`.

## Technologies

- Java 17
- IntelliJ IDEA
- Git and GitHub
- PlantUML

## Project Structure

```text
src/
├── Main.java
├── facade/
│   └── OrderFacade.java
└── subsystem/
    ├── InventoryService.java
    ├── PaymentProcessor.java
    ├── ShippingService.java
    └── NotificationService.java
```

## How to Run

1. Open the project in IntelliJ IDEA.
2. Make sure JDK 17 is configured.
3. Open `src/Main.java`.
4. Run the `main()` method.

## How It Works

The client calls `OrderFacade.placeOrder()`. The facade coordinates the subsystem services in the correct order:

1. Check product availability.
2. Reserve the required stock.
3. Process the payment.
4. Arrange shipping.
5. Send an order confirmation.

If the stock is insufficient or payment fails, the order is stopped and a failure notification is sent. If payment fails after stock reservation, the reserved items are returned to inventory.

## Design Pattern Roles

- **Facade:** `OrderFacade`
- **Client:** `Main`
- **Subsystem classes:** `InventoryService`, `PaymentProcessor`, `ShippingService`, and `NotificationService`

The Facade hides the coordination details of the subsystem from the client.

## Test Scenarios

- Successful order.
- Insufficient stock.
- Invalid payment amount.
- Invalid product quantity.
- Stock rollback after payment failure.

## UML Diagram

The UML class diagram represents the relationships between `Main`, `OrderFacade`, and the subsystem classes.

