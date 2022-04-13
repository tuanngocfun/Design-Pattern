package singleton_eg;

import java.util.ArrayList;
import java.util.List;

import singleton_eg.Item.Packing;

public class SingletonSample {
    public static void main(String[] args) {
        Singleton object = Singleton.getInstance();
        object.printMessage();

        // Factory & Singleton
        PrinterFactory obj = PrinterFactory.getPrinterInstance();
        Printer o1 = obj.createPrinter("Printer1");
        o1.print();

        Printer o2 = obj.createPrinter("Printer2");
        o2.print();

        Printer o3 = obj.createPrinter("Printer3");
        o3.print();

        Printer o4 = obj.createPrinter("Printer4");
        o4.print();

        Printer o5 = obj.createPrinter("Printer5");
        o5.print();

        // Builder & Singleton
        App obBuilder = App.getAppInstance();
        obBuilder.SingletonBuilder();
    }
}
interface Printer {
    void print();
}
class Printer1 implements Printer {
    @Override public void print() {
        System.out.println("Hello world, you are using printer 1");
    }
}
class Printer2 implements Printer {
    @Override public void print() {
        System.out.println("Hello world, you are using printer 2");
    }
}
class Printer3 implements Printer {
    @Override public void print() {
        System.out.println("Hello world, you are using printer 3");
    }
}
class Printer4 implements Printer {
    @Override public void print() {
        System.out.println("Hello world, you are using printer 4");
    }
}
class Printer5 implements Printer {
    @Override public void print() {
        System.out.println("Hello world, you are using printer 5");
    }
}
final class PrinterFactory {
    private static final PrinterFactory printerFactorySingleton = new PrinterFactory();
    private volatile static PrinterFactory objBoost;

    private PrinterFactory() {}

    public Printer createPrinter(String whichPrinter) {
        if(whichPrinter == null) {
            return null;
        }
        if(whichPrinter.equalsIgnoreCase("Printer1")) {
            return new Printer1();
        } else if(whichPrinter.equalsIgnoreCase("Printer2")) {
            return new Printer2();
        } else if(whichPrinter.equalsIgnoreCase("Printer3")) {
            return new Printer3();
        } else if(whichPrinter.equalsIgnoreCase("Printer4")) {
            return new Printer4();
        } else if(whichPrinter.equalsIgnoreCase("Printer5")) {
            return new Printer5();
        }
        return null;
    }
    public static PrinterFactory getPrinterInstance() {
        PrinterFactory obj = objBoost;
        if(obj==null){
            synchronized(printerFactorySingleton) {
                obj = objBoost;
                if(obj==null){
                    obj = new PrinterFactory();
                    objBoost = obj;
                }
            }
        }
        return obj;
    }
}
class App {
    private static final App appSingleton = new App();
    private volatile static App oB;

    private App(){}

    public static App getAppInstance() {
        App o = oB;
        if(o==null){
            synchronized(appSingleton){
                o = oB;
                if(o==null){
                    o = new App();
                    oB = o;
                }
            }
        }return o;
    }
    public void SingletonBuilder(){
        ClientMeal meal = ClientMeal.getClientMealInstance();
        meal=ClientMeal.MealBuilder.STANDARDMEAL.CREATE.
                            mandatory("Buger Chicken", "Flan", "Coke", 7.0).
                            withSpiceOption(ClientMeal.Spices.NO_SALT).
                            withItems().
                                addItem().
                                    withItemName("meal course A").withItemPrice(7.0).withPackingOption(Packing.WRAPPERPAPPER).
                                addToList().
                            buildItemList().
                        build();
        System.out.println(meal);

        ClientMeal meal2 = ClientMeal.getClientMealInstance();
        meal2 = ClientMeal.MealBuilder.STANDARDMEAL.CREATE.
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
final class ClientMeal {
    private List<String> burgerName = new ArrayList<String>();
    private List<String> ressertName = new ArrayList<String>();
    private List<String> beverageName = new ArrayList<String>();
    private double price;
    private Spices spicesOption = Spices.NO_SALT;
    private List<Item> items;

    private static final ClientMeal clientMealObj = new ClientMeal();
    private static volatile ClientMeal oBoost;

    private ClientMeal() {}

    public static ClientMeal getClientMealInstance() {
        ClientMeal ClientMealO = oBoost;
        if(ClientMealO==null){
            synchronized(clientMealObj){
                ClientMealO = oBoost;
                if(ClientMealO==null){
                    ClientMealO = new ClientMeal();
                    oBoost = ClientMealO;
                }
            }
        }
        return ClientMealO;
    }

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
class Singleton {
    private static final Singleton singleton = new Singleton();
    private volatile static Singleton objectBoost;

    private Singleton() {}

    public static Singleton getInstance() {
        Singleton object = objectBoost;
        if(object==null){
            synchronized(singleton) {
                object = objectBoost;
                if(object==null){
                    object = new Singleton();
                    objectBoost = object;
                }
            }
        }
        return object;
    }
    public void printMessage() {
        System.out.println("You are calling the print message from Singleton()");
    }
}