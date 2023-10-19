package com.github.SergoShe.controller;

import com.github.SergoShe.model.Reader;
import com.github.SergoShe.service.ReaderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reader")
public class ReaderController {

    private final ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    //Просмотр всех читателей
    @GetMapping("/all")
    public ResponseEntity<List<Reader>> readAll() {
        List<Reader> readers = readerService.getAllReaders();
        return readers != null && !readers.isEmpty()
                ? new ResponseEntity<>(readers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Просмотр читателя
    @GetMapping("/{id}")
    public ResponseEntity<Reader> readReader(@PathVariable long readerId) {
        Reader reader = readerService.getReader(readerId);
        return reader != null
                ? new ResponseEntity<>(reader, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Добавить читателя
    @PostMapping("/")
    public ResponseEntity<Reader> createReader(@RequestBody Reader reader) {
        Reader createdReader = readerService.createReader(reader);
        return createdReader != null
                ? new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //Изменить информацию о читателе
    @PutMapping("/")
    public ResponseEntity<Reader> updateReader(@RequestBody Reader reader) {
        Reader updatedReader = readerService.updateReader(reader);

        return updatedReader != null
                ? new ResponseEntity<>(updatedReader, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    //Удалить читателя
    @DeleteMapping("/{id}")
    public ResponseEntity<Reader> deleteReader(@PathVariable long readerId) {
        boolean deleted = readerService.deleteReader(readerId);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
