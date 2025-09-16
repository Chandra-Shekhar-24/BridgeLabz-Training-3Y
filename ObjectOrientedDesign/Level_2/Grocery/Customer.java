import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Product> products = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
