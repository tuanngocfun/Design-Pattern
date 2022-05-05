package PrototypeDesignPattern;


public abstract class Shape implements Cloneable{
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
