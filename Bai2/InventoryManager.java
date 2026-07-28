import java.time.LocalDate;

public class InventoryManager {
    private final Goods[] goodsList = new Goods[100];
    private int size = 0;

    public boolean addGoods(Goods goods) {
        if (goods == null) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (goodsList[i].getProductCode().equalsIgnoreCase(goods.getProductCode())) {
                return false;
            }
        }
        if (size >= goodsList.length) {
            return false;
        }
        goodsList[size] = goods;
        size++;
        return true;
    }

    public int getTotalQuantityByType(String type) {
        int total = 0;
        for (int i = 0; i < size; i++) {
            if (goodsList[i].getTypeName().equalsIgnoreCase(type)) {
                total += goodsList[i].getQuantity();
            }
        }
        return total;
    }

    public double getTotalVatAmountByType(String type) {
        double total = 0;
        for (int i = 0; i < size; i++) {
            if (goodsList[i].getTypeName().equalsIgnoreCase(type)) {
                total += goodsList[i].calculateVatAmount();
            }
        }
        return total;
    }

    public void printInventorySummary() {
        System.out.println("=== INVENTORY SUMMARY ===");
        System.out.println("Food: " + getTotalQuantityByType("Food") + " items, VAT=" + getTotalVatAmountByType("Food"));
        System.out.println("Electronics: " + getTotalQuantityByType("Electronics") + " items, VAT=" + getTotalVatAmountByType("Electronics"));
        System.out.println("Crockery: " + getTotalQuantityByType("Crockery") + " items, VAT=" + getTotalVatAmountByType("Crockery"));
    }

    public void printAllGoods() {
        if (size == 0) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("=== GOODS LIST ===");
        for (int i = 0; i < size; i++) {
            Goods goods = goodsList[i];
            System.out.println("- Code: " + goods.getProductCode() + " | Name: " + goods.getName() +
                    " | Type: " + goods.getTypeName() + " | Qty: " + goods.getQuantity() +
                    " | Price: " + goods.getUnitPrice() + " | VAT: " + goods.calculateVatAmount() +
                    " | Assessment: " + goods.evaluateConsumption());
        }
    }

    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        try {
            manager.addGoods(new Food("F001", "Milk", 2, 12000, LocalDate.of(2025, 1, 1), LocalDate.of(2026, 1, 1), "Vinamilk"));
            manager.addGoods(new Electronics("E001", "Fridge", 2, 5000000, 12, 2.5));
            manager.addGoods(new Crockery("C001", "Water bottle", 60, 150000, "Hoa Phat", LocalDate.of(2025, 1, 15)));
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        }

        manager.printInventorySummary();
        manager.printAllGoods();
    }
}
