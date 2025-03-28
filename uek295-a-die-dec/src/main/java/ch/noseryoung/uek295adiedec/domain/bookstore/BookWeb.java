package ch.noseryoung.uek295adiedec.domain.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/books")
public class BookWeb {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooks());
    }


    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable("bookId") String bookId) {
        Book book = bookService.getBook(UUID.fromString(bookId));
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book  createdBook = bookService.createBook(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }


    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable String bookId, @RequestBody Book newBookData) {
        Book updated = bookService.updateBook(UUID.fromString(bookId), newBookData);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Book> deleteBook(@PathVariable String bookId) {
        bookService.deleteBook(UUID.fromString(bookId));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
