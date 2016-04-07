package libJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Proba1 {
	public static void main(String[] args) {
		
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		Akspredmet k = new Akspredmet();
		/*k.setNaziv("Besnilo");
		k.setOpis("Pekic");
		k.setPocetnaCena(100.0f);
		k.setSlika(0);
		k.setStanje("novo");
		//entityManager.persist(k);
		Aksaukcija a = new Aksaukcija();
		//entityManager.persist(a);*/
		Akskorisnik kor = new Akskorisnik();
		kor.setIme("Besnilo");
		kor.setPrezime("Pekic");
		kor.setUsername("bp");
		kor.setPassword("bp");
		kor.setEmail("bb@gmail.com");
		/*Auto a=new Auto();
		a.setId("Yugo");*/
		entityManager.persist(kor);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}
}

