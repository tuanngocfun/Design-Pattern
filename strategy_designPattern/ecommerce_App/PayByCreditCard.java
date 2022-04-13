package ecommerce_App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Concrete strategy. Implements credit card payment method.
 */
public class PayByCreditCard implements PayStrategy{
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard card;

    // Collect credit card data
    @Override public void collectPaymentDetails(){
        try {
            System.out.println("Enter the number: ");
            String number = READER.readLine();
            System.out.println("Enter the card expiry date: --format('mm/yy')");
            String date = READER.readLine();
            System.out.println("Enter the ccv code");
            String ccv = READER.readLine();
            card = new CreditCard(number, date, ccv);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // After card validation we can charge customer's credit card.
    @Override public boolean pay(int paymentAmount){
        if(cardIsPresent()){
            System.out.println("Paying "+paymentAmount+" using credit card.");
            card.setAmount(card.getAmount()-paymentAmount);
            return true;
        } else {
            return false;
        }
    }
    private boolean cardIsPresent(){
        return card != null;
    }
}
