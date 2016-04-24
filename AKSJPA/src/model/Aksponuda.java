package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Aksponuda database table.
 * 
 */
@Entity
@NamedQuery(name="Aksponuda.findAll", query="SELECT a FROM Aksponuda a")
public class Aksponuda implements Serializable, Comparable<Aksponuda>{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PONUDA_ID")
	private int ponudaId;

	private float vrednost;

	//bi-directional many-to-one association to Aksaukcija
	@ManyToOne
	@JoinColumn(name="AUKCIJA_ID")
	private Aksaukcija aksaukcija;

	//bi-directional many-to-one association to Akskorisnik
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private Akskorisnik akskorisnik;

	public Aksponuda() {
	}

	public int getPonudaId() {
		return this.ponudaId;
	}

	public void setPonudaId(int ponudaId) {
		this.ponudaId = ponudaId;
	}

	public float getVrednost() {
		return this.vrednost;
	}

	public void setVrednost(float vrednost) {
		this.vrednost = vrednost;
	}

	public Aksaukcija getAksaukcija() {
		return this.aksaukcija;
	}

	public void setAksaukcija(Aksaukcija aksaukcija) {
		this.aksaukcija = aksaukcija;
	}

	public Akskorisnik getAkskorisnik() {
		return this.akskorisnik;
	}

	public void setAkskorisnik(Akskorisnik akskorisnik) {
		this.akskorisnik = akskorisnik;
	}
	
	@Override
	public int compareTo(Aksponuda o) {
		if (this.getPonudaId()<o.getPonudaId()){
			return -1;
		}else if (this.getPonudaId()==o.getPonudaId()){
			return 0;
		}else{
			return 1;
		}
		
	}
}