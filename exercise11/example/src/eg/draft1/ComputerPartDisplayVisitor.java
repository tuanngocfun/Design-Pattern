package example.src.eg.draft1;


public class ComputerPartDisplayVisitor implements ComputerVisitor{
    private double id=0.0;
    private int level = 1;
    private String underscore = "";
    
    @Override
    public void visit(Computer computer) {
        System.out.println("Computer:"+id);
    }

    @Override public void visit(Keyboard keyboard){
        
        System.out.println("Keyboard:"+id);
    }

    @Override public void visit(Mouse mouse) {
        System.out.println("Mouse:"+id);
    }

    @Override public void visit(Monitor monitor){
        System.out.println("Monitor:"+id);
    }

    public String getUnderscore(){
        return underscore;
    }
    public void setUnderscore(String score){
        this.underscore = score;
    }
    public double getID(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }
}
