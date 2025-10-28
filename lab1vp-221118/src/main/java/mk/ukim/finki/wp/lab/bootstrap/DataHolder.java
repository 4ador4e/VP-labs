package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.BookReservation;

import java.util.ArrayList;
import java.util.List;

public class DataHolder {
    public static List<Book> books = new ArrayList<>();
    public static List<BookReservation> reservations = new ArrayList<>();

    static {
        books.add(new Book("Twilight","Fantasy",8.2));
        books.add(new Book("Pride and Prejudice", "Romance", 8.8));
        books.add(new Book("The Shining", "Horror", 8.5));
        books.add(new Book("Dracula", "Gothic", 8.6));
        books.add(new Book("Sapiens", "History", 4.2));
        books.add(new Book("The Alchemist", "Fiction", 3.9));
        books.add(new Book("Harry Potter", "Fantasy", 9.5));
        books.add(new Book("Norwegian Wood", "Fiction", 4.0));
        books.add(new Book("The Hobbit", "Fantasy", 9.1));
        books.add(new Book("Dune", "Sci-Fi", 9.3));
    }
}
