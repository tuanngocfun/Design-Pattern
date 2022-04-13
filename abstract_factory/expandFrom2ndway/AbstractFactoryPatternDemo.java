package expandFrom2ndway;

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
