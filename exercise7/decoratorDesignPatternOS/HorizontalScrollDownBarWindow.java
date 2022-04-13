package decoratorDesignPatternOS;

public class HorizontalScrollDownBarWindow extends BaseWindow {
    
    public HorizontalScrollDownBarWindow(Window toBeWindow){
        super(toBeWindow);
        System.out.println("Contructor of HorizontalScollDownBarWindow() is constructed...");
    }

    @Override public void draw(){
        System.out.println("Drawing horizontal scroll down bar window also retain the old function: ");
        super.draw();
    }
    @Override public String work(){
        return "\nThe function HorizontalScrollDownBarWindow::work() is called and "+super.work();
    }
}
