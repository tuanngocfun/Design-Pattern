package expandedfromSecondway;

public abstract class Ressert implements Item {
    public abstract double price();

    @Override public Packing packing() {
        return new Wrapper();
    }
}
