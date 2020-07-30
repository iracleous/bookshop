package gr.codehub.bookstore;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Book {
    private String title;
    private int quantity;
    private double price;

 }
