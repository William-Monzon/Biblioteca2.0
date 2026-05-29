package interfaces.menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import controllers.book.ControllerBook;
import controllers.user.UserController;
import interfaces.book.WindowBook;
import interfaces.loans.WindowLoans;
import interfaces.users.WindowUser;
import services.book.ArrayListBook;

public class WindowMain extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnBook, btnUser, btnLoan, btnExit;


	public WindowMain() {
		setTitle("Ventana Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 153));
		panel.setBounds(0, 0, 232, 663);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblLibrary = new JLabel("  Biblioteca");
		lblLibrary.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibrary.setIcon(new ImageIcon(WindowBook.class.getResource("/interfaces/images/Library.png")));
		lblLibrary.setForeground(new Color(255, 255, 255));
		lblLibrary.setFont(new Font("Arial", Font.BOLD, 19));
		lblLibrary.setBounds(32, 23, 171, 50);
		panel.add(lblLibrary);

		btnBook = buttons("    Libros", new ImageIcon(WindowBook.class.getResource("/interfaces/images/Book.png")));
		btnBook.setBounds(33, 115, 160, 38);
		panel.add(btnBook);
		
		
		btnUser = buttons("   Usuarios", new ImageIcon(WindowBook.class.getResource("/interfaces/images/User.png")));
		btnUser.setBounds(43, 165, 160, 38);
		panel.add(btnUser);
		
		btnLoan = buttons("   Préstamos", new ImageIcon(WindowBook.class.getResource("/interfaces/images/Loans.png")));
		btnLoan.setBounds(40, 215, 170, 38);
		panel.add(btnLoan);
		
		btnExit = buttons("    Salir", new ImageIcon(WindowBook.class.getResource("/interfaces/images/Exit.png")));
		btnExit.setHorizontalAlignment(SwingConstants.LEADING);
		btnExit.setBounds(43, 265, 160, 38);
		panel.add(btnExit);

		// imagen menú
		ImageIcon icon = new ImageIcon(getClass().getResource("/interfaces/images/menu.png"));
		// Escalar imagen
		Image img = icon.getImage().getScaledInstance(310, 320, Image.SCALE_SMOOTH);
		// Convertir otra vez a icono
		ImageIcon iconEscalado = new ImageIcon(img);

		// mensaje de bienvenida
		JLabel lblBooks = new JLabel("Bienvenido al Sistema de Biblioteca");
		lblBooks.setForeground(new Color(0, 0, 128));
		lblBooks.setFont(new Font("Arial", Font.BOLD, 25));
		lblBooks.setBounds(331, 38, 440, 42);
		contentPane.add(lblBooks);

		// mensaje inicio
		JLabel lblForm = new JLabel("Seleccione una opción del menú para comenzar.");
		lblForm.setForeground(new Color(0, 0, 102));
		lblForm.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblForm.setBounds(351, 73, 381, 42);
		contentPane.add(lblForm);

		// Crear JLabel
		JLabel lblImagen = new JLabel(iconEscalado);
		lblImagen.setBounds(331, 147, 394, 296);
		contentPane.add(lblImagen);

	}

	public JButton buttons(String text, Icon icon) {
		JButton btn = new JButton(text);
		btn.setIcon(icon);
		btn.setFont(new Font("Dialog", Font.BOLD, 16));
		btn.setBackground(new Color(0, 0, 153));
		btn.setForeground(Color.WHITE);
		btn.setOpaque(true);
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.addActionListener(this);
		return btn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnBook == e.getSource()) {
			dispose();
			System.setProperty("file.encoding", "UTF-8");
			EventQueue.invokeLater(() -> {
				try {
					ArrayListBook bookService = new ArrayListBook();
					WindowBook frame = new WindowBook();
					ControllerBook controller = new ControllerBook(bookService, frame, Path.of("archivos/books.csv"));
					controller.loadData();
					controller.initEvents();
					frame.setVisible(true);
					this.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
		}
		if (btnUser == e.getSource()) {
			dispose();
			System.setProperty("file.encoding", "UTF-8");
			EventQueue.invokeLater(() -> {
				try {
					WindowUser frame = new WindowUser();
					new UserController(frame);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setResizable(true);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					this.dispose();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
		}
		if (btnLoan == e.getSource()) {
			dispose();
			System.setProperty("file.encoding", "UTF-8");
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						WindowLoans frame = new WindowLoans();
						frame.setVisible(true);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		if (btnExit == e.getSource()) {
			dispose();
		}
	}

}
