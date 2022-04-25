package eg.draft2;

public abstract class ComputerPart {
    private String id;

    public ComputerPart(){
        this.id = "";
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
}
