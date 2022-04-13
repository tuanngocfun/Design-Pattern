package exercise5.PrototypeDesignPattern;

public class Circle extends Shape {
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
