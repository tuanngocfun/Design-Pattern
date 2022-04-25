package eg.draft2;

public class Mouse extends ComputerPart{
    public Mouse(){
        super();
    }
    public Mouse(String id){
        super(id);
    }

    @Override public void accept(ComputerVisitor visitor){
        visitor.visit(this);
    }

    @Override public String toString(){
        return "Mouse id:"+getID();
    }
}
