package com.example.demoapp.Repository;

import com.example.demoapp.Model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRespository extends JpaRepository<BookModel, Integer> {

    @Query("SELECT b FROM BookModel b WHERE b.title = :title AND b.author = :author")
    List<BookModel> findByTitleAndAuthor(String title, String author);

    @Query("SELECT b FROM BookModel b WHERE b.genre = :genre")
    List<BookModel> findByGenre(String genre);

    @Query("SELECT b FROM BookModel b WHERE b.language = :language")
    List<BookModel> findByLanguage(String language);

    @Query("SELECT b FROM BookModel b WHERE b.title IN :titles")
    List<BookModel> findByTitleIn(List<String> titles);

    @Query("SELECT b FROM BookModel b WHERE b.author IN :authors")
    List<BookModel> findByAuthorIn(List<String> authors);

    @Query("SELECT b FROM BookModel b WHERE b.genre IN :genres")
    List<BookModel> findByGenreIn(List<String> genres);

    @Query("SELECT b FROM BookModel b WHERE b.language IN :languages")
    List<BookModel> findByLanguageIn(List<String> languages);
}