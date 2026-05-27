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

	public void initEvents() {
		window.btnAddBook.addActionListener(e -> addBook());
		window.btnModifyBook.addActionListener(e -> loadBookForEdit());
		window.btnDeleteBook.addActionListener(e -> deleteBook());
		window.btnExit.addActionListener(e -> window.dispose());
	}

	private void loadBookForEdit() {
		int row = window.table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(window, "Seleccione un libro de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		editingCode = window.table.getValueAt(row, 0).toString();
		window.txtCode.setText(editingCode);
		window.txtTitle.setText(window.table.getValueAt(row, 1).toString());
		window.txtAutor.setText(window.table.getValueAt(row, 2).toString());
		window.txtYear.setText(window.table.getValueAt(row, 3).toString());
		window.txtCopies.setText(window.table.getValueAt(row, 4).toString());
		isEditing = true;
		window.btnAddBook.setText("Guardar Cambios");
	}

	public void loadData() {
		try {
			bookService.uploadFromFile(csvPath);
			refreshTable();
		} catch (IOException e) {
			Logger.getLogger(ControllerBook.class.getName()).log(Level.SEVERE, "Error al cargar datos", e);
		}
	}

	private void addBook() {
		String code = window.txtCode.getText().trim();
		String title = window.txtTitle.getText().trim();
		String autor = window.txtAutor.getText().trim();
		String yearStr = window.txtYear.getText().trim();
		String copiesStr = window.txtCopies.getText().trim();

		if (code.isEmpty() || title.isEmpty() || autor.isEmpty() || yearStr.isEmpty() || copiesStr.isEmpty()) {
			JOptionPane.showMessageDialog(window, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			int year = Integer.parseInt(yearStr);
			int copies = Integer.parseInt(copiesStr);

			if (isEditing) {
				Book toUpdate = bookService.getBooks().stream()
						.filter(b -> b.getCode().equals(editingCode))
						.findFirst().orElse(null);
				if (toUpdate != null) {
					bookService.removeBook(toUpdate);
				}
				isEditing = false;
				editingCode = null;
				window.btnAddBook.setText("Agregar Libro");
			}

			Book book = new Book(code, title, autor, year, copies);
			bookService.addBooks(book);
			bookService.saveBooks(csvPath);
			refreshTable();
			clearFields();
			JOptionPane.showMessageDialog(window, "Libro guardado correctamente");
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(window, "Año y Copias deben ser números", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			Logger.getLogger(ControllerBook.class.getName()).log(Level.SEVERE, "Error al guardar datos", e);
			JOptionPane.showMessageDialog(window, "Error al guardar en el archivo CSV", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void refreshTable() {
		DefaultTableModel model = (DefaultTableModel) window.table.getModel();
		model.setRowCount(0);
		for (Book b : bookService.getBooks()) {
			model.addRow(new Object[]{b.getCode(), b.getTitle(), b.getAutor(), b.getYear(), b.getCopies()});
		}
	}

	private void deleteBook() {
		int row = window.table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(window, "Seleccione un libro de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String code = window.table.getValueAt(row, 0).toString();
		int confirm = JOptionPane.showConfirmDialog(window, "¿Eliminar el libro con código " + code + "?",
				"Confirmar", JOptionPane.YES_NO_OPTION);
		if (confirm != JOptionPane.YES_OPTION) return;

		Book toRemove = bookService.getBooks().stream()
				.filter(b -> b.getCode().equals(code))
				.findFirst().orElse(null);
		if (toRemove == null) return;

		try {
			bookService.removeBook(toRemove);
			bookService.saveBooks(csvPath);
			refreshTable();
		} catch (IOException e) {
			Logger.getLogger(ControllerBook.class.getName()).log(Level.SEVERE, "Error al guardar datos", e);
			JOptionPane.showMessageDialog(window, "Error al guardar en el archivo CSV", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void clearFields() {
		window.txtCode.setText("");
		window.txtTitle.setText("");
		window.txtAutor.setText("");
		window.txtYear.setText("");
		window.txtCopies.setText("");
	}
}
