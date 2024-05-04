package com.example.demo1.Purchase;

import java.util.Date;

public class customerData {

    private Integer customerId;
    private Integer bookId;
    private String title;
    private String author;
    private Integer quantity;
    private Double price;

    public customerData(Integer customerId, Integer bookId, String title, String author
            , Integer quantity, Double price){
        this.customerId = customerId;
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.price = price;
    }
    public Integer getCustomerId(){
        return customerId;
    }
    public Integer getBookId(){
        return bookId;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public Integer getQuantity(){
        return quantity;
    }
    public Double getPrice(){
        return price;
    }
}
