
package agenda;

import java.util.ArrayList;
import java.util.*;


public class Professionnel {

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return the numTel
     */
    public String getNumTel() {
        return numTel;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }
    private String nom;
    private String numTel;
    private String adresse; 
    

    public Professionnel(String nom,  String adresse, String numTel) {
        this.nom = nom;
        this.adresse = adresse;
        this.numTel = numTel;
        
    }
    
    public Professionnel() {
        nom = "";
        adresse = "";
        numTel = "";
        
    }
    




 public String toString() {
        return getNom() + "" + getAdresse()+""+getNumTel();
    }
 
}


