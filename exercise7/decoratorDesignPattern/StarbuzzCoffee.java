package decoratorDesignPattern;

public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Expresso();
        System.out.println(beverage.getDescription() + " S" + beverage.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " S" + beverage2.cost());

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription() + " S" + beverage3.cost());

        Beverage beverage4 = new Decaf();
        beverage4 = new SteamedMilk(beverage4);
        beverage4 = new Mocha(beverage4);
        beverage4 = new Whip(beverage4);
        System.out.println(beverage4.getDescription() + " S" + beverage4.cost());

        Beverage beverage5 = new Expresso();
        beverage5 = new Soy(beverage5);
        beverage5 = new Mocha(beverage5);
        beverage5 = new Whip(beverage5);
        System.out.println(beverage5.getDescription() + " S" + beverage5.cost());
    }
}
