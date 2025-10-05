package online_store;

import java.util.ArrayList;
import java.util.List;

public class OnlineStore {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public void buyProduct(int code, int quantity) {
        for (Product p : products) {
            if (p.getCode() == code) {
                if (p.getCount() >= quantity) {
                    p.setCount(p.getCount() - quantity);
                    System.out.println("Куплено " + quantity + " шт. " + p.getName());
                } else {
                    System.out.println("Недостаточно товара!");
                }
                return;
            }
        }
        System.out.println("Товар не найден!");
    }

    public void getProducts() {
        for (Product p : products) {
            System.out.println(p.getProductInfo());
        }
    }
}
