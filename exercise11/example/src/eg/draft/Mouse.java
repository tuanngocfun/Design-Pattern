package eg.draft;

public class Mouse extends ComputerPart {
    public void display(){
        System.out.println("Mouse::display()");
    }
    public int countPart(){
        return count++;
    }
}
