package eg.draft2;

public class ComputerDisplayVisitor implements ComputerVisitor{
    @Override public void visit(ComputerPart part){
        visitImpl(part, 0, 0);
    }

    private void visitImpl(ComputerPart parts, int height, int pos) {
        if(parts==null){
            return;
        }

        for(int i = 0; i < height; ++i){
            System.out.print("--");
        }

        String idx = Integer.toString(height!=0?height:1)+"."+pos;
        parts.setID(idx);

        System.out.println(parts);

        if(parts instanceof Computer){
            Computer computer = (Computer) parts;
            int nextpos = 1;
            for(ComputerPart part : computer.getPart()){
                visitImpl(part, height+1, nextpos);
                nextpos++;
            }
        }
    }
}
