package bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Aksaukcija;
import model.Akskomentar;
import model.Akskorisnik;
import model.Aksponuda;
import model.Aksporuka;
import model.Akspredmet;

/**
 * Session Bean implementation class AukcijaMainBean
 */
@Stateful
@LocalBean
public class AukcijaMainBean implements AukcijaMainBeanRemote, AukcijaMainBeanLocal {
@PersistenceContext
EntityManager em;
    /**
     * Default constructor. 
     */
    public AukcijaMainBean() {
        // TODO Auto-generated constructor stub
    }
    
    public Akskorisnik registracija(String ime, String prezime, 
    		                        String username,String password,String email){
    	Akskorisnik kor2=em.find(Akskorisnik.class, "username");
    	if (kor2.equals(null))
    	{
    		kor2=new Akskorisnik();
    		kor2.setAksaukcijas1(new LinkedList<Aksaukcija>());
    		kor2.setAksaukcijas2(new LinkedList<Aksaukcija>());
    		kor2.setAksponudas(new LinkedList<Aksponuda>());
    		kor2.setEmail(email);
    		kor2.setIme(prezime);
    		kor2.setPassword(password);
    		kor2.setPrezime(prezime);
    		kor2.setUsername(username);
    		em.persist(kor2);
    		return kor2;
    	}
    	return null;
    }
    
    public Akskorisnik login(String username, String password){
    	Akskorisnik kor2=em.find(Akskorisnik.class, "username");
    	if (kor2.equals(null))
    	{
    		if (kor2.getPassword().equals(password))
    		{
    			return kor2;
    		}
    		else
    		{
    			return null;
    		}
    		
    	}
    	return null;
    }
    
    public Aksaukcija novaAukcija(Akskorisnik vlasnik, Akspredmet predmet, int dan, int sat){
    	Aksaukcija a=new Aksaukcija();
    	a.setAkskomentars(new LinkedList<Akskomentar>());
    	a.setAkskorisnik1(vlasnik);
    	a.setAkskorisnik2(null);
    	a.setAksponudas(new LinkedList<Aksponuda>());
    	a.setAksporukas(new LinkedList<Aksporuka>());
    	a.setAkspredmet(predmet);
    	a.setUspesna(false);
    	int duzina=24*dan+sat;
    	Date d=new Date();
    	d.setTime(d.getTime()+3600*1000*duzina);
    	SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss");
    	String vreme=ft.format(d);
    	a.setVreme(vreme);
    	em.persist(a);
    	return a;
    }
    
