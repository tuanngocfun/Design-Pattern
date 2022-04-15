package example.src.eg.draft;
eg.draft;

public class Keyboard extends ComputerPart {
    public void display(){
        System.out.println("Keyboard::display()");
    }
    public int countPart(){
        return count++;
    }
}
