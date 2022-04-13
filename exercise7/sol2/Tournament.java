package sol2;
public interface Tournament {
    int getPointPl1();
    int getPointPl2();
    abstract void showResult(Branch branch);
    void showResult();
    String winnerOfEachGame(Player p1, Player p2);
    void showRank(Player p);
    void showWinner();
    void checkWinner();
}
