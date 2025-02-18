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
        
        // agregar
        entityManager.getTransaction().begin();
        Employe employe = new Employe(10L, "Andres", "Rojas", LocalDate.of(2000, 12, 21));
        entityManager.persist(employe);
        print();
        
        // encontrar
        Employe emp = entityManager.find(Employe.class, 10L);
        emp.setLastname("da");

        // merge y remove
        entityManager.merge(employe);
        entityManager.remove(employe);

        entityManager.getTransaction().commit();

        print();

        entityManager.close();
    }

    @SuppressWarnings("unchecked")
    private static void print(){
        List<Employe> employees = (List<Employe>) entityManager.createQuery("FROM Employe").getResultList();
        System.out.println("\n-------" + employees.size());
        employees.forEach(System.out::println);
    }
}
