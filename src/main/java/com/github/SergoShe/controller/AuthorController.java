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
        List<Author> authors = authorService.getAll();
        return authors != null && !authors.isEmpty()
                ? new ResponseEntity<>(authors, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Просмотр автора
    @GetMapping("/{id}")
    public ResponseEntity<Author> readAuthor(@PathVariable long id) {
        Author author = authorService.get(id);
        return author != null
                ? new ResponseEntity<>(author, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Добавить автора
    @PostMapping("/")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        authorService.create(author);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //Изменить информацию об авторе
    @PutMapping("/")
    public String updateAuthor(@RequestBody Author author) {
        long updatedAuthor_id = authorService.update(author);
        return "Author " + updatedAuthor_id + " is updated";
    }

    //Удалить автора
    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable long id) {
        authorService.delete(id);
    }
}
