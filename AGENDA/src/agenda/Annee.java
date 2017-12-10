
package agenda;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Annee {
    //liste des mois 
    public static ArrayList listeMois=new ArrayList() 
    {{add("janvier");add("février");add("mars");add("avril");add("mai");add("juin");
    add("juillet");add("aout");add("septembre");add("octobre");
    add("novembre");add("décembre");}};
    //annee en cours
    private int annee;
    //jours de l'année
    private ArrayList<Jour> lesJours = new ArrayList();
    
    /**
     * Constructeur pour une année à compléter
     * @param annee 
     */
    public Annee(int annee)
    {
        this.annee=annee;
        
    }
    public String toString()
    {
       return "l'année "+annee+"contient "+lesJours.size()+"jours"; 
    }
    public  ArrayList<Jour> getlesJours()
    {
        return lesJours;
    }
    public  ArrayList<Jour> getlesJoursDuMois(int mois)
    {
        ArrayList<Jour> leMois=new ArrayList();
        for(Jour unJour :lesJours)
        {
            if (unJour.getNumMois()==mois)
                leMois.add(unJour);
        }
        return leMois;
    }
    public Jour getUnJour(int nbJour,int nbMois)
    {
        for(Jour unJour :lesJours)
        {
            if(unJour.getNumMois()==nbMois && unJour.getNumJour()==nbJour)
                return unJour;
        }
        return null;
    }
    /**
     * 
     * @param jour
     * @param mois
     * @param annee
     * @return le jour de la semaine de la date passée en paramètres
     *          1 pour dimanche, 2 pour lundi..., 7 pour samedi 
     */
     public static int getJour(int jour, int mois, int annee)
   {
       try{
                SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
                String date =jour+"/"+mois+"/"+annee;
                Date dt1=format1.parse(date);
                Calendar c = Calendar.getInstance();
   
                c.setTime(dt1);

                int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
                return dayOfWeek;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return -1;
        }
   }
    
}
