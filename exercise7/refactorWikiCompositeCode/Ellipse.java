package refactorWikiCompositeCode;

/** "Leaf" */
public class Ellipse implements Graphic {
    //Prints the graphic.
    @Override
    public void print() {
        System.out.println("Ellipse");
    }
}