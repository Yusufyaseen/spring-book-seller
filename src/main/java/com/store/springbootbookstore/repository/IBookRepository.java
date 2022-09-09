package com.store.springbootbookstore.repository;

import com.store.springbootbookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {
}
