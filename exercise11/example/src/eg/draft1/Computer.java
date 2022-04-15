package example.src.eg.draft1;

import java.util.ArrayList;

public class Computer implements ComputerPart{
    // ComputerPart[] part;

    // public Computer(){
    //     part = new ComputerPart[]{
    //         new Monitor(),
    //         new Keyboard(),
    //         new Mouse(),
    //         new BluetoothMouse()
    //     };
    // }

    private ArrayList<ComputerPart> parts;

    public Computer(){
        this.parts = new ArrayList<>();
    }

    @Override public void accept(ComputerVisitor computerVisitor){
        computerVisitor.visit(this);
    }
    
}
