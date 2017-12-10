
package agenda;


public class RendezVous {
   private int duree;
  private String description;
  private Professionnel pro;
  
  /** 
   * Constructeur pour les objets de la classe RendezVous. 
   * @param duree durée du rendez-vous
   * @param description description du rendez-vous
   */
  public RendezVous(int duree, String description, Professionnel p)
  {
    this.duree = duree;
    this.description = description;
    this.pro=p;
  }
  
 

    /**
     * @return la durée du rendez-vous.
     */
    public int getDuree() {
        return duree;
    }

    /**
     * @return le motif du rendez-vous
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return le professionnel du rendez-vous
     */
    public Professionnel getPro() {
        return pro;
    }
}
