package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Akskomentar database table.
 * 
 */
@Entity
@NamedQuery(name="Akskomentar.findAll", query="SELECT a FROM Akskomentar a")
public class Akskomentar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="KOMENTAR_ID")
	private int komentarId;

	private String datumk;

	private int ocena;

	private byte prodavack;

	private String tekstk;

	//bi-directional many-to-one association to Aksaukcija
	@ManyToOne
	@JoinColumn(name="AUKCIJA_ID")
	private Aksaukcija aksaukcija;

	public Akskomentar() {
	}

	public int getKomentarId() {
		return this.komentarId;
	}

	public void setKomentarId(int komentarId) {
		this.komentarId = komentarId;
	}

	public String getDatumk() {
		return this.datumk;
	}

	public void setDatumk(String datumk) {
		this.datumk = datumk;
	}

	public int getOcena() {
		return this.ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public boolean getProdavack() {
		return this.prodavack!=0;
	}

	public void setProdavack(boolean prodavack) {
		byte pro=1;
		if (prodavack==false)
			pro=0;
		this.prodavack = pro;
	}

	public String getTekstk() {
		return this.tekstk;
	}

	public void setTekstk(String tekstk) {
		this.tekstk = tekstk;
	}

	public Aksaukcija getAksaukcija() {
		return this.aksaukcija;
	}

	public void setAksaukcija(Aksaukcija aksaukcija) {
		this.aksaukcija = aksaukcija;
	}

}