package expandedFromFirstway;
public class Client {
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
