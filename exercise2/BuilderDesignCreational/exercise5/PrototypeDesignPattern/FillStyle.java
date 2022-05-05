package PrototypeDesignPattern;


public class FillStyle implements Cloneable{
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
