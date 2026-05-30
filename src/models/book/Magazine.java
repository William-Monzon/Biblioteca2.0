package models.book;
//Esta clase no se agrego al proyecto, pero queda aqui como una futura actualización si la biblioteca empieza a trabajar con revistas
public class Magazine extends Material { //Clase hija

	public Magazine(String code, String title, String autor, int year, int copies) {
		super(code, title, autor, year, copies);
	}
	//Da el precio del préstamo
	@Override
	public double calculateFine() {
		return 25.00;
	}
	//Retorna los días del préstamo
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
