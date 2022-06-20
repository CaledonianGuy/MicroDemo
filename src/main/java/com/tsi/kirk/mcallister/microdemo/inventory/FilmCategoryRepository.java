package com.tsi.kirk.mcallister.microdemo.inventory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmCategoryRepository extends CrudRepository<FilmCategory, Integer> {

    Optional<FilmCategory> findByFilmId(int filmId);
    Iterable<FilmCategory> findByCategoryId(int categoryId);
}
