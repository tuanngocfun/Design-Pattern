package expandedFromFirstway;
public class Car {
    private final CarType carType;
    private final int seats;
    private final Engine engine;
    private final Transmission transmission;
    private final TripComputer tripComputer;
    private final GPSNavigator gpsNavigator;
    private double fuel = 0;

    public Car(CarType type, int seats, Engine engine, Transmission transmission, TripComputer tripComputer,
            GPSNavigator gpsNavigator) {
        this.carType = type;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.tripComputer = tripComputer;
        if(this.tripComputer != null) {
            this.tripComputer.setCar(this);
        }
        this.gpsNavigator = gpsNavigator;
    }
    public CarType getCarType() {
        return carType;
    }
    public double getFuel() {
        return fuel;
    }
    public int getSeats() {
        return seats;
    }
    public Engine getEngine() {
        return engine;
    }
    public Transmission getTransmission() {
        return transmission;
    }
    public TripComputer getTripComputer() {
        return tripComputer;
    }
    public GPSNavigator getGpsNavigator() {
        return gpsNavigator;
    }
}
