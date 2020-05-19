package com.vh.restapi.controller;

import com.vh.restapi.entity.Picture;
import com.vh.restapi.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pictures")
public class PictureController {
    private PictureService pictureService;

    @Autowired
    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @GetMapping
    public ResponseEntity<List<Picture>> findAll() {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(pictureService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Picture> findById(@PathVariable int id) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(pictureService.findById(id));
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody Picture picture) {
        int id = pictureService.save(picture);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(id);
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody Picture picture) {
        int id = pictureService.update(picture);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(id);
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity deleteUser(@PathVariable int id) {
        pictureService.delete(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
