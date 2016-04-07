package libJPA;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Akskorisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Akskorisnik.findAll", query="SELECT a FROM Akskorisnik a")
public class Akskorisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String username;

	private String email;

	private String ime;

	private String password;

	private String prezime;

	//bi-directional many-to-one association to Aksaukcija
	@OneToMany(mappedBy="akskorisnik1")
	private List<Aksaukcija> aksaukcijas1;

	//bi-directional many-to-one association to Aksaukcija
	@OneToMany(mappedBy="akskorisnik2")
	private List<Aksaukcija> aksaukcijas2;

	//bi-directional many-to-one association to Aksponuda
	@OneToMany(mappedBy="akskorisnik")
	private List<Aksponuda> aksponudas;

	public Akskorisnik() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Aksaukcija> getAksaukcijas1() {
		return this.aksaukcijas1;
	}

	public void setAksaukcijas1(List<Aksaukcija> aksaukcijas1) {
		this.aksaukcijas1 = aksaukcijas1;
	}

	public Aksaukcija addAksaukcijas1(Aksaukcija aksaukcijas1) {
		getAksaukcijas1().add(aksaukcijas1);
		aksaukcijas1.setAkskorisnik1(this);

		return aksaukcijas1;
	}

	public Aksaukcija removeAksaukcijas1(Aksaukcija aksaukcijas1) {
		getAksaukcijas1().remove(aksaukcijas1);
		aksaukcijas1.setAkskorisnik1(null);

		return aksaukcijas1;
	}

	public List<Aksaukcija> getAksaukcijas2() {
		return this.aksaukcijas2;
	}

	public void setAksaukcijas2(List<Aksaukcija> aksaukcijas2) {
		this.aksaukcijas2 = aksaukcijas2;
	}

	public Aksaukcija addAksaukcijas2(Aksaukcija aksaukcijas2) {
		getAksaukcijas2().add(aksaukcijas2);
		aksaukcijas2.setAkskorisnik2(this);

		return aksaukcijas2;
	}

	public Aksaukcija removeAksaukcijas2(Aksaukcija aksaukcijas2) {
		getAksaukcijas2().remove(aksaukcijas2);
		aksaukcijas2.setAkskorisnik2(null);

		return aksaukcijas2;
	}

	public List<Aksponuda> getAksponudas() {
		return this.aksponudas;
	}

	public void setAksponudas(List<Aksponuda> aksponudas) {
		this.aksponudas = aksponudas;
	}

	public Aksponuda addAksponuda(Aksponuda aksponuda) {
		getAksponudas().add(aksponuda);
		aksponuda.setAkskorisnik(this);

		return aksponuda;
	}

	public Aksponuda removeAksponuda(Aksponuda aksponuda) {
		getAksponudas().remove(aksponuda);
		aksponuda.setAkskorisnik(null);

		return aksponuda;
	}

}