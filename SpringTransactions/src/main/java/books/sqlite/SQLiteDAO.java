package books.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import books.intefaces.BooksDAO;
import books.objects.Books;



@Component("sqliteDAO")
public class SQLiteDAO implements BooksDAO{
	
	
	private SimpleJdbcInsert insertBooks;
	private DataSource dataSource;
	private NamedParameterJdbcTemplate jdbcTemplate;
		
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.insertBooks = new SimpleJdbcInsert(dataSource).withTableName("BooksDB").usingColumns("author", "book", "year");
		this.dataSource = dataSource;
	   
	}


	@Override
	public int insert(Books books) {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("author", books.getAuthor());
		params.addValue("book", books.getBook());
		params.addValue("year", books.getYear());
		

		return insertBooks.execute(params);
		
	}

	public int insertSimple(Books books){ //insert by SimpleJdbcInsert --- docs spring 19.4*
		MapSqlParameterSource p = new MapSqlParameterSource();
		p.addValue("author",books.getAuthor());
		p.addValue("book", books.getBook());
		p.addValue("year",books.getYear());
		return insertBooks.execute(p);
	}
	
	public void insertWithJDBC(Books books) {

		Connection conn = null;

		try {
			Class.forName("org.sqlite.JDBC");
			String url = "jdbc:sqlite:db/BooksDB.db";
			conn = DriverManager.getConnection(url, "", "");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sql = "insert into BooksDB (author, book, year) VALUES (?, ?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, books.getBook());
			ps.setString(2, books.getAuthor());
			ps.setInt(3, books.getYear());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	
	
	
	@Override
	public int insert(List<Books> booksList) {
		
		String sql = "insert into BooksDB (author, book, year) VALUES (:author, :name, :year)";

		SqlParameterSource[] params = new SqlParameterSource[booksList.size()];

		int i = 0;

		for (Books book : booksList) {
			MapSqlParameterSource p = new MapSqlParameterSource();
			p.addValue("name", book.getAuthor());
			p.addValue("author", book.getAuthor());
			p.addValue("year", book.getYear());

			params[i] = p;
			i++;
		}

//		 SqlParameterSource[] batch =
//		 SqlParameterSourceUtils.createBatch(booksList.toArray());
		int[] updateCounts = jdbcTemplate.batchUpdate(sql, params);
		return updateCounts.length;
	
		
	}

	

	@Override
	public void delete(int id) {
		String sql = "delete from BooksDB where id=:id";//запрос для БД

		MapSqlParameterSource params = new MapSqlParameterSource();//передаем в джбстемплейт
		params.addValue("id", id);//добавляем

		jdbcTemplate.update(sql, params);//обновляем таблицу
		
	}

	@Override
	public void delete(Books books) {
		delete(books.getId());
		
	}
	
	@Override
	public Books getBooksByID(int id) {
		String sql = "select * from BooksDB where id=:id";//делаем запрос

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);//добавляем ид

		return jdbcTemplate.queryForObject(sql, params, new BooksRowMapper());
	}

	@Override
	public List<Books> getBooksListByBook(String book) {
		String sql = "select * from BooksDB where upper(book) like :book";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("book", "%" + book.toUpperCase() + "%");
		
		return jdbcTemplate.query(sql,params, new BooksRowMapper());
	}

	@Override
	public List<Books> getMP3ListByAuthor(String author) {
		String sql = "select * from BooksDB where upper(author) like :author";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("author", "%" + author.toUpperCase() + "%");

		return jdbcTemplate.query(sql, params, new BooksRowMapper());
	}

	@Override
	public int getBooksCount() {
		String sql = "select count(*) from BooksDB";
		return jdbcTemplate.getJdbcOperations().queryForObject(sql, Integer.class);
	}


	private static final class BooksRowMapper implements RowMapper<Books> {

		@Override
		public Books mapRow(ResultSet rs, int rowNum) throws SQLException {
			Books books = new Books();
			books.setId(rs.getInt("id"));
			books.setBook(rs.getString("author"));
			books.setAuthor(rs.getString("book"));
			books.setYear(rs.getInt("year"));
			return books;
		}

	}



}
