package expandedfromSecondway;

public abstract class Beverage implements Item {
    public abstract double price();

    @Override public Packing packing() {
        return new Bottle();
    }
}
