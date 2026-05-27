package interfaces.users;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import interfaces.book.WindowBook;





public class FrmUser extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JTextField txtid;
    private JTextField txtcarnet;

    public JButton btnAddUser;
    public JButton btnShowUser;

    public FrmUser() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
     // panel azul izquierdo
     		JPanel panel = new JPanel();
     		panel.setBackground(new Color(0, 0, 102));
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
     		
     		
     		
        

        //-----------------------------------
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
}
