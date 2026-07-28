import java.time.LocalDate;

public class Crockery extends Goods {
    private String manufacturer;
    private LocalDate arrivalDate;

    public Crockery(String productCode, String name, int quantity, double unitPrice,
                    String manufacturer, LocalDate arrivalDate) {
        super(productCode, name, quantity, unitPrice);
        setManufacturer(manufacturer);
        setArrivalDate(arrivalDate);
    }

    @Override
    public double getVatRate() {
        return 0.10;
    }

    @Override
    public String getTypeName() {
        return "Crockery";
    }

    @Override
    public String evaluateConsumption() {
        LocalDate today = LocalDate.now();
        long daysStored = java.time.temporal.ChronoUnit.DAYS.between(arrivalDate, today);
        if (quantity > 50 && daysStored > 10) {
            return "Slow sale (stock > 50 and stored > 10 days)";
        }
        return "Not evaluated";
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        if (manufacturer == null || manufacturer.trim().isEmpty()) {
            throw new IllegalArgumentException("Manufacturer cannot be empty");
        }
        this.manufacturer = manufacturer.trim();
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        if (arrivalDate == null) {
            throw new IllegalArgumentException("Arrival date cannot be empty");
        }
        this.arrivalDate = arrivalDate;
    }
}
