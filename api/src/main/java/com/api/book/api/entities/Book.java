package com.api.book.api.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name="Books")
public class Book {
    @Id
   
    @Column(name="book_id")
    private Integer id;
    private String title;
    @OneToOne(cascade=CascadeType.ALL)
   // @JoinColumn(name="authorId") 
   @JsonManagedReference
    private Author author;
    public Integer getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
    }
     public Book(){
        
    }
    
    
    public Book(Integer id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
   

}
