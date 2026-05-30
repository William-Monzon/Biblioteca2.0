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
	// Atributos de la ventada libros
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelBlue, panelWhite;
	public JTextField txtCode;
	public JTextField txtTitle;
	public JTextField txtAutor;
	public JTextField txtYear;
	public JTextField txtCopies;
	public JTable table;
	public JButton btnBook, btnUser, btnLoan, btnExit, btnAddBook, btnModifyBook, btnDeleteBook;

	// Constructor de clase libros
	public WindowBook() {
		setTitle("Ventana Libros"); // Titulo de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700); // Dimensiones de la ventana
		setLocationRelativeTo(null); // Coloca la ventana en el medio de la pantalla
		// Panel que contiene todos lo componentes
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		GridBagLayout gblContentPane = new GridBagLayout(); // GridBagLayoud para alinear los componentes de manera dinámica en una cuadricula
		gblContentPane.columnWidths = new int[] { 232, 854, 0 };
		gblContentPane.rowHeights = new int[] { 663, 0 };
		gblContentPane.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gblContentPane.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gblContentPane);
		// Panel azul
		panelBlue = new JPanel();
		panelBlue.setBackground(new Color(0, 0, 153));
		GridBagConstraints gbcPanelBlue = new GridBagConstraints();
		gbcPanelBlue.weighty = 1.0;
		gbcPanelBlue.fill = GridBagConstraints.BOTH; // Hace que el panel se estire cuando la ventana se maximiza
		gbcPanelBlue.insets = new Insets(0, 0, 0, 5); // Se le da una separción de 5 pixeles con respecto al panel blanco
		gbcPanelBlue.gridx = 0;
		gbcPanelBlue.gridy = 0;
		contentPane.add(panelBlue, gbcPanelBlue); // Se agrega el panel azul y el GridBagLayout del panel azul
		panelBlue.setLayout(null);

		JLabel lblLibrary = new JLabel("  Biblioteca");
		lblLibrary.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibrary.setIcon(new ImageIcon(WindowBook.class.getResource("/interfaces/images/Library.png")));
		lblLibrary.setForeground(new Color(255, 255, 255));
		lblLibrary.setFont(new Font("Dialog", Font.BOLD, 19));
		lblLibrary.setBounds(32, 23, 171, 50);
		panelBlue.add(lblLibrary);
		// Botones del panel azul que contienen iconos
		btnBook = buttons("    Libros", new ImageIcon(WindowBook.class.getResource("/interfaces/images/Book.png")));
		btnBook.setBounds(33, 115, 160, 38);// setBounds para darle dimensiones al botón
		panelBlue.add(btnBook); // .add() para agregar el botón
		// ImageIcon() es el objeto para colocar un icono y con getResource() se busca la dirección de la imagen para colocarla
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
		// Panel Blanco que contiene los demás componentes
		panelWhite = new JPanel();
		panelWhite.setBackground(Color.WHITE);
		GridBagConstraints gbcPanelWhite = new GridBagConstraints();
		gbcPanelWhite.weighty = 1.0;
		gbcPanelWhite.weightx = 1.0;
		gbcPanelWhite.fill = GridBagConstraints.BOTH;
		gbcPanelWhite.gridx = 1; // Indica que el panel ocupe la columna 1 porque el panel azul ocupa la columna
									// 0
		gbcPanelWhite.gridy = 0;
		contentPane.add(panelWhite, gbcPanelWhite); // Se agrega el panel blanco y el GridBagLayout del panel blanco
		GridBagLayout gblPanelWhite = new GridBagLayout();
		gblPanelWhite.columnWidths = new int[] { 854, 0 }; // Se le da el tamaño a las columnas y filas de la cuadricula
		gblPanelWhite.rowHeights = new int[] { 36, 42, 2, 301, 35, 0 };
		gblPanelWhite.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gblPanelWhite.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelWhite.setLayout(gblPanelWhite);
		// Label con GridBagLayout para adecuarse a la ventana
		JLabel lblBooks = new JLabel("Libros");
		GridBagConstraints gbcLblBooks = new GridBagConstraints();
		gbcLblBooks.anchor = GridBagConstraints.WEST;
		gbcLblBooks.fill = GridBagConstraints.VERTICAL;
		gbcLblBooks.insets = new Insets(0, 0, 5, 0);
		gbcLblBooks.gridx = 0;
		gbcLblBooks.gridy = 1;
		panelWhite.add(lblBooks, gbcLblBooks);
		lblBooks.setFont(new Font("Dialog", Font.BOLD, 30));
		// Separador con GridBagLayout para expandirse junto con la ventana
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.anchor = GridBagConstraints.NORTH;
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 2;
		panelWhite.add(separator, gbc_separator);
		// Panel que contiene los labels y campos de texto de la ventana
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GridBagConstraints gbcPanel = new GridBagConstraints();
		gbcPanel.fill = GridBagConstraints.BOTH;
		gbcPanel.insets = new Insets(0, 0, 5, 0);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 3; // Se coloca en la fila 3
		panelWhite.add(panel, gbcPanel);
		panel.setLayout(null);
		// Botón para agregar libros
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
		// Botón para modificar libros
		btnModifyBook = new JButton("Modificar");
		btnModifyBook.setFont(new Font("Dialog", Font.BOLD, 16));
		btnModifyBook.setBackground(new Color(204, 153, 0));
		btnModifyBook.setForeground(Color.WHITE);
		btnModifyBook.setOpaque(true);
		btnModifyBook.setBorderPainted(false);
		btnModifyBook.setFocusPainted(false);
		btnModifyBook.setBounds(297, 256, 146, 35);
		panel.add(btnModifyBook);
		// Botón para eliminar libros
		btnDeleteBook = new JButton("Eliminar");
		btnDeleteBook.setFont(new Font("Dialog", Font.BOLD, 16));
		btnDeleteBook.setBackground(new Color(153, 0, 0));
		btnDeleteBook.setForeground(Color.WHITE);
		btnDeleteBook.setOpaque(true);
		btnDeleteBook.setBorderPainted(false);
		btnDeleteBook.setFocusPainted(false);
		btnDeleteBook.setBounds(561, 256, 146, 35);
		panel.add(btnDeleteBook);

		// Label y campos de texto para ingresar los datos del libro
		txtAutor = txtField("Ingrese el autor");
		txtAutor.setBounds(38, 199, 433, 27); // Dimensiones de los campos de texto
		panel.add(txtAutor);

		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(38, 173, 52, 16);
		panel.add(lblAutor);
		lblAutor.setFont(new Font("Dialog", Font.BOLD, 15)); // Tipo de letra y tamaño de las letras del label

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
		// JScrollpane para cuando los libros ya no quepan en la ventana
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbcSscrollPane = new GridBagConstraints();
		gbcSscrollPane.weighty = 1.0;
		gbcSscrollPane.weightx = 1.0;
		gbcSscrollPane.fill = GridBagConstraints.BOTH;
		gbcSscrollPane.gridx = 0;
		gbcSscrollPane.gridy = 4; // Se coloca en la fila 4
		panelWhite.add(scrollPane, gbcSscrollPane);
		// Tabla que muestra los libros
		table = new JTable();// Se crea la tabla vacia
		table.setFont(new Font("Dialog", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(new Object[][] {}, // Inicializa la tabla de forma limpia, porque está vacío
				new String[] { // Se nombra las columnas
						"Código", "Titulo", "Autor", "Año", "Copias" })); // Aquí se configura el ancho y y el ancho minimo de las columnas
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(210);
		table.getColumnModel().getColumn(1).setMinWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(210);
		table.getColumnModel().getColumn(2).setMinWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(15);
		table.getColumnModel().getColumn(4).setPreferredWidth(15);
		table.setToolTipText(""); // Deja un texto flotante
		table.setFillsViewportHeight(true);// Hace que la tabla de esti
		table.setCellSelectionEnabled(true); // Permite seleccionear una celda de la tabla
		table.setColumnSelectionAllowed(true); // Permite seleccionar una columna de la tabla
		scrollPane.setViewportView(table);
	}
	// Método de la configuración de los botones de panel azul, con los parametros del texto y el icono
	public JButton buttons(String text, Icon icon) {
		JButton btn = new JButton(text);
		btn.setIcon(icon); // Se agrega el icono
		btn.setFont(new Font("Dialog", Font.BOLD, 16));
		btn.setBackground(new Color(0, 0, 153));
		btn.setForeground(Color.WHITE);
		btn.setOpaque(true); // Hace que se vuelva transparente para que se del mismo colo que el fondo
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.addActionListener(this); // Al presionar el botón se realiza la acción de este botón
		return btn;
	} 
	//Método de la configuración de los campos de texto
	public JTextField txtField(String text) {
		JTextField txt = new JTextField();
		txt.setToolTipText(text);//Da un diálogo flotante indicando que es lo que se ingresa
		txt.setFont(new Font("Dialog", Font.PLAIN, 12));
		txt.setColumns(10);
		return txt;
	}
	//Método sobreescrito de ActionListener para realizar acciones con los botones
	@Override
	public void actionPerformed(ActionEvent e) { 
		if (btnBook == e.getSource()) { //Si el usuario le da click al botón de libros, ingresa a la ventana de libros
			System.setProperty("file.encoding", "UTF-8");
			EventQueue.invokeLater(() -> {
				try {
					ArrayListBook bookService = new ArrayListBook();
					WindowBook frame = new WindowBook();
					ControllerBook controller = new ControllerBook(bookService, frame, Path.of("archivos/books.csv"));//llama a la clase Controlador de libros
					controller.loadData(); //Carga los datos de los lib
					controller.initEvents(); //inicia los eventos de de ControllerBook
					frame.setVisible(true); //Muestra la ventana
				} catch (Exception ex) {
					ex.printStackTrace(); //Muestra que lineas fallaron
				}
			});
		}
		if (btnUser == e.getSource()) {
			dispose();//dispose() para cerrar las ventanas anteriores
			System.setProperty("file.encoding", "UTF-8");
			EventQueue.invokeLater(() -> {
				try {
					WindowUser frame = new WindowUser();
					new UserController(frame);
					frame.setResizable(true); //Indica que el usuario tiene permitido agrandar la ventana si es true o no tiene permitido con false
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
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
		}
		if (btnExit == e.getSource()) {
			dispose();  //Cierra el programa y las ventanas
		}
	}
}
