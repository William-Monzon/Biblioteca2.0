package models.book;

public class Book extends Material {

	public Book(String code, String title, String autor, int year, int copies) {
		super(code, title, autor, year, copies);
	}

	@Override
	public double calculateFine() {
		return 100.00;
	}

	@Override
	public int dayLoans() {
		return 10;
	}

	@Override
	public boolean isAvailable() {
		return super.isAvailable();
	}

	@Override
	public void reduceCopies() {
		super.reduceCopies();
	}

	@Override
	public void returnCopies() {
		super.returnCopies();
	}

	@Override
	public String toString() {
		return "Book [getCode()=" + getCode() + ", getTitle()=" + getTitle() + ", getAutor()=" + getAutor()
				+ ", getYear()=" + getYear() + ", getCopies()=" + getCopies() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
