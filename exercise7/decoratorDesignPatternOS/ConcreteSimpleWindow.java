package decoratorDesignPatternOS;

public class ConcreteSimpleWindow implements Window {
    @Override public void draw(){
        System.out.println("ConcreteSimpleWindow::draw() is called...");
    }
    @Override public String work(){
        return "\nConcreteSimpleWindow::work() is being worked";
    }
}
