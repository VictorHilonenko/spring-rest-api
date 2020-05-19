package com.vh.restapi.service;

import com.vh.restapi.entity.Picture;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PictureService {

    public List<Picture> findAll() {
        List<Picture> pictures = new ArrayList<>();
        Picture picture1 = new Picture(1, "path", "comment");
        Picture picture2 = new Picture(2, "path", "comment");
        pictures.add(picture1);
        pictures.add(picture2);
        return pictures;
    }

    public Picture findById(int id) {
        return new Picture(1, "path", "comment");
    }

    public int save(Picture picture) {
        return 1;
    }

    public int update(Picture picture) {
        return 1;
    }

    public void delete(int id) {
        //
    }
}
