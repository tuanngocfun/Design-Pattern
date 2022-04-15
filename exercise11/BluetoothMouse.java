import example.src.eg.draft.ComputerPart;

public class BluetoothMouse extends ComputerPart {
    public void display(){
        System.out.println("BluetoothMouse::display()");
    }
    public int countPart(){
        return count++;
    }
}
