package firstwayBuilderDesignPattern;

public class Demo {
    public static void main(String[] args) {
        Director director = new Director();
        
        CarBuilder builder = new CarBuilder();
        director.constructSportCar(builder);

        Car car = builder.getResult();
        System.out.println("Car built:\n"+car.getCarType());

        CarManualBuilder manualBuilder = new CarManualBuilder();

        director.constructSportCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println(("\nCar manual built:\n"+carManual.print()));
    }
}
interface Builder {
    void setCarType(CarType type);
    void setSeats(int number);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripcomputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
    // Car getResult();
}
class CarBuilder implements Builder {
    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    @Override public void setCarType(CarType type) {
        this.type = type;
    }
    @Override public void setSeats(int seats) {
        this.seats = seats;
    }
    @Override public void setEngine(Engine engine) {
        this.engine = engine;
    }
    @Override public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
    @Override public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }
    @Override public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }
    public Car getResult() {
        return new Car(type,seats,engine,transmission,tripComputer,gpsNavigator);
    }
}
class Car {
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
class Engine {
    private final double volume;
    private double mileage;
    private boolean started;

    public Engine(double volume, double mileage) {
        this.volume = volume;
        this.mileage = mileage;
    }
    public void on() {
        started = true;
    }
    public void off() {
        started = false;
    }
    public boolean isStarted() {
        return started;
    }
    public void go(double mileage) {
        if(started) {
            this.mileage += mileage;
        } else {
            System.err.println("Cannot go(), you must start engine first!");
        }
    }
    public double getVolume() {
        return volume;
    }
    public double getMileage() {
        return mileage;
    }
}
class TripComputer {
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }
    public void showFuelLevel() {
        System.out.println("Fuel level: " + car.getFuel());
    }
    public void showStatus() {
        if(this.car.getEngine().isStarted()) {
            System.out.println("Car is started");
        } else {
            System.out.println("Car isn't started");
        }
    }
}
class GPSNavigator {
    private String route;

    public GPSNavigator() {
        this.route = "221b, Baker Street, London to Scotland Yard, 8-10 Broadway, London";
    }
    public GPSNavigator(String manualRoute) {
        this.route = manualRoute;
    }
    public String getRoute() {
        return route;
    }
}
enum Transmission {
    SINGLE_SPEED, MANUAL, AUTOMATIC, SEMI_AUTOMATIC
}
enum CarType {
    CITY_CAR, SPORT_CAR, SUV
}
class CarManualBuilder implements Builder {
    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    @Override public void setCarType(CarType type) {
        this.type = type;
    }
    @Override public void setSeats(int seats) {
        this.seats = seats;
    }
    @Override public void setEngine(Engine engine) {
        this.engine = engine;
    }
    @Override public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
    @Override public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }
    @Override public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }
    public Manual getResult() {
        return new Manual(type,seats,engine,transmission,tripComputer,gpsNavigator);
    }
}
class Manual {
    private final CarType carType;
    private final int seats;
    private final Engine engine;
    private final Transmission transmission;
    private final TripComputer tripComputer;
    private final GPSNavigator gpsNavigator;

    public Manual(CarType type, int seats, Engine engine, Transmission transmission, TripComputer tripComputer,
            GPSNavigator gpsNavigator) {
                this.carType = type;
                this.seats = seats;
                this.engine = engine;
                this.transmission = transmission;
                this.tripComputer = tripComputer;
                this.gpsNavigator = gpsNavigator;
    }
    public String print() {
        String info = "";
        info += "Type of car: " + carType + "\n";
        info += "Count of seats: " + seats + "\n";
        info += "Engine: volume - " + engine.getVolume() + "; mileage - " + engine.getMileage()+"\n";
        info += "Transmission: " + transmission + "\n";
        if(this.tripComputer != null) {
            info += "Trip Computer: Functional" + "\n";
        } else {
            info += "Trip Computer: N/A" + "\n";
        }
        if(this.gpsNavigator != null) {
            info += "GPS Navigator: Functional" + "\n";
        } else {
            info += "GPS Navigator: N/A" + "\n";
        }
        return info;
    }
}
class Director {
    public void constructSportCar(Builder builder) {
        builder.setCarType(CarType.SPORT_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(3.0, 0));
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }
    public void constructCityCar(Builder builder) {
        builder.setCarType(CarType.CITY_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(1.2, 0));
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }
    public void constructSUV(Builder builder) {
        builder.setCarType(CarType.SUV);
        builder.setSeats(4);
        builder.setEngine(new Engine(2.5, 0));
        builder.setTransmission(Transmission.MANUAL);
        builder.setGPSNavigator(new GPSNavigator());
    }
}