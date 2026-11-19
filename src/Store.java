import Utility.FileIO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class Store {
    private String name;
    private HashMap<String, Product> allProducts = new HashMap<>();
    private HashMap<String, Product> discountedProducts = new HashMap<>();
    private ArrayList<Product> allProductTest = new ArrayList<>();

    private FileIO io = new FileIO();

    public Store(String name) {
        this.name = name;
    }

    public void setAllProducts(String path) {
        for(String data : io.readData(path)) {
            String[] values = data.split(";");

            String id = values[0];
            String name = values[1];
            String priceDate = values[2];
            double price = Double.parseDouble(values[3]);
            boolean isBudgetBrand = Boolean.parseBoolean(values[4]);
            double quantity = Double.parseDouble(values[5]);

            String unit = values[6];
            boolean isWeighted = Boolean.parseBoolean(values[7]);
            boolean isBio = Boolean.parseBoolean(values[8]);
            boolean isAvailable = Boolean.parseBoolean(values[9]);

            Product prod = new Product(id, name, priceDate, price, isBudgetBrand, quantity, unit, isWeighted, isBio, isAvailable);

            allProducts.put(id, prod);
            allProductTest.add(prod);
        }
    }

    public void setDiscountedProducts(String path) {
        for(String data : io.readData(path)) {
            String[] values = data.split(";");

            String id = values[0];
            String name = values[1];
            String priceDate = values[2];
            double price = Double.parseDouble(values[3]);
            boolean isBudgetBrand = Boolean.parseBoolean(values[4]);
            double quantity = Double.parseDouble(values[5]);
            String unit = values[6];
            boolean isWeighted = Boolean.parseBoolean(values[7]);
            boolean isBio = Boolean.parseBoolean(values[8]);
            boolean isAvailable = Boolean.parseBoolean(values[9]);

            Product prod = new Product(id, name, priceDate, price, isBudgetBrand, quantity, unit, isWeighted, isBio, isAvailable);

            discountedProducts.put(id, prod);
        }
    }

    public HashMap<String, Product> getAllProducts() {
        return allProducts;
    }

    public HashMap<String, Product> getDiscountedProducts() {
        return discountedProducts;
    }

    public ArrayList<Product> getAllProductTest() {
        return allProductTest;
    }

    public void checkout(Collection<Product> cart) {
        double total = 0;

        HashMap<String, Integer> addedItems = new HashMap<>();
        for(Product prod : cart) {
            addedItems.merge(prod.getId(), 1, Integer::sum);

            if(discountedProducts.containsKey(prod.getId())) {
                total += discountedProducts.get(prod.getId()).getPrice();
            } else {
                total += allProducts.get(prod.getId()).getPrice();
            }
        }

        StringBuilder receipt = new StringBuilder("==| Receipt |==");

        addedItems.forEach( (key, value) -> {
            Product prod = allProducts.get(key);

            String receiptItem = "";
            receiptItem += "\n" + value + "x " + prod.getName() + ": " + (prod.getPrice() * value) + "kr.";

            if(discountedProducts.containsKey(prod.getId())) {
                receiptItem += "\n  Discount: " + ((prod.getPrice() - discountedProducts.get(prod.getId()).getPrice()) * value) + "kr.";
            }

            receiptItem += "\n";

            receipt.append(receiptItem);
        });

        System.out.println(receipt);
    }
}
