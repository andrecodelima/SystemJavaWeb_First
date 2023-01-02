package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
	
//		INSERINDO UMA PESSOA NO BANCO DE DADOS
		
//		Pessoa p1 = new Pessoa(null, "Carlos Lima", "carlos@hotmail.com");
//		Pessoa p2 = new Pessoa(null, "Rozana Silva", "rose21@hotmail.com");
//		Pessoa p3 = new Pessoa(null, "Lorena Maia", "lomaia@gmail.com");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("teste-jpa"); //Cria a conexao com o banco
		EntityManager em = emf.createEntityManager();
		
//		em.getTransaction().begin(); -- Transação. Sempre deve haver uma transação quando for inserir ou remover um registro.
//		em.persist(p1);
//		em.persist(p2);
//		em.persist(p3);
//		em.getTransaction().commit();

		
//		BUSCANDO UMA PESSOA NO BANCO DE DADOS
		
		Pessoa p = em.find(Pessoa.class, 2); //Params: Classe e ID
		System.out.println("Pessoa encontrada: " + p);
		
//		REMOVENDO UMA PESSOA NO BANCO DE DADOS
		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println("Feito!");

		em.close();
		emf.close();
		

	}

}
