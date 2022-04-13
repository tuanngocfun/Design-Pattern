package expandedfromSecondway;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal oneMealChoice = mealBuilder.oneCourseMeal();
        System.out.println("Vegie meal: ");
        oneMealChoice.showItem();
        System.out.println("Total cost: "+oneMealChoice.OptionNoSalt());

        Meal twoMealChoice = mealBuilder.twoCourseMeal();
        System.out.println("Non-vegie meal: ");
        twoMealChoice.showItem();
        System.out.println("Total cost: "+twoMealChoice.OptionNoSalt());
    }
}