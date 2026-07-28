public abstract class Vehicle {
    protected String vehicleNumber;
    protected String manufacturer;
    protected int manufactureYear;
    protected String color;
    protected Owner owner;

    public Vehicle(String vehicleNumber, String manufacturer, int manufactureYear, String color, Owner owner) {
        setVehicleNumber(vehicleNumber);
        setManufacturer(manufacturer);
        setManufactureYear(manufactureYear);
        setColor(color);
        setOwner(owner);
    }

    public abstract String getVehicleType();

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public String getColor() {
        return color;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setVehicleNumber(String vehicleNumber) {
        if (vehicleNumber == null || vehicleNumber.trim().length() != 5) {
            throw new IllegalArgumentException("Vehicle number must have exactly 5 characters");
        }
        this.vehicleNumber = vehicleNumber.trim();
    }

    public void setManufacturer(String manufacturer) {
        if (manufacturer == null || !isValidManufacturer(manufacturer)) {
            throw new IllegalArgumentException("Manufacturer must be one of: Honda, Yamaha, Toyota, Suzuki");
        }
        this.manufacturer = manufacturer.trim();
    }

    public void setManufactureYear(int manufactureYear) {
        int currentYear = java.time.Year.now().getValue();
        if (manufactureYear > currentYear || manufactureYear <= 2000) {
            throw new IllegalArgumentException("Manufacture year must be > 2000 and <= current year");
        }
        this.manufactureYear = manufactureYear;
    }

    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Color cannot be empty");
        }
        this.color = color.trim();
    }

    public void setOwner(Owner owner) {
        if (owner == null) {
            throw new IllegalArgumentException("Owner cannot be empty");
        }
        this.owner = owner;
    }

    private boolean isValidManufacturer(String manufacturer) {
        String normalized = manufacturer.trim().toLowerCase();
        return normalized.equals("honda") || normalized.equals("yamaha") || normalized.equals("toyota") || normalized.equals("suzuki");
    }
}
