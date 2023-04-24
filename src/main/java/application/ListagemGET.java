package application;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import domain.Arma;

public class ListagemGET {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gunsmith");
		EntityManager em = emf.createEntityManager();
		
		
		Query query = em.createQuery("select i from Arma i");
		List<Arma> armas = query.getResultList();
			for (Arma arma : armas) {
				System.out.println("\nArma n*:" + arma.getId() +"\n" + "Fabricante:" + arma.getFabricante() + "\n" + "Nome: " + arma.getNome()+"\n" + "Raridade: " + arma.getRaridade()+"\n" + "Preco: " + arma.getPreco());
		}
		
		em.close();
		emf.close();
	}

}
