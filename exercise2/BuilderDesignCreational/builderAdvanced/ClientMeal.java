package builderAdvanced;

import java.util.ArrayList;
import java.util.List;

public class ClientMeal {
    private List<String> burgerName = new ArrayList<String>();
    private List<String> ressertName = new ArrayList<String>();
    private List<String> beverageName = new ArrayList<String>();
    private double price;
    private Spices spicesOption = Spices.NO_SALT;
    private List<Item> items;

    private ClientMeal() {}

    public static class MealBuilder {
        public enum STANDARDMEAL {
            CREATE;
            private GeneralFunctionalSteps steps;

            public GeneralFunctionalSteps mandatory(String burgerName,String ressertName,String beverageName,double price) {
                steps = new GeneralFunctionalSteps();
                steps.clientMealInfo = new ClientMeal();
                steps.clientMealInfo.burgerName.add(burgerName);
                steps.clientMealInfo.ressertName.add(ressertName);
                steps.clientMealInfo.beverageName.add(beverageName);
                steps.clientMealInfo.price = price;
                return steps;
            }

            public ClientMeal build() {
                return steps.clientMealInfo;
            }
            public GeneralFunctionalSteps addMeal(String burgerName,String ressertName,String beverageName,double price) {
                steps = new GeneralFunctionalSteps();
                steps.clientMealInfo = new ClientMeal();
                steps.clientMealInfo.burgerName.add(burgerName);
                steps.clientMealInfo.ressertName.add(ressertName);
                steps.clientMealInfo.beverageName.add(beverageName);
                steps.clientMealInfo.price += price;
                return steps;
            }
        };

        public enum SPECIALMEAL {
            CREATE;
            private GeneralFunctionalSteps steps;

            public GeneralFunctionalSteps mandatory(String burgerName,String ressertName,String beverageName,double price) {
                steps = new GeneralFunctionalSteps();
                steps.clientMealInfo = new ClientMeal();
                steps.clientMealInfo.burgerName.add(burgerName);
                steps.clientMealInfo.ressertName.add(ressertName);
                steps.clientMealInfo.beverageName.add(beverageName);
                steps.clientMealInfo.price = price+price*0.1;
                return steps;
            }

            public GeneralFunctionalSteps addMeal(String burgerName,String ressertName,String beverageName,double price) {
                steps = new GeneralFunctionalSteps();
                steps.clientMealInfo = new ClientMeal();
                steps.clientMealInfo.burgerName.add(burgerName);
                steps.clientMealInfo.ressertName.add(ressertName);
                steps.clientMealInfo.beverageName.add(beverageName);
                steps.clientMealInfo.price += price;
                return steps;
            }
        };
        public static class GeneralFunctionalSteps {
            private ClientMeal clientMealInfo;
            private ItemListBuilder itemListBuilder;

            public GeneralFunctionalSteps addBurgerType(String type) {
                clientMealInfo.burgerName.add(type);
                return this;
            }
            public GeneralFunctionalSteps addResserType(String type) {
                clientMealInfo.ressertName.add(type);
                return this;
            }
            public GeneralFunctionalSteps addBeverageType(String type) {
                clientMealInfo.beverageName.add(type);
                return this;
            }
            public GeneralFunctionalSteps withSpiceOption(Spices spicesOption) {
                if(spicesOption==Spices.NO_SALT) {
                    clientMealInfo.price = clientMealInfo.price;
                }
                else if(spicesOption==Spices.SALT) {
                    clientMealInfo.price += 0.1*clientMealInfo.price;
                }
                clientMealInfo.spicesOption = spicesOption;
                return this;
            }
            public GeneralFunctionalSteps addMealPrice(double price) {
                clientMealInfo.price += price;
                return this;
            }
            public ItemListBuilder withItems() {
                itemListBuilder = new ItemListBuilder(this);
                return itemListBuilder;
            }
            
            public ClientMeal build() {
                clientMealInfo.items = itemListBuilder.items;
                return clientMealInfo;
            }
        }
    }

    public static class ItemListBuilder {
        private List<Item> items = new ArrayList<Item>();
        private MealBuilder.GeneralFunctionalSteps steps;

        public ItemListBuilder(MealBuilder.GeneralFunctionalSteps steps) {
            this.steps = steps;
        }

        public Item.ItemBuilder addItem() {
            return new Item.ItemBuilder(this);
        }
        public ItemListBuilder addAllItem(List<Item> items) {
            items.addAll(items);
            return this;
        }
        public ItemListBuilder addItem(Item item) {
            items.add(item);
            return this;
        }
        public MealBuilder.GeneralFunctionalSteps buildItemList() {
            return steps;
        }
    }

    public enum Spices {
        SALT,
        NO_SALT
    }

    public List<String> getBurgerName() {
        return burgerName;
    }
    public List<String> getRessertName() {
        return ressertName;
    }
    public List<String> getBeverageName() {
        return beverageName;
    }
    public double getPrice() {
        return price;
    }
    public Spices getSpices() {
        return spicesOption;
    }
    public List<Item> getItem() {
        return items;
    }
    @Override public String toString() {
        System.out.println("Client meal information: "+'\n');
        burgerName.forEach(burger->System.out.print(burger+", "));
        System.out.println();
        ressertName.forEach(ressert->System.out.print(ressert+", "));
        System.out.println();
        beverageName.forEach(drink->System.out.print(drink+", "));

        return  "spice option: "+spicesOption+'\n'+
                "price: "+price+'\n';
    }
}
class Item {
    private String itemName;
    private double mealPrice;
    private Packing packing;
    
    public Item(ItemBuilder builder) {
        this.itemName = builder.itemName;
        this.mealPrice = builder.mealPrice;
    }
    
    public static class ItemBuilder {
        private String itemName;
        private double mealPrice;
        private Packing packing;

        private ClientMeal.ItemListBuilder itemListBuilder;

        public ItemBuilder() {}
        public ItemBuilder(ClientMeal.ItemListBuilder itemListBuilder) {
            this.itemListBuilder = itemListBuilder;
        }

        public ItemBuilder withItemName(String itemName) {
            this.itemName = itemName;
            return this;
        }
        public ItemBuilder withItemPrice(Double itemPrice) {
            this.mealPrice = itemPrice;
            return this;
        }
        public ItemBuilder withPackingOption(Packing packing) {
            this.packing = packing;
            return this;
        }
        public Item build() {
            return new Item(this);
        }
        public ClientMeal.ItemListBuilder addToList() {
            Item item = build();
            this.itemListBuilder.addItem(item);
            return this.itemListBuilder;
        }
    }
    
    public enum Packing {
        WRAPPERPAPPER,
        WRAPPERGIFT
    }

    public String getItemMeal() {
        return itemName;
    }
    public double getItemMealPrice() {
        return mealPrice;
    }
    public Packing getPackingOption() {
        return packing;
    }
}