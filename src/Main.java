public class Main {
    public static void main(String[] args){
        OrderFacade facade = new OrderFacade();
        facade.placeOrder("Laptop",1,1200.0);
        facade.placeOrder("Keyboard", 2, 0.0);
        facade.placeOrder("Mouse",0,25.0);
    }
}
