package models.book;

public class Magazine extends Material {

	public Magazine(String code, String title, String autor, int year, int copies) {
		super(code, title, autor, year, copies);
	}

	@Override
	public double calculateFine() {
		return 25.00;
	}

	@Override
	public int dayLoans() {
		return 15;
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
