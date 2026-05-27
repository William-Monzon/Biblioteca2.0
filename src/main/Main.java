package main;


import javax.swing.JFrame;

import interfaces.users.FrmUser;



import java.awt.EventQueue;
import java.nio.file.Path;

import controllers.book.ControllerBook;
import controllers.user.UserController;
import interfaces.book.WindowBook;
import services.book.ArrayListBook;

public class Main {

	public static void main(String[] args) {
		System.setProperty("file.encoding", "UTF-8");
		EventQueue.invokeLater(() -> {
			try {
				ArrayListBook bookService = new ArrayListBook();
				WindowBook frame = new WindowBook();
				ControllerBook controller = new ControllerBook(bookService, frame, Path.of("archivos/books.csv"));
				controller.loadData();
				controller.initEvents();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		/*// Crear ventana principal
        FrmUser view = new FrmUser();

        // Crear controlador
        new UserController(view);

        // Abrir maximizado
        view.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Permitir redimensionar
        view.setResizable(true);

        // Centrar ventana
        view.setLocationRelativeTo(null);

        // Mostrar ventana
        view.setVisible(true);*/
	}


}
