package models.book;

public abstract class Material { //Clase padre
	private final String code;
	private final String title;
	private final String autor;
	private final int year;
	private int copies;

	public Material(String code, String title, String autor, int year, int copies) {
		this.code = code;
		this.title = title;
		this.autor = autor;
		this.year = year;
		setCopies(copies); //Copias validadas para qu no sean menos a 0
	}

	public String getCode() {
		return code;
	}

	public String getTitle() {
		return title;
	}

	public String getAutor() {
		return autor;
	}

	public int getYear() {
		return year;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		if(copies<0) { //Se validan las copias para que no sean menores a 0
			throw new IllegalArgumentException("Error: ");
		}
		this.copies = copies;
	}
	//Métodos abstractos para que la clase hija los sobreescriba obligatoriamente
	public abstract double calculateFine();

	public abstract int dayLoans();
	//Método para saber si el libro está disponible
	public boolean isAvailable() {
		if (copies > 0) {
			return true;
		} else {
			return false;
		}

	}
	//Método para reducir copias si hay un préstamo
	public void reduceCopies() {
		this.copies--;
	}
	//Método para aumentar las copias si hay una devolución
	public void returnCopies() {
		this.copies++;
	}
	//To string que muestra el nombre del libro
	@Override
	public String toString() {
		return title;
	}
}
