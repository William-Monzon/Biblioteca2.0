package models.book;

public class Magazine extends Material {

	public Magazine(String code, String title, String autor, int year, int copies, boolean available) {
		super(code, title, autor, year, copies, available);
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

	@Override
	public String toString() {
		return "Magazine [getCode()=" + getCode() + ", getTitle()=" + getTitle() + ", getAutor()=" + getAutor()
				+ ", getYear()=" + getYear() + ", getCopies()=" + getCopies() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
