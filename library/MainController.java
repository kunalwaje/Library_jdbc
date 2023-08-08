package library;
import java.sql.SQLException;
import java.util.Scanner;

public class MainController {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc= new Scanner(System.in);
		Book book=new Book();
		BookCRUD crud=new BookCRUD();
		boolean exit=false;
		
		while(true)
		{
			System.out.println("WELCOME ADMIN");
			System.out.println("Enter your choice");
			System.out.println("1.Add Book \n2.View Book \n3.Update Book \n4.Delete Book \n5.Exit");
			switch(sc.nextInt())
			{
			case 1:
			{
				System.out.println("Enter ID : ");
				book.setId(sc.nextInt());
				System.out.println("Enter Book Name :");
				book.setName(sc.next());
				System.out.println("Enter Book Author :");
				book.setAuthor(sc.next());
				System.out.println("Enter Book Price :");
				book.setPrice(sc.nextDouble());
				System.out.println("Enter Book Genre :");
				book.setGenre(sc.next());
				crud.saveBook(book);
				break;
			}
			case 2:
			{
				System.out.println("1.View Book by id");
				System.out.println("2.View Book by name");
				System.out.println("3.View Book by author");
				System.out.println("4.View Book by price");
				System.out.println("5.View Book by genre");
				System.out.println("6.View Book in range");
				switch (sc.nextInt()) {
				case 1: {
					System.out.println("Enter ID");

					crud.viewBook(sc.nextInt());
					break;
				}
				case 2: {
					System.out.println("Enter Name");
					String value = sc.next();

					crud.viewBookByName(value);
					break;

				}
				case 3: {
					System.out.println("Enter Author");
					crud.viewBookByAuthor(sc.next());
					break;

				}
				case 4: {
					System.out.println("Enter Price");
					crud.viewBook(sc.nextDouble());
					break;

				}
				case 5: {
					System.out.println("Enter Genre");
					crud.viewBookByGenre(sc.next());
					break;

				}
				case 6: {
					System.out.println("Enter Starting price");
					double min = sc.nextDouble();
					System.out.println("Enter Ending price");
					double max = sc.nextDouble();
					crud.getBookInRange(min, max);
				}

				}
				break;
			}
			case 3: {
				System.out.println("1.update book id by id");
				System.out.println("2.update book name by id");
				System.out.println("3.update book author by id");
				System.out.println("4.update book price by id");
				System.out.println("5.update book genre by id");

				switch (sc.nextInt()) {
				case 1: {
					System.out.println("Enter new ID:");
					int newId = sc.nextInt();
					String newId1 = String.valueOf(newId);

					System.out.println("Enter Old ID");
					int oldId = sc.nextInt();

					crud.updateBook("id", newId1, oldId);
					break;
				}
				case 2: {
					System.out.println("Enter new Name");
					String newName = sc.next();
					System.out.println("ENTER ID");
					int id = sc.nextInt();
					crud.updateBook("name", newName, id);
					break;

				}
				case 3: {
					System.out.println("Enter new Author");
					String newAuthor = sc.next();
					System.out.println("Enter ID");
					int id = sc.nextInt();
					crud.updateBook("author", newAuthor, id);
					break;

				}
				case 4: {
					System.out.println("Enter new price");
					double price = sc.nextDouble();
					String newPrice = String.valueOf(price);
					System.out.println("Enter ID");
					int id = sc.nextInt();
					crud.updateBook("price", newPrice, id);
					break;

				}
				case 5: {
					System.out.println("Enter new genere");
					String genre = sc.next();
					System.out.println("Enter ID");
					int id = sc.nextInt();
					crud.updateBook("name", genre, id);
					break;

				}

				}
				break;
			}
			case 4: {

				System.out.println("1.DELETE BOOK BY ID");
				System.out.println("2.DELETE BOOK BY NAME");
				System.out.println("3.DELETE BOOK BY AUTHOR");
				System.out.println("4.DELETE BOOK BY GENRE");

				switch (sc.nextInt()) {
				case 1: {
					System.out.println("Enter id");
					crud.deleteBookById(sc.nextInt());

				}
				case 2: {
					System.out.println("Enter name");
					crud.deleteBookByName(sc.next());
					break;

				}
				case 3: {
					System.out.println("Enter author");
					crud.deleteBookByAuthor(sc.next());
					break;

				}
				case 4: {
					System.out.println("Enter genre");
					crud.deleteBookByGenre(sc.next());
					break;
				}

				}
				break;

			}
				case 5: 
				{
					exit=true;
				
					break;
				}
			
				}
					if(exit)
					break;

				}
					System.err.println("THANKS FOR VISIT OUR BOOKSTORE");

			
			}
			
	}



