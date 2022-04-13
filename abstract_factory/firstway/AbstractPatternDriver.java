package firstway;
public class AbstractPatternDriver {
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
interface AbstractFactory<T> {
    T create(String Type);
}
class FactoryProvider {
    public static AbstractFactory getFactory(String choice) {
        if("Animal".equalsIgnoreCase(choice)) {
            return new AnimalFactory();
        } else if("Color".equalsIgnoreCase(choice)) {
            return new ColorFactory();
        }
        return null;
    }
}
class AnimalFactory implements AbstractFactory<Animal> {
    @Override public Animal create(String animalType) {
        if("Dog".equalsIgnoreCase(animalType)) {
            return new Dog();
        } else if("Duck".equalsIgnoreCase(animalType)) {
            return new Duck();
        }
        return null;
    }
}
class ColorFactory implements AbstractFactory<Color> {
    @Override public Color create(String colorType) {
        if("Brown".equalsIgnoreCase(colorType)) {
            return new Brown();
        } else if("White".equalsIgnoreCase(colorType)) {
            return new White();
        }
        return null;
    }
}
interface Animal {
    String getAnimal();
    String makeSound();
}
interface Color {
    String getColor();
}
class Dog  implements Animal {
    @Override public String getAnimal() {
        return "Dog";
    }
    @Override public String makeSound() {
        return "Go";
    }
}
class Duck implements Animal {
    @Override public String getAnimal() {
        return "Duck";
    }
    @Override public String makeSound() {
        return "Squeks";
    }
}
class Brown implements Color {
    @Override public String getColor() {
        return "Brown";
    }
}
class White implements Color {
    @Override public String getColor() {
        return "White";
    }
}
