import java.util.ArrayList;

abstract class ComputerPart{
    public String index = "";
    void display(){};
    void accept(ComputerVisitor computerVisitor){};
}
class Computer extends ComputerPart{
    ArrayList<ComputerPart> parts = new ArrayList<>();

    public void addPart(ComputerPart part){
        parts.add(part);
    }
    
    @Override public void accept(ComputerVisitor computerVisitor){
        computerVisitor.visit(this);
    }

    @Override public void display(){
        for(ComputerPart part : parts){
            part.display();
        }
    }
}
class Monitor extends ComputerPart{
    @Override public void accept(ComputerVisitor computerVisitor){
        computerVisitor.visit(this);
    }

    @Override public void display(){
        System.out.println("Monitor");
    }
}
class Keyboard extends ComputerPart{
    @Override public void accept(ComputerVisitor computerVisitor){
        computerVisitor.visit(this);
    }

    @Override public void display(){
        System.out.println("Keyboard");
    }
}
class Mouse extends ComputerPart{
    @Override public void accept(ComputerVisitor computerVisitor){
        computerVisitor.visit(this);
    }

    @Override public void display(){
        System.out.println("Mouse");
    }
}
class BluetoothMouse extends ComputerPart{
    @Override public void accept(ComputerVisitor computerVisitor){
        computerVisitor.visit(this);
    }

    @Override public void display(){
        System.out.println("Bluetooth Mouse");
    }
}
interface ComputerVisitor{
    void visit(Computer part);
    void visit(Monitor monitor);
    void visit(Keyboard keyboard);
    void visit(Mouse mouse);
    void visit(BluetoothMouse bluetoothMouse);
}
class ComputerDisplayVisitor implements ComputerVisitor{
    public int lvl = 0;
    public boolean flag = true;
    @Override public void visit(Computer computer){
        if(flag){
            flag = false;
            computer.index = "1.0";
            System.out.println("1.0 "+"Computer");
        } else {
            System.out.println(" Computer");
        }
        lvl++;
        int i = 1;
        for(ComputerPart part : computer.parts){
            for(int j = 0; j < lvl; j++){
                System.out.print("--");
            }
            part.index = String.valueOf(lvl) + "." + String.valueOf(i);
            System.out.print(lvl+"."+i);
            part.accept(this);
            i++;
        }
        lvl--;
    }
    @Override public void visit(Monitor monitor){
        System.out.println(" Monitor");
    }
    @Override public void visit(Keyboard keyboard){
        System.out.println(" Keyboard");
    }
    @Override public void visit(Mouse mouse){
        System.out.println(" Mouse");
    }
    @Override public void visit(BluetoothMouse bluetoothMouse){
        System.out.println(" Bluetooth Mouse");
    }
}
class MouseReplaceVisitor implements ComputerVisitor{
    static boolean isMouse = false;
    @Override public void visit(Computer computer){
        int i = 0;
        for(ComputerPart part : computer.parts){
            part.accept(this);
            if(isMouse){
                BluetoothMouse bluetoothMouse = new BluetoothMouse();
                bluetoothMouse.index = part.index;
                computer.parts.set(i, bluetoothMouse);
                isMouse = false;
            }
            i++;
        }
    }
    @Override public void visit(Monitor monitor){
    }
    @Override public void visit(Keyboard keyboard){
    }
    @Override public void visit(Mouse mouse){
        isMouse = true;
    }
    @Override public void visit(BluetoothMouse bluetoothMouse){
    }
}
public class Client {
    public static void main(String[] args) {
        Computer computer1 = new Computer();
        Computer computer2 = new Computer();
        Computer computer3 = new Computer();

        computer2.addPart(new Keyboard());
        computer2.addPart(new Keyboard());

        computer1.addPart(computer2);

        computer3.addPart(new Keyboard());

        computer1.addPart(new Monitor());
        computer1.addPart(new Mouse());

        computer2.addPart(new Mouse());
        
        computer1.addPart(computer3);
        computer1.accept(new ComputerDisplayVisitor());
        computer1.accept(new MouseReplaceVisitor());
        System.out.println();
        computer1.accept(new ComputerDisplayVisitor());
    }
}