import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VehicleManager {
    private final List<Vehicle> vehicles = new ArrayList<>();

    public boolean addVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            return false;
        }
        for (Vehicle existing : vehicles) {
            if (existing.getVehicleNumber().equalsIgnoreCase(vehicle.getVehicleNumber())) {
                return false;
            }
        }
        vehicles.add(vehicle);
        return true;
    }

    public Vehicle findByVehicleNumber(String vehicleNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleNumber().equalsIgnoreCase(vehicleNumber)) {
                return vehicle;
            }
        }
        return null;
    }

    public List<Vehicle> findByOwnerId(String idNumber) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getOwner().getIdNumber().equals(idNumber)) {
                result.add(vehicle);
            }
        }
        return result;
    }

    public void deleteByManufacturer(String manufacturer) {
        vehicles.removeIf(vehicle -> vehicle.getManufacturer().equalsIgnoreCase(manufacturer));
    }

    public String getManufacturerWithMostVehicles() {
        if (vehicles.isEmpty()) {
            return "No vehicles";
        }
        String bestManufacturer = null;
        int maxCount = -1;
        for (String manufacturer : new String[]{"Honda", "Yamaha", "Toyota", "Suzuki"}) {
            int count = 0;
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getManufacturer().equalsIgnoreCase(manufacturer)) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                bestManufacturer = manufacturer;
            }
        }
        return bestManufacturer;
    }

    public void sortByVehicleNumberDesc() {
        Collections.sort(vehicles, Comparator.comparing(Vehicle::getVehicleNumber).reversed());
    }

    public void printStatistics() {
        int carCount = 0;
        int motorbikeCount = 0;
        int truckCount = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {
                carCount++;
            } else if (vehicle instanceof Motorbike) {
                motorbikeCount++;
            } else if (vehicle instanceof Truck) {
                truckCount++;
            }
        }
        System.out.println("Car count: " + carCount);
        System.out.println("Motorbike count: " + motorbikeCount);
        System.out.println("Truck count: " + truckCount);
    }

    public void printAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicle data");
            return;
        }
        for (Vehicle vehicle : vehicles) {
            System.out.println("Type: " + vehicle.getVehicleType() +
                    " | Number: " + vehicle.getVehicleNumber() +
                    " | Manufacturer: " + vehicle.getManufacturer() +
                    " | Year: " + vehicle.getManufactureYear() +
                    " | Color: " + vehicle.getColor() +
                    " | Owner: " + vehicle.getOwner().getFullName() +
                    " | ID: " + vehicle.getOwner().getIdNumber());
        }
    }

    public static void main(String[] args) {
        VehicleManager manager = new VehicleManager();

        try {
            manager.addVehicle(new Car("A1234", "Honda", 2020, "Red", new Owner("123456789012", "Nguyen Van A", "a@gmail.com"), 4, "Gasoline"));
            manager.addVehicle(new Motorbike("B5678", "Yamaha", 2021, "Blue", new Owner("210987654321", "Tran Thi B", "b@gmail.com"), 150));
            manager.addVehicle(new Truck("C9012", "Toyota", 2019, "White", new Owner("321654987012", "Le Van C", "c@gmail.com"), 3.5));
            manager.addVehicle(new Car("D3456", "Honda", 2022, "Black", new Owner("456123789012", "Pham Thi D", "d@gmail.com"), 5, "Diesel"));
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        }

        System.out.println("=== All vehicles ===");
        manager.printAllVehicles();

        System.out.println("\n=== Search by vehicle number ===");
        Vehicle found = manager.findByVehicleNumber("B5678");
        if (found != null) {
            System.out.println(found.getVehicleType() + " - " + found.getOwner().getFullName());
        }

        System.out.println("\n=== Search by owner ID ===");
        List<Vehicle> ownerVehicles = manager.findByOwnerId("123456789012");
        for (Vehicle v : ownerVehicles) {
            System.out.println(v.getVehicleType() + " - " + v.getVehicleNumber());
        }

        System.out.println("\n=== Delete by manufacturer ===");
        manager.deleteByManufacturer("Honda");
        manager.printAllVehicles();

        System.out.println("\n=== Manufacturer with most vehicles ===");
        System.out.println(manager.getManufacturerWithMostVehicles());

        System.out.println("\n=== Sort by vehicle number desc ===");
        manager.sortByVehicleNumberDesc();
        manager.printAllVehicles();

        System.out.println("\n=== Statistics ===");
        manager.printStatistics();
    }
}
