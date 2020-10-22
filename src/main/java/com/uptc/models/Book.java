package com.uptc.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "BOOKS")
@Data
@AllArgsConstructor
public class Book {

    @Id
    @Column(name = "book_id")
    private Long id;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    @Override
    public String toString() {
        return "Book [author=" + author.getId() + ", id=" + id + ", title=" + title + "]";
    }

  
}
