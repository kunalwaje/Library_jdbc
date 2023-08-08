package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookCRUD {
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm17","root","1234");
		return connection;
	}
	public void saveBook(Book book) throws ClassNotFoundException, SQLException {
		Connection connection =getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("insert into Book(id,name,author,price,genre)values(?,?,?,?,?)");
		preparedStatement.setInt(1, book.getId());
		preparedStatement.setString(2, book.getName());
		preparedStatement.setString(3, book.getAuthor());
		preparedStatement.setDouble(4,book.getPrice() );
		preparedStatement.setString(5, book.getGenre());
		int count = preparedStatement.executeUpdate();

		if (count != 0) {
			System.out.println("Book Saved!");
		} else {
			System.err.println("Book not Saved!");
		}

		connection.close();
	}
	public void viewBook(int id) throws ClassNotFoundException, SQLException
	{
		Connection connection =getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("select * from Book where id=?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next())
		{
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println(resultSet.getDouble(4));
			System.out.println(resultSet.getString(5));
			System.out.println("-----------------------");
		}
		else
		{
			System.err.println("BOOK NOT FOUND WITH ID (" + id + ")");
			connection.close();
		}
	}
	
	public void viewBookByName(String value) throws ClassNotFoundException, SQLException 
	{
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from Book where name=?");

		preparedStatement.setString(1, value);
		ResultSet resultSet = preparedStatement.executeQuery();
		boolean data = false;

		while (resultSet.next()) {
			data = true;
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println(resultSet.getDouble(4));
			System.out.println(resultSet.getString(5));
			System.out.println("-----------------------");
		}
		if (data == false)
			System.err.println("BOOK NOT FOUND WITH NAME ("+value+")");

		connection.close();

	}
	
	public void viewBookByAuthor(String value) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from Book where author=?");

		preparedStatement.setString(1, value);
		ResultSet resultSet = preparedStatement.executeQuery();
		boolean data = false;

		while (resultSet.next()) {
			data = true;
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println(resultSet.getDouble(4));
			System.out.println(resultSet.getString(5));
			System.out.println("-----------------------");
		}
		if (data == false)
			System.err.println("BOOK NOT FOUND WITH AUTHOR ("+value+")");

		connection.close();

	}
	
	public void viewBookByGenre(String value) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from Book where genre=?");

		preparedStatement.setString(1, value);
		ResultSet resultSet = preparedStatement.executeQuery();

		boolean data = false;
		while (resultSet.next()) {
			data = true;
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println(resultSet.getDouble(4));
			System.out.println(resultSet.getString(5));
			System.out.println("-----------------------");
		}
		if (data == false)
			System.err.println("BOOK NOT FOUND WITH GENRE (" + value + ")");

		connection.close();

	}
	
	public void viewBook(double price) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from Book where price=?");
		preparedStatement.setDouble(1, price);

		ResultSet resultSet = preparedStatement.executeQuery();
		boolean data = false;

		while (resultSet.next()) {
			data = true;
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println(resultSet.getDouble(4));
			System.out.println(resultSet.getString(5));
			System.out.println("-----------------------");
		}
		if (data == false)
			System.err.println("BOOK NOT FOUND WITH PRICE (" + price + ")");

		connection.close();

	}
	
	public void updateBook(int oldId,int newId) throws ClassNotFoundException, SQLException
	{
		Connection connection= getConnection();
		PreparedStatement preparedStatement= connection.prepareStatement("update book set id=? where id=? ");
		preparedStatement.setInt(1, newId);
		preparedStatement.setInt(2, oldId);
		if(preparedStatement.executeUpdate()!=0)
		{
			System.out.println("BOOK UPDATED SUCCESSFULLY !");			
		}
		else
			System.err.println("BOOK NOT UPDATED !");
		
		connection.close();
			
	}
	
	public void updateBook(String attribute, String value, int id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("update book set genre =? where id=?");
		preparedStatement.setString(1, value);
		preparedStatement.setInt(2, id);

		if (preparedStatement.executeUpdate() != 0) {
			System.out.println("BOOK UPDATED SUCCESSFULLY !");
		} else
			System.err.println("BOOK NOT UPDATED !");

		connection.close();

	}
	

	public void deleteBookById(int id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("delete from book where id=?");
		preparedStatement.setInt(1, id);
		int rowAffected=preparedStatement.executeUpdate();
		if ( rowAffected != 0)
			System.out.println("BOOK DELETED !");
		else
			System.err.println("BOOK NOT DELETED !");

		connection.close();
	}
	
	public void deleteBookByName(String name) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("delete from book where name=?");
		preparedStatement.setString(1, name);
		
		int rowAffected=preparedStatement.executeUpdate();
		
		if ( rowAffected != 0)
			System.out.println("("+rowAffected+")BOOK DELETED !");
		else
			System.err.println("BOOK NOT DELETED !");

		connection.close();
	}
	
	public void deleteBookByAuthor(String author) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("delete from book where author=?");
		preparedStatement.setString(1, author);
		
		int rowAffected=preparedStatement.executeUpdate();
		
		if ( rowAffected != 0)
			System.out.println("("+rowAffected+")BOOK DELETED !");
		else
			System.err.println("BOOK NOT DELETED !");

		connection.close();
	}
	
	public void deleteBookByGenre(String genre) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("delete from book where genre=?");
		preparedStatement.setString(1, genre);
		
		int rowAffected=preparedStatement.executeUpdate();
		
		if ( rowAffected != 0)
			System.out.println("("+rowAffected+")BOOK DELETED !");
		else
			System.err.println("BOOK NOT DELETED !");

		connection.close();
	}
	
	public void getBookInRange(double sP, double eP) throws ClassNotFoundException, SQLException
	{
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from book where price between ? and ?");
		preparedStatement.setDouble(1, eP);
		preparedStatement.setDouble(2, eP);
		
		ResultSet resultSet = preparedStatement.executeQuery();

		boolean data = false;
		while (resultSet.next()) {
			data = true;
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println(resultSet.getDouble(4));
			System.out.println(resultSet.getString(5));
			System.out.println("-----------------------");
		}
		if (data == false)
			System.err.println("BOOK NOT FOUND )");

		connection.close();
				
	}
	

}
