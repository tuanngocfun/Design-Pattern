package expandedfromSecondway;

public class MealBuilder {
    public Meal oneCourseMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegieBurger());
        meal.addItem(new Coke());
        meal.addItem(new Fruit());
        return meal;
    }

    public Meal twoCourseMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new VegieBurger());
        meal.addItem(new Pepsi());
        meal.addItem(new Flan());
        return meal;
    }
}
