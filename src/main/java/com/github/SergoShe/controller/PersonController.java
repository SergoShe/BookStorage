package com.github.SergoShe.controller;

import com.github.SergoShe.model.Person;
import com.github.SergoShe.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    PersonService personService;

    //Просмотр всех читателей
    @GetMapping("/all")
    public ResponseEntity<List<Person>> readAll() {
        List<Person> persons = personService.readAll();
        return persons != null && !persons.isEmpty()
                ? new ResponseEntity<>(persons, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Просмотр читателя
    @GetMapping("/{id}")
    public ResponseEntity<Person> read(@PathVariable long id) {
        Person person = personService.read(id);
        return person != null
                ? new ResponseEntity<>(person, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Добавить читателя
    @PostMapping("/")
    public ResponseEntity<Person> create(@RequestBody Person person) {
        personService.create(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //Изменить информацию о книге
    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable long id, @RequestBody Person person) {
        boolean updated = personService.update(person, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    //Удалить книгу
    @DeleteMapping("/{id}")
    public ResponseEntity<Person> deleteBook(@PathVariable long id) {
        boolean deleted = personService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
