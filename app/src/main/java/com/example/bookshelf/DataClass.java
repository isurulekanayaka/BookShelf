package com.example.bookshelf;

public class DataClass {
    private  String bookCategories;
    private  String bookTitle;
    private  String bookAuthor;
    private  String bookIsbn;
    private  String bookImage;

    private String key;

    public String getBookCategories() {
        return bookCategories;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public String getBookImage() {
        return bookImage;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }


    public DataClass(String bookCategories, String bookTitle, String bookAuthor, String bookIsbn, String bookImage) {
        this.bookCategories = bookCategories;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookIsbn = bookIsbn;
        this.bookImage = bookImage;
    }
    public DataClass(){

    }
}
