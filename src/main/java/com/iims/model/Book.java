package com.iims.model;

public class Book {
    int id, stock;
    String bookName, author;

    public Book() {}

    public Book(String bookName, String author, int stock) {
        this.stock = stock;
        this.bookName = bookName;
        this.author = author;
    }

    public Book(int id, String bookName, String author, int stock) {
        this.id = id;
        this.stock = stock;
        this.bookName = bookName;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
