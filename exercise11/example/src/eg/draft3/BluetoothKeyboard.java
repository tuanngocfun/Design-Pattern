package example.src.eg.draft3;

public class BluetoothKeyboard extends Keyboard {
    public BluetoothKeyboard(){
        super();
    }
    public BluetoothKeyboard(String id){
        super(id);
    }

    @Override public String toString(){
        return "Bluetooth Keyboard: "+getID();
    }
}
