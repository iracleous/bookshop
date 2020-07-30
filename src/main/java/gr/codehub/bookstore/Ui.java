package gr.codehub.bookstore;

import java.io.FileNotFoundException;

public class Ui {

    public static void main(String[] args) {
        Store store = new Store();

        try {
            store.loadFromFile("bookstore.txt");
        } catch (FileNotFoundException e) {
            System.out.println("The file cannot be found");
        }

//        Book book = new Book();
//        book.setTitle("The red book");
//        book.setPrice(12.2);
//
//        Book book2 = new Book();
//        book2.setTitle("The green book");
//        book2.setPrice(10.2);
//
//        store.create(book);
//        store.create(book2);

       store.showBooks();



    }
}
