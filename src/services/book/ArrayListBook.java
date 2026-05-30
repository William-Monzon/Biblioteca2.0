package services.book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import models.book.Book;

public class ArrayListBook {
	private final ArrayList<Book> books = new ArrayList<>(); //Se crea la lista de libros
	//Método para mostrar la lista de libros
	public List<Book> getBooks() {
		return Collections.unmodifiableList(books);	}
	//Método para ingresar un libro
	public void addBooks(Book e) {
		books.add(e);
	}
	//Método para limpiar
	public void clear() {
		books.clear();
	}
	//Método para eliminar un libro
	public void removeBook(Book e) {
		books.remove(e);
	}
	//Método para guardar un libro en el archivo .csv
	public void saveBooks(Path archivo) throws IOException {
		try (BufferedWriter out = Files.newBufferedWriter(archivo, StandardCharsets.UTF_8)) {
			for (Book e : books) {
				out.write(e.getCode());
				out.write(';');
				out.write(e.getTitle());
				out.write(';');
				out.write(e.getAutor());
				out.write(';');
				out.write(String.valueOf(e.getYear()));
				out.write(';');
				out.write(String.valueOf(e.getCopies()));
				out.newLine();
			}
		}
	}
	//Método que sube la información desde el archivo
	public void uploadFromFile(Path archivo) throws IOException {
		books.clear(); //limpia la lista para qu no haya duplicados
		if (!Files.isRegularFile(archivo)) { 
			return; //Busca que el libro exista en el archivo, de lo contraro retorna nada
		}
		try (BufferedReader in = Files.newBufferedReader(archivo, StandardCharsets.UTF_8)) {
			String linea;
			while ((linea = in.readLine()) != null) { //Entra al bucle lee los libros y se detiene cuando ya no encuentra libros
				if (linea.isBlank()) {//Si se encuentra la linea vaacía se la salta y continua.
					continue;
				}
				StringTokenizer t = new StringTokenizer(linea, ";");
				if (t.countTokens() < 3) {
					continue;
				}//Se valida que no contengan espacios
				String code = t.nextToken().trim();
				String title = t.nextToken().trim();
				String autor = t.nextToken().trim();
				try { //Se valida que el año y las copias sean int
					int year = Integer.parseInt(t.nextToken().trim());
					int copies = Integer.parseInt(t.nextToken().trim());
					books.add(new Book(code, title, autor, year, copies));
				} catch(NumberFormatException e){
					System.out.println("Línea malformada, se omite: " + linea);
				}
			}
		}
	}
}
