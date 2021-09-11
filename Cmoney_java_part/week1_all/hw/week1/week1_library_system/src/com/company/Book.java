package com.company;

import java.util.Scanner;

public class Book {
    private String name;
    private Date date;
    private String author;
    private String bookClass;
    Scanner sc = new Scanner(System.in);

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

    public String getBookClass() {
        return bookClass;
    }

    public void setBookClass(String bookClass) {
        this.bookClass = bookClass;
    }

    public String toString() {
        return "書名:" + this.name + " 出版日:" + this.date.toString() + " 作者:" + this.author+ " 書櫃分類:" + this.bookClass;
    }

    public Book editBook(Book book, int chooseFunc) {
        if (chooseFunc == 1) {
            System.out.print("請輸入新的書名:");
            book.setName(sc.nextLine());
        } else if (chooseFunc == 2) {
            System.out.print("請輸入新的年:");
            book.date.setYear(sc.nextInt());
            System.out.print("請輸入新的月:");
            book.date.setMonth(sc.nextInt());
            System.out.print("請輸入新的日:");
            book.date.setDay(sc.nextInt());
            sc.nextLine();
        } else if (chooseFunc == 3) {
            System.out.print("請輸入新的作者:");
            book.setAuthor(sc.nextLine());
        } else {
            System.out.println("沒有這個選項");
        }
        System.out.println("修改後的資料: " + book.toString());
        return book;
    }
}
