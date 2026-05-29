package interfaces.loans;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

import javax.swing.border.EmptyBorder;
import javax.swing.*;

import controllers.book.ControllerBook;
import controllers.loans.LoansController;
import controllers.user.UserController;
import interfaces.book.WindowBook;
import interfaces.users.WindowUser;
import models.book.Book;
import models.user.User;
import services.book.ArrayListBook;

public class WindowLoans extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnBook, btnUser, btnLoan, btnExit;
	public JComboBox<User> cbUsers;
	public JComboBox<Book> cbBooks;
	private LoansController controller;

	public WindowLoans() {
		setTitle("Ventana Pr\u00E9stamos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1100, 700);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 153));
		panel.setBounds(0, 0, 232, 700);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Biblioteca");
		lblNewLabel.setBounds(42, 10, 136, 30);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);

		btnBook = buttons("    Libros", new ImageIcon(WindowBook.class.getResource("/interfaces/images/Book.png")));
		btnBook.setBounds(33, 115, 160, 38);
		panel.add(btnBook);

		btnUser = buttons("   Usuarios", new ImageIcon(WindowBook.class.getResource("/interfaces/images/User.png")));
		btnUser.setBounds(43, 165, 160, 38);
		panel.add(btnUser);

		btnLoan = buttons("   Pr\u00E9stamos", new ImageIcon(WindowBook.class.getResource("/interfaces/images/Loans.png")));
		btnLoan.setBounds(40, 215, 170, 38);
		panel.add(btnLoan);

		btnExit = buttons("    Salir", new ImageIcon(WindowBook.class.getResource("/interfaces/images/Exit.png")));
		btnExit.setHorizontalAlignment(SwingConstants.LEADING);
		btnExit.setBounds(43, 265, 160, 38);
		panel.add(btnExit);

		JLabel lblNewLabel_1 = new JLabel("Pr\u00E9stamos");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel_1.setBounds(284, 49, 191, 56);
		contentPane.add(lblNewLabel_1);

		JLabel lblUser = new JLabel("Usuario:");
		lblUser.setBackground(new Color(240, 240, 240));
		lblUser.setFont(new Font("Dialog", Font.BOLD, 23));
		lblUser.setBounds(374, 147, 125, 56);
		contentPane.add(lblUser);

		cbUsers = new JComboBox<>();
		cbUsers.setBounds(384, 206, 358, 27);
		contentPane.add(cbUsers);

		JLabel lblBook = new JLabel("Libro");
		lblBook.setFont(new Font("Dialog", Font.BOLD, 23));
		lblBook.setBounds(384, 331, 125, 35);
		contentPane.add(lblBook);

		cbBooks = new JComboBox<>();
		cbBooks.setBounds(384, 391, 375, 27);
		contentPane.add(cbBooks);

		JButton btnPrestar = new JButton("Prestar");
		btnPrestar.setFont(new Font("Dialog", Font.BOLD, 18));
		btnPrestar.setBackground(Color.decode("#2A2FD2"));
		btnPrestar.setForeground(Color.WHITE);
		btnPrestar.setOpaque(true);
		btnPrestar.setBorderPainted(false);
		btnPrestar.setFocusPainted(false);
		btnPrestar.setBounds(374, 490, 149, 56);
		contentPane.add(btnPrestar);
		btnPrestar.addActionListener(e -> prestar());

		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.setFont(new Font("Dialog", Font.BOLD, 18));
		btnDevolver.setBackground(Color.decode("#008000"));
		btnDevolver.setForeground(Color.WHITE);
		btnDevolver.setOpaque(true);
		btnDevolver.setBorderPainted(false);
		btnDevolver.setFocusPainted(false);
		btnDevolver.setBounds(553, 490, 149, 56);
		contentPane.add(btnDevolver);
		btnDevolver.addActionListener(e -> devolver());

		controller = new LoansController(cbUsers, cbBooks);
	}

	private void prestar() {
		if (cbUsers.getSelectedItem() == null || cbBooks.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(this, "Seleccione usuario y libro", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		controller.createloan();
	}

	private void devolver() {
		if (cbUsers.getSelectedItem() == null || cbBooks.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(this, "Seleccione usuario y libro", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		controller.returnLoan();
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
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
		}
		if (btnLoan == e.getSource()) {
			dispose();
			EventQueue.invokeLater(() -> {
				try {
					WindowLoans frame = new WindowLoans();
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
		}
		if (btnExit == e.getSource()) {
			dispose();
		}
	}
}
