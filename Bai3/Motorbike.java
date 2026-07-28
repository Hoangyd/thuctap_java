public class Motorbike extends Vehicle {
    private double capacity;

    public Motorbike(String vehicleNumber, String manufacturer, int manufactureYear, String color, Owner owner, double capacity) {
        super(vehicleNumber, manufacturer, manufactureYear, color, owner);
        setCapacity(capacity);
    }

    @Override
    public String getVehicleType() {
        return "Motorbike";
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.capacity = capacity;
    }
}
