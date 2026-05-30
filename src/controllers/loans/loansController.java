package controllers.loans;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import database.UserDatabase;
import models.book.Book;
import models.loans.Loans;
import models.user.User;
import services.book.ArrayListBook;
import services.loans.ArrayListLoans;

public class LoansController {

	private JComboBox<User> cbUsers;
	private JComboBox<Book> cbBooks;
	private ArrayListLoans loanService;
	private ArrayListBook bookService;
	private Path loansPath = Path.of("archivos/loans.csv");
	private Path booksPath = Path.of("archivos/books.csv");

	public LoansController(JComboBox<User> cbUsers, JComboBox<Book> cbBooks) {
		this.cbUsers = cbUsers;
		this.cbBooks = cbBooks;
		this.loanService = new ArrayListLoans();
		this.bookService = new ArrayListBook();

		loadUsers();
		loadBooks();
		loadLoans();
	}

	private void loadLoans() {
		try {
			loanService.archiveLoans(loansPath);
		} catch (IOException e) {
			Logger.getLogger(LoansController.class.getName()).log(Level.INFO, "No hay archivo de préstamos aún");
		}
	}

	private void loadUsers() {
		UserDatabase.loadUsers();
		for (User u : UserDatabase.users) {
			cbUsers.addItem(u);
			loanService.addUser(u);
		}
	}

	private void loadBooks() {
		try {
			bookService.uploadFromFile(booksPath);
			for (Book b : bookService.getBooks()) {
				cbBooks.addItem(b);
				loanService.addMaterial(b);
			}
		} catch (Exception e) {
			Logger.getLogger(LoansController.class.getName()).log(Level.SEVERE, "Error al cargar libros", e);
		}
	}

	// Método para crear el préstamo
	public void createloan() {
		User user = (User) cbUsers.getSelectedItem(); // El usuario selecciona quien es el titular del prestamo capturando los datos
		Book book = (Book) cbBooks.getSelectedItem(); // El usuario elige que libro se prestará capturando los datos
		// Validación cuando el libro no está disponible, porque no cuenta con copias
		if (!book.isAvailable()) {
			JOptionPane.showMessageDialog(null, "El libro no tiene copias disponibles", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		// Datos del préstamo como el id, el día del préstamo, el día limite y el dia de devolucón
		int id = loanService.getLoans().size() + 1;
		LocalDate now = LocalDate.now();
		Loans loan = new Loans(id, book, user, now, now.plusDays(book.dayLoans()), null);
		// llamada al método que reduce las copias del libro
		book.reduceCopies();
		// Valida que el préstamo se ingrese correctamente para guardarlo en los archivos .csv
		try { 
			loanService.addLoan(loan); //Se guarda el préstamo en el ArrayList y con persistencia en los archivos .csv
			loanService.saveLoans(loansPath);
			bookService.saveBooks(booksPath);
			JOptionPane.showMessageDialog(null, "Préstamo realizado correctamente\n" + // En una ventana JOptionPane muestra la información del préstamo
					"Usuario: " + user.getName() + " " + user.getLastname() + "\n" + "Libro: " + book.getTitle() + "\n"
					+ "Fecha: " + now + "\n" + "Fecha límite: " + now.plusDays(book.dayLoans()));
		} catch (IOException e) { //Se muestra la excepción cuando el préstamo no se puede guardar porque el archivo .csv está abierto
			Logger.getLogger(LoansController.class.getName()).log(Level.SEVERE, "Error al guardar préstamo", e);
			JOptionPane.showMessageDialog(null, "Error al guardar el préstamo", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	// Método para devolver el el libro que se présto
	public void returnLoan() {
		User user = (User) cbUsers.getSelectedItem(); // Se selecciona el titular del préstamo
		Book book = (Book) cbBooks.getSelectedItem(); // Se selecciona le Libro que fue préstado
		// Busca si la información ingresada es verdadera y el préstamo ha sido efectaudo
		Loans loan = loanService.getLoans().stream().filter(l -> l.getUser().getId() == user.getId() //con .filter valida que el usuario seleccionado sea correcto
				&& l.getMaterial().getCode().equals(book.getCode()) && l.isActive()).findFirst().orElse(null); //valida que el libro seleccionado sea el correcto
		//Lo más importan se valida que el préstamo está activo.
		if (loan == null) {	//Si todo lo anterior no se cumple entra al if y sa con un mensaje en un panel de JOptionPane
			JOptionPane.showMessageDialog(null, "No hay un préstamo activo de este libro al usuario", "Error",
					JOptionPane.ERROR_MESSAGE);
			return; //El return frena la ejecución de la devolución
		}
		//Se retorna el libro aumentando la copia y dando la fecha de devolución
		loan.returned();
		book.returnCopies();
		//Se guarda la información del préstamo con persistencia en un archivo .csv y se valida con try-catch
		try {
			loanService.saveLoans(loansPath);
			bookService.saveBooks(booksPath);
			JOptionPane.showMessageDialog(null, //Se muestra datos del ususario y el libro que ha sido devuelto en un JOptionPane
					"Devolución realizada correctamente\n" + "Usuario: " + user.getName() + " " + user.getLastname()
							+ "\n" + "Libro: " + book.getTitle() + "\n" + "Fecha devolución: "
							+ java.time.LocalDate.now());
		} catch (IOException e) { //Muestra la excepción si no se pudo devolver el libro o cuando el archivo .csv está abierto
			Logger.getLogger(LoansController.class.getName()).log(Level.SEVERE, "Error al guardar devolución", e);
			JOptionPane.showMessageDialog(null, "Error al guardar la devolución", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
