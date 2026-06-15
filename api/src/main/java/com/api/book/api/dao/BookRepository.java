package com.api.book.api.dao;

import com.api.book.api.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // Changed from @Component
public interface BookRepository extends JpaRepository<Book, Integer> {
    // JpaRepository already has findAll() that returns List<Book>
    // JpaRepository already has findById(Integer id) that returns Optional<Book>
    // You don't need to add anything here!
}