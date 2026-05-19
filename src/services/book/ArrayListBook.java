package services.book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import models.book.Book;

public class ArrayListBook {
	private final ArrayList<Book> books = new ArrayList<>();
	
	public List<Book> getEstudiantes() {
		return books;
	}

	public void addMaterials(Book e) {
		books.add(e);
	}

	public void limpiar() {
		books.clear();
	}
	
	public void guardarEnArchivo(Path archivo) throws IOException {
		try (BufferedWriter out = Files.newBufferedWriter(archivo, StandardCharsets.UTF_8)) {
			for (Book e : books) {
				out.write(e.getCode());
				out.write(';');
				out.write(e.getTitle());
				out.write(';');
				out.write(e.getAutor());
				out.write(';');
				out.write(e.getYear());
				out.write(';');
				out.write(e.getCopies());
				out.newLine();
			}
		}
	}

	public void cargarDesdeArchivo(Path archivo) throws IOException {
		books.clear();
		if (!Files.isRegularFile(archivo)) {
			return;
		}
		try (BufferedReader in = Files.newBufferedReader(archivo, StandardCharsets.UTF_8)) {
			String linea;
			while ((linea = in.readLine()) != null) {
				if (linea.isBlank()) {
					continue;
				}
				StringTokenizer t = new StringTokenizer(linea, ";");
				if (t.countTokens() < 3) {
					continue;
				}
				String code = t.nextToken().trim();
				String title = t.nextToken().trim();
				String autor = t.nextToken().trim();
				int year = Integer.parseInt(t.nextToken().trim());
				int copies = Integer.parseInt(t.nextToken().trim());
				books.add(new Book(code, title, autor, year, copies, false));
			}
		}
	}
}
