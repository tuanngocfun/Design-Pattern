package expandedfromSecondway;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private List<Item> items = new ArrayList<Item>();
    
    public void addItem(Item item) {
        items.add(item);
    }
    public float OptionWithSalt() {
        float cost = 0.0f;

        for(Item item : items) {
            cost += item.price();
        }
        return cost;
    }
    public float OptionNoSalt() {
        float cost = 0.0f;

        for(Item item : items) {
            cost += item.price()-item.price()*0.1;
        }
        return cost;
    }
    public void showItem() {
        for(Item item : items) {
            System.out.print("Item: "+item.name());
            System.out.print(" ,packing: "+item.packing().pack());
            System.out.println(" ,Price: "+item.price());
        }
    }
}
