package decoratorDesignPatternOS;

public class VerticalScrollDownBarWindow extends BaseWindow {

    public VerticalScrollDownBarWindow(Window toBeWindow) {
        super(toBeWindow);
        //TODO Auto-generated constructor stub
    }

    @Override public void draw(){
        System.out.println("Vertical scroll down bar is going to be added to the base function: ");
        super.draw();
    }
    @Override public String work(){
        return "\nVertical bar functionality(scrolling down) is updated with: "+super.work();
    }
}
