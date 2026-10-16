package subsystem;

public class PaymentProcessor {

    public boolean processPayment(double amount) {
        System.out.println("Processing payment: $" + amount);

        if (amount <= 0) {
            System.out.println("Payment failed: invalid amount.");
            return false;
        }

        System.out.println("Payment successful.");
        return true;
    }
    public void refundPayment(double amount) {
        System.out.println("Refunding payment: $" + amount);
    }
}

