public class Product {
    private String id;
    private String name;
    private String priceDate;
    private double price;
    private boolean isBudgetBrand;
    private double quantity;
    private String unit;
    private boolean isWeighted;
    private boolean isBio;
    private boolean isAvailable;

    public Product(String id, String name, String priceDate, double price, boolean isBudgetBrand,
                   double quantity, String unit, boolean isWeighted, boolean isBio, boolean isAvailable) {
        this. id = id;
        this.name = name;
        this.priceDate = priceDate;
        this.price = price;
        this.isBudgetBrand = isBudgetBrand;
        this.quantity = quantity;
        this.unit = unit;
        this.isWeighted = isWeighted;
        this.isBio = isBio;
        this.isAvailable = isAvailable;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPriceDate() {
        return priceDate;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBudgetBrand() {
        return isBudgetBrand;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public boolean isWeighted() {
        return isWeighted;
    }

    public boolean isBio() {
        return isBio;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
