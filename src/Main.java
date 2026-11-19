import java.util.ArrayList;
import java.util.Collection;

public class Main {
    void main() {
        Store store = new Store("Da Store");
        store.setAllProducts("data/varer.csv");
        store.setDiscountedProducts("data/tilbud.csv");

        TestCostumer test = new TestCostumer();
        Collection<Product> testCart = test.fillCart(store.getAllProductTest());

        store.checkout(testCart);

//        System.out.println(store.getAllProducts().get("5708921003050").getName());
    }
}