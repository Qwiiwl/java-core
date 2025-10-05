package simple_classes;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String isbn;
    private String name;
    private String author;
    private int year;
    private boolean status; // true = доступна, false = зарезервирована

    private static List<Book> books = new ArrayList<>();

    public Book(String isbn, String name, String author, int year) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.year = year;
        this.status = true;
    }

    public String getBookInfo() {
        return name + " (" + author + ", " + year + ") ISBN: " + isbn +
            (status ? " [Доступна]" : " [Зарезервирована]");
    }

    public static void getBooks() {
        for (Book b : books) {
            System.out.println(b.getBookInfo());
        }
    }

    public static void addNewBook(Book b) {
        books.add(b);
    }

    public void reserveBook() {
        if (status) {
            status = false;
            System.out.println("Книга \"" + name + "\" зарезервирована.");
        } else {
            System.out.println("Книга уже занята!");
        }
    }
}
