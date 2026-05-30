package controllers.book;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import interfaces.book.WindowBook;
import models.book.Book;
import services.book.ArrayListBook;

public class ControllerBook {
	private final ArrayListBook bookService;
	private final WindowBook window;
	private final Path csvPath;
	private boolean isEditing = false;
	private String editingCode;

	public ControllerBook(ArrayListBook bookService, WindowBook window, Path csvPath) {
		this.bookService = bookService;
		this.window = window;
		this.csvPath = csvPath;
	}
	//Método para inicializar los botones utilizando lambdas
	public void initEvents() {
		window.btnAddBook.addActionListener(e -> addBook());
		window.btnModifyBook.addActionListener(e -> loadBookForEdit());
		window.btnDeleteBook.addActionListener(e -> deleteBook());
		window.btnExit.addActionListener(e -> window.dispose());
	}
	//Método para modificar un libro, seleccionandolo en la tabla
	private void loadBookForEdit() {
		int row = window.table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(window, "Seleccione un libro de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		} //Se llenan los campos con los datos de la fila seleccionada
		editingCode = window.table.getValueAt(row, 0).toString();
		window.txtCode.setText(editingCode);
		window.txtTitle.setText(window.table.getValueAt(row, 1).toString());
		window.txtAutor.setText(window.table.getValueAt(row, 2).toString());
		window.txtYear.setText(window.table.getValueAt(row, 3).toString());
		window.txtCopies.setText(window.table.getValueAt(row, 4).toString());
		isEditing = true; //Se edita el libro seleccionado y se se guardan los cambios con el botón de agregar libros
		window.btnAddBook.setText("Guardar");
	}
	//Se cargan los libros en el archivo .csv con persistencia
	public void loadData() {
		try {
			bookService.uploadFromFile(csvPath);
			refreshTable();
		} catch (IOException e) {
			Logger.getLogger(ControllerBook.class.getName()).log(Level.SEVERE, "Error al cargar datos", e);
		}
	}
	//Método para aggregar los datos de los libros en los campos
	private void addBook() {
		String code = window.txtCode.getText().trim(); //Con trim se valida que no haya espacioa
		String title = window.txtTitle.getText().trim();
		String autor = window.txtAutor.getText().trim();
		String yearStr = window.txtYear.getText().trim();
		String copiesStr = window.txtCopies.getText().trim();
		//Se valida que no haya campos vacios y muestra el mensaje en un panel pequeño de JOptionPane
		if (code.isEmpty() || title.isEmpty() || autor.isEmpty() || yearStr.isEmpty() || copiesStr.isEmpty()) {
			JOptionPane.showMessageDialog(window, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		//Pasado los datos de year y copies de String a int
		try {
			int year = Integer.parseInt(yearStr);
			int copies = Integer.parseInt(copiesStr);
			//Si la variable isEditig es true entra al if, osea que si se ingrsa un libro ya existente
			if (isEditing) {
				Book toUpdate = bookService.getBooks().stream()//Se busca el libro con el código y si se encuentra se guarda en toUpdate
						.filter(b -> b.getCode().equals(editingCode))
						.findFirst().orElse(null); //Si no se encuentra el libro, devuelve null
				if (toUpdate != null) {	//Si el libro se encontro se cambia el libro existente por el nuevo
					bookService.removeBook(toUpdate);
				}//Al finalizar se reseta y vuelve a su estado original
				isEditing = false;
				editingCode = null;
				window.btnAddBook.setText("Agregar Libro");
			}
			//Se guarda el libro nuevo en el archivo .csv
			Book book = new Book(code, title, autor, year, copies);
			bookService.addBooks(book);
			bookService.saveBooks(csvPath);
			refreshTable(); //Refresca la tabla para mostrar el nuevo libro ingresado
			clearFields();  //Se limpian los campos para ingresar nuevos datos
			JOptionPane.showMessageDialog(window, "Libro guardado correctamente"); //Muestra el mensaje de que esta todo correcto
		} catch (NumberFormatException e) {//Error cuando en año y copias no se ingresa un numero
			JOptionPane.showMessageDialog(window, "Año y Copias deben ser números", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) { //Error si no se guarda porque está abierto el archivo .csv
			Logger.getLogger(ControllerBook.class.getName()).log(Level.SEVERE, "Error al guardar datos", e);
			JOptionPane.showMessageDialog(window, "Error al guardar en el archivo CSV", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	//En este método se actualiza la tabla
	private void refreshTable() {
		DefaultTableModel model = (DefaultTableModel) window.table.getModel();
		model.setRowCount(0); //Se limpia la tabla para que no se dupliquen los libros
		for (Book b : bookService.getBooks()) { //Aquí se actualiza la tabla
			model.addRow(new Object[]{b.getCode(), b.getTitle(), b.getAutor(), b.getYear(), b.getCopies()});
		}
	}
	//Método para eliminar un libro
	private void deleteBook() {
		int row = window.table.getSelectedRow();
		if (row == -1) { //Se valida que haya un fila seleccionada
			JOptionPane.showMessageDialog(window, "Seleccione un libro de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		} //El usuario puede eliminar el libro seleccionando el código
		String code = window.table.getValueAt(row, 0).toString();
		int confirm = JOptionPane.showConfirmDialog(window, "¿Eliminar el libro con código " + code + "?",
				"Confirmar", JOptionPane.YES_NO_OPTION); //Se pide confirmación si está seguro de borrar el libro
		if (confirm != JOptionPane.YES_OPTION) return; //Si no esta seguro, retorna nada y regresa al inicio
		//Aqui el programa busca el libro seleccionado, si el usuario confirmo la eliminación
		Book toRemove = bookService.getBooks().stream()
				.filter(b -> b.getCode().equals(code))
				.findFirst().orElse(null);
		if (toRemove == null) return; //Si no se encontro el libro, retorna nada y regresa al inicio

		try {
			bookService.removeBook(toRemove); //Se borra el libro
			bookService.saveBooks(csvPath); //Sobreescribe el archivo para guardar cambios
			refreshTable(); //Se actualiza la tabla
		} catch (IOException e) { //Da error si el archivo está abierto.
			Logger.getLogger(ControllerBook.class.getName()).log(Level.SEVERE, "Error al guardar datos", e);
			JOptionPane.showMessageDialog(window, "Error al guardar en el archivo CSV", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	//Método que limpa los campos de texto después de haber ingresado la información
	private void clearFields() {
		window.txtCode.setText("");
		window.txtTitle.setText("");
		window.txtAutor.setText("");
		window.txtYear.setText("");
		window.txtCopies.setText("");
	}
}
