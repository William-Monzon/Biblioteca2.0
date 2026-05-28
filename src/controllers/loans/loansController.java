package controllers.loans;


import java.nio.file.Path;
import java.util.ArrayList;

import services.book.ArrayListBook;

import javax.swing.JComboBox;

import database.UserDatabase;

import models.book.Book;

import models.user.User;



public class loansController {

	

	
	

    private JComboBox<User> cbUsers;
    private JComboBox<Book> cbBooks;
	
	
	public loansController(
		   JComboBox<User> cbUsers,
		  JComboBox<Book> cbBooks
		) {
	
		this.cbUsers = cbUsers;
		this.cbBooks = cbBooks;
	  
	    
		loadUsers();
		loadBooks();
		
	
	}
	
	
	
	
	private void loadUsers() {
		 UserDatabase.loadUsers();

		    for(User u : UserDatabase.users) {
		        cbUsers.addItem(u);
		    }
		}
	
	private void loadBooks() {
		try {
	        ArrayListBook bookService = new ArrayListBook();

	        bookService.uploadFromFile(
	            Path.of("archivos/books.csv")
	        );

	        for (Book b : bookService.getBooks()) {
	            cbBooks.addItem(b);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public void createloan() {
		
		User user = (User)  cbUsers.getSelectedItem();
		Book book = (Book ) cbBooks.getSelectedItem();
		
		
		
		
		
		
		
		
			
	
	
	
	
	
}
}
