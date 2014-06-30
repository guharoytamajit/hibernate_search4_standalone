

import java.io.IOException;
import java.util.List;

import org.apache.lucene.queryParser.ParseException;


@SuppressWarnings("serial")
public class SearchController  {



	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws IOException {
		
		List result = null;
		try {
			SearchDAO searchDAO = new SearchDAO();
			String searchKey="action";
			result = searchDAO.doSearching(searchKey);
			System.out.println("size of result : " + result);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	

	}


}