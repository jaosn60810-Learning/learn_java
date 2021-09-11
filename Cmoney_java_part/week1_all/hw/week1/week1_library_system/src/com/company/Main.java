package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        ArrayList<BookShelf> bookShelves = new ArrayList<>();
        ArrayList<Book> books = new ArrayList<>();
        BookShelf bookShelf = new BookShelf(books, 0);
        Book book;
        while (true) {
            System.out.print("請輸入功能:");
            int opt = sc.nextInt();
            sc.nextLine();
            switch (opt) {
                case 1:
                    System.out.println("請輸入書櫃資料");
                    System.out.print("請輸入書櫃編號:");
                    int bookShelfIndex = sc.nextInt();
                    sc.nextLine();
                    System.out.print("請輸入書櫃分類:");
                    String bookShelfClass = sc.nextLine();
                    System.out.print("請輸入書櫃存書量上限:");
                    int bookShelfBooksMaxNum = sc.nextInt();
                    sc.nextLine();
                    library.addBookShelf(bookShelfIndex, bookShelfClass, bookShelfBooksMaxNum);
                    break;
                case 2:
                    System.out.println("請輸入書籍資料");
                    System.out.print("請輸入書名:");
                    String name = sc.nextLine();
                    System.out.print("請輸入作者:");
                    String author = sc.nextLine();
                    Date date = new Date();
                    System.out.print("請輸入年:");
                    date.setYear(sc.nextInt());
                    System.out.print("請輸入月:");
                    date.setMonth(sc.nextInt());
                    System.out.print("請輸入日:");
                    date.setDay(sc.nextInt());
                    sc.nextLine();
                    System.out.print("請輸入書櫃分類:");
                    String bookClass = sc.nextLine();
                    book = new Book(name, date, author);
                    book.setBookClass(bookClass);
                    library.addBookByCLass(book);
                    break;
                case 3:
                    System.out.print("請輸入想查詢的書櫃分類:");
                    bookClass = sc.nextLine();
                    bookShelves = library.findBookShelvesByClass(bookClass);
                    library.printAllBooks(bookShelves);
                    break;
                case 4:
                    System.out.print("請輸入要修改的書所在書櫃編號:");
                    bookShelf = library.findBookShelfByIndex(sc.nextInt());
                    sc.nextLine();
                    System.out.print("請輸入要修改的書名:");
                    book = bookShelf.getByName(bookShelf.getBooks(), sc.nextLine());
                    if (book == null) {
                        System.out.println("沒有此書");
                        break;
                    }
                    System.out.println("要修改的書籍: " + book.toString());
                    System.out.print("請輸入要修改的內容選項(1.書名 2.出版日 3.作者):");
                    int chooseFunc = sc.nextInt();
                    sc.nextLine();
                    book = book.editBook(book, chooseFunc);
                    break;
                case 5:
                    library.printAllBooks(library.getBookShelves());
                    break;
            }
        }
    }
}
