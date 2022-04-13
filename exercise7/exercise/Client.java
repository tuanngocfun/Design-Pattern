package exercise;
public class Client {
    public static void main(String[] args) {
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");

        Player p3 = new Player("p3");
        Player p4 = new Player("p4");
        
        Player p5 = new Player("p5");
        Player p6 = new Player("p6");
        
        Player p7 = new Player("p7");
        Player p8 = new Player("p8");
        
        Match mll1 = new Match(2,4,p1,p2);
        Match mlr1 = new Match(1, 3, p3, p4);
        Match mlt = new Match(0, 1, p2, p4);
        Match mt = new Match(3, 2, p4, p6);
        Match mrl1 = new Match(0, 5, p5, p6);
        Match mrr1 = new Match(6, 2, p7, p8);
        Match mrt = new Match(2, 0, p6, p7);

        System.out.println(mll1);
        System.out.println(mlr1);
        System.out.println(mlt);
        System.out.println(mrl1);
        System.out.println(mrr1);
        System.out.println(mt);
        System.out.println("endline\n");

        Branch branchMatch1 = new Branch(mll1,mlr1);
        // // branchMatch1.add(mll1,mlr1);
        // branchMatch1.setLeftMatchResult(mll1);
        // branchMatch1.setLeftMatchResult(mlr1);
        branchMatch1.add(mll1);
        branchMatch1.add(mlr1);
        branchMatch1.showResult(branchMatch1);
        System.out.println("endline\n");

        Branch branchMatch2 = new Branch();
        branchMatch2.add(mrl1,mrr1);

        Branch branchMatch3 = new Branch();
        branchMatch3.add(mlt,branchMatch1);

        Branch branchMatch4 = new Branch();
        branchMatch4.add(mrt,branchMatch2);

        Branch branchMatch5 = new Branch();
        branchMatch5.add(branchMatch3,branchMatch4,mt);

        branchMatch5.showResult(branchMatch5);
        System.out.println("endline\n");

        Branch branchMatch6 = new Branch(mlt,mrt,mt);
        branchMatch6.showResult(branchMatch6);
    }
}
