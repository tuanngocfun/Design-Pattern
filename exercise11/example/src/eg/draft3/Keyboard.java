package example.src.eg.draft3;

public class Keyboard extends ComputerPart {
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
        return "Keyboard: "+getID();
    }
}
