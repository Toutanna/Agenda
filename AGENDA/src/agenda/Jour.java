
package agenda;

import java.util.ArrayList;


public class Jour {
     // Heures de début et de fin pour les RDV
    public static final int HEURE_DEBUT = 9; 
    public static final int HEURE_FIN = 17;
    // Nombre d'heures réservables dans une journée
    // Hypothèse durée RDV = multiple d'1 heure
    public static final int NB_MAX_RDV = HEURE_FIN - HEURE_DEBUT + 1; 
    // Un numéro de jour dans un mois (1-31) 
    private int numJour;
    //un numéro de mois dans une année (1-12)
    private int numMois;
    //booléen permettant de définir si c'est un jour ouvrable ou non
    private boolean ouvrable;
    // Liste des RDV de la journée
    private ArrayList<RendezVous> listeRDV; 
    
    /** 
     * Constructeur pour les objets de la classe Jour. 
     * @param numJour le numéro de jour dans l'année (1-31)
     * @param numMois le numéro du mois dans l'année (1-12)
     */ 
    public Jour(int numJour, int numMois) 
    { 
      this.numJour = numJour; 
      this.numMois= numMois;
      //par défaut on considère que le jour est ouvrable
      this.ouvrable=true;
      listeRDV = new ArrayList<RendezVous>(NB_MAX_RDV); 
      //ajoute des objets null dans la liste de rdv
      for (int i =0; i<NB_MAX_RDV; i++)
      {
          listeRDV.add(null);
      }
      
    } 
     
    /** 
     * Cherche un créneau pour placer un RDV.
     * @param  unRDV le RDV a placer. 
     * @return la première heure de libre pour placer le RDV. 
     *         Retourne -1 si pas de créneau (de durée suffisante). 
     */ 
    public int chercheCreneau(RendezVous unRDV)
    {
      int duree = unRDV.getDuree(); 
      for(int creneau = 0; creneau < NB_MAX_RDV; creneau++)
      {
        if (listeRDV.get(creneau) == null)
        { 
          final int heure = HEURE_DEBUT + creneau; 
          // Heure de début potentielle
          if (duree == 1)
          {
            // Un seul creneau (d'1 h) est demandé
            return heure;
          }
          else
          { 
            // Combien de créneaux supplémentaires sont demandés 
            int creneaux_suppl = duree - 1; 
            for (int prochainCreneau = creneau + 1;
                 creneaux_suppl > 0 && listeRDV.get(prochainCreneau) == null;
                 prochainCreneau++)
            {
              creneaux_suppl--;
            }
            if (creneaux_suppl == 0)
            { 
              // Un espace suffisant a été trouvé.
              return heure;
            }
          }
        }
      }
      // Pas suffisamment de place pour le RDV
      return -1;
    }
  
  /**
   * Place un RDV. 
   * @param  heure l'heure a laquelle le RDV débute 
   * @param  unRDV le RDV à placer 
   * @return true  si le RDV a pu être placé, 
   *         false autrement.
   */
  public boolean placerRendezVous(int heure, RendezVous unRDV)
  {
    if (heure >= HEURE_DEBUT && heure <= HEURE_FIN)
    {
      int heureDebut = heure - HEURE_DEBUT;
      if (listeRDV.get(heureDebut) == null)
      {
        int duree = unRDV.getDuree();
        // Reserve tous les créneaux nécessaires à
        // la durée du RDV
        for (int i = 0; i < duree; i++)
        {
          listeRDV.set(heureDebut + i, unRDV); 
        }
        return true;
      }
      else
      {
        return false;
      }
    }
    else
    {
      return false;
    }
  }
  
  /**
   * Affiche la liste des RDV de la journée sur la console
   */ 
  public void afficheRendezVous()
  {
    System.out.println("===  " + getNumJour() + " "+Annee.listeMois.get(getNumMois()-1)+"==="); 
    
    for (int i = 0; i < NB_MAX_RDV; i++)
    {
      System.out.print ((HEURE_DEBUT + i) + " : ");
      if (listeRDV.get(i) != null)
      {
        System.out.println(listeRDV.get(i).getDescription());
          System.out.println(listeRDV.get(i).getPro().getNom());
      }
      else
      {
        System.out.println();
      }
    }
  }
  
    /**
   * Donne le RDV fixé à cette heure. 
   * @param  heure l'heure a laquelle le RDV débute 
   * @return unRDV s'il en existe un à cette heure là, 
   *         null  s'il n'y a aucun RDV ou si l'heure est hors limites.
   */
  public RendezVous donneRendezVous(int heure)
  {
    if (HEURE_DEBUT <= heure && heure <= HEURE_FIN)
       return listeRDV.get(heure - HEURE_DEBUT);
    else
       return null;
  }

    /**
     * @return le numéro du jour dans le mois 1-31
     */
    public int getNumJour() {
        return numJour;
    }
    /**
     * @return le numéro du mois 1-12
     */
    public int getNumMois() {
        return numMois;
    }

    /**
     * @param ouvrable true si le jour est ouvrable, false sinon
     */
    public void setOuvrable(boolean ouvrable) {
        this.ouvrable = ouvrable;
    }
}
