import java.time.LocalDate;

public class Food extends Goods {
    private LocalDate manufactureDate;
    private LocalDate expirationDate;
    private String supplier;

    public Food(String productCode, String name, int quantity, double unitPrice,
                LocalDate manufactureDate, LocalDate expirationDate, String supplier) {
        super(productCode, name, quantity, unitPrice);
        setManufactureDate(manufactureDate);
        setExpirationDate(expirationDate);
        setSupplier(supplier);
        if (!expirationDate.isAfter(manufactureDate) && !expirationDate.isEqual(manufactureDate)) {
            throw new IllegalArgumentException("Expiration date must be after manufacture date");
        }
    }

    @Override
    public double getVatRate() {
        return 0.05;
    }

    @Override
    public String getTypeName() {
        return "Food";
    }

    @Override
    public String evaluateConsumption() {
        LocalDate today = LocalDate.now();
        if (quantity > 0 && expirationDate.isBefore(today)) {
            return "Difficult to sell (expired)";
        }
        return "Not evaluated";
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        if (manufactureDate == null) {
            throw new IllegalArgumentException("Manufacture date cannot be empty");
        }
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        if (expirationDate == null) {
            throw new IllegalArgumentException("Expiration date cannot be empty");
        }
        this.expirationDate = expirationDate;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        if (supplier == null || supplier.trim().isEmpty()) {
            throw new IllegalArgumentException("Supplier cannot be empty");
        }
        this.supplier = supplier.trim();
    }
}
