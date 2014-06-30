

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.WildcardQuery;
import org.apache.lucene.util.Version;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;

import entity.Author;
import entity.Book;



public class SearchDAO {



	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List doSearching(String searchKey) throws ParseException {
		System.out.println("searchKey : " + searchKey);
		EntityManager entityManager = SessionManger.getEntityManager();
		
		  FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		  QueryParser  parser=new MultiFieldQueryParser(Version.LUCENE_30,new String[]{"title"}, new StandardAnalyzer(Version.LUCENE_30));
		  
		  Query parse = parser.parse(searchKey);
		
		  FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(parse, Book.class);
		  
		  
	
		    fullTextQuery.setFirstResult(0);
		    fullTextQuery.setMaxResults(10);
		    List results = fullTextQuery.getResultList();
		    for (Object book : results) {
				System.out.println((Book)book);
			}
		    return results;
	}
	
}