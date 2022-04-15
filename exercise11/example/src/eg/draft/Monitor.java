package example.src.eg.draft;
eg.draft;

public class Monitor extends ComputerPart{
    public void display(){
        System.out.println("Monitor::display()");
    }
    public int countPart(){
        return count++;
    }
}
