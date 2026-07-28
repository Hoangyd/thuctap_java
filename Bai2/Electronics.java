public class Electronics extends Goods {
    private int warrantyMonths;
    private double capacityKW;

    public Electronics(String productCode, String name, int quantity, double unitPrice,
                       int warrantyMonths, double capacityKW) {
        super(productCode, name, quantity, unitPrice);
        setWarrantyMonths(warrantyMonths);
        setCapacityKW(capacityKW);
    }

    @Override
    public double getVatRate() {
        return 0.10;
    }

    @Override
    public String getTypeName() {
        return "Electronics";
    }

    @Override
    public String evaluateConsumption() {
        if (quantity < 3) {
            return "Easy to sell (stock < 3)";
        }
        return "Not evaluated";
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        if (warrantyMonths < 0) {
            throw new IllegalArgumentException("Warranty months must be >= 0");
        }
        this.warrantyMonths = warrantyMonths;
    }

    public double getCapacityKW() {
        return capacityKW;
    }

    public void setCapacityKW(double capacityKW) {
        if (capacityKW < 0) {
            throw new IllegalArgumentException("Capacity must be >= 0");
        }
        this.capacityKW = capacityKW;
    }
}
