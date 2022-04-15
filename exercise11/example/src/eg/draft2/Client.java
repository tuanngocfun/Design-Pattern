package example.src.eg.draft2;

public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();

        Mouse mouse1 = new Mouse();
        Keyboard keyboard1 = new Keyboard();

        Computer computer1 = new Computer();
    
        Computer computer2 = new Computer();
        
        Mouse mouse2 = new Mouse();
        Keyboard keyboard2 = new Keyboard();

        Monitor monitor1 = new Monitor();
        
        computer.add(mouse1);
        computer.add(keyboard1);
        computer.add(computer1);

        computer1.add(computer2);
        computer1.add(mouse2);
        computer1.add(keyboard2);

        computer2.add(monitor1);
        computer.accept(new ComputerDisplayVisitor());
    }
}
