package com.iims.model;

public class Book {
    private int id, stock;
    private String name, author;

    public Book() {}

    public Book(String name, String author, int stock) {
        this.stock = stock;
        this.name = name;
        this.author = author;
    }

    public Book(int id, String name, String author, int stock) {
        this.id = id;
        this.stock = stock;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
