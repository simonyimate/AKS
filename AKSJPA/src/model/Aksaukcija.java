package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Aksaukcija database table.
 * 
 */
@Entity
@NamedQuery(name="Aksaukcija.findAll", query="SELECT a FROM Aksaukcija a")
public class Aksaukcija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AUKCIJA_ID")
	private int aukcijaId;

	private float najvecaponuda;

	private byte uspesna;

	private String vreme;

	//bi-directional many-to-one association to Akskorisnik
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private Akskorisnik akskorisnik1;

	//bi-directional many-to-one association to Akskorisnik
	@ManyToOne
	@JoinColumn(name="AKS_USERNAME")
	private Akskorisnik akskorisnik2;

	//bi-directional many-to-one association to Akspredmet
	@ManyToOne
	@JoinColumn(name="PREDMET_ID")
	private Akspredmet akspredmet;

	//bi-directional many-to-one association to Akskomentar
	@OneToMany(mappedBy="aksaukcija")
	private List<Akskomentar> akskomentars;

	//bi-directional many-to-one association to Aksponuda
	@OneToMany(mappedBy="aksaukcija")
	private List<Aksponuda> aksponudas;

	//bi-directional many-to-one association to Aksporuka
	@OneToMany(mappedBy="aksaukcija")
	private List<Aksporuka> aksporukas;

	public Aksaukcija() {
	}

	public int getAukcijaId() {
		return this.aukcijaId;
	}

	public void setAukcijaId(int aukcijaId) {
		this.aukcijaId = aukcijaId;
	}

	public float getNajvecaponuda() {
		return this.najvecaponuda;
	}

	public void setNajvecaponuda(float najvecaponuda) {
		this.najvecaponuda = najvecaponuda;
	}

	public boolean getUspesna() {
		return this.uspesna!=0;
	}

	public void setUspesna(boolean uspesna) {
		if (uspesna)
			this.uspesna = 1;
		else
			this.uspesna=0;
	}

	public String getVreme() {
		return this.vreme;
	}

	public void setVreme(String vreme) {
		this.vreme = vreme;
	}

	public Akskorisnik getAkskorisnik1() {
		return this.akskorisnik1;
	}

	public void setAkskorisnik1(Akskorisnik akskorisnik1) {
		this.akskorisnik1 = akskorisnik1;
	}

	public Akskorisnik getAkskorisnik2() {
		return this.akskorisnik2;
	}

	public void setAkskorisnik2(Akskorisnik akskorisnik2) {
		this.akskorisnik2 = akskorisnik2;
	}

	public Akspredmet getAkspredmet() {
		return this.akspredmet;
	}

	public void setAkspredmet(Akspredmet akspredmet) {
		this.akspredmet = akspredmet;
	}

	public List<Akskomentar> getAkskomentars() {
		return this.akskomentars;
	}

	public void setAkskomentars(List<Akskomentar> akskomentars) {
		this.akskomentars = akskomentars;
	}

	public Akskomentar addAkskomentar(Akskomentar akskomentar) {
		getAkskomentars().add(akskomentar);
		akskomentar.setAksaukcija(this);

		return akskomentar;
	}

	public Akskomentar removeAkskomentar(Akskomentar akskomentar) {
		getAkskomentars().remove(akskomentar);
		akskomentar.setAksaukcija(null);

		return akskomentar;
	}

	public List<Aksponuda> getAksponudas() {
		return this.aksponudas;
	}

	public void setAksponudas(List<Aksponuda> aksponudas) {
		this.aksponudas = aksponudas;
	}

	public Aksponuda addAksponuda(Aksponuda aksponuda) {
		getAksponudas().add(aksponuda);
		aksponuda.setAksaukcija(this);

		return aksponuda;
	}

	public Aksponuda removeAksponuda(Aksponuda aksponuda) {
		getAksponudas().remove(aksponuda);
		aksponuda.setAksaukcija(null);

		return aksponuda;
	}

	public List<Aksporuka> getAksporukas() {
		return this.aksporukas;
	}

	public void setAksporukas(List<Aksporuka> aksporukas) {
		this.aksporukas = aksporukas;
	}

	public Aksporuka addAksporuka(Aksporuka aksporuka) {
		getAksporukas().add(aksporuka);
		aksporuka.setAksaukcija(this);

		return aksporuka;
	}

	public Aksporuka removeAksporuka(Aksporuka aksporuka) {
		getAksporukas().remove(aksporuka);
		aksporuka.setAksaukcija(null);

		return aksporuka;
	}

}