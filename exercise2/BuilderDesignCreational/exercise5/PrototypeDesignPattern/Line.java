package exercise5.PrototypeDesignPattern;

public class Line extends Shape{
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
