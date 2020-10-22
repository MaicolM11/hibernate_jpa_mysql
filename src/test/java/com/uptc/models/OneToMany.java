package com.uptc.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OneToMany {

    private static EntityManagerFactory managerFactory;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        managerFactory = Persistence.createEntityManagerFactory("Persistencia");
        entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Author author1 = new Author(20L, "Ana Rojas");
        Author author2 = new Author(30L, "Miguel Lopez");
        Author author3 = new Author(40L, "Pablo Perez");

        Book book1 = new Book(1L, "Libro1", author1);
        Book book2 = new Book(2L, "Libro2", author2);
        Book book3 = new Book(3L, "Libro3", author2);
        Book book4 = new Book(4L, "Libro4", author1);
        Book book5 = new Book(5L, "Libro5", author1);
        Book book6 = new Book(6L, "Libro6", author3);
        author1.setBooks(List.of(book1, book4, book5));
        author2.setBooks(List.of(book2, book3));
        author3.setBooks(List.of(book6));

        entityManager.persist(book1);
        entityManager.persist(book2);
        entityManager.persist(book3);
        entityManager.persist(book4);
        entityManager.persist(book5);
        entityManager.persist(book6);

        List<Book> a = entityManager.find(Author.class, 20L).getBooks();

        entityManager.getTransaction().commit();

        entityManager.close();

        a.forEach(System.out::println);
    }

    @SuppressWarnings("unchecked")
    private static void print() {
        List<Author> authors = (List<Author>) entityManager.createQuery("FROM Author").getResultList();
        System.out.println("\n-------" + authors.size());
        authors.forEach(System.out::println);
    }

}
