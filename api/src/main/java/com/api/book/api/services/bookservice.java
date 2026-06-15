package com.api.book.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.api.book.api.dao.BookRepository;
import com.api.book.api.entities.Book;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class bookservice {  // Fix 4: PascalCase
    @Autowired
    private BookRepository bookRepository;

    //private static List<Book> list = new ArrayList<>();  // Fix 1: static field

    //static {
        // list.add(new Book(12, "java", "XYZ"));   // Fix 2: wrap in new Book()
        // list.add(new Book(13, "python", "ABC"));
        // list.add(new Book(14, "C++", "DEF"));
    //}

    public List<Book> getAllBooks() {
       // return list;
       return bookRepository.findAll();
    }

    public Book getBooksById(int id) {
        // Fix 3: removed curly braces (expression lambda), fixed `Id` → `id`
        // return list.stream()
        //            .filter(e -> e.getId() == id)
        //            .findFirst()
        //            .orElse(null);  // safer than .get() which throws if not found
         Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }
    public Book addBook(Book b){
        // list.add(b);
        // return b;
        return bookRepository.save(b);
    }

   public Book deleteBook(int bid) {
    // Find the book before deleting, so we can return it
    // Book deleted = list.stream()
    //                    .filter(book -> book.getId() == bid)
    //                    .findFirst()
    //                    .orElse(null);

    // list = list.stream()
    //            .filter(book -> book.getId() != bid)
    //            .collect(Collectors.toList());

    // return deleted; //  now returning a Book, not an int
    Optional<Book> book = bookRepository.findById(bid);
        if (book.isPresent()) {
            bookRepository.deleteById(bid);
            return book.get();
        }
        return null;
}

public Book updateBook(Book book,int bookId) { // return Book instead of void
    // list = list.stream().map(b -> {
    //     if (b.getId() == bookId) { //  book.getId() not bookId
    //         b.setTitle(book.getTitle());
    //         b.setAuthor(book.getAuthor()); // update author too
    //     }
    //     return b;
    // }).collect(Collectors.toList());

    // return book; }//  return updated book
    Optional<Book> existingBook = bookRepository.findById(bookId);
        if (existingBook.isPresent()) {
            Book b = existingBook.get();
            b.setTitle(book.getTitle());
            b.setAuthor(book.getAuthor());
            return bookRepository.save(b);  // Save updated book
        }
        return null;
    }
}