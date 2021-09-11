package com.company;

import java.util.ArrayList;

public class BookShelf {
    private ArrayList<Book> books;
    private int booksNum;
    private int bookShelfIndex;
    private String bookShelfClass;
    private int bookShelfBooksMaxNum;

    public BookShelf(ArrayList<Book> books, int booksNum) {
        this.books = books;
        this.booksNum = booksNum;
    }

    public void setBookShelfIndex(int bookShelfIndex) {
        this.bookShelfIndex = bookShelfIndex;
    }

    public int getBookShelfIndex() {
        return bookShelfIndex;
    }

    public void setBookShelfClass(String bookShelfClass) {
        this.bookShelfClass = bookShelfClass;
    }

    public String getBookShelfClass() {
        return bookShelfClass;
    }

    public void setBookShelfBooksMaxNum(int bookShelfBooksMaxNum) {
        this.bookShelfBooksMaxNum = bookShelfBooksMaxNum;
    }

    public int getBookShelfBooksMaxNum() {
        return bookShelfBooksMaxNum;
    }

    public void setBooksNum(int booksNum) {
        this.booksNum = booksNum;
    }

    public int getBooksNum() {
        return booksNum;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
    public ArrayList<Book> getBooks() {
        return books;
    }

    public Book getByName(ArrayList<Book> books, String name) {
        for (Book book : books) {
            if (book.getName().equals(name)) {
                return book;
            }
        }
        return null;
    }

    public ArrayList<Book> getByAuthor(ArrayList<Book> books, String author) {
        ArrayList<Book> authorBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getName().contains(author)) {
                authorBooks.add(book);
            }
        }
        return authorBooks;
    }

    public void printBooks(ArrayList<Book> books) {
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    public ArrayList<Book> getByDate(ArrayList<Book> books, Date date) {
        ArrayList<Book> dateBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getDate().getYear() == date.getYear() && book.getDate().getMonth() == date.getMonth() && book.getDate().getDay() == date.getDay()) {
                dateBooks.add(book);
            }
        }
        return dateBooks;
    }

    public ArrayList<Book> getByStartDateToEndDate(ArrayList<Book> books, Date startDate, Date endDate) {
        ArrayList<Book> startDateToEndDateBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getDate().getYear() >= startDate.getYear() && book.getDate().getYear() <= endDate.getYear()) {
                if (book.getDate().getMonth() >= startDate.getMonth() && book.getDate().getMonth() <= endDate.getMonth())
                    if (book.getDate().getDay() >= startDate.getDay() && book.getDate().getDay() <= endDate.getDay())
                        startDateToEndDateBooks.add(book);
            }
        }
        return startDateToEndDateBooks;
    }
}
