package controllers.book;

import interfaces.book.WindowBook;
import services.book.ArrayListBook;

public class ControllerBook {
	private final ArrayListBook book;
	private final WindowBook window;
	public ControllerBook(ArrayListBook book, WindowBook window) {
		super();
		this.book = book;
		this.window = window;
	}
	
	
	
}
