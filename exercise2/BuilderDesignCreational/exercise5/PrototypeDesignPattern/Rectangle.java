package exercise5.PrototypeDesignPattern;

public class Rectangle extends Shape{
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
