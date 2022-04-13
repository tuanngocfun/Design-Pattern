package exercise5.PrototypeDesignPattern;

import java.util.Hashtable;

public class ShapeCache {
    private static Hashtable<String,Shape> shapeMap = new Hashtable<>();

    public static Shape getShape(String shapeID)throws CloneNotSupportedException{
        Shape cacheShape = shapeMap.get(shapeID);
        return (Shape) cacheShape.clone();
    }

    public static void loadCache() throws CloneNotSupportedException{
        Circle circle = new Circle();
        circle.setID("1");
        circle.setX(10);
        circle.setY(10);
        circle.setRadius(3.14);
        ShapeStyle circleStyle = new ShapeStyle();
        circleStyle.setLineColor(Color.MAROON);
        circleStyle.setLinePattern(LinePattern.DOUBLE_DASH);
        circleStyle.setLineThickness(1.1d);
        FillStyle cFillStyle = new FillStyle();
        cFillStyle.setFillColor(Color.YELLOW);
        cFillStyle.setFillPattern(FillPattern.WAVY);
        circle.setStyle(circleStyle);
        circle.setFillStyle(cFillStyle);
        System.out.println("Drawing original object");
        System.out.println("-------------------------------------------------------------------------");
        circle.draw();
        System.out.println("Making clone of original object(deep copy)");
        Circle deepCopyCircle = circle.clone();
        System.out.println("Drawing clone object");
        System.out.println("-------------------------------------------------------------------------");
        deepCopyCircle.draw();
        System.out.println("Modifying clone object");
        deepCopyCircle.setX(20);
        deepCopyCircle.getStyle().setLineColor(Color.PURPLE);
        deepCopyCircle.getFillStyle().setFillPattern(FillPattern.HEART);
        System.out.println("Drawing clone object");
        System.out.println("-------------------------------------------------------------------------");
        deepCopyCircle.draw();
        shapeMap.put(circle.getID(), circle);

        Square square = new Square();
        square.setID("2");
        square.setX(5);
        square.setY(5);
        ShapeStyle squareStyle = new ShapeStyle();
        squareStyle.setLineColor(Color.BLACK);
        squareStyle.setLinePattern(LinePattern.DASH);
        squareStyle.setLineThickness(1.0d);
        FillStyle squarFillStyle = new FillStyle();
        squarFillStyle.setFillColor(Color.BLUE);
        squarFillStyle.setFillPattern(FillPattern.LACY);
        square.setStyle(squareStyle);
        square.setFillStyle(squarFillStyle);
        System.out.println("Drawing original object");
        System.out.println("-------------------------------------------------------------------------");
        square.draw();
        System.out.println("Making clone of original object(deep copy)");
        Square deepCopySquare = square.clone();
        System.out.println("Drawing clone object");
        System.out.println("-------------------------------------------------------------------------");
        deepCopySquare.draw();
        System.out.println("Modifying clone object");deepCopySquare.setX(10);
        deepCopySquare.getStyle().setLineColor(Color.GREEN);
        deepCopySquare.getFillStyle().setFillPattern(FillPattern.HOLLOW);
        System.out.println("Drawing clone object");
        System.out.println("-------------------------------------------------------------------------");
        deepCopySquare.draw();
        shapeMap.put(square.getID(), square);

        Rectangle rectangle = new Rectangle();
        rectangle.setID("3");
        shapeMap.put(rectangle.getID(), rectangle);

        Line line = new Line();
        line.setID("4");
        shapeMap.put(line.getID(), line);
    }
}
