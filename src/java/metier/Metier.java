/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import Entities.Etudiant;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Mamy
 */
public class Metier {
     public static List<Etudiant> listeetudiants(){
        
        List<Etudiant> etudiant = new ArrayList<>();
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("projetcissePU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Etudiant.findAll");
        etudiant=query.getResultList();
        return etudiant;
    }
      public static void ajouter(Etudiant U){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("projetcissePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(U);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
       public static void supprimer(String numcarte){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("projetcissePU");
        EntityManager em = emf.createEntityManager();
        Etudiant e=em.find(Etudiant.class, numcarte);
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
        public static Etudiant avantmodifier(String numcarte){
        Etudiant etudiant = new Etudiant();
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("projetcissePU");
        EntityManager em = emf.createEntityManager();
        Etudiant e=em.find(Etudiant.class, numcarte);  
        return e;
    }
        public static void modifier(Etudiant U){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("projetcissePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(U);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
