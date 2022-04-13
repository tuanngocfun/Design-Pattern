package secondway;

public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        AbstractFactory ShapeFactory = FactoryProducer.getFactory(false);

        Shape shape1 = ShapeFactory.getShape("RECTANGLE");
        shape1.draw();

        Shape shape2 = ShapeFactory.getShape("SQUARE");
        shape2.draw();

        AbstractFactory ShapeFactory1 = FactoryProducer.getFactory(true);

        Shape shape3 = ShapeFactory1.getShape("RECTANGLE");
        shape3.draw();

        Shape shape4 = ShapeFactory1.getShape("SQUARE");
        shape4.draw();
    }
}
abstract class AbstractFactory {
    abstract Shape getShape(String shapeType);
}
class FactoryProducer {
    public static AbstractFactory getFactory(boolean rounded) {
        if(rounded) {
            return new RoundedShapeFactory();
        } else {
            return new ShapeFactory();
        }
    }
}
class RoundedShapeFactory extends AbstractFactory {
    @Override public Shape getShape(String shapeType) {
        if("RECTANGLE".equalsIgnoreCase(shapeType)) {
            return new RoundedRectangle();
        } else if("SQUARE".equalsIgnoreCase(shapeType)) {
            return new RoundedSquare();
        }
        return null;
    }
}
class ShapeFactory extends AbstractFactory {
    @Override public Shape getShape(String shapeType) {
        if("RECTANGLE".equalsIgnoreCase(shapeType)) {
            return new Rectangle();
        } else if("SQUARE".equalsIgnoreCase(shapeType)) {
            return new Square();
        }
        return null;
    }
}
interface Shape {
    void draw();
}
class RoundedRectangle implements Shape {
    @Override public void draw() {
        System.out.println("Inside RoundedRectangle::draw() method.");
    }
}
class RoundedSquare implements Shape {
    @Override public void draw() {
        System.out.println("Inside RoundedSquare::draw() method.");
    }
}
class Rectangle implements Shape {
    @Override public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
class Square implements Shape {
    @Override public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}