package com.example.demo1.Book;

public class Book {

    private String image;
    private int bookid;
    private String title;
    private String author;
    private double price;
    private String path;
    private String chapter0;
    private String chapter1;
    private String chapter2;
    private String chapter3;
    private String chapter4;
    private String chapter5;
    private String description;
    public Book(int bookid, String title, String author, double price){
        this.bookid=bookid;
        this.title=title;
        this.author=author;
        this.price=price;
    }
    public Book(String title, String author, String image){
        this.title=title;
        this.author=author;
        this.image=image;
    }
    public Book(int bookid, String title, String author, String image, String path, String chapter0,String chapter1, String chapter2, String chapter3, String chapter4, String chapter5, String description){
        this.bookid=bookid;
        this.author=author;
        this.title=title;
        this.image=image;
        this.path=path;
        this.chapter0=chapter0;
        this.chapter1=chapter1;
        this.chapter2=chapter2;
        this.chapter3=chapter3;
        this.chapter4=chapter4;
        this.chapter5=chapter5;
        this.description=description;
    }
    public Book(){
    }
    public String getPath() {
        return path;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    public Integer getBookId(){
        return bookid;
    }

    public void setBookId(Integer bookid) {
        this.bookid = bookid;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    public String getChapter0() {
        return chapter0;
    }

    public String getChapter1() {
        return chapter1;
    }

    public String getChapter2() {
        return chapter2;
    }

    public String getChapter3() {
        return chapter3;
    }

    public String getChapter4() {
        return chapter4;
    }

    public String getChapter5() {
        return chapter5;
    }

    public String getDescription() {
        return description;
    }

}
