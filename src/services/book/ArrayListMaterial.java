package services.book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import models.book.Book;
import models.book.Magazine;
import models.book.Material;

public class ArrayListMaterial {
	ArrayListBook books = new ArrayListBook();	//Instancio las listas de libros
	ArrayListMagazine magazines = new ArrayListMagazine(); //Instancio la lista de revistas
	//Método para mostrar la lista de libros
	public Collection<Book> getLibros() {
		return books.getBooks();
	}
	//Método para mostrar la lista de revistas
	public Collection<Magazine> getRevistas() {
		return magazines.getMagazines();
	}
	//Método para mostrar todos los matriales, osea los libros y revistas
	public List<Material> getMaterialAll() {
		List<Material> allMaterial = new ArrayList<>();
		allMaterial.addAll(books.getBooks());
		allMaterial.addAll(magazines.getMagazines());
		return Collections.unmodifiableList(allMaterial); //Retorna la lista completa de material
	}

	public List<Material> search(String termino) { //Método para buscar un Material, ya sea por rl código o por el nombre
		String t = termino.toLowerCase();
		return getMaterialAll().stream()
				.filter(m -> m.getCode().toLowerCase().contains(t) || m.getTitle().toLowerCase().contains(t))
				.collect(Collectors.toList());
	}

}
