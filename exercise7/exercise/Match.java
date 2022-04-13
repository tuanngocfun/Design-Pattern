package exercise;
public class Match extends Branch{
    private int point1;
    private int point2;
    private Player player1;
    private Player player2;

    public Match(int p1, int p2, Player pl1, Player pl2){
        super();
        this.point1=p1;
        this.point2=p2;
        this.player1=pl1;
        this.player2=pl2;
    }

    public Player getPlayer1(){
        return player1;
    }
    public Player getPlayer2(){
        return player2;
    }
    public void setPointPl1(int p1){
        this.point1=p1;
    }
    public void setPointPl2(int p2){
        this.point2=p2;
    }
    @Override public int getPointPl1(){
        return point1;
    }
    @Override public int getPointPl2(){
        return point2;
    }
    @Override public void checkWinner(){
        if(point1>point1){
            System.out.println(player1.getName());
        } else {
            System.out.println(player2.getName());
        }
    }
    @Override public String winnerOfEachGame(Player p1, Player p2){
        return (point1>point2)?p1.getName():p2.getName();
    }
    @Override public void showRank(Player p){
        throw new UnsupportedOperationException();
    }
    @Override public void showWinner(){
        throw new UnsupportedOperationException();
    }
    @Override public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(player1.getName()).append("= "+point1+", ").append(player2.getName()).append("= "+point2);
        return builder.toString();
    }
    @Override public void showResult(){
        System.out.println(player1.getName()+"= "+point1+" "+player2.getName()+"= "+point2);
    }

    // @Override
    // public void showResult(Branch branch) {
    //     // TODO Auto-generated method stub
        
    // }
}
