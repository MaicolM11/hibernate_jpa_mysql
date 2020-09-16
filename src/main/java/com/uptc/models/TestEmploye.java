package com.uptc.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

public class TestEmploye {

    private static EntityManagerFactory managerFactory;
    private static EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        managerFactory = Persistence.createEntityManagerFactory("Persistencia");
        entityManager = managerFactory.createEntityManager();

        List<Employe> employees =(List<Employe>) entityManager.createQuery("FROM Employe").getResultList();
        System.out.println("-------"+employees.size());
    }
}
