package com.tsi.kirk.mcallister.microdemo.inventory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmCategoryRepository extends CrudRepository<FilmCategory, FilmCategoryID> {

//    Iterable<FilmCategory> findByFilmCatId_FilmId(int filmId);
//    Iterable<FilmCategory> findByFilmCatId_CategoryId(int categoryId);

    Iterable<FilmCategory> findByFilmId(int filmId);
    Iterable<FilmCategory> findByCategoryId(int categoryId);
}
