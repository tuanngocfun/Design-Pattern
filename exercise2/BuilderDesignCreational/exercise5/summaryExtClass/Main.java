package summaryExtClass;


import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        ShapeFactory factory = new ShapeFactory();
        Shape circle = (Shape) factory.createShape("Circle");
        circle.display();
    }
}
class ShapeFactory{
    private static HashMap<String, Shape> clone;

    public HashMap<String, Shape> getCache() {
        return clone;
    }

    static {
        clone = new HashMap<String,Shape>();
        clone.put("Circle", new Circle());
        clone.put("Square", new Square());
        clone.put("Rectangle", new Rectangle());
    }
    public Shape createShape(String shape) throws CloneNotSupportedException{
        if(shape==null){
            return null;
        }
        Shape shape2=clone.get(shape);
        if(clone.get(shape)!=null){
            return (Shape) shape2.clone();
        }
        return null;
    }
}
abstract class Shape implements Cloneable{
    public void display(){
        System.out.println("Shape::display() method was printed out");
    }
    public Object clone() {
        Object clone = null;
        
        try {
           clone = super.clone();
           
        } catch (CloneNotSupportedException e) {
           e.printStackTrace();
        }
        return clone;
    }
}
class Square extends Shape{
    public void display() {
        System.out.println("Square::display() method was printed out!");
    }
    @Override public Object clone() {
        return (Square) super.clone();
    }
}
class Circle extends Shape{
    @Override public void display() {
        System.out.println("Circle::display() method was printed out!");
    }
    @Override public Object clone(){
        return (Circle)super.clone();
    }
}
class Rectangle extends Shape{
    @Override public void display() {
        System.out.println("Rectangle::display() method was printed out!");
    }
    @Override public Object clone(){
        return (Rectangle)super.clone();
    }
}