package com.api.book.api.controller;

import com.api.book.api.dao.BookRepository;
import org.springframework.web.bind.annotation.RestController;
import com.api.book.api.entities.Book;
import com.api.book.api.services.bookservice;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



//by Rest controller no need of response body
//by get mapping youdont have to write @requestMapping(value="/test",method=Requestmethod.GET)
//

@RestController
public class BookController {
    private final BookRepository bookRepository;
    @Autowired
    private bookservice Bookservice;

    BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/book")
    public ResponseEntity<List<Book>> getBooks(){
        // Book book =new Book();
        // book.setAuthor("hc verma");
        // book.setId(123);
        // book.setTitle("as");

        List<Book> list=Bookservice.getAllBooks();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.CREATED).body(list);

        }
    }
    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id")int id ){
        return Bookservice.getBooksById(id);
    }
    @PostMapping("/books")
    public ResponseEntity<Book> postMethodName(@RequestBody Book book) {

    
    try{
       Book savedBook = Bookservice.addBook(book);
       return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);  
    }
    catch(Exception e){
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
        
    }
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId){
   
        try{
       // this.Bookservice.deleteBook(bookId);
       Bookservice.deleteBook(bookId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
       
    }
    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId){
    
        try{ 
        //this.Bookservice.updateBook(book, bookId);
        Book updatedBook = Bookservice.updateBook(book, bookId);
         return ResponseEntity.ok(updatedBook);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        // book.setId(bookId);
        // bookRepository.save(book);
    }
    
}
