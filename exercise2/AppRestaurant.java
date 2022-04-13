public class AppRestaurant {
    public static void main(String[] args) {
        MealFactory mealFactory = new MealFactory();

        Meal meal1 = mealFactory.takeOrder("MainDish");

        meal1.setMeal("Chicken Burger", 50);
        System.out.println("item name: "+meal1.getItem()+" ,price:"+meal1.getPrice());

        meal1.setMeal("Vegie Burger", 75);
        System.out.println("item name: "+meal1.getItem()+" ,price:"+meal1.getPrice());

        Meal meal2 = mealFactory.takeOrder("Beverage");

        meal2.setMeal("Coke", 10);
        System.out.println("item name: "+meal2.getItem()+" ,price:"+meal2.getPrice());

        meal2.setMeal("Pepsi", 12);
        System.out.println("item name: "+meal2.getItem()+" ,price:"+meal2.getPrice());

        Meal meal3 = mealFactory.takeOrder("Beverage");

        meal3.setMeal("Flan", 10);
        System.out.println("item name: "+meal3.getItem()+" ,price:"+meal3.getPrice());

        meal3.setMeal("Fruit", 10);
        System.out.println("item name: "+meal3.getItem()+" ,price:"+meal3.getPrice());
    }
}
class MealFactory {
    public Meal takeOrder(String mealChoice) {
        if("MainDish".equalsIgnoreCase(mealChoice)) {
            return new MainDish();
        } else if("Beverage".equalsIgnoreCase(mealChoice)) {
            return new Beverage();
        } else if("Ressert".equalsIgnoreCase(mealChoice)) {
            return new Ressert();
        }
        return null;
    }
} 
interface Meal {
    String getItem();
    int getPrice();
    void setMeal(String mealName, int price);
}
class MainDish implements Meal {
    private String mealName;
    private int mealPrice;
    public void setMeal(String mealName, int dishPrice) {
        this.mealName = mealName;
        this.mealPrice = dishPrice;
    }
    public String getItem() {
        return mealName;
    }
    public int getPrice() {
        return mealPrice;
    }
}
class Beverage implements Meal {
    private String beverageName;
    private int beveragePrice;
    public void setMeal(String drinkName, int drinkPrice) {
        this.beverageName = drinkName;
        this.beveragePrice = drinkPrice;
    }
    public String getItem() {
        return beverageName;
    }
    public int getPrice() {
        return beveragePrice;
    }
}
class Ressert implements Meal {
    private String ressertName;
    private int ressertPrice;
    public void setMeal(String ressertName, int ressertPrice) {
        this.ressertName = ressertName;
        this.ressertPrice = ressertPrice;
    }
    public String getItem() {
        return ressertName;
    }
    public int getPrice() {
        return ressertPrice;
    }
}