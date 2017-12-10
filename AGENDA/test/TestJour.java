
import agenda.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author p1605819
 */
public class TestJour {
    
    public TestJour() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void cherchetest1h()
    {
        //Append :préparation des objets
        Jour j1=new Jour (8,12);
        Professionnel p= new Professionnel("test","adresse","tel");
        RendezVous rdv= new RendezVous(1,"rdv test",p);
        
        //Act: execution de la méthode testée
        int heure= j1.chercheCreneau(rdv);
        
        //Assert : verification du resultat
        assertEquals(heure,9);
    }
    
    @Test
    public void cherchetest2h()
    {
        //Append :préparation des objets
        Jour j1=new Jour (8,12);
        Professionnel p= new Professionnel("test","adresse","tel");
        RendezVous r1= new RendezVous(7,"rdv",p);
        j1.placerRendezVous(9,r1);
        RendezVous rdv= new RendezVous(2,"rdv test",p);
        
        
        //Act: execution de la méthode testée
        int heure= j1.chercheCreneau(rdv);
        
        //Assert : verification du resultat
        assertEquals(heure,16);
    }
    
    @Test
    public void cherchetestcomplet()
    {
        //Append :préparation des objets
        Jour j1=new Jour (8,12);
        Professionnel p= new Professionnel("test","adresse","tel");
        //on céé un rdv pour avoir une journée complete
        RendezVous r1= new RendezVous(9,"rdv",p);
        j1.placerRendezVous(9,r1);
        RendezVous rdv= new RendezVous(1,"rdv test",p);
        
        
        //Act: execution de la méthode testée
        int heure= j1.chercheCreneau(rdv);
        
        //Assert : verification du resultat
        assertEquals(heure,-1);
    }
    
    @Test
    public void cherchetestcomplet2h()
    {
        //Append :préparation des objets
        Jour j1=new Jour (8,12);
        Professionnel p= new Professionnel("test","adresse","tel");
        //on céé un rdv pour avoir une journée  avec 1h de dispo
        RendezVous r1= new RendezVous(8,"rdv",p);
        j1.placerRendezVous(9,r1);
        //créaion du rdv de 2h
        RendezVous rdv= new RendezVous(2,"rdv test",p);
        
        
        //Act: execution de la méthode testée
        int heure= j1.chercheCreneau(rdv);
        
        //Assert : verification du resultat
        assertEquals(heure,-1);
    }
    
    @Test
    public void placerRDVtest()
    {
        //Append :préparation des objets
        Jour j1=new Jour (8,12);
        Professionnel p= new Professionnel("test","adresse","tel");
        //on céé un rdv pour avoir une journée  avec 1h de dispo
        RendezVous r1= new RendezVous(8,"rdv",p);
      
        //Act: execution de la méthode testée
        boolean result= j1.placerRendezVous(9,r1);
        
        //Assert : verification du resultat
        assertTrue (result);
    }
    
    @Test
    public void placerRDVtestErreur()
    {
        //Append :préparation des objets
        Jour j1=new Jour (8,12);
        Professionnel p= new Professionnel("test","adresse","tel");
        //on céé un rdv pour avoir une journée  avec 1h de dispo
        RendezVous r1= new RendezVous(8,"rdv",p);
        j1.placerRendezVous(9,r1);
      
        //Act: execution de la méthode testée
        boolean result= j1.placerRendezVous(9,r1);
        
        //Assert : verification du resultat
        assertFalse(result);
    }
    
    @Test
    public void donnerRDVtest()
    {
        //Append :préparation des objets
        Jour j1=new Jour (8,12);
        Professionnel p= new Professionnel("test","adresse","tel");
        RendezVous r1= new RendezVous(1,"rdv",p);
        j1.placerRendezVous(9,r1);
      
        //Act: execution de la méthode testée
        RendezVous r2= j1.donneRendezVous(9);
        
        //Assert : verification du resultat
        assertEquals(r1,r2);
    }
    
    @Test
    public void donnerRDVtestErreur()
    {
        //Append :préparation des objets
        Jour j1=new Jour (8,12);
        //Act: execution de la méthode testée
        RendezVous r2= j1.donneRendezVous(9);
        
        //Assert : verification du resultat
        assertNull(r2);
    }
}
