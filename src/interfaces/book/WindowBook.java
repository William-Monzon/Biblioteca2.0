package interfaces.book;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.ScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class WindowBook extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCode;
	private JTextField txtTitle;
	private JTextField txtAutor;
	private JTextField txtYear;
	private JTextField txtCopies;
	private JTable tblBooks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBook frame = new WindowBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WindowBook() {
		setTitle("Ventana Libros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
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
		
		JButton btnBook = new JButton("    Libros");
		btnBook.setIcon(new ImageIcon(WindowBook.class.getResource("/interfaces/images/Book.png")));
		btnBook.setFont(new Font("Arial", Font.BOLD, 16));
		btnBook.setBounds(33, 115, 160, 38);
		// color azul del botón
		btnBook.setBackground(Color.BLUE);
		btnBook.setForeground(Color.WHITE);
		btnBook.setOpaque(true);
		btnBook.setContentAreaFilled(false);
		btnBook.setBorderPainted(false);
		btnBook.setFocusPainted(false);
		panel.add(btnBook);
		
		JButton btnUser = new JButton("   Usuarios");
		btnUser.setIcon(new ImageIcon(WindowBook.class.getResource("/interfaces/images/User.png")));
		btnUser.setFont(new Font("Arial", Font.BOLD, 16));
		btnUser.setBounds(43, 165, 160, 38);
		// color azul del botón
		btnUser.setBackground(Color.BLUE);
		btnUser.setForeground(Color.WHITE);
		btnUser.setOpaque(true);
		btnUser.setContentAreaFilled(false);
		btnUser.setBorderPainted(false);
		btnUser.setFocusPainted(false);
		panel.add(btnUser);
		
		JButton btnLoan = new JButton("   Préstamos");
		btnLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLoan.setIcon(new ImageIcon(WindowBook.class.getResource("/interfaces/images/Loans.png")));
		btnLoan.setFont(new Font("Arial", Font.BOLD, 16));
		btnLoan.setBounds(40, 215, 170, 38);
		// color azul del botón
		btnLoan.setBackground(Color.BLUE);
		btnLoan.setForeground(Color.WHITE);
		btnLoan.setOpaque(true);
		btnLoan.setContentAreaFilled(false);
		btnLoan.setBorderPainted(false);
		btnLoan.setFocusPainted(false);
		panel.add(btnLoan);
		
		JButton btnExit = new JButton("    Salir");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExit.setHorizontalAlignment(SwingConstants.LEADING);
		btnExit.setIcon(new ImageIcon(WindowBook.class.getResource("/interfaces/images/Exit.png")));
		btnExit.setFont(new Font("Arial", Font.BOLD, 16));
		btnExit.setBounds(43, 265, 160, 38);
		// color azul del botón
		btnExit.setBackground(Color.BLUE);
		btnExit.setForeground(Color.WHITE);
		btnExit.setOpaque(true);
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.setFocusPainted(false);
		panel.add(btnExit);
		
		JLabel lblBooks = new JLabel("Libros");
		lblBooks.setFont(new Font("Arial", Font.BOLD, 30));
		lblBooks.setBounds(270, 10, 109, 42);
		contentPane.add(lblBooks);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(252, 62, 824, 2);
		contentPane.add(separator);
		
		JLabel lblForm = new JLabel("Formulario");
		lblForm.setFont(new Font("Arial", Font.BOLD, 20));
		lblForm.setBounds(270, 83, 135, 42);
		contentPane.add(lblForm);
		
		JLabel lblCode = new JLabel("Código");
		lblCode.setFont(new Font("Arial", Font.BOLD, 15));
		lblCode.setBounds(270, 148, 73, 27);
		contentPane.add(lblCode);
		
		JLabel lblTitle = new JLabel("Titulo");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 15));
		lblTitle.setBounds(512, 159, 52, 16);
		contentPane.add(lblTitle);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Arial", Font.BOLD, 15));
		lblAutor.setBounds(270, 236, 52, 16);
		contentPane.add(lblAutor);
		
		JLabel lblYear = new JLabel("Año");
		lblYear.setFont(new Font("Arial", Font.BOLD, 15));
		lblYear.setBounds(734, 236, 52, 16);
		contentPane.add(lblYear);
		
		JLabel lblCopies = new JLabel("Copias");
		lblCopies.setFont(new Font("Arial", Font.BOLD, 15));
		lblCopies.setBounds(933, 236, 52, 16);
		contentPane.add(lblCopies);
		
		txtCode = new JTextField();
		txtCode.setForeground(Color.LIGHT_GRAY);
		txtCode.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCode.setText("Ingrese el código");
		txtCode.setBounds(270, 185, 125, 27);
		contentPane.add(txtCode);
		txtCode.setColumns(10);
		
		txtTitle = new JTextField();
		txtTitle.setText("Ingrese el titulo");
		txtTitle.setForeground(Color.LIGHT_GRAY);
		txtTitle.setFont(new Font("Arial", Font.PLAIN, 12));
		txtTitle.setColumns(10);
		txtTitle.setBounds(512, 185, 400, 27);
		contentPane.add(txtTitle);
		
		txtAutor = new JTextField();
		txtAutor.setText("Ingrese el autor");
		txtAutor.setForeground(Color.LIGHT_GRAY);
		txtAutor.setFont(new Font("Arial", Font.PLAIN, 12));
		txtAutor.setColumns(10);
		txtAutor.setBounds(270, 262, 400, 27);
		contentPane.add(txtAutor);
		
		txtYear = new JTextField();
		txtYear.setText("Ingrese el año");
		txtYear.setForeground(Color.LIGHT_GRAY);
		txtYear.setFont(new Font("Arial", Font.PLAIN, 12));
		txtYear.setColumns(10);
		txtYear.setBounds(733, 262, 125, 27);
		contentPane.add(txtYear);
		
		txtCopies = new JTextField();
		txtCopies.setText("Ingrese las copias");
		txtCopies.setForeground(Color.LIGHT_GRAY);
		txtCopies.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCopies.setColumns(10);
		txtCopies.setBounds(932, 262, 125, 27);
		contentPane.add(txtCopies);
		
		JButton btnAddBook = new JButton("Agregar Libro");
		btnAddBook.setFont(new Font("Arial", Font.BOLD, 17));
		btnAddBook.setBounds(270, 323, 146, 35);
		btnAddBook.setBackground(new Color(0, 0, 153));
		btnAddBook.setForeground(Color.WHITE);
		btnAddBook.setOpaque(true);
		btnAddBook.setContentAreaFilled(true);
		btnAddBook.setBorderPainted(false);
		btnAddBook.setFocusPainted(false);
		contentPane.add(btnAddBook);
		
		tblBooks = new JTable();
		tblBooks.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblBooks.setFont(new Font("Arial", Font.BOLD, 12));
		tblBooks.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Code", "Title", "Autor", "Year", "Copies"
			}
		));
		tblBooks.getColumnModel().getColumn(0).setPreferredWidth(20);
		tblBooks.getColumnModel().getColumn(0).setMinWidth(20);
		tblBooks.getColumnModel().getColumn(1).setPreferredWidth(200);
		tblBooks.getColumnModel().getColumn(2).setPreferredWidth(200);
		tblBooks.getColumnModel().getColumn(2).setMinWidth(20);
		tblBooks.getColumnModel().getColumn(3).setPreferredWidth(20);
		tblBooks.getColumnModel().getColumn(3).setMinWidth(20);
		tblBooks.getColumnModel().getColumn(4).setPreferredWidth(20);
		tblBooks.getColumnModel().getColumn(4).setMinWidth(20);
		tblBooks.setBounds(252, 419, 805, 160);
		contentPane.add(tblBooks);
		

	}
}
