package services.book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import models.book.Book;
import models.book.Magazine;
import models.book.Material;

public class ArrayListMaterial {
	ArrayListBook books = new ArrayListBook();
	ArrayListMagazine magazines = new ArrayListMagazine();

	public Collection<Book> getLibros() {
		return books.getBooks();
	}

	public Collection<Magazine> getRevistas() {
		return magazines.getMagazines();
	}

	public List<Material> getMaterialAll() {
		List<Material> allMaterial = new ArrayList<>();
		allMaterial.addAll(books.getBooks());
		allMaterial.addAll(magazines.getMagazines());
		return Collections.unmodifiableList(allMaterial);
	}

	public List<Material> search(String termino) {
		String t = termino.toLowerCase();
		return getMaterialAll().stream()
				.filter(m -> m.getCode().toLowerCase().contains(t) || m.getTitle().toLowerCase().contains(t))
				.toList();
	}

}
