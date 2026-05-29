package interfaces.users;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controllers.book.ControllerBook;
import controllers.user.UserController;
import interfaces.book.WindowBook;
import interfaces.loans.WindowLoans;
import services.book.ArrayListBook;

public class WindowUser extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTextField txtid;
	private JTextField txtcarnet;

	public JButton btnAddUser;
	public JButton btnShowUser;
	public JButton btnBook, btnUser, btnLoan, btnExit;

	public WindowUser() {
		setTitle("Ventana Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// panel azul izquierdo
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 153));
		panel.setBounds(0, 0, 201, 663);
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

		// -----------------------------------
		JLabel lblTitle = new JLabel("USUARIOS");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
		lblTitle.setBounds(211, 10, 200, 40);
		contentPane.add(lblTitle);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Arial", Font.BOLD, 16));
		lblId.setBounds(180, 150, 100, 30);
		contentPane.add(lblId);

		txtid = new JTextField();
		txtid.setBounds(261, 190, 220, 35);
		contentPane.add(txtid);

		JLabel lblCarnet = new JLabel("CARNET");
		lblCarnet.setFont(new Font("Arial", Font.BOLD, 16));
		lblCarnet.setBounds(656, 150, 100, 30);
		contentPane.add(lblCarnet);

		txtcarnet = new JTextField();
		txtcarnet.setBounds(656, 190, 220, 35);
		contentPane.add(txtcarnet);

		btnAddUser = new JButton("AGREGAR USUARIO");
		btnAddUser.setBackground(Color.BLUE);
		btnAddUser.setForeground(Color.WHITE);
		btnAddUser.setBounds(261, 350, 220, 50);
		contentPane.add(btnAddUser);

		btnShowUser = new JButton("MOSTRAR USUARIOS");
		btnShowUser.setBackground(Color.BLUE);
		btnShowUser.setForeground(Color.WHITE);
		btnShowUser.setBounds(656, 350, 220, 50);
		contentPane.add(btnShowUser);

		JLabel lblID1 = new JLabel("ID");
		lblID1.setFont(new Font("Arial", Font.BOLD, 16));
		lblID1.setBounds(261, 159, 65, 12);
		contentPane.add(lblID1);
	}

	public JTextField getTxtid() {
		return txtid;
	}

	public JTextField getTxtcarnet() {
		return txtcarnet;
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
