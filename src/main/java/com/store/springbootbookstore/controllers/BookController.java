package com.store.springbootbookstore.controllers;

import com.store.springbootbookstore.model.Book;
import com.store.springbootbookstore.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @PostMapping()
    public ResponseEntity<?> addBook(@RequestBody Book book) throws Exception {
        try {
            return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @DeleteMapping("{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable Long bookId) throws Exception {
        try {
            bookService.deleteBook(bookId);
            return new ResponseEntity<>("Book is successfully deleted", HttpStatus.OK);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @GetMapping()
    public ResponseEntity<?> getAllBooks() throws Exception{
        try {
            return new ResponseEntity<>(bookService.findAllBooks(), HttpStatus.OK);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
