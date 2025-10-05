package online_store;

public class Product {
    private int code;
    private String name;
    private double price;
    private int count;

    public Product(int code, String name, double price, int count) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public int getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getCount() { return count; }

    public void setCount(int count) { this.count = count; }

    public String getProductInfo() {
        return "[" + code + "] " + name + " - " + price + "₽ (в наличии: " + count + ")";
    }
}
