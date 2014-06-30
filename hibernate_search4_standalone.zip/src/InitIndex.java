import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.avro.Protocol;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.store.impl.FSDirectoryProvider;

import entity.Book;




public class InitIndex {
public static void main(String[] args) {
	  EntityManagerFactory emf =  
	          Persistence.createEntityManagerFactory("customerManager");
		  EntityManager em = emf.createEntityManager(); 
	 Search.getFullTextEntityManager(em).createIndexer(Book.class).start();
	 em.close();
	 Protocol protocol;
}
}
