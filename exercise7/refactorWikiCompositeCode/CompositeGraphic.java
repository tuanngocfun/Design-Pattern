package refactorWikiCompositeCode;

import java.util.ArrayList;
import java.util.List;

/** "Composite" */
public class CompositeGraphic implements Graphic {
    //Collection of child graphics.
    private final List<Graphic> childGraphics = new ArrayList<>();

    //Adds the graphic to the composition.
    public void add(Graphic graphic) {
        childGraphics.add(graphic);
    }
    
    //Prints the graphic.
    @Override
    public void print() {
        for (Graphic graphic : childGraphics) {
            graphic.print();  //Delegation
        }
    }
}
