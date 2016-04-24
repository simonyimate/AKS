package bean;

import java.util.List;

import javax.ejb.Local;

import model.Aksaukcija;
import model.Akskorisnik;
import model.Aksponuda;
import model.Aksporuka;
import model.Akspredmet;

@Local
public interface AksMainLocal {
	public Akskorisnik registracija(String ime, String prezime, 
            String username,String password,String email);
	public Akskorisnik login(String username, String password);
	public Aksaukcija novaAukcija(Akskorisnik vlasnik, Akspredmet predmet, int dan, int sat);
	public Akspredmet novPredmet(String naziv, String opis, String stanje, float pocetnaCena, String pathSlika);
	public Aksponuda novaPonuda(String username, int aukcijaId, float vrednost);
	public Aksporuka novaPorukaP(int aukcijaId, String text);
	public Aksporuka novaPorukaK(int aukcijaId, String text);
	 public List<Aksaukcija> aukcijeNazivSve(String naziv);
	 public List<Aksaukcija> aukcijeNazivAktivne(String naziv);
	 public List<Aksaukcija> aukcijeNazivZavrsene(String naziv);
	 public List<Aksaukcija> aukcijeNazivVlasnikSve(String naziv, String vlasnik);
	 public List<Aksaukcija> aukcijeNazivVlasnikAktivne(String naziv, String vlasnik);
	 public List<Aksaukcija> aukcijeNazivVlasnikZavrsene(String naziv, String vlasnik);
	 public List<Aksaukcija> aukcijeNazivStanjeSve(String naziv, String stanje);
	 public List<Aksaukcija> aukcijeNazivStanjeAktivne(String naziv, String stanje);
	 public List<Aksaukcija> aukcijeNazivStanjeZavrsene(String naziv, String stanje);
	 public List<Aksaukcija> aukcijeNazivCenaSve(String naziv, float c1, float c2);
	 public List<Aksaukcija> aukcijeNazivCenaAktivne(String naziv, float c1, float c2);
	 public List<Aksaukcija> aukcijeNazivCenaZavrsene(String naziv, float c1, float c2);
	 public List<Aksaukcija> aukcijeReportP(String vlasnik);
	 public List<Aksaukcija> aukcijeReportK(String vlasnik);
	 public List<Aksaukcija> aukcijeListP(String vlasnik);
	 public List<Aksaukcija> aukcijeListK(String vlasnik);
	 public List<Aksporuka> porukaList(int aukcijaId);
}
