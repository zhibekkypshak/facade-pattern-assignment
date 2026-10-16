public class NotificationService {

    public void sendConfirmation(String product) {
        System.out.println("Notification: Your order for " + product + " has been confirmed.");
    }

    public void sendFailure(String product) {
        System.out.println("Notification: Your order for " + product + " has failed.");
    }
}

