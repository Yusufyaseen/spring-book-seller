package com.store.springbootbookstore.service;

import com.store.springbootbookstore.model.Book;

import java.util.List;

public interface IBookService {
    Book saveBook(Book book);

    void deleteBook(Long id);

    List<Book> findAllBooks();
}
