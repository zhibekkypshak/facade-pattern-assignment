# Online Order Processing — Facade Pattern

## Project Description

This project demonstrates the Facade Design Pattern in Java.

The system processes online orders by coordinating inventory management, payment processing, shipping, and customer notifications through one simple interface: `OrderFacade`.

## Technologies

- Java 17
- IntelliJ IDEA
- Git and GitHub

## Project Structure

```text
src/
├── client/
│   └── Main.java
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
3. Open `src/client/Main.java`.
4. Run the `main()` method.

Or from the command line, from the project root:

```bash
javac -d out $(find src -name "*.java")
java -cp out client.Main
```

## Public API of the Facade

- `placeOrder(String product, int quantity, double amount)`
- `cancelOrder(String product, int quantity, double amount)`

The client never calls subsystem classes directly.

## How It Works

The client calls `OrderFacade.placeOrder()`. The facade coordinates the subsystem services in the correct order:

1. Check product availability.
2. Reserve the required stock.
3. Process the payment.
4. Arrange shipping.
5. Send an order confirmation.

If any step fails, the facade rolls back the previous steps:

- if payment fails → reserved stock is released;
- if shipping fails → payment is refunded and reserved stock is released;
- the customer receives a failure notification.

`cancelOrder()` rolls back an already placed order: releases stock, refunds the payment and sends a cancellation notification.

## Design Pattern Roles

- **Facade:** `OrderFacade`
- **Client:** `Main`
- **Subsystem classes:** `InventoryService`, `PaymentProcessor`, `ShippingService`, `NotificationService`

Subsystem classes have no reference to the Facade and can still be used directly by advanced clients.

## Test Scenarios

Covered in `Main`:

1. Successful order.
2. Order cancellation.
3. Insufficient stock.
4. Invalid payment amount → stock rollback.
5. Invalid product quantity.
6. Successful order again, to prove the system state is consistent after rollbacks.

## UML Diagram

 It shows the relationships between `Main`, `OrderFacade`, and the four subsystem classes.

