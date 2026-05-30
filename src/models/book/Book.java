package models.book;

public class Book extends Material {

	public Book(String code, String title, String autor, int year, int copies) {
		super(code, title, autor, year, copies);
	}
	//Retorna el precio del préstamo
	@Override
	public double calculateFine() {
		return 100.00;
	}
	//Retorna los días del préstamo
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

}
