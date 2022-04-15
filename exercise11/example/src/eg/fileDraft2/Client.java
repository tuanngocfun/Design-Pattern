package example.src.eg.fileDraft2;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Computer computer0 = new Computer();
        Mouse mouse1 = new Mouse();
        Keyboard keyboard1 = new Keyboard();
        Computer computer1 = new Computer();
        Computer computer2 = new Computer();
        Mouse mouse2 = new Mouse();
        Keyboard keyboard2 = new Keyboard();
        Monitor monitor3 = new Monitor();
        
        computer0.add(mouse1);
        computer0.add(keyboard1);
        computer0.add(computer1);
        
        computer1.add(computer2);
        computer1.add(mouse2);
        computer1.add(keyboard2);
        
        computer2.add(monitor3);
        
        computer0.accept(new DisplayVisitor());
    }
}

abstract class ComputerPart {
    private String ID;

    public ComputerPart() {
        ID = "";
    }
    
    public ComputerPart(String ID) {
        this.ID = ID;
    }
    
    public void setID(String ID) {
        this.ID = ID;
    }
    
    public String getID() {
        return ID;
    }
    
    public abstract void accept(Visitor visitor);
}

class Computer extends ComputerPart {
    private final List<ComputerPart> parts = new ArrayList<>();
    
    public Computer() {
        super();
    }

    public Computer(String ID) {
        super(ID);
    }
    
    public void add(ComputerPart part) {
        parts.add(part);
    }
    
    public void remove(ComputerPart part) {
        parts.remove(part);
    }
    
    public List<ComputerPart> getParts() {
        return parts;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
    @Override
    public String toString() {
        return "Computer: " + getID();
    }
}

class Mouse extends ComputerPart {
    public Mouse() {
        super();
    }

    public Mouse(String ID) {
        super(ID);
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
    @Override
    public String toString() {
        return "Mouse: " + getID();
    }
}

class Keyboard extends ComputerPart {
    public Keyboard() {
        super();
    }

    public Keyboard(String ID) {
        super(ID);
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
    @Override
    public String toString() {
        return "Keyboard: " + getID();
    }
}

class Monitor extends ComputerPart {
    public Monitor() {
        super();
    }

    public Monitor(String ID) {
        super(ID);
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
    @Override
    public String toString() {
        return "Monitor: " + getID();
    }
}

interface Visitor {
    public void visit(ComputerPart obj);
}

class DisplayVisitor implements Visitor {
    private void visitImpl(ComputerPart obj, int height, int position) {
        if(obj == null)
            return;
        
        for(int i = 0; i < height; i++)
            System.out.print("--");
        
        // The number before the dot in the ID is equal to the current height (or 1 if height is 0)
        // The number after the dot in the ID is equal to position where position is the ordinal of a part at its current height
        
        String index = Integer.toString((height != 0) ? height : 1) + "." + position;
        obj.setID(index);
        
        System.out.println(obj);
        
        if(obj instanceof Computer) {
            Computer computer = (Computer) obj;
            int nextPosition = 1;
            for(ComputerPart part : computer.getParts()) {
                visitImpl(part, height + 1, nextPosition);
                nextPosition++;
            }
        }
    }

    @Override
    public void visit(ComputerPart obj) {
        visitImpl(obj, 0, 0);
    }
}

