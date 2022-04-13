package ecommerce_App;

public interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}
