public abstract class Goods {
    protected String productCode;
    protected String name;
    protected int quantity;
    protected double unitPrice;

    public Goods(String productCode, String name, int quantity, double unitPrice) {
        setProductCode(productCode);
        setName(name);
        setQuantity(quantity);
        setUnitPrice(unitPrice);
    }

    public abstract double getVatRate();

    public abstract String getTypeName();

    public abstract String evaluateConsumption();

    public double calculateVatAmount() {
        return getInventoryValue() * getVatRate();
    }

    public double getInventoryValue() {
        return quantity * unitPrice;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setProductCode(String productCode) {
        if (productCode == null || productCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Product code cannot be empty");
        }
        this.productCode = productCode.trim();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name.trim();
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be >= 0");
        }
        this.quantity = quantity;
    }

    public void setUnitPrice(double unitPrice) {
        if (unitPrice < 0) {
            throw new IllegalArgumentException("Unit price must be >= 0");
        }
        this.unitPrice = unitPrice;
    }
}
