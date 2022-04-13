package exercise5.PrototypeDesignPattern;

public class ShapeStyle implements Cloneable{
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
