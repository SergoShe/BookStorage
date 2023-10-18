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
    AdministratorService adminService;

    //Просмотр всех администраторов
    @GetMapping("/all")
    public ResponseEntity<List<Administrator>> readAll() {
        List<Administrator> administrators = adminService.getAllAdministrators();
        return administrators != null && !administrators.isEmpty()
                ? new ResponseEntity<>(administrators, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Просмотр администратора
    @GetMapping("/{id}")
    public ResponseEntity<Administrator> readAdministrator(@PathVariable long adminId) {
        Administrator administrator = adminService.getAdministrator(adminId);
        return administrator != null
                ? new ResponseEntity<>(administrator, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Добавить администратора
    @PostMapping("/")
    public ResponseEntity<Administrator> createAdministrator(@RequestBody Administrator administrator) {
        adminService.createAdministrator(administrator);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //Изменить информацию об администраторе
    @PutMapping("/")
    public ResponseEntity<Administrator> updateAdministrator(@RequestBody Administrator administrator) {
        Administrator updatedAdmin = adminService.updateAdministrator(administrator);

        return updatedAdmin != null
                ? new ResponseEntity<>(updatedAdmin, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    //Удалить администратора
    @DeleteMapping("/{id}")
    public ResponseEntity<Administrator> deleteAdministrator(@PathVariable long adminId) {
        boolean deleted = adminService.deleteAdministrator(adminId);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
