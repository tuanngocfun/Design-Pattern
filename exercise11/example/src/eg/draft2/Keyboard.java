package eg.draft2;

public class Keyboard extends ComputerPart{

    public Keyboard(){
        super();
    }
    public Keyboard(String id){
        super(id);
    }

    @Override public void accept(ComputerVisitor visitor){
        visitor.visit(this);
    }

    @Override public String toString(){
        return "Keyboard id:"+getID();
    }
}
