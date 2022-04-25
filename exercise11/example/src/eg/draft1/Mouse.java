package eg.draft1;

public class Mouse implements ComputerPart{
    private double id;
    private String underscore;

    @Override
    public void accept(ComputerVisitor computerVisitor) {
        computerVisitor.visit(this);
    }

    public void setID(double id){
        this.id = id;
    }
    public double getID(){
        return id;
    }
    public void setUnderscore(String underscore){
        this.underscore = underscore;
    }
    public String getUnderscore(){
        return underscore;
    }
}
