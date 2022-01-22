package com.iims.model;

public class BookCustomer {
    int bookId, customerId;

    public BookCustomer() {}

    public BookCustomer(int bookId, int customerId) {
        this.bookId = bookId;
        this.customerId = customerId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
