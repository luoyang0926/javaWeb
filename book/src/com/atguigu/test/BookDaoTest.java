package com.atguigu.test;

import com.atguigu.dao.BaseDao;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"sea","haizi",new BigDecimal(50),100,150,null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(23);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(23, "worriors", "haizi", new BigDecimal(50), 100, 150, null));
    }

    @Test
    public void queryBookById() {
        System.out.println( bookDao.queryBookById(23));
    }

    @Test
    public void queryBook() {
        for (Book queryBook : bookDao.queryBook()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryforpageTotalCount() {
        System.out.println(bookDao.queryforpageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        for (Book book : bookDao.queryForPageItems(4, 4)) {
            System.out.println(book);

        }
    }
    @Test
    public void queryforpageTotalCountByPrice() {
        System.out.println(bookDao.queryforpageTotalCountByPrice(10,1000));
    }
    @Test
    public void queryForPageItemsByPrice() {
        for (Book book : bookDao.queryForPageItemsByPrice(0, 4,50,1000)) {
            System.out.println(book);

        }
    }
}