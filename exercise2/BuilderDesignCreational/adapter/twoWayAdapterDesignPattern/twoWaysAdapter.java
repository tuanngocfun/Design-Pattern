package adapter.twoWayAdapterDesignPattern;


import java.util.ArrayList;
import java.util.List;

public class twoWaysAdapter {
    public static void main(String[] args) {

        System.out.println("Creating drawing of shapes...");
        Drawing drawing = new Drawing();
        drawing.addShape(new TwoWaysAdapter(ShapeType.RECTANGLE));
        drawing.addShape(new TwoWaysAdapter(ShapeType.CIRCLE));
        drawing.addShape(new TwoWaysAdapter(ShapeType.TRIANGLE));
        drawing.addShape(new TwoWaysAdapter(ShapeType.RHOMBUS));

        System.out.println("Drawing...");
        drawing.draw();
        System.out.println("Resizing...");
        drawing.resize();
    }
}
interface Shape { // target
    void draw();
    void resize();
    String description();
    boolean isHide();
}
class Rectangle implements Shape {
    @Override
    public void draw() {
    System.out.println("Drawing Rectangle");
    }
    @Override
    public void resize() {
    System.out.println("Resizing Rectangle");
    }
    @Override
    public String description() {
    return "Rectangle object";
    }
    @Override
    public boolean isHide() {
    return false;
    }
}
class Circle implements Shape {
    @Override
    public void draw() {
    System.out.println("Drawing Circle");
    }
    @Override
    public void resize() {
    System.out.println("Resizing Circle");
    }
    @Override
    public String description() {
    return "Circle object";
    }
    @Override
    public boolean isHide() {
    return false;
    }
}
class Drawing {
    List<Shape> shapes = new ArrayList<Shape>();

    public Drawing() {
    super();
    }

    public void addShape(Shape shape) {
    shapes.add(shape);
    }
    public List<Shape> getShapes() {
    return new ArrayList<Shape>(shapes);
    }
    public void draw() {
        if (shapes.isEmpty()) {
        System.out.println("Nothing to draw!");
        } else {
        shapes.stream().forEach(shape -> shape.draw());
        }
    }
    public void resize() {
        if (shapes.isEmpty()) {
        System.out.println("Nothing to resize!");
        } else {
        shapes.stream().forEach(shape -> shape.resize());
        }
    }
}
class GeometricShapeObjectAdapter implements Shape {
    private GeometricShape adaptee;

    public GeometricShapeObjectAdapter(GeometricShape adaptee) {
          super();
          this.adaptee = adaptee;
    }

    @Override
    public void draw() {
        adaptee.drawShape();
    }
    @Override
    public void resize() {
        System.out.println(description() + " can't be resized. Please create new one with required values.");
    }
    @Override
    public String description() {
        if (adaptee instanceof Triangle) {
        return "Triangle object";
        } else if (adaptee instanceof Rhombus) {
        return "Rhombus object";
        } else {
        return "Unknown object";
        }
    }
    @Override
    public boolean isHide() {
        return false;
    }
}
class TriangleAdapter extends Triangle implements Shape {
    public TriangleAdapter() {
        super();
    }

    @Override
    public void draw() {
        this.drawShape();
    }
    @Override
    public void resize() {
        System.out.println("Triangle can't be resized. Please create new one with required values.");
    }
    @Override
    public String description() {
        return "Triangle object";
    }
    @Override
    public boolean isHide() {
        return false;
    }
}
class RhombusAdapter extends Rhombus implements Shape {
    public RhombusAdapter() {
        super();
    }

    @Override
    public void draw() {
        this.drawShape();
    }   
    @Override
    public void resize() {
        System.out.println("Rhombus can't be resized. Please create new one with required values.");
    }
    @Override
    public String description() {
        return "Rhombus object";
    }
    @Override
    public boolean isHide() {
        return false;
    }
}
interface GeometricShape {
    double area();
    double perimeter();
    void drawShape();
}
class Triangle implements GeometricShape {
    // sides
    private final double a;
    private final double b;
    private final double c;

    public Triangle() {
        this(1.0d, 1.0d, 1.0d);
    }

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public double area() {
        // Heron's formula:
        // Area = SquareRoot(s * (s - a) * (s - b) * (s - c)) 
        // where s = (a + b + c) / 2, or 1/2 of the perimeter of the triangle 
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    @Override
    public double perimeter() {
        // P = a + b + c
        return a + b + c;
    }
    @Override
    public void drawShape() {
        System.out.println("Drawing Triangle with area: " + area() + " and perimeter: " + perimeter());
    }
}
class Rhombus implements GeometricShape {
    // sides
    private final double a;
    private final double b;

    public Rhombus() {
        this(1.0d, 1.0d);
    }

    public Rhombus(double a, double b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public double area() {
        double s = a * b;
        return s;
    }
    @Override
    public double perimeter() {
        return 2 * (a + b);
    }
    @Override
    public void drawShape() {
        System.out.println("Drawing Rhombus with area: " + area() + " and perimeter: " + perimeter());
    }
}
enum ShapeType {
    CIRCLE,
    RECTANGLE,
    TRIANGLE,
    RHOMBUS
}
class TwoWaysAdapter implements Shape, GeometricShape {
    // sides
    private ShapeType shapeType;

    public TwoWaysAdapter() {
      this(ShapeType.TRIANGLE);
    }
    public TwoWaysAdapter(ShapeType shapeType) {
            super();
            this.shapeType = shapeType;
    }

    @Override public void draw() {
        switch (shapeType) {
            case CIRCLE:
                new Circle().draw();
                break;
            case RECTANGLE:
                new Rectangle().draw();
                break;
            case TRIANGLE:
                new Triangle().drawShape();
                break;
            case RHOMBUS:
                new Rhombus().drawShape();
                break;
        }
    }
    @Override public void resize() {
        switch (shapeType) {
            case CIRCLE:
                new Circle().resize();
                break;
            case RECTANGLE:
                new Rectangle().resize();
                break;
            case TRIANGLE:
                System.out.println("Triangle can't be resized. Please create new one with required values.");
                break;
            case RHOMBUS:
                System.out.println("Rhombus can't be resized. Please create new one with required values.");
            break;                                          
        }
    }
    @Override public String description() {
        switch (shapeType) {
            case CIRCLE:
            return new Circle().description();
            case RECTANGLE:
            return new Rectangle().description();
            case TRIANGLE:
            return "Triangle object";
            case RHOMBUS:
            return "Rhombus object";
        }
        return "Unknown object";
    }
    @Override public boolean isHide() {
        return false;
    }
    @Override public double area() {
        switch (shapeType) {
            case CIRCLE:
            case RECTANGLE:
            return 0.0d;
            case TRIANGLE:
            return new Triangle().area();
            case RHOMBUS:
            return new Rhombus().area();
        }
        return 0.0d;
    }
    @Override public double perimeter() {
        switch (shapeType) {
                case CIRCLE:
                case RECTANGLE:
                return 0.0d;
                case TRIANGLE:
                return new Triangle().perimeter();
                case RHOMBUS:
                return new Rhombus().perimeter();
        }
        return 0.0d;
    }
    @Override public void drawShape() {
        draw();
    }
}