public class Car extends Vehicle {
    private int numberOfSeats;
    private String engineType;

    public Car(String vehicleNumber, String manufacturer, int manufactureYear, String color, Owner owner,
               int numberOfSeats, String engineType) {
        super(vehicleNumber, manufacturer, manufactureYear, color, owner);
        setNumberOfSeats(numberOfSeats);
        setEngineType(engineType);
    }

    @Override
    public String getVehicleType() {
        return "Car";
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        if (numberOfSeats <= 0) {
            throw new IllegalArgumentException("Number of seats must be greater than 0");
        }
        this.numberOfSeats = numberOfSeats;
    }

    public void setEngineType(String engineType) {
        if (engineType == null || engineType.trim().isEmpty()) {
            throw new IllegalArgumentException("Engine type cannot be empty");
        }
        this.engineType = engineType.trim();
    }
}
