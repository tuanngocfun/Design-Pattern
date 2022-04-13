package ecommerce_App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Concrete strategy. Implements PayPal payment method.
 */
public class PayByPayPal implements PayStrategy {
    private static final Map<String,String> DATA_BASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    private boolean signedIn;

    static {
        DATA_BASE.put("ElonMusk@gacon", "Muskgacon@gmail.com");
        DATA_BASE.put("Tuanngoc@hacker", "tuanngocpro001@gmail.com");
    }

    // collect customer's data
    @Override public void collectPaymentDetails(){
        try {
            while(!signedIn){
                System.out.println("Enter the user's email: ");
                email = READER.readLine();
                System.out.println("Enter the password: ");
                password = READER.readLine();
                if(verify()){
                    System.out.println("Data verification has been successful.");
                } else {
                    System.out.println("Wrong email or password!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private boolean verify(){
        setSignedIn(email.equalsIgnoreCase(DATA_BASE.get(password)));
        return signedIn;
    }
    private void setSignedIn(boolean signedIn){
        this.signedIn = signedIn;
    }
    
    // Save customer data for future shopping attempts
    @Override public boolean pay(int paymentAmount){
        if(signedIn){
            System.out.println("Paying "+paymentAmount+" using Paypal");
            return true;
        } else {
            return false;
        }
    }
}
