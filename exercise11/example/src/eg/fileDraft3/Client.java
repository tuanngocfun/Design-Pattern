package eg.fileDraft3;

import java.util.ArrayList;
import java.util.List;

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

class BluetoothKeyboard extends Keyboard {
    public BluetoothKeyboard() {
        super();
    }
    
    public BluetoothKeyboard(String ID) {
        super(ID);
    }
    
    @Override
    public String toString() {
        return "Bluetooth Keyboard: " + getID();
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
    private void visitImpl(ComputerPart currentObj, int height, int position) {
        // If there is no current object
        if(currentObj == null) {
            // Simply return
            return;
        }
        
        // For every height, print out two '-'
        for(int i = 0; i < height; i++)
            System.out.print("--");

        // The index includes a dot, a number before the dot and a number after the dot
        // The number before the dot in the ID is equal to the current height (or 1 if height is 0)
        // The number after the dot in the ID is equal to position where position is the ordinal of a part at its current height
        String index = Integer.toString((height != 0) ? height : 1) + "." + position;
        currentObj.setID(index);

        // Print out the current object
        System.out.println(currentObj);

        // If the current object is a computer, we continue to traverse over its parts
        if(currentObj.getClass().equals(Computer.class)) {
            Computer computer = (Computer) currentObj;
            // The position start from 1
            int nextPosition = 1;
            // For every part of the computer
            for(ComputerPart part : computer.getParts()) {
                // Apply the same semantic with it
                visitImpl(part, height + 1, nextPosition);
                // Increment the position
                nextPosition++;
            }
        }
    }

    @Override
    public void visit(ComputerPart obj) {
        visitImpl(obj, 0, 0);
    }
}

class KeyboardReplaceVisitor implements Visitor {
    private void visitImpl(ComputerPart currentObj, Computer parent) {
        // If there is no current object
        if(currentObj == null) {
            // DO NOTHING
        }
        // If current object is a keyboard object
        else if(currentObj.getClass().equals(Keyboard.class)) {
            // create a new bluetooth keyboard to replace with the current one
            BluetoothKeyboard newKeyboard = new BluetoothKeyboard(currentObj.getID());
            
            // If there is a parent, replace the plain old keyboard in the list of parent's parts 
            // with a new bluetooth keyboard instance that has just been created
            if(parent != null) {
                List<ComputerPart> parts = parent.getParts();
                int index = parts.indexOf(currentObj);
                parts.set(index, newKeyboard);
            }
            
            // Recall the method with the new 'currentObj' as 'newKeyboard', other parameters stay the same
            visitImpl(newKeyboard, parent);
        }
        // If current object is a computer object
        else if(currentObj.getClass().equals(Computer.class)) {
            Computer computer = (Computer) currentObj;
            // For every part of the computer
            computer.getParts().forEach(part -> {
                // Apply the same semantic with it
                visitImpl(part, computer);
            });
        }
    }
    
    @Override
    public void visit(ComputerPart obj) {
        visitImpl(obj, null);
    }
}

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
        
        System.out.println();
        System.out.println("Change all keyboards in the tree to bluetooth keyboards...");
        computer0.accept(new KeyboardReplaceVisitor());
        System.out.println();
        
        computer0.accept(new DisplayVisitor());
    }
}