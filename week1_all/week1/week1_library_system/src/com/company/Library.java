package com.company;

import java.util.ArrayList;

public class Library {
    private ArrayList<BookShelf> bookShelves = new ArrayList<>();
    private int bookShelvesNum;

    public ArrayList<BookShelf> getBookShelves() {
        return bookShelves;
    }

    public void addBookByCLass(Book book) {
        for (BookShelf bookShelf : this.bookShelves) {
            if (bookShelf.getBookShelfClass().equals(book.getBookClass())) {
                if (bookShelf.getBookShelfBooksMaxNum() > bookShelf.getBooks().size()) {
                    bookShelf.getBooks().add(book);
                    return;
                }
            }
        }
        System.out.println("書櫃全滿");
    }

    public void addBookShelf(int bookShelfIndex, String bookShelfClass, int bookShelfBooksMaxNum) {
        BookShelf bookShelf = new BookShelf(null, 0);
        ArrayList<Book> books = new ArrayList<>();
        bookShelf.setBooks(books);
        bookShelf.setBookShelfIndex(bookShelfIndex);
        bookShelf.setBookShelfClass(bookShelfClass);
        bookShelf.setBookShelfBooksMaxNum(bookShelfBooksMaxNum);
        this.bookShelves.add(bookShelf);
    }

    public BookShelf findBookShelfByIndex(int index) {
        for (BookShelf bookShelf : this.bookShelves) {
            if (bookShelf.getBookShelfIndex() == index) {
                return bookShelf;
            }
        }
        return null;
    }

    public ArrayList<BookShelf> findBookShelvesByClass(String bookShelfClass) {
        ArrayList<BookShelf> sameClassBookShelves = new ArrayList<>();
        for (BookShelf bookShelf : this.bookShelves) {
            if (bookShelf.getBookShelfClass().equals(bookShelfClass)) {
                sameClassBookShelves.add(bookShelf);
            }
        }
        return sameClassBookShelves;
    }

    public void printAllBooks(ArrayList<BookShelf> bookShelves) {
        for (BookShelf bookshelf :bookShelves) {
            bookshelf.printBooks(bookshelf.getBooks());
        }
    }

}
