package secondwayCompositeBuilderPattern;

import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
    public static void main(String[] args) {
        
    }
}
class MealBuilder {
    
    
}
class Meal {
    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item) {
        items.add(item);
    }
    public void removeItem(Item item) {
        items.remove(item);
    }
    public float OptionWithSalt() {
        float cost = 0.0f;

        for(Item item : items) {
            cost += item.getPrice();
        }
        return cost;
    }
    public float OptionNoSalt() {
        float cost = 0.0f;

        for(Item item : items) {
            cost += item.getPrice()-item.getPrice()*0.1;
        }
        return cost;
    }
    public void showItem() {
        for(Item item : items) {
            System.out.print("Item: "+item.getName());
            System.out.println(" ,Price: "+item.getPrice());
        }
    }
}
interface Item {
    void showMealDetails();
    double getPrice();
    String getName();
    void setPrice(double price);
    void setName(String name);
}
class VegieBurger implements Item {
    private String name;
    private double price;
    
    public VegieBurger(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setName(String name){
        this.name = name;
    }
    @Override public void showMealDetails() {
        System.out.println("name:"+name+" ,price: "+price);
    }
}
class ChickenBurger implements Item {
    private String name;
    private double price;

    public ChickenBurger(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setName(String name){
        this.name = name;
    }
    @Override public void showMealDetails() {
        System.out.println("name:"+name+" ,price: "+price);
    }
}
class Coke implements Item {
    private String name;
    private double price;

    public Coke(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setName(String name){
        this.name = name;
    }
    @Override public void showMealDetails() {
        System.out.println("name:"+name+" ,price: "+price);
    }
}
class Pepsi implements Item {
    private String name;
    private double price;

    public Pepsi(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setName(String name){
        this.name = name;
    }
    @Override public void showMealDetails() {
        System.out.println("name:"+name+" ,price: "+price);
    }
}
class Flan implements Item {
    private String name;
    private double price;

    public Flan(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setName(String name){
        this.name = name;
    }
    @Override public void showMealDetails() {
        System.out.println("name:"+name+" ,price: "+price);
    }
}
class Fruit implements Item {
    private String name;
    private double price;

    public Fruit(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setName(String name){
        this.name = name;
    }
    @Override public void showMealDetails() {
        System.out.println("name:"+name+" ,price: "+price);
    }
}