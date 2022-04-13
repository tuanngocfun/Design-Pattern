package exercise5.PrototypeZipDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class ShapeRegistryMain {
    public static void main(String[] args) throws CloneNotSupportedException {
		Circle circle = new Circle();
		circle.setX(10);
		circle.setY(10);
		ShapeStyle circleStyle = new ShapeStyle();
		circleStyle.setLineColor(Color.BLUE);
		circleStyle.setLinePattern(LinePattern.DOT);
		circleStyle.setLineThickness(1.1d);
		FillStyle circleFillStyle = new FillStyle();
		circleFillStyle.setFillColor(Color.YELLOW);
		circleFillStyle.setFillPattern(FillPattern.HEART);
		circle.setStyle(circleStyle);
		circle.setFillStyle(circleFillStyle);

		System.out.println("Drawing original object");
		System.out.println("-------------------------------------------------------------------------");
		circle.draw();
		System.out.println("Making clone of original object");
		// check the registry if its already available at there.
		Circle deepCopyCircle = (Circle) ShapeRegistry.getByType(circle.type());
		if (deepCopyCircle == null) {
			// add it in the registry if its not available
			ShapeRegistry.addShape(circle);
		}
		// get the clone always from the regeistry and use.
		deepCopyCircle = (Circle) ShapeRegistry.getByType(circle.type());
		System.out.println("Drawing clone object");
		System.out.println("-------------------------------------------------------------------------");
		deepCopyCircle.draw();
		System.out.println("Modifying clone object");
		deepCopyCircle.setX(20);
		deepCopyCircle.getStyle().setLineColor(Color.RED);
		deepCopyCircle.getFillStyle().setFillPattern(FillPattern.CHECKS);
		System.out.println("\n\nDrawing original object");
		System.out.println("-------------------------------------------------------------------------");
		circle.draw();
		System.out.println("Drawing clone object");
		System.out.println("-------------------------------------------------------------------------");
		deepCopyCircle.draw();
	}
}
class ShapeRegistry {
    protected static Map<String, Shape> CACHE = new HashMap<String, Shape>();

	public static Shape getByType(String type) {
		return CACHE.get(type);
	}

	public static void addShape(Shape shape) throws CloneNotSupportedException {
		CACHE.put(shape.type(), shape.clone());
	}
}
enum Color{
    BLUE,ORANGE,YELLOW,BLACK,PURPLE,GREEN,MAROON,RED
}
enum FillPattern {
    DOT,SOLID,HOLLOW,HEART,CHECKS,WAVY,LACY,STRIPED
}
enum LinePattern {
    SOLID,DOT,DASH,DOUBLE_DASH,DASH_SPACE
}
class FillStyle implements Cloneable{
    protected FillPattern fillPattern;
    protected Color fillColor;

    public FillStyle(){
        super();
    }
    public FillStyle(FillStyle fillStyle){
        this();
        System.out.println("Deep copy constructor for FillStyle class..");
        this.fillPattern=fillStyle.fillPattern;
        this.fillColor=fillStyle.fillColor;
    }

    @Override public FillStyle clone() throws CloneNotSupportedException{
        return (FillStyle) super.clone();
    }

    public Color getFillColor(){
        return fillColor;
    }
    public void setFillColor(Color color){
        this.fillColor=color;
    }
    public FillPattern getFillPattern(){
        return fillPattern;
    }
    public void setFillPattern(FillPattern pattern){
        this.fillPattern=pattern;
    }
    @Override public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("fillPattern=").append(fillPattern).append(" ,fillColor=").append(fillColor);
        return builder.toString();
    }
}
class ShapeStyle implements Cloneable{
    protected Color linecColor;
    protected LinePattern linePattern;
    protected double lineThickness;

    public ShapeStyle(){
        super();
    }
    public ShapeStyle(ShapeStyle shapeStyle){
        this();
        System.out.println("Deep-copy constructor for ShapeStyle class...");
        this.linePattern=shapeStyle.linePattern;
        this.lineThickness=shapeStyle.lineThickness;
        this.linecColor=shapeStyle.linecColor;
    }

    @Override public ShapeStyle clone() throws CloneNotSupportedException{
        return (ShapeStyle) super.clone();
    }

    public Color getLineColor(){
        return linecColor;
    }
    public void setLineColor(Color lineColor){
        this.linecColor=lineColor;
    }
    public LinePattern getLinePattern(){
        return linePattern;
    }
    public void setLinePattern(LinePattern linePattern){
        this.linePattern=linePattern;
    }
    public double getLineThickness(){
        return lineThickness;
    }
    public void setLineThickness(double lineThickness){
        this.lineThickness=lineThickness;
    }
    @Override public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("lineColor=").append(linecColor).append(" ,linePattern=").append(linePattern)
            .append(" ,lineThickness=").append(lineThickness);
        return builder.toString();
    }
}
abstract class Shape implements Cloneable{
    protected int x;
    protected int y;
    protected ShapeStyle shapeStyle;
    private String id;

