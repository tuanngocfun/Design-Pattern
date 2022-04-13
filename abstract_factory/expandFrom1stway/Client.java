package expandFrom1stway;
public class Client {
    public static void main(String[] args) {
        AbstractFactory abstractFactory;
        
        // create a brown toy dog
        abstractFactory = FactoryProvider.getFactory("Animal");
        Animal dog = (Animal) abstractFactory.create("Dog");

        abstractFactory = FactoryProvider.getFactory("Color");
        Color color = (Color) abstractFactory.create("Brown");

        System.out.println("A "+dog.getAnimal()+" with "+color.getColor()+" color "+dog.makeSound());
    }
}
