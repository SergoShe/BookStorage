package com.github.SergoShe.controller;

import com.github.SergoShe.model.Book;
import com.github.SergoShe.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;

    //Просмотр всех книг
    @GetMapping("/all")
    public ResponseEntity<List<Book>> readAll() {
        List<Book> books = bookService.readAll();
        return books != null && !books.isEmpty()
                ? new ResponseEntity<>(books, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Просмотр книги
    @GetMapping("/{id}")
    public ResponseEntity<Book> read(@PathVariable long id) {
        Book book = bookService.read(id);
        return book != null
                ? new ResponseEntity<>(book, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Добавить книгу
    @PostMapping("/")
    public ResponseEntity<Book> create(@RequestBody Book book) {
        bookService.create(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //Изменить информацию о книге
    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable long id, @RequestBody Book book) {
        boolean updated = bookService.update(book, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    //Отправить книгу в обслуживание
    @PatchMapping("/{id}")
    public String transferToService(@PathVariable long id) {

        return "Книга " + bookService.read(id).getTitle() + " отправлена на обслуживание";
    }

    //Удалить книгу
    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable long id) {
        boolean deleted = bookService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

    }
}