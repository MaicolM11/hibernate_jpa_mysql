package com.uptc.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "AUTHORS")
@Data
public class Author {
    
    @Id
    @Column(name = "author_id")
    private Long id;

    private String names;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;

    public Author(Long id, String names) {
        this.id = id;
        this.names = names;
        this.books = new ArrayList<>();
    }

    
}
