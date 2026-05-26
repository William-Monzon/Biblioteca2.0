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

import models.book.Magazine;

public class ArrayListMagazine {
private final ArrayList<Magazine> magazines = new ArrayList<>();
	
	public List<Magazine> getMagazines() {
		return Collections.unmodifiableList(magazines);	}

	public void addMagazines(Magazine e) {
		magazines.add(e);
	}

	public void clearMagazine() {
		magazines.clear();
	}
	public void removeMagazine(Magazine e) {
		magazines.remove(e);
	}
	
	public void save(Path archivo) throws IOException {
		try (BufferedWriter out = Files.newBufferedWriter(archivo, StandardCharsets.UTF_8)) {
			for (Magazine e : magazines) {
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

	public void uploadFromFile(Path file) throws IOException {
		magazines.clear();
		if (!Files.isRegularFile(file)) {
			return;
		}
		try (BufferedReader in = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
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
				try {
					int year = Integer.parseInt(t.nextToken().trim());
					int copies = Integer.parseInt(t.nextToken().trim());
					magazines.add(new Magazine(code, title, autor, year, copies));
				} catch(NumberFormatException e){
					System.out.println("Línea malformada, se omite: " + linea);
				}
				
				
			}
		}
	}
}
