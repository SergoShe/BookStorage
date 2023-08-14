package com.github.SergoShe.controller;

import com.github.SergoShe.model.Administrator;
import com.github.SergoShe.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("administrator")
public class AdministratorController {

    @Autowired
    AdministratorService administratorService;

    //Просмотр всех администраторов
    @GetMapping("/all")
    public ResponseEntity<List<Administrator>> readAll() {
        List<Administrator> administrators = administratorService.readAll();
        return administrators != null && !administrators.isEmpty()
                ? new ResponseEntity<>(administrators, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Просмотр администратора
    @GetMapping("/{id}")
    public ResponseEntity<Administrator> read(@PathVariable long id) {
        Administrator administrator = administratorService.read(id);
        return administrator != null
                ? new ResponseEntity<>(administrator, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Добавить читателя
    @PostMapping("/")
    public ResponseEntity<Administrator> create(@RequestBody Administrator administrator) {
        administratorService.create(administrator);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //Изменить информацию об администраторе
    @PutMapping("/{id}")
    public ResponseEntity<Administrator> update(@PathVariable long id, @RequestBody Administrator administrator) {
        boolean updated = administratorService.update(administrator, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    //Удалить администратора
    @DeleteMapping("/{id}")
    public ResponseEntity<Administrator> deleteBook(@PathVariable long id) {
        boolean deleted = administratorService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
