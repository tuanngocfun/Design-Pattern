package example.src.eg.draft3;

import java.util.List;

public class Keyboard_replaced_Visitor implements ComputerVisitor {
    @Override public void visit(ComputerPart part){
        visitImpl(part, null);
    }

    private void visitImpl(ComputerPart part, Computer computerRoot) {
        if(part==null){
        }
        else if(part.getClass().equals(Keyboard.class)){
            BluetoothKeyboard bluetoothKeyboard = new BluetoothKeyboard(part.getID());
            if(computerRoot!=null){
                List<ComputerPart> parts = computerRoot.getParts();
                int idx = parts.indexOf(part);
                parts.set(idx, bluetoothKeyboard);
            }
            visitImpl(bluetoothKeyboard, computerRoot);
        }
        else if(part.getClass().equals(Computer.class)){
            Computer computer = (Computer) part;
            computer.getParts().forEach(device -> visitImpl(device, computer));
        }
    }

    // @Override public void visit(ComputerPart part){
    //     if(part instanceof Computer){
    //         Computer computer = (Computer) part;
    //         visitImpl(computer,true);
    //     }
    // }
    // public void visitImpl(Computer computer, boolean belongedTo){
    //     for(int i = 0; i < computer.size(); i++){
    //         computer.get(i).accept(this);
    //         if(belongedTo==true){
    //             BluetoothKeyboard bluetoothKeyboard = new BluetoothKeyboard();
    //             computer.set(i, bluetoothKeyboard);
    //             belongedTo = false;
    //         }
    //     }
    // }
}
