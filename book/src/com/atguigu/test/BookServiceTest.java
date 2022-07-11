package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "fuck", "laoba", new BigDecimal(500), 5000, 0, null));
    }

    @Test
    public void deleteBookById() {

        bookService.deleteBookById(24);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(24, "yes", "laoba", new BigDecimal(500), 5000, 0, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(24));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }
    @Test
    public void page() {
        System.out.println(bookService.page(1,4));
    }
}