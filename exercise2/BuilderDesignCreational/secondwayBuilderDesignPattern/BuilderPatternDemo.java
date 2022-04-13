package secondwayBuilderDesignPattern;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegieMeal();
        System.out.println("Vegie meal: ");
        vegMeal.showItem();
        System.out.println("Total cost: "+vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegieMeal();
        System.out.println("Non-vegie meal: ");
        nonVegMeal.showItem();
        System.out.println("Total cost: "+nonVegMeal.getCost());
    }
}
class MealBuilder {
    public Meal prepareVegieMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegieBurger());
        meal.addItem(new Coke());
        meal.addItem(new Fruit());
        return meal;
    }

    public Meal prepareNonVegieMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        meal.addItem(new Flan());
        return meal;
    }
}
class Meal {
    private List<Item> items = new ArrayList<Item>();
    
    public void addItem(Item item) {
        items.add(item);
    }
    public BigDecimal getCost() {
        BigDecimal cost = new BigDecimal("0");

        for(Item item : items) {
            cost = cost.add(item.price());
        }
        return cost;
    }
    public void showItem() {
        for(Item item : items) {
            System.out.print("Item: "+item.name());
            System.out.print(" ,packing: "+item.packing().pack());
            System.out.println(" ,Price: "+item.price());
        }
    }
}
interface Item {
    String name();
    Packing packing();
    BigDecimal price();
}
abstract class Beverage implements Item {
    public abstract BigDecimal price();

    @Override public Packing packing() {
        return new Bottle();
    }
}
abstract class MainDish implements Item {
    public abstract BigDecimal price();

    @Override public Packing packing() {
        return new Wrapper();
    }
}
abstract class Ressert implements Item {
    public abstract BigDecimal price();

    @Override public Packing packing() {
        return new Wrapper();
    }
}
interface Packing {
    String pack();
}
class Bottle implements Packing {
    @Override public String pack() {
        return "Bottle";
    }
}
class Wrapper implements Packing {
    @Override public String pack() {
        return "Wrapper";
    }
}
class Coke extends Beverage {
    @Override public String name() {
        return "Coke";
    }
    @Override public BigDecimal price() {
        return BigDecimal.valueOf(1.0f);
    }
}
class Pepsi extends Beverage{
    @Override public String name() {
        return "Pepsi";
    }
    @Override public BigDecimal price() {
        return BigDecimal.valueOf(1.2f);
    }
}
class ChickenBurger extends MainDish{
    @Override public String name() {
        return "Chicken Burger";
    }
    @Override public BigDecimal price() {
        return BigDecimal.valueOf(5.0f);
    }
}
class VegieBurger extends MainDish {
    @Override public String name() {
        return "Vegie Burger";
    }
    @Override public BigDecimal price() {
        return BigDecimal.valueOf(7.5f);
    } 
}
class Flan extends Ressert {
    @Override public String name() {
        return "Flan";
    }
    @Override public BigDecimal price() {
        return BigDecimal.valueOf(1.0f);
    }
}
class Fruit extends Ressert {
    @Override public String name() {
        return "Fruit";
    }
    @Override public BigDecimal price() {
        return BigDecimal.valueOf(1.0f);
    }
}