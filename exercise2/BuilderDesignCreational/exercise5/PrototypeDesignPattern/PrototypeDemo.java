package exercise5.PrototypeDesignPattern;

public class PrototypeDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        ShapeCache.loadCache();

        // can not change the value from the client unless you change the cache from implementation
        Shape cloneShape = (Shape) ShapeCache.getShape("1");
        ShapeStyle circleStyle = new ShapeStyle();
		circleStyle.setLineColor(Color.BLUE);
		circleStyle.setLinePattern(LinePattern.DOT);
		circleStyle.setLineThickness(1.1d);
        cloneShape.setStyle(circleStyle);
        FillStyle circleFillStyle = new FillStyle();
		circleFillStyle.setFillColor(Color.YELLOW);
		circleFillStyle.setFillPattern(FillPattern.HEART);

        cloneShape.draw();

        /** 
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
		Circle deepCopyCircle = circle.clone();
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
		deepCopyCircle.draw();*/
        /**
        Circle circle = new Circle();
        circle.setID("1");
        circle.setX(10);
        circle.setY(10);
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
        System.out.println("\n\nDrawing original object");
		System.out.println("-------------------------------------------------------------------------");
		circle.draw();
        System.out.println("Drawing clone object");
        System.out.println("-------------------------------------------------------------------------");
        deepCopyCircle.draw(); */
    }
}
