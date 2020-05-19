package com.vh.restapi.controller;

import com.vh.restapi.entity.Picture;
import com.vh.restapi.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
                .body(
                        pictureService.findById(id)
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                );
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Picture picture) {
        Picture resPicture = pictureService.save(picture);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(resPicture);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Picture picture) {
        Picture resPicture = pictureService.update(picture);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resPicture);
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity delete(@PathVariable int id) {
        pictureService.delete(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
