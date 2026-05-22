package interfaces.menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import interfaces.book.WindowBook;

public class Frmmain_menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmmain_menu frame = new Frmmain_menu();
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
	public Frmmain_menu() {
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

}
