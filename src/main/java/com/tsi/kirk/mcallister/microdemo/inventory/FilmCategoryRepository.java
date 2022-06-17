package com.tsi.kirk.mcallister.microdemo.inventory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmCategoryRepository extends CrudRepository<FilmCategory, FilmCategoryID> {

//    List<FilmCategory> findByFilmCatId_FilmId(int filmId);
//    List<FilmCategory> findByFilmCatId_CategoryId(int categoryId);

    List<FilmCategory> findByFilmId(int filmId);
    List<FilmCategory> findByCategoryId(int categoryId);
}
