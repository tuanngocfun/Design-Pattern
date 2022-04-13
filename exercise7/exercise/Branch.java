package exercise;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Branch implements Tournament{
    protected List<Tournament> matches = new ArrayList<>();
    private Match left;
    private Match right;

    public Branch(){

    }
    public Branch(Player pl1, Player pl2, Tournament... components){
        super();
        add(components);
    }
    public Branch(int p1, int p2, Player pl1, Player pl2, Tournament... components){
        super();
        left.setPointPl1(p1);
        right.setPointPl2(p2);
        left.getPlayer1().setName(pl1.getName());
        right.getPlayer2().setName(pl2.getName());
        add(components);
    }
    public Branch(Match left, Match right, Tournament... components){
        super();
        this.left = left;
        this.right = right;
        add(components);
    }
    public Branch(Tournament... components){
        super();
        add(components);
    }

    public String getPlayerName(){
        String name = " ";
        while(left!=null||right!=null){
            if(left.getPlayer1()!=null) name = name+left.getPlayer1().getName();
            if(left.getPlayer2()!=null) name = name+left.getPlayer2().getName();
            if(right.getPlayer1()!=null)name = name+right.getPlayer1().getName();
            if(right.getPlayer2()!=null)name = name+right.getPlayer2().getName();
        }
        return name;
    }
    public void remove(Tournament components){
        matches.remove(components);
    }
    public void remove(Tournament... components){
        matches.removeAll(Arrays.asList(components));
    }
    public void add(Tournament components){
        matches.add(components);
    }
    public void add(Tournament... components){
        matches.addAll(Arrays.asList(components));
    }
    public void add(Match match){
        matches.add(match);
    }
    public void clear(){
        matches.clear();
    }
    public void setLeftLeaf(Match m){
        left.setPointPl1(m.getPointPl1());
    }
    public void setRightLeaf(Match m){
        right.setPointPl2(m.getPointPl2());
    }
    public void setLeftMatchResult(Match m){
        left.setPointPl1(m.getPointPl1());
        left.setPointPl2(m.getPointPl2());
    }
    public void setRightMatchResult(Match m){
        right.setPointPl1(m.getPointPl1());
        right.setPointPl2(m.getPointPl2());
    }
    public void checkWinner(){
        if(left.getPointPl1()>left.getPointPl2()){
            System.out.println(left.getPlayer1().getName());
        } else if(left.getPointPl1()<left.getPointPl2()) {
            System.out.println(left.getPlayer2().getName());
        } else if(right.getPointPl1()>right.getPointPl2()){
            System.out.println(right.getPlayer1().getName());
        } else if(right.getPointPl1()<right.getPointPl2()){
            System.out.println(right.getPlayer2().getName());
        }
    }
    @Override
    public int getPointPl1() {
        return (this==left)?left.getPointPl1():right.getPointPl1();
    }
    @Override
    public int getPointPl2() {
        return (this==left)?left.getPointPl2():right.getPointPl2();
    }
    @Override
    public void showResult(Branch branch) {
        System.out.println(branch);
        if(branch.left!=null) showResult(branch.left);
        if(branch.right!=null) showResult(branch.right);
    }
    @Override 
    public void showResult(){
        for(Tournament m : matches){
            m.showResult();
        }
    }
    @Override
    public String winnerOfEachGame(Player p1, Player p2) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void showRank(Player p) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void showWinner() {
        // TODO Auto-generated method stub
        
    }
    @Override public String toString(){
        StringBuilder builder = new StringBuilder();
        if(matches!=null){
            builder.append("matches=["+matches).append("]; ");

        }
        if(left!=null){
            builder.append(",left=["+left).append("]; ");
        }
        if(right!=null){
            builder.append(",right=["+right).append("]; ");
        }
        return builder.toString();
    }
}
