package models.book;

public abstract class Material {
	private final String code;
	private final String title;
	private final String autor;
	private final int year;
	private int copies;

	public Material(String code, String title, String autor, int year, int copies, boolean available) {
		super();
		this.code = code;
		this.title = title;
		this.autor = autor;
		this.year = year;
		this.copies = copies;
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
		this.copies = copies;
	}

	public void setAvailable(boolean available) {
	}

	public abstract double calculateFine();

	public abstract int dayLoans();

	public boolean isAvailable() {
		if (copies > 0) {
			return true;
		} else {
			return false;
		}

	}

	public void reduceCopies() {
		this.copies--;
	}

	public void returnCopies() {
		this.copies++;
	}

	@Override
	public String toString() {
		return "Material [code=" + code + ", title=" + title + ", autor=" + autor + ", year=" + year + "]";
	}
}