    public Akspredmet novPredmet(String naziv, String opis, String stanje, float pocetnaCena, String pathSlika){
    	Akspredmet p=new Akspredmet();
    	p.setAksaukcijas(new LinkedList<Aksaukcija>());
    	p.setNaziv(naziv);
    	p.setOpis(opis);
    	p.setPocetnaCena(pocetnaCena);
    	p.setStanje(stanje);
    	//TODO slika from pathslika
    	int slika=0; //DELETE IT LATER
    	p.setSlika(slika);
    	em.persist(p);
		return p;
    }
    
    
    public List<Aksaukcija> aukcijeNazivSve(String naziv){
    	TypedQuery<Aksaukcija> query = em.createQuery
    									("SELECT auk FROM Aksaukcija auk WHERE auk.akspredmet.naziv LIKE '%:naziv%' ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("naziv", naziv);
        List<Aksaukcija> list = query.getResultList(); 
        return list;
    }
    
    public List<Aksaukcija> aukcijeNazivAktivne(String naziv){
    	TypedQuery<Aksaukcija> query = em.createQuery
    									("SELECT auk FROM Aksaukcija auk WHERE (auk.akspredmet.naziv LIKE '%:naziv%' AND auk.vreme>:vreme) ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("naziv", naziv);
    	Date d=new Date();
    	d.setTime(d.getTime());
    	SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss");
    	String vreme=ft.format(d);
    	query.setParameter("vreme", vreme);
        List<Aksaukcija> list = query.getResultList(); 
        return list;
    }
    
    public List<Aksaukcija> aukcijeNazivZavrsene(String naziv){
    	TypedQuery<Aksaukcija> query = em.createQuery
    									("SELECT auk FROM Aksaukcija auk WHERE (auk.akspredmet.naziv LIKE '%:naziv%' AND auk.vreme<:vreme) ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("naziv", naziv);
    	Date d=new Date();
    	d.setTime(d.getTime());
    	SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss");
    	String vreme=ft.format(d);
    	query.setParameter("vreme", vreme);
        List<Aksaukcija> list = query.getResultList(); 
        return list;
    }
    
    public List<Aksaukcija> aukcijeNazivVlasnikSve(String naziv, String vlasnik){
    	TypedQuery<Aksaukcija> query = em.createQuery
    									("SELECT auk FROM Aksaukcija auk WHERE (auk.akspredmet.naziv LIKE '%:naziv%' AND auk.akskorisnik1.username LIKE '%:vlasnik%') ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("naziv", naziv);
    	query.setParameter("vlasnik", vlasnik);
        List<Aksaukcija> list = query.getResultList(); 
        return list;
    }
    
    public List<Aksaukcija> aukcijeNazivVlasnikAktivne(String naziv, String vlasnik){
    	TypedQuery<Aksaukcija> query = em.createQuery
    									("SELECT auk FROM Aksaukcija auk WHERE (auk.akspredmet.naziv LIKE '%:naziv%' AND auk.akskorisnik1.username LIKE '%:vlasnik%' AND auk.vreme>:vreme) ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("naziv", naziv);
    	query.setParameter("vlasnik", vlasnik);
    	Date d=new Date();
    	d.setTime(d.getTime());
    	SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss");
    	String vreme=ft.format(d);
    	query.setParameter("vreme", vreme);
        List<Aksaukcija> list = query.getResultList(); 
        return list;
    }
    
    public List<Aksaukcija> aukcijeNazivVlasnikZavrsene(String naziv, String vlasnik){
    	TypedQuery<Aksaukcija> query = em.createQuery
    									("SELECT auk FROM Aksaukcija auk WHERE (auk.akspredmet.naziv LIKE '%:naziv%' AND auk.akskorisnik1.username LIKE '%:vlasnik%' AND auk.vreme<:vreme) ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("naziv", naziv);
    	query.setParameter("vlasnik", vlasnik);
    	Date d=new Date();
    	d.setTime(d.getTime());
    	SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss");
    	String vreme=ft.format(d);
    	query.setParameter("vreme", vreme);
        List<Aksaukcija> list = query.getResultList(); 
        return list;
    }
    
    public List<Aksaukcija> aukcijeNazivStanjeSve(String naziv, String stanje){
    	TypedQuery<Aksaukcija> query = em.createQuery
    									("SELECT auk FROM Aksaukcija auk WHERE (auk.akspredmet.naziv LIKE '%:naziv%' AND auk.akspredmet.stanje LIKE ':stanje') ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("naziv", naziv);
    	query.setParameter("stanje", stanje);
        List<Aksaukcija> list = query.getResultList(); 
        return list;
    }
    
    public List<Aksaukcija> aukcijeNazivStanjeAktivne(String naziv, String stanje){
    	TypedQuery<Aksaukcija> query = em.createQuery
    									("SELECT auk FROM Aksaukcija auk WHERE (auk.akspredmet.naziv LIKE '%:naziv%' AND auk.akspredmet.stanje LIKE ':stanje' AND auk.vreme>:vreme) ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("naziv", naziv);
    	query.setParameter("stanje", stanje);
    	Date d=new Date();
    	d.setTime(d.getTime());
    	SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss");
    	String vreme=ft.format(d);
    	query.setParameter("vreme", vreme);
        List<Aksaukcija> list = query.getResultList(); 
        return list;
    }
    
    public List<Aksaukcija> aukcijeNazivStanjeZavrsene(String naziv, String stanje){
    	TypedQuery<Aksaukcija> query = em.createQuery
    									("SELECT auk FROM Aksaukcija auk WHERE (auk.akspredmet.naziv LIKE '%:naziv%' AND auk.akspredmet.stanje LIKE ':stanje' AND auk.vreme<:vreme) ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("naziv", naziv);
    	query.setParameter("stanje", stanje);
    	Date d=new Date();
    	d.setTime(d.getTime());
    	SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss");
    	String vreme=ft.format(d);
    	query.setParameter("vreme", vreme);
        List<Aksaukcija> list = query.getResultList(); 
        return list;
    }
    
    public List<Aksaukcija> aukcijeNazivCenaSve(String naziv, float c1, float c2){
    	TypedQuery<Aksaukcija> query = em.createQuery
    									("SELECT auk FROM Aksaukcija auk WHERE (auk.akspredmet.naziv LIKE '%:naziv%' AND auk.akspredmet.stanje LIKE ':stanje') ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("naziv", naziv);
    	//TODO
        List<Aksaukcija> list = query.getResultList(); 
        return list;
    }
    
    public List<Aksaukcija> aukcijeNazivCenaAktivne(String naziv, float c1, float c2){
    	TypedQuery<Aksaukcija> query = em.createQuery
    									("SELECT auk FROM Aksaukcija auk WHERE (auk.akspredmet.naziv LIKE '%:naziv%' AND auk.akspredmet.stanje LIKE ':stanje' AND auk.vreme>:vreme) ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("naziv", naziv);
    	//TODO
    	Date d=new Date();
    	d.setTime(d.getTime());
    	SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss");
    	String vreme=ft.format(d);
    	query.setParameter("vreme", vreme);
        List<Aksaukcija> list = query.getResultList(); 
        return list;
    }
    
    public List<Aksaukcija> aukcijeNazivCenaZavrsene(String naziv, float c1, float c2){
    	TypedQuery<Aksaukcija> query = em.createQuery
    									("SELECT auk FROM Aksaukcija auk WHERE (auk.akspredmet.naziv LIKE '%:naziv%' AND auk.akspredmet.stanje LIKE ':stanje' AND auk.vreme<:vreme) ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("naziv", naziv);
    	//TODO
    	Date d=new Date();
    	d.setTime(d.getTime());
    	SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss");
    	String vreme=ft.format(d);
    	query.setParameter("vreme", vreme);
        List<Aksaukcija> list = query.getResultList(); 
        return list;
    }

}
