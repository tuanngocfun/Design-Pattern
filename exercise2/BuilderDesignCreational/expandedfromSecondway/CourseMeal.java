package expandedfromSecondway;

public abstract class CourseMeal implements Item {
    public abstract double price();

    @Override public Packing packing() {
        return new Wrapper();
    }
}