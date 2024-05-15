package com.example.demoapp.Service;

import com.example.demoapp.Model.BookModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Optional;

public interface BookService {

    BookModel addBooks(BookModel book);

    List<BookModel> getAllBooks();

    @Query("SELECT b FROM BookModel b WHERE b.id = :id")
    Optional<BookModel> getBookById(@Param("id") int id);

    List<BookModel> getBookByTitle(String title);

    List<BookModel> getBookByAuthor(String author);

    List<BookModel> getBookByTitleAndAuthor(String title, String author);

    List<BookModel> getBookByGenre(String genre);

    List<BookModel> getBookByLanguage(String language);

    @Query("SELECT b FROM BookModel b WHERE b.title IN :titles AND b.author IN :authors")
    List<BookModel> getBooksByTitleAndAuthor(@Param("titles") List<String> titles, @Param("authors") List<String> authors);

    List<BookModel> getBookByTitles(List<String> titles);

    List<BookModel> getBookByAuthors(List<String> authors);

    @Query("SELECT b FROM BookModel b WHERE b.genre IN :books")
    List<BookModel> getBookByGenres(@Param("genres") List<String> genres);

    @Query("SELECT b FROM BookModel b WHERE b.language IN :books")
    List<BookModel> getBookByLanguages(@Param("languages") List<String> language);

    BookModel updateBook(BookModel book);

    @Modifying
    @Query("DELETE FROM BookModel WHERE b.id = :id")
    void deleteBook(@Param("id") int id);

    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM StudentModel b WHERE b.id = :id")
    boolean existsById(@Param("id") int id);

    String values();

    Class<? extends Annotation> annotationType();
}
