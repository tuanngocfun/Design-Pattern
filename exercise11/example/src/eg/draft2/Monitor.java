package example.src.eg.draft2;

public class Monitor extends ComputerPart{
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
        return "Monitor id:"+getID();
    }
}
