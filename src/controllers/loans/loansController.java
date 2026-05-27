package controllers.loans;


import models.user.*;

import java.util.ArrayList;


import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import models.book.*;
import models.loans.Loans;

public class loansController {

	private ArrayList<User> users = new ArrayList<>();
	private ArrayList<Book> books = new ArrayList<>();
	
	

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
		for(User u : users) {
			cbUsers.addItem(u);
		}
			
		}
	
	private void loadBooks() {
		for(Book m : books) {
			cbBooks.addItem(m);
			
		}
		
	}

	public void createloan() {
		
		User user = (User)  cbUsers.getSelectedItem();
		Book book = (Book ) cbBooks.getSelectedItem();
		
		
		
		
		
		
		
		
			
	
	
	
	
	
}
}
