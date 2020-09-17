package com.uptc.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class TestEmploye {

    private static EntityManagerFactory managerFactory;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        managerFactory = Persistence.createEntityManagerFactory("Persistencia");
        entityManager = managerFactory.createEntityManager();

        
        entityManager.getTransaction().begin();

        add(new Employe(10L, "Andres", "Rojas", LocalDate.of(2000, 12, 21)));
        print();

        entityManager.getTransaction().commit();

    }

    private static void add(Employe employe){
        entityManager.persist(employe);
    }

    @SuppressWarnings("unchecked")
    private static void print(){
        List<Employe> employees = (List<Employe>) entityManager.createQuery("FROM Employe").getResultList();
        System.out.println("-------" + employees.size());
        employees.forEach(System.out::print);
    }
}
