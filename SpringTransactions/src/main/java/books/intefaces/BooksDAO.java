package books.intefaces;

import java.util.List;

import books.objects.Books;



public interface BooksDAO {

	int insert(Books books);

	int insert(List<Books> booksList);

	void delete(Books books);

	void delete(int id);

	Books getBooksByID(int id);

	List<Books> getBooksListByBook(String book);

	List<Books> getMP3ListByAuthor(String author);

	int getBooksCount();
	
	
}
