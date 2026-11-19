import java.util.*;

public class TestCostumer {

    private int min = 5; // minimum antal (slags) varer i kurven
    private int max = 25; // maximum antal (slags) varer i kurven
    private int sandsynlighedForKun1Vare = 70; // procents sandsynlighed for at der kun er et styk af hver slags vare
    private int maxStyk = 5; // maximalt antal af samme slags vare

    public TestCostumer() {

    }

    public Collection<Product> fillCart(ArrayList<Product> allProducts) {
        // hav en god random klar!
        Random random = new Random();

        // lav en kurv til varerne
        ArrayList<Product> cart = new ArrayList<>();

        // find på et tilfældigt antal varer, mellem 5 og 25
        int productCount = random.nextInt(min, max);
        for (int i = 0; i < productCount; i++) {
            // find et tilfældigt styktal - med % sandsynlighed for at der kun er 1
            int styk = (random.nextInt(100) > sandsynlighedForKun1Vare) ? random.nextInt(2, maxStyk) : 1;

            // find en tilfældig vare i samlingen af alleVarer
            Product prod = allProducts.stream().skip(random.nextInt(allProducts.size())).findFirst().get();
            // og put det antal styk i kurven
            while (styk > 0) {
                cart.add(prod);
                styk--;
            }
        }

        // ryst kurven godt, så ens varer ikke ligger lige ved siden af hinanden
        Collections.shuffle(cart);

        // og returner den fyldte kurv
        return cart;
    }
}
