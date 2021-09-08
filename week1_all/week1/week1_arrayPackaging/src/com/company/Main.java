package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        BookShelf bookShelf = new BookShelf(books, 0);
        Book book;
        while (true) {
            System.out.print("請輸入功能:");
            int opt = sc.nextInt();
            switch (opt) {
                case 1:
                    sc.nextLine();
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
                    book = new Book(name, date, author);
                    bookShelf.getBooks().add(book);
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("請輸入要查詢的作者姓名");
                    author = sc.nextLine();
                    ArrayList<Book> authorBooks = bookShelf.getByAuthor(books, author);
                    bookShelf.printAuthorBooks(authorBooks);
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("請輸入要查詢的書名");
                    System.out.println(bookShelf.getByName(books, sc.nextLine()));
                    break;
                case 4:
                    sc.nextLine();
                    date = new Date();
                    System.out.println("請輸入要查詢的年");
                    date.setYear(sc.nextInt());
                    System.out.println("請輸入要查詢的月");
                    date.setMonth(sc.nextInt());
                    System.out.println("請輸入要查詢的日");
                    date.setDay(sc.nextInt());
                    sc.nextLine();
                    ArrayList<Book> dateBooks = bookShelf.getByDate(books, date);
                    bookShelf.printDateBooks(dateBooks);
                    break;
                case 5:
                    sc.nextLine();
                    Date startDate = new Date();
                    System.out.println("請輸入要查詢開始的年");
                    startDate.setYear(sc.nextInt());
                    System.out.println("請輸入要查詢開始的月");
                    startDate.setMonth(sc.nextInt());
                    System.out.println("請輸入要查詢開始的日");
                    startDate.setDay(sc.nextInt());
                    sc.nextLine();
                    Date endDate = new Date();
                    System.out.println("請輸入要查詢結束的年");
                    endDate.setYear(sc.nextInt());
                    System.out.println("請輸入要查詢結束的月");
                    endDate.setMonth(sc.nextInt());
                    System.out.println("請輸入要查詢結束的日");
                    endDate.setDay(sc.nextInt());
                    sc.nextLine();
                    ArrayList<Book> startDateToEndDateBooks = bookShelf.getByStartDateToEndDate(books, startDate, endDate);
                    bookShelf.printDateBooks(startDateToEndDateBooks);
                    break;
                case 7:
                    for (Book bk : books) {
                        System.out.println(bk.toString());
                    }
            }
        }
    }
}
