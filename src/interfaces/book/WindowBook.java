package interfaces.book;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controllers.book.ControllerBook;
import controllers.user.UserController;
import interfaces.loans.WindowLoans;
import interfaces.users.WindowUser;
import services.book.ArrayListBook;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JScrollPane;

public class WindowBook extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelBlue, panelWhite;
	public JTextField txtCode;
	public JTextField txtTitle;
	public JTextField txtAutor;
	public JTextField txtYear;
	public JTextField txtCopies;
	public JTable table;
	public JButton btnBook, btnUser, btnLoan, btnExit, btnAddBook, btnModifyBook, btnDeleteBook;

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
		
		panelBlue = new JPanel();
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
		lblLibrary.setFont(new Font("Dialog", Font.BOLD, 19));
		lblLibrary.setBounds(32, 23, 171, 50);
		panelBlue.add(lblLibrary);
		
		btnBook = buttons("    Libros", new ImageIcon(WindowBook.class.getResource("/interfaces/images/Book.png")));
		btnBook.setBounds(33, 115, 160, 38);
		panelBlue.add(btnBook);
		
		
		btnUser = buttons("   Usuarios", new ImageIcon(WindowBook.class.getResource("/interfaces/images/User.png")));
		btnUser.setBounds(43, 165, 160, 38);
		panelBlue.add(btnUser);
		
		btnLoan = buttons("   Préstamos", new ImageIcon(WindowBook.class.getResource("/interfaces/images/Loans.png")));
		btnLoan.setBounds(40, 215, 170, 38);
		panelBlue.add(btnLoan);
		
		btnExit = buttons("    Salir", new ImageIcon(WindowBook.class.getResource("/interfaces/images/Exit.png")));
		btnExit.setHorizontalAlignment(SwingConstants.LEADING);
		btnExit.setBounds(43, 265, 160, 38);
		panelBlue.add(btnExit);
		
		panelWhite = new JPanel();
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
		lblBooks.setFont(new Font("Dialog", Font.BOLD, 30));
		
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
		
		btnAddBook = new JButton("Agregar");
		btnAddBook.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAddBook.setBackground(new Color(0, 0, 153));
		btnAddBook.setForeground(Color.WHITE);
		btnAddBook.setOpaque(true);
		btnAddBook.setBorderPainted(false);
		btnAddBook.setFocusPainted(false);
		btnAddBook.addActionListener(this);
		btnAddBook.setBounds(38, 256, 146, 35);
		panel.add(btnAddBook);

		btnModifyBook = new JButton("Modificar");
		btnModifyBook.setFont(new Font("Dialog", Font.BOLD, 16));
		btnModifyBook.setBackground(new Color(204, 153, 0));
		btnModifyBook.setForeground(Color.WHITE);
		btnModifyBook.setOpaque(true);
		btnModifyBook.setBorderPainted(false);
		btnModifyBook.setFocusPainted(false);
		btnModifyBook.setBounds(297, 256, 146, 35);
		panel.add(btnModifyBook);

		btnDeleteBook = new JButton("Eliminar");
		btnDeleteBook.setFont(new Font("Dialog", Font.BOLD, 16));
		btnDeleteBook.setBackground(new Color(153, 0, 0));
		btnDeleteBook.setForeground(Color.WHITE);
		btnDeleteBook.setOpaque(true);
		btnDeleteBook.setBorderPainted(false);
		btnDeleteBook.setFocusPainted(false);
		btnDeleteBook.setBounds(561, 256, 146, 35);
		panel.add(btnDeleteBook);
		
		
		txtAutor = txtField("Ingrese el autor");
		txtAutor.setBounds(38, 199, 433, 27);
		panel.add(txtAutor);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(38, 173, 52, 16);
		panel.add(lblAutor);
		lblAutor.setFont(new Font("Dialog", Font.BOLD, 15));
		
		txtCode = txtField("Ingrese el código");
		txtCode.setBounds(38, 121, 125, 27);
		panel.add(txtCode);
		
		JLabel lblCode = new JLabel("Código");
		lblCode.setBounds(38, 84, 68, 27);
		panel.add(lblCode);
		lblCode.setFont(new Font("Dialog", Font.BOLD, 15));
		
		txtYear = txtField("Ingrese el año");
		txtYear.setBounds(526, 199, 125, 27);
		panel.add(txtYear);
		
		JLabel lblYear = new JLabel("Año");
		lblYear.setBounds(526, 173, 52, 16);
		panel.add(lblYear);
		lblYear.setFont(new Font("Dialog", Font.BOLD, 15));
		
		txtCopies = txtField("Ingrese las copias");
		txtCopies.setBounds(703, 199, 125, 27);
		panel.add(txtCopies);
		
		JLabel lblCopies = new JLabel("Copias");
		lblCopies.setBounds(703, 173, 52, 16);
		panel.add(lblCopies);
		lblCopies.setFont(new Font("Dialog", Font.BOLD, 15));
		
		txtTitle = txtField("Ingrese el titulo");
		txtTitle.setBounds(284, 121, 471, 27);
		panel.add(txtTitle);
		
		JLabel lblTitle = new JLabel("Titulo");
		lblTitle.setBounds(285, 89, 52, 16);
		panel.add(lblTitle);
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JLabel lblForm = new JLabel("Formulario");
		lblForm.setBounds(38, 10, 135, 42);
		panel.add(lblForm);
		lblForm.setFont(new Font("Dialog", Font.BOLD, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.weighty = 1.0;
		gbc_scrollPane.weightx = 1.0;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		panelWhite.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Dialog", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {},
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
	public JTextField txtField(String text) {
		JTextField txt = new JTextField();
		txt.setToolTipText(text);
		txt.setFont(new Font("Dialog", Font.PLAIN, 12));
		txt.setColumns(10);
		return txt;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(btnBook == e.getSource()) {
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
		if(btnUser==e.getSource()) {
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
		if(btnLoan==e.getSource()) {
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
		if(btnExit == e.getSource()) {
			dispose();
		}
	}
}
