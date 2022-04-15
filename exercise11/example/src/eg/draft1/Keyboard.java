package example.src.eg.draft1;

public class Keyboard implements ComputerPart{
    private double id;
    private int level;
    private String underscore="";
    @Override public void accept(ComputerVisitor computerVisitor) {
        computerVisitor.visit(this);
    }

    public Keyboard(){
        this.id = 1.2;
        this.underscore = "--";
    }

    public Keyboard(double id, String underscore){
        this.id = id;
        this.underscore = underscore;
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
