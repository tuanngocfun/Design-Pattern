package adapter.objectAdapterZip;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Creating drawing of shapes...");
        Drawing drawing = new Drawing();
        drawing.addShape(new Rectangle());
        drawing.addShape(new Circle());
        drawing.addShape(new GeometricShapeObjectAdapter(new Triangle()));
        drawing.addShape(new GeometricShapeObjectAdapter(new Rhombus()));

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