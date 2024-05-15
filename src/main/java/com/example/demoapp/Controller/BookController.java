package com.example.demoapp.Controller;

import com.example.demoapp.Model.BookModel;
import com.example.demoapp.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController{

    private BookService service;

    @Autowired
    public BookController(BookService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<BookModel>> getAllBooks(){
        List<BookModel> books = service.getAllBooks();
        return new ResponseEntity<>(books,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookModel> getBookById(@PathVariable int id){
        Optional<BookModel> books = service.getBookById(id);
        return books.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/byTitlesAndAuthors")
    public ResponseEntity<List<BookModel>> getBooksByTitlesAndAuthors(@RequestBody Map<String, List<String>> requestBody) {
        List<String> titles = requestBody.get("titles");
        List<String> authors = requestBody.get("authors");

        List<BookModel> books = service.getBooksByTitleAndAuthor(titles, authors);

        return ResponseEntity.ok(books);
    }

    @GetMapping("/byGenres")
    public ResponseEntity<List<BookModel>> getBookByGenres(@RequestBody List<String> Genres) {
        List<BookModel> books = service.getBookByGenres(Genres);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/byLanguages")
    public ResponseEntity<List<BookModel>> getBookByLanguages(@RequestBody List<String> languages) {
        List<BookModel> books = service.getBookByLanguages(languages);
        return ResponseEntity.ok(books);
    }

    @PostMapping
    public ResponseEntity<BookModel> createBook(@RequestBody BookModel books){
        BookModel createdBook = service.addBooks(books);
        return ResponseEntity.ok(createdBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookModel> updateBook(@PathVariable int id, @RequestBody BookModel books){
        books.setId(id);
        BookModel updatesBook = service.updateBook(books);
        return ResponseEntity.ok(updatesBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id){
        service.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
