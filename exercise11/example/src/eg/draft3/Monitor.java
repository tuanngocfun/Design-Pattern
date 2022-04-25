package eg.draft3;

public class Monitor extends ComputerPart {
    public Monitor(){
        super();
    }
    public Monitor(String id){
        super(id);
    }

    @Override public void accept(ComputerVisitor visitor){
        visitor.visit(this);
    }
    @Override public String toString(){
        return "Monitor: "+getID();
    }
}
