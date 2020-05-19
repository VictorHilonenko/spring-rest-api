package com.vh.restapi.service;

import com.vh.restapi.entity.Picture;
import com.vh.restapi.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PictureService {
    private PictureRepository pictureRepository;

    @Autowired
    public PictureService(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }


    public List<Picture> findAll() {
        return pictureRepository.findAll();
    }

    public Optional<Picture> findById(int id) {
        return pictureRepository.findById(id);
    }

    public Picture save(Picture picture) {
        return pictureRepository.save(picture);
    }

    public Picture update(Picture picture) {
        return pictureRepository.save(picture);
    }

    public void delete(int id) {
        pictureRepository.deleteById(id);
    }
}
