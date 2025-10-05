
import simple_classes.*;
import online_store.*;
import bank_system.*;
import street_fighter.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== SIMPLE CLASSES ===");
        // Person
        Person p = new Person("Иван", 25);
        p.introduce();

        // Rectangle
        Rectangle rect = new Rectangle(5, 10);
        System.out.println("Площадь прямоугольника: " + rect.calculateSquare());
        System.out.println("Периметр прямоугольника: " + rect.calculatePerimeter());

        // Car
        Car car = new Car("Germany", "BMW X5", 2020);
        car.printCarInfo();

        // BankAccount
        BankAccount acc = new BankAccount("Петров Петр", 101, 5000);
        acc.deposit(2000);
        acc.withdraw(1000);
        System.out.println("Баланс: " + acc.getBalance());

        // Book
        Book b1 = new Book("12345", "Война и мир", "Толстой", 1869);
        Book b2 = new Book("67890", "Преступление и наказание", "Достоевский", 1866);
        Book.addNewBook(b1);
        Book.addNewBook(b2);
        Book.getBooks();
        b1.reserveBook();
        Book.getBooks();

        System.out.println("\n=== ONLINE STORE ===");
        OnlineStore store = new OnlineStore();
        store.addProduct(new Product(1, "Телефон", 15000, 10));
        store.addProduct(new Product(2, "Ноутбук", 45000, 5));
        store.getProducts();
        store.buyProduct(1, 2);
        store.getProducts();

        System.out.println("\n=== BANK SYSTEM ===");
        BankSystem bank = new BankSystem();
        Account a1 = new Account(101, "Иванов Иван", 10000);
        Account a2 = new Account(102, "Сидоров Сидр", 5000);
        bank.addAccount(a1);
        bank.addAccount(a2);
        bank.showAllAccounts();
        bank.replenishAccount(101, 2000);
        bank.transferMoneyBetweenAccounts(101, 102, 3000);
        bank.showAllAccounts();

        System.out.println("\n=== STREET FIGHTER ===");
        StreetFighter game = new StreetFighter();
        Fighter f1 = new Fighter(1, "Рю", 100, 20);
        Fighter f2 = new Fighter(2, "Кэн", 100, 18);
        game.addFighter(f1);
        game.addFighter(f2);
        game.getFighters();
        game.fight(1, 2);
    }
}
