package exercise5.extendClassWay;

public class extendClass {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setString("wow");
        circle.print();

        Rectangle rectangle = new Rectangle();
        rectangle.setString("idk");
        rectangle.print();

        Square square = new Square();
        square.setString("lgtm");
        square.print();
    }
}
class Shape{
    private String type;

    public void print() {
        System.out.println("Shape::print method have "+type);
    }
    public void setString(String thing) {
        this.type = thing;
    }
}
class Circle extends Shape {
    private String type;

    public void print(){
        System.out.println("Circle::print method have "+type);
    }
    public void setString(String thing) {
        this.type = thing;
    }
}
class Rectangle extends Shape{
    private String type;

    public void print(){
        System.out.println("Rectangle::print method have "+type);
    }
    public void setString(String thing) {
        this.type = thing;
    }
}
class Square extends Shape{
    private String type;

    public void print(){
        System.out.println("Square::print method have "+type);
    }
    public void setString(String thing) {
        this.type = thing;
    }
}