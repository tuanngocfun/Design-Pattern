package eg.draft3;

import java.util.ArrayList;
import java.util.List;

public class Computer extends ComputerPart {
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
    public List<ComputerPart> getParts(){
        return parts;
    }
    public int size(){
        return parts.size();
    }

    @Override public void accept(ComputerVisitor visitor){
        visitor.visit(this);
    }
    @Override public String toString(){
        return "Computer: "+getID();
    }
}
