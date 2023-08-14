package com.github.SergoShe.controller;

import com.github.SergoShe.model.Author;
import com.github.SergoShe.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    //Просмотр всех авторов
    @GetMapping("/all")
    public ResponseEntity<List<Author>> readAll() {
        List<Author> authors = authorService.readAll();
        return authors != null && !authors.isEmpty()
                ? new ResponseEntity<>(authors, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Просмотр автора
    @GetMapping("/{id}")
    public ResponseEntity<Author> read(@PathVariable long id) {
        Author author = authorService.read(id);
        return author != null
                ? new ResponseEntity<>(author, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Добавить автора
    @PostMapping("/")
    public ResponseEntity<Author> create(@RequestBody Author author) {
        authorService.create(author);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //Изменить информацию об авторе
    @PutMapping("/{id}")
    public ResponseEntity<Author> update(@PathVariable long id, @RequestBody Author author) {
        boolean updated = authorService.update(author, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    //Удалить автора
    @DeleteMapping("/{id}")
    public ResponseEntity<Author> deleteBook(@PathVariable long id) {
        boolean deleted = authorService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
