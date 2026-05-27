package interfaces.book;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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

import interfaces.loans.windowLoans;
import interfaces.users.FrmAddUser;
import interfaces.users.FrmUser;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;

public class WindowBook extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCode;
	private JTextField txtTitle;
	private JTextField txtAutor;
	private JTextField txtYear;
	private JTextField txtCopies;
	private JTable table;
	public JButton btnBook, btnUser, btnLoan, btnExit;

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
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{232, 854, 0};
		gbl_contentPane.rowHeights = new int[]{663, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panelBlue = new JPanel();
		panelBlue.setBackground(new Color(0, 0, 153));
		GridBagConstraints gbc_panelBlue = new GridBagConstraints();
		gbc_panelBlue.weighty = 1.0;
		gbc_panelBlue.fill = GridBagConstraints.BOTH;
		gbc_panelBlue.insets = new Insets(0, 0, 0, 5);
		gbc_panelBlue.gridx = 0;
		gbc_panelBlue.gridy = 0;
		contentPane.add(panelBlue, gbc_panelBlue);
		panelBlue.setLayout(null);
		
		JLabel lblLibrary = new JLabel("  Biblioteca");
		lblLibrary.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibrary.setIcon(new ImageIcon(WindowBook.class.getResource("/interfaces/images/Library.png")));
		lblLibrary.setForeground(new Color(255, 255, 255));
		lblLibrary.setFont(new Font("Arial", Font.BOLD, 19));
		lblLibrary.setBounds(32, 23, 171, 50);
		panelBlue.add(lblLibrary);
		
		btnBook = new JButton("    Libros");
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
		btnBook.addActionListener(this);
		panelBlue.add(btnBook);
		
		btnUser = new JButton("   Usuarios");
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
		btnUser.addActionListener(this);
		panelBlue.add(btnUser);
		
		btnLoan = new JButton("   Préstamos");
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
		btnLoan.addActionListener(this);
		panelBlue.add(btnLoan);
		
		btnExit = new JButton("    Salir");
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
		btnExit.addActionListener(this);
		panelBlue.add(btnExit);
		
		JPanel panelWhite = new JPanel();
		panelWhite.setBackground(Color.WHITE);
		GridBagConstraints gbc_panelWhite = new GridBagConstraints();
		gbc_panelWhite.weighty = 1.0;
		gbc_panelWhite.weightx = 1.0;
		gbc_panelWhite.fill = GridBagConstraints.BOTH;
		gbc_panelWhite.gridx = 1;
		gbc_panelWhite.gridy = 0;
		contentPane.add(panelWhite, gbc_panelWhite);
		GridBagLayout gbl_panelWhite = new GridBagLayout();
		gbl_panelWhite.columnWidths = new int[]{854, 0};
		gbl_panelWhite.rowHeights = new int[]{36, 42, 2, 301, 35, 0};
		gbl_panelWhite.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelWhite.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelWhite.setLayout(gbl_panelWhite);
		
		JLabel lblBooks = new JLabel("Libros");
		GridBagConstraints gbc_lblBooks = new GridBagConstraints();
		gbc_lblBooks.anchor = GridBagConstraints.WEST;
		gbc_lblBooks.fill = GridBagConstraints.VERTICAL;
		gbc_lblBooks.insets = new Insets(0, 0, 5, 0);
		gbc_lblBooks.gridx = 0;
		gbc_lblBooks.gridy = 1;
		panelWhite.add(lblBooks, gbc_lblBooks);
		lblBooks.setFont(new Font("Arial", Font.BOLD, 30));
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.anchor = GridBagConstraints.NORTH;
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 2;
		panelWhite.add(separator, gbc_separator);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		panelWhite.add(panel, gbc_panel);
		panel.setLayout(null);
		
		JButton btnAddBook = new JButton("Agregar Libro");
		btnAddBook.setBounds(38, 256, 146, 35);
		btnBook.addActionListener(this);
		panel.add(btnAddBook);
		btnAddBook.setFont(new Font("Arial", Font.BOLD, 17));
		btnAddBook.setBackground(new Color(0, 0, 153));
		btnAddBook.setForeground(Color.WHITE);
		btnAddBook.setOpaque(true);
		btnAddBook.setContentAreaFilled(true);
		btnAddBook.setBorderPainted(false);
		btnAddBook.setFocusPainted(false);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(38, 199, 433, 27);
		panel.add(txtAutor);
		txtAutor.setToolTipText("Ingrese el autor");
		txtAutor.setForeground(new Color(0, 0, 0));
		txtAutor.setFont(new Font("Arial", Font.PLAIN, 12));
		txtAutor.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(38, 173, 52, 16);
		panel.add(lblAutor);
		lblAutor.setFont(new Font("Arial", Font.BOLD, 15));
		
		txtCode = new JTextField();
		txtCode.setBounds(38, 121, 125, 27);
		panel.add(txtCode);
		txtCode.setToolTipText("Ingrese el código");
		txtCode.setForeground(new Color(0, 0, 0));
		txtCode.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCode.setColumns(10);
		
		JLabel lblCode = new JLabel("Código");
		lblCode.setBounds(38, 84, 68, 27);
		panel.add(lblCode);
		lblCode.setFont(new Font("Arial", Font.BOLD, 15));
		
		txtYear = new JTextField();
		txtYear.setBounds(526, 199, 125, 27);
		panel.add(txtYear);
		txtYear.setToolTipText("Ingrese el año");
		txtYear.setForeground(new Color(0, 0, 0));
		txtYear.setFont(new Font("Arial", Font.PLAIN, 12));
		txtYear.setColumns(10);
		
		JLabel lblYear = new JLabel("Año");
		lblYear.setBounds(526, 173, 52, 16);
		panel.add(lblYear);
		lblYear.setFont(new Font("Arial", Font.BOLD, 15));
		
		txtCopies = new JTextField();
		txtCopies.setBounds(703, 199, 125, 27);
		panel.add(txtCopies);
		txtCopies.setToolTipText("Ingrese las copias");
		txtCopies.setForeground(new Color(0, 0, 0));
		txtCopies.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCopies.setColumns(10);
		
		JLabel lblCopies = new JLabel("Copias");
		lblCopies.setBounds(703, 173, 52, 16);
		panel.add(lblCopies);
		lblCopies.setFont(new Font("Arial", Font.BOLD, 15));
		
		txtTitle = new JTextField();
		txtTitle.setBounds(284, 121, 471, 27);
		panel.add(txtTitle);
		txtTitle.setToolTipText("Ingrese el titulo");
		txtTitle.setForeground(new Color(0, 0, 0));
		txtTitle.setFont(new Font("Arial", Font.PLAIN, 12));
		txtTitle.setColumns(10);
		
		JLabel lblTitle = new JLabel("Titulo");
		lblTitle.setBounds(285, 89, 52, 16);
		panel.add(lblTitle);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel lblForm = new JLabel("Formulario");
		lblForm.setBounds(38, 10, 135, 42);
		panel.add(lblForm);
		lblForm.setFont(new Font("Arial", Font.BOLD, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.weighty = 1.0;
		gbc_scrollPane.weightx = 1.0;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		panelWhite.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Arial", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Titulo", "Autor", "A\u00F1o", "Copias"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(210);
		table.getColumnModel().getColumn(1).setMinWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(210);
		table.getColumnModel().getColumn(2).setMinWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(15);
		table.getColumnModel().getColumn(4).setPreferredWidth(15);
		table.setToolTipText("");
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(table);
	}
	public void button() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(btnBook==e.getSource()) {
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
		if(btnUser==e.getSource()) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						FrmUser frame = new FrmUser();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		if(btnLoan==e.getSource()) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						windowLoans frame = new windowLoans();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		if(btnExit==e.getSource()) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						FrmAddUser frame = new FrmAddUser();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
	}
}
