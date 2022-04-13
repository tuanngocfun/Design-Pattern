package sol2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Branch implements Tournament{
    protected List<Tournament> matches = new ArrayList<>();

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
    @Override 
    public void showResult(){
        for(Tournament m : matches){
            m.showResult();
        }
    }
    @Override
    public String winnerOfEachGame(Player p1, Player p2) {
        throw new UnsupportedOperationException();
    }
    @Override
    public void showRank(Player p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }
    @Override
    public void showWinner() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }
    @Override
    public int getPointPl1() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }
    @Override
    public int getPointPl2() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }
    @Override
    public void showResult(Branch branch) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }
    @Override
    public void checkWinner() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }
}
