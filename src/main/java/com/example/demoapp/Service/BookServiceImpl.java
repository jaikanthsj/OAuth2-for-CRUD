package com.example.demoapp.Service;

import com.example.demoapp.Model.BookModel;
import com.example.demoapp.Repository.BookRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRespository repository;

    @Autowired
    public BookServiceImpl(BookRespository repository){
        this.repository = repository;
    }

    @Override
    public BookModel addBooks(BookModel book){
        return repository.save(book);
    }

    @Override
    public List<BookModel> getAllBooks(){
        return repository.findAll();
    }

    @Override
    public Optional<BookModel> getBookById(int id){
        return repository.findById(id);
    }

    @Override
    public List<BookModel> getBookByTitle(String title) {
        return List.of();
    }

    @Override
    public List<BookModel> getBookByAuthor(String author) {
        return List.of();
    }

    @Override
    public List<BookModel> getBookByTitleAndAuthor(String title, String author) {
        return repository.findByTitleAndAuthor(title, author);
    }

    @Override
    public List<BookModel> getBookByGenre(String genre){
        return repository.findByGenre(genre);
    }

    @Override
    public List<BookModel> getBookByLanguage(String language){
        return repository.findByLanguage(language);
    }

    @Override
    public List<BookModel> getBooksByTitleAndAuthor(List<String> titles, List<String> authors) {
        return List.of();
    }

    @Override
    public List<BookModel> getBookByTitles(List<String> titles){
        return repository.findByTitleIn(titles);
    }

    @Override
    public List<BookModel> getBookByAuthors(List<String> authors){
        return repository.findByAuthorIn(authors);
    }

    @Override
    public List<BookModel> getBookByGenres(List<String> genres){
        return repository.findByGenreIn(genres);
    }

    @Override
    public List<BookModel> getBookByLanguages(List<String> languages){
        return repository.findByLanguageIn(languages);
    }

    @Override
    public BookModel updateBook(BookModel book){
        return repository.save(book);
    }

    @Override
    public void deleteBook(int id){
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(int id){
        return repository.existsById(id);
    }

    @Override
    public String values() {
        return "";
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}