package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Aksporuka database table.
 * 
 */
@Entity
@NamedQuery(name="Aksporuka.findAll", query="SELECT a FROM Aksporuka a")
public class Aksporuka implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PORUKA_ID")
	private int porukaId;

	private String datump;

	private byte prodavacp;

	private String tekstp;

	//bi-directional many-to-one association to Aksaukcija
	@ManyToOne
	@JoinColumn(name="AUKCIJA_ID")
	private Aksaukcija aksaukcija;

	public Aksporuka() {
	}

	public int getPorukaId() {
		return this.porukaId;
	}

	public void setPorukaId(int porukaId) {
		this.porukaId = porukaId;
	}

	public String getDatump() {
		return this.datump;
	}

	public void setDatump(String datump) {
		this.datump = datump;
	}

	public boolean getProdavacp() {
		return this.prodavacp!=0;
	}

	public void setProdavacp(boolean prodavacp) {
		byte pro=1;
		if (prodavacp==false)
			pro=0;
		this.prodavacp = pro;
	}

	public String getTekstp() {
		return this.tekstp;
	}

	public void setTekstp(String tekstp) {
		this.tekstp = tekstp;
	}

	public Aksaukcija getAksaukcija() {
		return this.aksaukcija;
	}

	public void setAksaukcija(Aksaukcija aksaukcija) {
		this.aksaukcija = aksaukcija;
	}

}