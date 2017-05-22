package books.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import books.objects.Books;
import books.sqlite.SQLiteDAO;

public class Main {

	public static void main(String[] args) {
		Books books = new Books();
		books.setAuthor("Billy");
		books.setBook("SandersonTheHawk");
		books.setYear(1934);
//		books.setId(2);
		Books booksSimple = new Books();
		booksSimple.setAuthor("LordVilliams");
		booksSimple.setBook("JavaForJuniors");
		booksSimple.setYear(2005);
		
		List<Books> list = new ArrayList<>();
		list.add(books);
		list.add(booksSimple);
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		
		SQLiteDAO sqLiteDAO = (SQLiteDAO) context.getBean("sqliteDAO");
		
        //	sqLiteDAO.insert(booksSimple);

		//	sqLiteDAO.insertSimple(booksSimple);	

		//		sqLiteDAO.insert(list);

//				sqLiteDAO.getBooksByID(3);
//		System.out.println(sqLiteDAO.getBooksCount());
//	System.out.println(	sqLiteDAO.getMP3ListByAuthor(books.getAuthor()));
		
		
		
	
	}

}
