package adapter.extractFrom2WayAdapter;

public class RhombusAdapter extends Rhombus implements Shape {
    public RhombusAdapter() {
        super();
    }

    @Override
    public void draw() {
        this.drawShape();
    }   
    @Override
    public void resize() {
        System.out.println("Rhombus can't be resized. Please create new one with required values.");
    }
    @Override
    public String description() {
        return "Rhombus object";
    }
    @Override
    public boolean isHide() {
        return false;
    }
}