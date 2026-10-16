package client;

import facade.OrderFacade;

public class Main {

    public static void main(String[] args) {
        OrderFacade facade = new OrderFacade();

        facade.placeOrder("Laptop", 1, 1200.0);
        facade.cancelOrder("Laptop", 1, 1200.0);
        facade.placeOrder("Laptop", 10, 12000.0);
        facade.placeOrder("Keyboard", 2, 0.0);
        facade.placeOrder("Mouse", 0, 25.
        facade.placeOrder("Mouse", 1, 25.0);
    }
}
