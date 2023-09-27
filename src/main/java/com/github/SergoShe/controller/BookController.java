package com.github.SergoShe.controller;

import com.github.SergoShe.model.Book;
import com.github.SergoShe.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //Просмотр всех книг
    @GetMapping("/all")
    public ResponseEntity<List<Book>> readAll() {
        List<Book> books = bookService.getAll();
        return books != null && !books.isEmpty()
                ? new ResponseEntity<>(books, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Просмотр книги
    @GetMapping("/{id}")
    public ResponseEntity<Book> read(@PathVariable long id) {
        Book book = bookService.get(id);
        return book != null
                ? new ResponseEntity<>(book, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Добавить книгу
    @PostMapping("/")
    public ResponseEntity<Book> create(@RequestBody Book book) {
        Book newBook = bookService.create(book);
        return new ResponseEntity<>(newBook,HttpStatus.CREATED);
    }

    //Изменить информацию о книге
    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@RequestBody Book book) {
        Book updatedBook = bookService.update(book);
        return new ResponseEntity<>(updatedBook,HttpStatus.OK);

    }

    //Отправить книгу в обслуживание
    @PatchMapping("/{id}")
    public void transferToService(@PathVariable long id) {
        bookService.sendBookToService(id);
    }

    //Удалить книгу
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        bookService.delete(id);
    }
}