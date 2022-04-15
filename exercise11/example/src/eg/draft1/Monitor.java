package example.src.eg.draft1;

public class Monitor implements ComputerPart{
    private double id;
    private String underscore="";

    @Override public  void accept(ComputerVisitor computerVisitor){
        computerVisitor.visit(this);
    }

    public 
    public Monitor(){
        this.id = 3.1;
        this.underscore = "------";
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
