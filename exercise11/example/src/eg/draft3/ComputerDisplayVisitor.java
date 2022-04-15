package example.src.eg.draft3;

public class ComputerDisplayVisitor implements ComputerVisitor{
    @Override public void visit(ComputerPart part){
        visitImpl(part, 0, 0);
    }

    private void visitImpl(ComputerPart part, int height, int pos) {
        if(part==null){
            return;
        }

        for(int i = 0; i < height; i++){
            System.out.print("--");
        }

        String idx = Integer.toString(height!=0?height:1)+"."+pos;
        part.setID(idx);

        System.out.println(part);

        if(part.getClass().equals(Computer.class)){
            Computer computer = (Computer) part;
            int nxtpos = 1;
            for(ComputerPart device : computer.getParts()){
                visitImpl(device, height+1, nxtpos);
                nxtpos++;
            }
        }
    }
}
