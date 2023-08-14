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

    @GetMapping("/some")
    public String printSome(){
        return "Some";
    }

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

/*

    //Отправить книгу в обслуживание
    @GetMapping(path = "/{id}",params = "status")
    public String transferToService(@PathVariable long id, @RequestParam String status) {

        return "Книга "+id+" имеет статус " + status;
    }
*/


    //Удалить книгу
    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable long id) {
        boolean deleted = bookService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

    }
}