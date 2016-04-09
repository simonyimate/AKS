package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Akspredmet database table.
 * 
 */
@Entity
@NamedQuery(name="Akspredmet.findAll", query="SELECT a FROM Akspredmet a")
public class Akspredmet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PREDMET_ID")
	private int predmetId;

	private String naziv;

	private String opis;

	@Column(name="POCETNA_CENA")
	private float pocetnaCena;
	
	//TODO Menjati za sliku
	private int slika;

	private String stanje;

	//bi-directional many-to-one association to Aksaukcija
	@OneToMany(mappedBy="akspredmet")
	private List<Aksaukcija> aksaukcijas;

	public Akspredmet() {
	}

	public int getPredmetId() {
		return this.predmetId;
	}

	public void setPredmetId(int predmetId) {
		this.predmetId = predmetId;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public float getPocetnaCena() {
		return this.pocetnaCena;
	}

	public void setPocetnaCena(float pocetnaCena) {
		this.pocetnaCena = pocetnaCena;
	}

	public int getSlika() {
		return this.slika;
	}

	public void setSlika(int slika) {
		this.slika = slika;
	}

	public String getStanje() {
		return this.stanje;
	}

	public void setStanje(String stanje) {
		this.stanje = stanje;
	}

	public List<Aksaukcija> getAksaukcijas() {
		return this.aksaukcijas;
	}

	public void setAksaukcijas(List<Aksaukcija> aksaukcijas) {
		this.aksaukcijas = aksaukcijas;
	}

	public Aksaukcija addAksaukcija(Aksaukcija aksaukcija) {
		getAksaukcijas().add(aksaukcija);
		aksaukcija.setAkspredmet(this);

		return aksaukcija;
	}

	public Aksaukcija removeAksaukcija(Aksaukcija aksaukcija) {
		getAksaukcijas().remove(aksaukcija);
		aksaukcija.setAkspredmet(null);

		return aksaukcija;
	}

}