package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Arma;

public class UpdatePUT {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gunsmith");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		Arma arma = em.find(Arma.class, 4L);
		arma.setNome(arma.getNome().replace("Kilavolt","Kilovolt"));
		System.out.println("Alterado o nome para: "+ arma.getNome());
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
