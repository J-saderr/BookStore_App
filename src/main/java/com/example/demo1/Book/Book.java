package com.example.demo1.Book;

public class Book {
    private String name;

    private String image;
    private Integer bookid;
    private String title;
    private String author;
    private double price;
    public Book(int bookid, String title, String author, double price){
        this.bookid=bookid;
        this.title=title;
        this.author=author;
        this.price=price;
    }
    public Book(){
    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image=image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public Integer getBookid(){
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
