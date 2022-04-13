package ecommerce_App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Demo {
    private static Map<Integer,Integer> priceOnProduct = new HashMap<>();
    private static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;

    static {
        priceOnProduct.put(1, 2200);
        priceOnProduct.put(2, 1850);
        priceOnProduct.put(3, 1100);
        priceOnProduct.put(4, 890);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        while(!order.getClosed()){
            int cost;

            String continueChoice;
            do{
                System.out.println("Please, select a product:" + "\n" +
                                    "1 - Mother board" + "\n" +
                                    "2 - CPU" + "\n" +
                                    "3 - HDD" + "\n" +
                                    "4 - Memory" + "\n");
                int choice = Integer.parseInt(READER.readLine());
                cost = priceOnProduct.get(choice);
                System.out.println("Count: ");
                int count = Integer.parseInt(READER.readLine());
                order.setTotalCost(cost*count);
                System.out.println("Do you wish to continue selecting products? Y/N:");
                continueChoice = READER.readLine();
            } while (continueChoice.equalsIgnoreCase("Y"));

            if(strategy==null){
                System.out.println("Please, select a payment method:"+"\n"+
                                    "1 - PayPay"+"\n"+
                                    "2 - Credit card");
                String paymentMethod = READER.readLine();

                // Client creates different strategies based on input from the user, application configuration, etc.
                if(paymentMethod.equalsIgnoreCase("1")){
                    strategy = new PayByPayPal();
                } else {
                    strategy = new PayByCreditCard();
                }
            }

            // Order object delegates gathering payment data to strategy object, 
            // because only the strategy object know which data they need to process payment
            order.processOrder(strategy);

            System.out.println("Pay "+order.getTotalCost()+" units or (C)ontinue shopping?"+"P/C:");
            String proceed = READER.readLine();
            if(proceed.equalsIgnoreCase("P")){
                // Strategy handles payment
                if(strategy.pay(order.getTotalCost())){
                    System.out.println("Successful payment! Thank you, have a nice day!");
                } else {
                    System.out.println("Unsuccessful payment, check your data!");
                }
                order.setClosed();
            }
        }
    }
}
