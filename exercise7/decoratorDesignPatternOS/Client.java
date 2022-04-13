package decoratorDesignPatternOS;

public class Client {
    public static void main(String[] args) {
        Window windowObject = new HorizontalScrollDownBarWindow(new VerticalScrollDownBarWindow(new ConcreteSimpleWindow()));
        windowObject.draw();
        System.out.println(windowObject.work());
    }
}
