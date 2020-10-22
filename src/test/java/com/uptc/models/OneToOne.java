package com.uptc.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OneToOne {
    private static EntityManagerFactory managerFactory;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        managerFactory = Persistence.createEntityManagerFactory("Persistencia");
        entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Location location = new Location(100L, "cra 20 b", "Colombia");
        Employe employe = new Employe(10L, "Andres", "Rojas", LocalDate.of(2000, 12, 21));
        entityManager.persist(employe);
        employe.setLocation(location);
        print();
        entityManager.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    private static void print(){
        List<Employe> employees = (List<Employe>) entityManager.createQuery("FROM Employe").getResultList();
        System.out.println("\n-------" + employees.size());
        employees.forEach(System.out::println);
    }

}
