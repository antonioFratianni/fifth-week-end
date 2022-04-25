package com.example.backend.controller;

import com.example.backend.domain.Show;
import com.example.backend.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class ShowController {

    @Autowired
    ShowService showService;

    @GetMapping(path = "/{id}")
    ResponseEntity<Show> findById(@PathVariable String id) {
        Show show = showService.findById(id);
        return new ResponseEntity<>(show, HttpStatus.OK);
    }

    @GetMapping(path = "findall")
    ResponseEntity<?> findAll() {
        return new ResponseEntity<>(showService.findAll(), HttpStatus.OK);
    }

    @PostMapping(path = "save")
    ResponseEntity<Show> save(@RequestParam int reservationNumber) {
        Show show = showService.save(reservationNumber);
        return new ResponseEntity<>(show, HttpStatus.OK);
    }
}
