package decoratorDesignPatternOS;

public abstract class BaseWindow implements Window {
    private final Window toBeInWindow;

    public BaseWindow(Window toBeWindow){
        this.toBeInWindow=toBeWindow;
    }
    @Override public void draw(){
        toBeInWindow.draw();
    }
    @Override public String work(){
        return toBeInWindow.work();
    }
}
