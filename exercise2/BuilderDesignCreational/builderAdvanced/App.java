package builderAdvanced;

import builderAdvanced.Item.Packing;

public class App {
    public static void main(String[] args) {
        ClientMeal meal = ClientMeal.MealBuilder.STANDARDMEAL.CREATE.
                            mandatory("Buger Chicken", "Flan", "Coke", 7.0).
                            withSpiceOption(ClientMeal.Spices.NO_SALT).
                            withItems().
                                addItem().
                                    withItemName("meal course A").withItemPrice(7.0).withPackingOption(Packing.WRAPPERPAPPER).
                                addToList().
                            buildItemList().
                        build();
        System.out.println(meal);

        ClientMeal meal2 = ClientMeal.MealBuilder.STANDARDMEAL.CREATE.
                            mandatory("Vegie Burger", "Fruit", "Pepsi", 9.7).
                            withSpiceOption(ClientMeal.Spices.SALT).
                            addBurgerType("Chicken Burger").addResserType("Flan").addBeverageType("Coke").addMealPrice(7.0).
                            withItems().
                                addItem().
                                    withItemName("Meal course B").withItemPrice(9.7+7.0).withPackingOption(Packing.WRAPPERPAPPER).
                                addToList().
                            buildItemList().
                        build();
        System.out.println(meal2);
    }
}
