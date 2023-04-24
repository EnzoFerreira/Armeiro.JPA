package application;

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import domain.Arma;

public class ProgramaPOST {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gunsmith");
		EntityManager em = emf.createEntityManager();
		
		//Persistindo objetos POST
		em.getTransaction().begin();
		Arma arma1 = new Arma();
		
		arma1.setFabricante("Jakobs");
		arma1.setNome("Vagabond vision");
		arma1.setRaridade("Epico");
		arma1.setPreco(new BigDecimal(758));
		
		em.persist(arma1);
		em.getTransaction().commit();
		
		//Bonus: fazendo a busca no banco de dados pra confirmar
		/*
		Arma arma = em.find(Arma.class,1L);
		System.out.println("Arma cadastrada no ID: "+ arma.getId() + ", é do tipo " + arma.getModelo());
		*/
		
		em.close();
		emf.close();
	}

}
