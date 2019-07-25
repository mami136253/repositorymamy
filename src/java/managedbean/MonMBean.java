/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import Entities.Etudiant;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PreDestroy;
import metier.Metier;

/**
 *
 * @author Mamy
 */
@Named(value = "monMBean")
@SessionScoped
public class MonMBean implements Serializable {
     private Metier metier;
    private Etudiant U = new Etudiant();
    private Etudiant V= new Etudiant();
    
     @PreDestroy
     public void dest(){
        U=null;
    }
     

    /**
     * Creates a new instance of MonMBean
     */
    public MonMBean() {
    }
     public Etudiant getU() {
        return U;
    }

    public Etudiant getV() {
        return V;
    }
     public void setV(Etudiant V) {
        this.V = V;
    }
    
    public void setU(Etudiant U) {
        this.U = U;
    }
     public List<Etudiant> getAllUsers(){
        return metier.listeetudiants();
    }
    public Metier getMetier() {
        return metier;
    }
    public void setMetier(Metier metier) {
        this.metier = metier;
    } 
    public String ajouter(){
        this.metier.ajouter(V);
        V = new Etudiant();
        return "listeetudiants";   
    }
    public String supp(String  numcarte){
        this.metier.supprimer(numcarte);
        
        return "listeetudiants";
    }
    public String modif(String numcarte){
        U=metier.avantmodifier(numcarte);
        return "modifier";
    }
    public String modifier(){
        this.metier.modifier(U);
        return "listeetudiants";
    }
}
