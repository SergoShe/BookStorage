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
    public ResponseEntity<List<Author>> readAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        return authors != null && !authors.isEmpty()
                ? new ResponseEntity<>(authors, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Просмотр автора
    @GetMapping("/{id}")
    public ResponseEntity<Author> readAuthor(@PathVariable long authorId) {
        Author author = authorService.getAuthor(authorId);
        return author != null
                ? new ResponseEntity<>(author, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Добавить автора
    @PostMapping("/")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        authorService.createAuthor(author);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //Изменить информацию об авторе
    @PutMapping("/")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author) {
        Author updatedAuthor = authorService.updateAuthor(author);
        return updatedAuthor != null
                ? new ResponseEntity<>(updatedAuthor, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    //Удалить автора
    @DeleteMapping("/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable long authorId) {
        boolean deleted = authorService.deleteAuthor(authorId);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
