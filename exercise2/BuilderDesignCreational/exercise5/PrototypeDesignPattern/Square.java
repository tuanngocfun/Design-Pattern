package PrototypeDesignPattern;


public class Square extends Shape{
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
