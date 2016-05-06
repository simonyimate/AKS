package bean;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
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
 * Session Bean implementation class AksMain
 */
@Stateful
@LocalBean
public class AksMain implements AksMainRemote, AksMainLocal {
	@PersistenceContext
	EntityManager em;
	private Akskorisnik user;
    /**
     * Default constructor. 
     */
    public AksMain() {
        // TODO Auto-generated constructor stub
    }
    public Akskorisnik registracija(String ime, String prezime, 
    		                        String username,String password,String email){
    	Akskorisnik kor2=em.find(Akskorisnik.class, username);
    	if (kor2==null)
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
    		em.merge(kor2);
    		return kor2;
    	}
    	return null;
    }
	public Akskorisnik login(String username, String password){
		System.out.println(username);
		System.out.println(password);
    	Akskorisnik kor2=em.find(Akskorisnik.class, username);
    	if (kor2!=null)
    	{
    		System.out.println("NOT NULL");
    		System.out.println(kor2.getIme()+""+kor2.getPrezime());
    		if (kor2.getPassword().equals(password))
    		{	
    			user=kor2;
    			return kor2;
    		}
    		else
    		{	
    			user=null;
    			return null;
    		}
    		
    	}
    	return null;
    }
    
    public Aksaukcija novaAukcija(Akskorisnik vlasnik, Akspredmet predmet, int dan, int sat){
    	Aksaukcija a=new Aksaukcija();
    	a.setAkskomentars(new LinkedList<Akskomentar>());
    	a.setAkskorisnik1(user);
    	a.setAkskorisnik2(null);
    	a.setAksponudas(new LinkedList<Aksponuda>());
    	a.setAksporukas(new LinkedList<Aksporuka>());
    	a.setAkspredmet(predmet);
    	a.setUspesna(false);
    	a.setNajvecaponuda(predmet.getPocetnaCena());
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
    	//byte[] slika=new byte[300]; //DELETE IT LATER
    	File file = new File(pathSlika);
        byte[] imageData  = new byte[(int) file.length()];
        
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(imageData);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    	p.setSlika(imageData);
    	em.persist(p);
		return p;
    }
    
    public Aksponuda novaPonuda(String username, int aukcijaId, float vrednost){
    	System.out.println("AID "+aukcijaId+" vrednost "+vrednost);
    	if(user==null){
    		return null;
    	}
    	username=user.getUsername();
    	Akskorisnik kor=em.find(Akskorisnik.class, username);
    	System.out.println("USER OK "+user.getUsername());
    	if (kor!=null)
    	{
    		System.out.println("Korisnik FOUND");
    		Aksaukcija auk=em.find(Aksaukcija.class, aukcijaId);
        	if (auk!=null)
        	{
        		System.out.println("Aukcija FOUND");
        		Date d=new Date();
            	d.setTime(d.getTime());
            	SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss");
            	String vreme=ft.format(d);
        		if (auk.getVreme().compareTo(vreme)>0)
            	{
        			System.out.println("Nezavrsena FOUND");
        			if(auk.getNajvecaponuda()<vrednost)
	        		{
        				System.out.println("Dobar vrednost FOUND");
        				Aksponuda pon=new Aksponuda();
	        			pon.setAksaukcija(auk);
	        			pon.setAkskorisnik(kor);
	        			pon.setVrednost(vrednost);
	        			List<Aksponuda> list=auk.getAksponudas();
	        			list.add(pon);
	        			auk.setAksponudas(list);
	        			auk.setNajvecaponuda(vrednost);
	        			em.merge(pon);
	        			em.merge(auk);
	        			return pon;
	        		}
	        		else
	        		{
	        			System.out.println("Los vrednost FOUND");
	        			Aksponuda pon=new Aksponuda();
	        			pon.setVrednost(-1.0f);
	        			return pon;
	        		}
            	}
        		else{
        			System.out.println("Zavrsena aukcija FOUND");
        			Aksponuda pon=new Aksponuda();
        			pon.setVrednost(-2.0f);
        			return pon;
        		}
        	}
    	}
    	
    	return null;
    }
    
    public Aksporuka novaPorukaP(int aukcijaId, String text){
    	Aksaukcija auk=em.find(Aksaukcija.class, aukcijaId);
        if (auk!=null)
        {
        		Aksporuka por=new Aksporuka();
        		por.setAksaukcija(auk);
        		por.setTekstp(text);
        		por.setProdavacp(true);
        		Date d=new Date();
            	SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss");
            	String vreme=ft.format(d);
            	por.setDatump(vreme);
            	List<Aksporuka> list= auk.getAksporukas();
            	list.add(por);
            	auk.setAksporukas(list);
            	em.merge(por);
            	em.merge(auk);
            	return por;
    	}
    	return null;
    }
    
    public Aksporuka novaPorukaK(int aukcijaId, String text){
    	Aksaukcija auk=em.find(Aksaukcija.class, aukcijaId);
        if (auk!=null)
        {
        		Aksporuka por=new Aksporuka();
        		por.setAksaukcija(auk);
        		por.setTekstp(text);
        		por.setProdavacp(false);
        		Date d=new Date();
            	SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss");
            	String vreme=ft.format(d);
            	por.setDatump(vreme);
            	List<Aksporuka> list= auk.getAksporukas();
            	list.add(por);
            	auk.setAksporukas(list);
            	em.merge(por);
            	em.merge(auk);
            	return por;
    	}
    	return null;
    }
    
    public Akskomentar novKommentarP(int aukcijaId, String text, int ocena){
    	Aksaukcija auk=em.find(Aksaukcija.class, aukcijaId);
        if (auk!=null)
        {
        		if ((ocena<1)||(ocena>5)){
        			return null;
        		}
        		Akskomentar kom=new Akskomentar();
        		kom.setAksaukcija(auk);
        		kom.setTekstk(text);        		
        		kom.setOcena(ocena);
        		kom.setProdavack(true);
        		Date d=new Date();
            	SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss");
            	String vreme=ft.format(d);
            	kom.setDatumk(vreme);
            	List<Akskomentar> list= auk.getAkskomentars();
            	list.add(kom);
            	auk.setAkskomentars(list);
            	em.merge(kom);
            	em.merge(kom);
            	return kom;
    	}
    	return null;
    }
    public Akskomentar novKommentarK(int aukcijaId, String text, int ocena){
    	Aksaukcija auk=em.find(Aksaukcija.class, aukcijaId);
        if (auk!=null)
        {
        		if ((ocena<1)||(ocena>5)){
        			return null;
        		}
        		Akskomentar kom=new Akskomentar();
        		kom.setAksaukcija(auk);
        		kom.setTekstk(text);        		
        		kom.setOcena(ocena);
        		kom.setProdavack(false);
        		Date d=new Date();
            	SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss");
            	String vreme=ft.format(d);
            	kom.setDatumk(vreme);
            	List<Akskomentar> list= auk.getAkskomentars();
            	list.add(kom);
            	auk.setAkskomentars(list);
            	em.merge(kom);
            	em.merge(kom);
            	return kom;
    	}
    	return null;
    }
    
    public List<Akskomentar> kommentarP(String username){
    	TypedQuery<Akskomentar> query = em.createQuery
    									("SELECT kom FROM Akskomentar kom WHERE kom.aksaukcija.akskorisnik1.username = :username ORDER BY kom.aksaukcija.vreme",
                Akskomentar.class);
    	query.setParameter("username", username);
        return query.getResultList();
    }
    public List<Akskomentar> kommentarK(String username){
    	TypedQuery<Akskomentar> query = em.createQuery
    									("SELECT kom FROM Akskomentar kom WHERE kom.aksaukcija.akskorisnik2.username = :username ORDER BY kom.aksaukcija.vreme",
                Akskomentar.class);
    	query.setParameter("username", username);
        return query.getResultList();
    }
    
    public List<Aksaukcija> aukcijeNazivSve(String naziv){
    	TypedQuery<Aksaukcija> query = em.createQuery
    									("SELECT auk FROM Aksaukcija auk WHERE auk.akspredmet.naziv LIKE :naziv ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("naziv", "%"+naziv+"%");
        List<Aksaukcija> list = query.getResultList();
        System.out.println("List in the aukcijeNazivSve");
        for (Aksaukcija aksaukcija : list) {
			System.out.println(aksaukcija.getAkspredmet().getNaziv());
			System.out.println(aksaukcija.getAkspredmet().getPredmetId());
		}
        return list;
    }
    
    public List<Aksaukcija> aukcijeNazivAktivne(String naziv){
    	TypedQuery<Aksaukcija> query = em.createQuery
    									("SELECT auk FROM Aksaukcija auk WHERE (auk.akspredmet.naziv LIKE :naziv AND auk.vreme>:vreme) ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("naziv", "%"+naziv+"%");
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
    									("SELECT auk FROM Aksaukcija auk WHERE (auk.akspredmet.naziv LIKE :naziv AND auk.vreme<:vreme) ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("naziv", "%"+naziv+"%");
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
    									("SELECT auk FROM Aksaukcija auk WHERE (auk.akspredmet.naziv LIKE :naziv AND auk.akskorisnik1.username LIKE :vlasnik) ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("naziv", "%"+naziv+"%");
    	query.setParameter("vlasnik", "%"+vlasnik+"%");
        List<Aksaukcija> list = query.getResultList(); 
        return list;
    }
    
    public List<Aksaukcija> aukcijeNazivVlasnikAktivne(String naziv, String vlasnik){
    	TypedQuery<Aksaukcija> query = em.createQuery
    									("SELECT auk FROM Aksaukcija auk WHERE (auk.akspredmet.naziv LIKE :naziv AND auk.akskorisnik1.username LIKE :vlasnik AND auk.vreme>:vreme) ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("naziv", "%"+naziv+"%");
    	query.setParameter("vlasnik", "%"+vlasnik+"%");
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
    									("SELECT auk FROM Aksaukcija auk WHERE (auk.akspredmet.naziv LIKE :naziv AND auk.akskorisnik1.username LIKE :vlasnik AND auk.vreme<:vreme) ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("naziv", "%"+naziv+"%");
    	query.setParameter("vlasnik", "%"+vlasnik+"%");
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
    									("SELECT auk FROM Aksaukcija auk WHERE (auk.akspredmet.naziv LIKE :naziv AND auk.akspredmet.stanje LIKE :stanje) ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("naziv", "%"+naziv+"%");
    	query.setParameter("stanje", stanje);
        List<Aksaukcija> list = query.getResultList(); 
        return list;
    }
    
    public List<Aksaukcija> aukcijeNazivStanjeAktivne(String naziv, String stanje){
    	TypedQuery<Aksaukcija> query = em.createQuery
    									("SELECT auk FROM Aksaukcija auk WHERE (auk.akspredmet.naziv LIKE :naziv AND auk.akspredmet.stanje LIKE :stanje AND auk.vreme>:vreme) ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("naziv", "%"+naziv+"%");
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
    									("SELECT auk FROM Aksaukcija auk WHERE (auk.akspredmet.naziv LIKE :naziv AND auk.akspredmet.stanje LIKE :stanje AND auk.vreme<:vreme) ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("naziv", "%"+naziv+"%");
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
    									("SELECT auk FROM Aksaukcija auk WHERE (auk.akspredmet.naziv LIKE :naziv AND auk.najvecaponuda>:c1 AND auk.najvecaponuda<:c2) ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("naziv", "%"+naziv+"%");
    	query.setParameter("c1", c1-0.01f);
    	query.setParameter("c2", c2+0.01f);
        List<Aksaukcija> list = query.getResultList(); 
        return list;
    }
    
    public List<Aksaukcija> aukcijeNazivCenaAktivne(String naziv, float c1, float c2){
    	TypedQuery<Aksaukcija> query = em.createQuery
    									("SELECT auk FROM Aksaukcija auk WHERE (auk.akspredmet.naziv LIKE :naziv AND auk.najvecaponuda>:c1 AND auk.najvecaponuda<:c2 AND auk.vreme>:vreme) ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("naziv", "%"+naziv+"%");
    	query.setParameter("c1", c1-0.01f);
    	query.setParameter("c2", c2+0.01f);
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
    									("SELECT auk FROM Aksaukcija auk WHERE (auk.akspredmet.naziv LIKE :naziv AND auk.najvecaponuda>:c1 AND auk.najvecaponuda<:c2 AND auk.vreme<:vreme) ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("naziv", "%"+naziv+"%");
    	query.setParameter("c1", c1-0.01f);
    	query.setParameter("c2", c2+0.01f);
    	Date d=new Date();
    	d.setTime(d.getTime());
    	SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss");
    	String vreme=ft.format(d);
    	query.setParameter("vreme", vreme);
        List<Aksaukcija> list = query.getResultList(); 
        return list;
    }
   
    public List<Aksaukcija> aukcijeReportP(String vlasnik){
    	//return null;
    	
    	vlasnik=user.getUsername();
    	
    	TypedQuery<Aksaukcija> query = em.createQuery
    									("SELECT auk FROM Aksaukcija auk WHERE (auk.akskorisnik1.username LIKE :vlasnik AND auk.vreme<:vreme) ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("vlasnik", "%"+vlasnik+"%");
    	Date d=new Date();
    	d.setTime(d.getTime());
    	SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss");
    	String vreme=ft.format(d);
    	query.setParameter("vreme", vreme);
        List<Aksaukcija> list = query.getResultList();
        for (Aksaukcija aksaukcija : list) {
			if (!aksaukcija.getUspesna()){
				if (aksaukcija.getAksponudas().size()>0){
					aksaukcija.setUspesna(true);
					Aksponuda pon= aksaukcija.getAksponudas().get(aksaukcija.getAksponudas().size()-1);
					aksaukcija.setAkskorisnik2(pon.getAkskorisnik());
					em.merge(aksaukcija);
				}
			}
		}
        System.out.println("aukcijeReportP");
        System.out.println(vlasnik);
        for (Aksaukcija aksaukcija : list) {
			System.out.println(aksaukcija.getAkskorisnik1()+" "+aksaukcija.getAkspredmet().getNaziv());
		}
        System.out.println("aukcijeReportP");
        return list;
    }
    
    public List<Aksaukcija> aukcijeListP(String vlasnik){
    	//return null;
    	
    	vlasnik=user.getUsername();
    	TypedQuery<Aksaukcija> query = em.createQuery
    									("SELECT auk FROM Aksaukcija auk WHERE (auk.akskorisnik1.username LIKE :vlasnik AND auk.vreme<:vreme) ORDER BY auk.vreme",
                Aksaukcija.class);
    	query.setParameter("vlasnik", "%"+vlasnik+"%");
    	Date d=new Date();
    	d.setTime(d.getTime());
    	SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss");
    	String vreme=ft.format(d);
    	query.setParameter("vreme", vreme);
        List<Aksaukcija> list = query.getResultList();
        List<Aksaukcija> list2 = new LinkedList<Aksaukcija>();
        for (Aksaukcija aksaukcija : list) {
			if (!aksaukcija.getUspesna()){
				if (aksaukcija.getAksponudas().size()>0){
					aksaukcija.setUspesna(true);
					Aksponuda pon= aksaukcija.getAksponudas().get(aksaukcija.getAksponudas().size()-1);
					aksaukcija.setAkskorisnik2(pon.getAkskorisnik());
					em.merge(aksaukcija);
				}
			}
			if (aksaukcija.getUspesna()){
				list2.add(aksaukcija);
			}
		}
        return list2;
    }
    
    static class AukComparatorVreme implements Comparator<Aksaukcija>
    {
        public int compare(Aksaukcija a1, Aksaukcija a2)
        {
            return a1.getVreme().compareTo(a2.getVreme());
        }
     }
    
    public List<Aksaukcija> aukcijeReportK(String vlasnik){
    	//return null;
    	
    	vlasnik=user.getUsername();
    	TypedQuery<Aksponuda> query = em.createQuery
    									("SELECT pon FROM Aksponuda pon WHERE (pon.akskorisnik.username LIKE :vlasnik AND pon.aksaukcija.vreme<:vreme)", //ORDER BY pon.aksaukcija.vreme",
                Aksponuda.class);
    	query.setParameter("vlasnik", "%"+vlasnik+"%");
    	Date d=new Date();
    	d.setTime(d.getTime());
    	SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss");
    	String vreme=ft.format(d);
    	query.setParameter("vreme", vreme);
        List<Aksponuda> list = query.getResultList();
        List<Aksaukcija> list2 = new LinkedList<Aksaukcija>();
        
        for (Aksponuda aksponuda : list) {
        	Aksaukcija aksaukcija=aksponuda.getAksaukcija();
			if (!aksaukcija.getUspesna()){
				if (aksaukcija.getAksponudas().size()>0){
					aksaukcija.setUspesna(true);
					Aksponuda pon= aksaukcija.getAksponudas().get(aksaukcija.getAksponudas().size()-1);
					aksaukcija.setAkskorisnik2(pon.getAkskorisnik());
					em.merge(aksaukcija);
				}
			}
			if (!list2.contains(aksaukcija)){
					list2.add(aksaukcija);
			}
		}
        Collections.sort(list2, new AukComparatorVreme());
        return list2;
        
    }
    public List<Aksaukcija> aukcijeListK(String vlasnik){
    	//return null;
    	
    	vlasnik=user.getUsername();
    	TypedQuery<Aksponuda> query = em.createQuery
    									("SELECT pon FROM Aksponuda pon WHERE (pon.akskorisnik.username LIKE :vlasnik AND pon.aksaukcija.vreme<:vreme)", //ORDER BY pon.aksaukcija.vreme",
                Aksponuda.class);
    	query.setParameter("vlasnik", "%"+vlasnik+"%");
    	Date d=new Date();
    	d.setTime(d.getTime());
    	SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss");
    	String vreme=ft.format(d);
    	query.setParameter("vreme", vreme);
        List<Aksponuda> list = query.getResultList();
        List<Aksaukcija> list2 = new LinkedList<Aksaukcija>();
        
        for (Aksponuda aksponuda : list) {
        	Aksaukcija aksaukcija=aksponuda.getAksaukcija();
			if (!aksaukcija.getUspesna()){
				if (aksaukcija.getAksponudas().size()>0){
					aksaukcija.setUspesna(true);
					Aksponuda pon= aksaukcija.getAksponudas().get(aksaukcija.getAksponudas().size()-1);
					aksaukcija.setAkskorisnik2(pon.getAkskorisnik());
					em.merge(aksaukcija);
				}
			}
			if (!list2.contains(aksaukcija)){
				if (aksaukcija.getAkskorisnik2().getUsername().equals(vlasnik)){
					list2.add(aksaukcija);
				}	
			}
		}
        Collections.sort(list2, new AukComparatorVreme());
        return list2;
    }
     
    public List<Aksporuka> porukaList(int aukcijaId){
    	List<Aksporuka>list;
    	TypedQuery<Aksporuka> query = em.createQuery
				("SELECT por FROM Aksporuka por WHERE (por.aksaukcija.aukcijaId = :AID )", Aksporuka.class);
    	query.setParameter("AID", aukcijaId);
    	list = query.getResultList();
    	
    	/*Aksaukcija auk=em.find(Aksaukcija.class, aukcijaId);
        if (auk!=null)
        {
        		list=auk.getAksporukas();
    	}
        else{
        	list=new LinkedList<Aksporuka>();
        }*/
    	return list;
    }


}
