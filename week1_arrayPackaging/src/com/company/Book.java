package com.company;

public class Book {
    private String name;
    private Date date;
    private String author;

    public Book(String name, Date date, String author) {
        this.name = name;
        this.date = date;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

//    public void printBook() {
//        System.out.print(this.name + " ");
//        this.date.printDate();
//        System.out.print(" " + this.author);
//    }

    public String toString() {
        return "書名:" +this.name + " 出版日:" + this.date.toString() + " 作者:" + this.author;
    }
}
