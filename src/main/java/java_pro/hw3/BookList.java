package java_pro.hw3;

import java.util.Set;
import java.util.TreeSet;

public class BookList {
    public static void main(String[] args) {
        Set<Book> bookSet = new TreeSet<>();
        bookSet.add(new Book("The Hobbit", "Tolkien", 100));
        bookSet.add(new Book("Lord of the Rings", "Tolkien", 120));
        bookSet.add(new Book("Silmarillion", "Tolkien", 70));
        bookSet.add(new Book("HPMOR", "Yudkowskiy", 60));
        bookSet.add(new Book("Alice in Wonderland", "Carol", 50));
        for (Book book : bookSet) {
            System.out.println(book);
        }
    }


}
