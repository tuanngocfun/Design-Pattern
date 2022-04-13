package ecommerce_App;

public class CreditCard {
    private int amount;
    private String number;
    private String date;
    private String ccv;

    public CreditCard(String number, String date,String ccv){
        this.amount = 100000;
        this.number = number;
        this.date = date;
        this.ccv = ccv;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }
    public int getAmount(){
        return amount;
    }
}
