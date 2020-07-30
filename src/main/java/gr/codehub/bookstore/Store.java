package gr.codehub.bookstore;




import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {

    private List<Book> books;


    public Store(){
        books = new ArrayList<>();
    }

    //CRUD   create, read, update, delete

    public void create(Book book){
        books.add(book);
    }


    public void showBooks(){
           for(int i=0;i<books.size();i++) {
               System.out.println(books.get(i));
           }
    }

    public void showBooks2(){
        for(Book book:books) {
            System.out.println(book);
        }
    }

    public void loadFromFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner (file);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String []words = line.split(",");
            Book book = new Book();
            book.setTitle(words[0]);
            book.setPrice(Double.parseDouble(words[1].trim()));
            book.setQuantity(Integer.parseInt(words[2].trim()));
            books.add(book);
        }
    }

    public void delete(int index){
        if (index >= 0 && index < books.size())
            books.remove(index);
    }

    public void changePrice(double newPrice, int index){
        if (index >= 0 && index < books.size())
            books.get(index)
                    .setPrice(newPrice);
    }


    public void changePrice(double newPrice, String title){
         for (Book book:books)
            if (book.getTitle().equals(title))
                 book.setPrice(newPrice);
    }

    public double sumCost(){
        double sum = 0;
        for (Book book: books)
            sum += book.getPrice() * book.getQuantity();

        return sum;
    }

    public int countBooksBelowOrEqualGivenPrice(double givenPrice){
        int count = 0;
        for (Book book:books)
            if (book.getPrice() <= givenPrice)
                count += book.getQuantity();
        return count;
    }


    public void saveToFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        PrintWriter pw = new PrintWriter(file);

        for (Book book : books){
            pw.println(book.getTitle()+","+ book.getPrice() +","+ book.getQuantity());
        }
        pw.close();

    }

    //convertTojson


 }


