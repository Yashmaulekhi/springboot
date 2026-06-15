package com.api.book.api.entities;

import jakarta.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
@Entity
public class Author {
    @Id
    
    @Column(name="authorId")
    public Integer authorId;
    public String language ;
    public String firstName;
    public String lastName;
    @OneToOne
    @JsonBackReference
    public Book book;
    public int getAuthorId() {
        return authorId;
    }
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
    public Author(Integer authorId, String language, String firstName, String lastName) {
        this.authorId = authorId;
        this.language = language;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return "Author [authorId=" + authorId + ", language=" + language + ", firstName=" + firstName + ", lastName="
                + lastName + "]";
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Author(){

    }
}
