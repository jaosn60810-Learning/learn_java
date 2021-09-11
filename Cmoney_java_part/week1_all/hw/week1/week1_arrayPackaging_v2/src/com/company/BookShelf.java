package com.company;

import java.util.ArrayList;

public class BookShelf {
    private ArrayList<Book> books = new ArrayList<>();
    private int booksNum;


    public BookShelf(ArrayList<Book> books, int booksNum) {
        this.books = books;
        this.booksNum = booksNum;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public int getBooksNum() {
        return booksNum;
    }

    public void setBooksNum(int booksNum) {
        this.booksNum = booksNum;
    }

    public void add(String name, Date date, String author) {
        Book book = new Book(name, date, author);
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

    public void printAuthorBooks(ArrayList<Book> authorBooks) {
        for (Book book : authorBooks) {
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

    public void printDateBooks(ArrayList<Book> dateBooks) {
        for (Book book : dateBooks) {
            System.out.println(book.toString());
        }
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

    public void printStartDateToEndDateBooks(ArrayList<Book> startDateToEndDateBooks) {
        for (Book book : startDateToEndDateBooks) {
            System.out.println(book.toString());
        }
    }

}
