package com.vh.restapi.repository;

import com.vh.restapi.entity.Picture;
import com.vh.restapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer> {
    List<Picture> findAll();

    Picture save(Picture picture);

    void deleteById(Integer id);
}
