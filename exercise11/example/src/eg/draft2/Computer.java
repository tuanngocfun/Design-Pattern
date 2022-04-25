package eg.draft2;

import java.util.ArrayList;
import java.util.List;

public class Computer extends ComputerPart{
    private List<ComputerPart> parts = new ArrayList<>();

    public Computer(){
        super();
    }

    public Computer(String id){
        super(id);
    }

    public void add(ComputerPart part){
        parts.add(part);
    }

    public void remove(ComputerPart part){
        parts.remove(part);
    }

    public List<ComputerPart> getPart(){
        return parts;
    }

    @Override public void accept(ComputerVisitor visitor){
        visitor.visit(this);
    }

    @Override public String toString(){
        return "Computer id:"+this.getID();
    }
}
