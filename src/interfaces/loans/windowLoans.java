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
import controllers.user.UserController;
import interfaces.book.WindowBook;
import interfaces.users.WindowUser;
import services.book.ArrayListBook;

public class windowLoans extends JFrame implements ActionListener {
	public windowLoans() {
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnBook, btnUser, btnLoan, btnExit;

	public WindowLoans() {
		setTitle("Ventana Préstamos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		setExtendedState(JFrame.MAXIMIZED_BOTH);

		setBounds(100, 100, 1100, 700);
		setLocationRelativeTo(null);

		// panel azul izquierdo
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 153));
		panel.setBounds(0, 0, 232, 700);

		setLocationRelativeTo(null);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Biblioteca");
		lblNewLabel.setBounds(42, 10, 136, 30);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);

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

		JLabel lblNewLabel_1 = new JLabel("Préstamos");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(284, 49, 191, 56);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Usuario:");
		lblNewLabel_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_2.setBounds(374, 147, 125, 56);
		contentPane.add(lblNewLabel_2);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(384, 206, 358, 27);
		contentPane.add(comboBox);

		JLabel lblNewLabel_3 = new JLabel("Libro");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_3.setBounds(384, 331, 125, 35);
		contentPane.add(lblNewLabel_3);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(384, 391, 375, 27);
		contentPane.add(comboBox_1);

		JLabel lblNewLabel_4 = new JLabel();
		lblNewLabel_4.setBounds(100, 100, 50, 50);

		contentPane.add(lblNewLabel_4);

		JButton btnNewButton_4 = new JButton("Prestar");
		btnNewButton_4.setBounds(780, 570, 120, 40);

		btnNewButton_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (comboBox.getSelectedItem() == null || comboBox_1.getSelectedItem() == null) {

					JOptionPane.showMessageDialog(null, "Seleccione usuario y libro ");
					return;
				}

				JOptionPane.showMessageDialog(null, "Préstamo realizado correctamente\n");

			}

		});

		btnNewButton_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

			;

		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_4.setBackground(new Color(42, 47, 210));
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBounds(374, 529, 149, 56);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.setBackground(Color.decode("#2A2FD2"));
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setOpaque(true);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setFocusPainted(false);

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