    public Shape(){
        super();
    }
    public Shape(Shape shape){
        this();
        System.out.println("Deep copy constructor for Shape class..");
        this.x=shape.x;
        this.y=shape.y;
        this.shapeStyle=shape.shapeStyle;
    }

    abstract void draw();
    abstract String type();

    @Override public Shape clone() throws CloneNotSupportedException{
        Shape shape = (Shape) super.clone();
		// call explicit clone for handling cloning of nested objects
		shape.shapeStyle = shapeStyle.clone();
        return shape;
    }

    public String getID(){
        return id;
    }
    public void setID(String ID){
        this.id=ID;
    }
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x=x;
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y=y;
    }
    public ShapeStyle getStyle(){
        return shapeStyle;
    }
    public void setStyle(ShapeStyle shapeStyle){
        this.shapeStyle=shapeStyle;
    }
    @Override public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("x=").append(x).append(" ,y=").append(y).append(" , shape style=").append(shapeStyle);
        return builder.toString();
    }
}
class Circle extends Shape {
    protected double radius;
    protected FillStyle fillStyle;

    public Circle(){
        super();
    }

    @Override public void draw(){
        System.out.printf("Drawing Circle (%s, %s).\n", super.toString(), this.toString());
    }
    @Override public String type(){
        return "Circle";
    }

    @Override public Circle clone() throws CloneNotSupportedException{
        System.out.println("Cloning Circle...");
		Circle circle = (Circle) super.clone();
		// call explicit clone for handling cloning of nested objects
		circle.fillStyle = fillStyle.clone();
        return circle;
    }

    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius){
        this.radius=radius;
    }
    public FillStyle getFillStyle(){
        return fillStyle;
    }
    public void setFillStyle(FillStyle fillStyle){
        this.fillStyle=fillStyle;
    }
    @Override public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("radius=").append(radius).append(" , fill style=").append(fillStyle);
        return builder.toString();
    }
}
class Square extends Shape{
    protected int width;
    protected int length;
    protected FillStyle fillStyle;

    public Square(){
        super();
    }

    @Override public Square clone() throws CloneNotSupportedException{
        System.out.println("Cloning Square...");
        Square square = (Square) super.clone();
         // call explicit clone for handling cloning of nested objects
        square.fillStyle = fillStyle.clone();
        return square;
    }

    @Override public void draw(){
        System.out.printf("Drawing Square (%s %s).\n",super.toString(),this.toString());
    }
    @Override public String type(){
        return "Square";
    }

    public int getWidth(){
        return width;
    }
    public void setWidth(int width){
        this.width=width;
    }
    public int getLength(){
        return length;
    }
    public void setLength(int length){
        this.length=length;
    }
    public FillStyle getFillStyle(){
        return fillStyle;
    }
    public void setFillStyle(FillStyle fillStyle){
        this.fillStyle=fillStyle;
    }
    @Override public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("width=").append(width).append(" ,length=").append(length).append(" , fill style=").append(fillStyle);
        return builder.toString();
    }
}
class Rectangle extends Shape{
    protected int length;
    protected int width;
    protected FillStyle fillStyle;

    public Rectangle(){
        super();
    }
    
    @Override public void draw(){
        System.out.printf("Drawing Rectangle (%s %s).\n",super.toString(),this.toString());
    }
    @Override public String type(){
        return "Rectangle";
    }

    @Override public Rectangle clone() throws CloneNotSupportedException{
        System.out.println("Cloning Rectangle...");
		Rectangle rectangle = (Rectangle) super.clone();
		// call explicit clone for handling cloning of nested objects
		rectangle.fillStyle = fillStyle.clone();
        return rectangle;
    }

    public int getLength(){
        return length;
    }
    public void setLength(int length){
        this.length=length;
    }
    public int getWidth(){
        return width;
    }
    public void setWidth(int width){
        this.width=width;
    }
    public FillStyle getFillStyle(){
        return fillStyle;
    }
    public void setFillStyle(FillStyle fillStyle){
        this.fillStyle=fillStyle;
    }
    @Override public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("length=").append(length).append(" ,width=").append(width).append(" , fill style=").append(fillStyle);
        return builder.toString();
    }
}
class Line extends Shape{
    protected int x1;
    protected int y1;

    public Line(){
        super();
    }

    @Override public void draw(){
        System.out.printf("Drawing line (%s %s).\n",super.toString(),this.toString());
    }
    @Override public String type(){
        return "Line";
    }

    @Override public Line clone() throws CloneNotSupportedException{
        System.out.println("Cloning line...");
        return (Line) super.clone();
    }

    public int getX1(){
        return x1;
    }
    public void setX1(int x){
        this.x1=x;
    }
    public int getY1(){
        return y1;
    }
    public void setY1(int y){
        this.y1=y;
    }
    @Override public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("x1=").append(x1).append(" ,y1=").append(y1);
        return builder.toString();
    }
}