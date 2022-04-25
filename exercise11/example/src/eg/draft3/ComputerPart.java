package eg.draft3;

public abstract class ComputerPart {
    private String id;

    public ComputerPart(){
        id = "";
    }
    public ComputerPart(String id){
        this.id = id;
    }
    
    public String getID(){
        return id;
    }
    public void setID(String id){
        this.id = id;
    }
    public abstract void accept(ComputerVisitor visitor);

    // public void set(int i, ComputerPart part){
    //     this.setID(String.valueOf(i));
    // }
    // public Computer get(int i){
    //     Computer computer = new Computer(String.valueOf(i));
    //     return computer;
    // }
}
