package interfaces.users;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class FrmAddUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDIRECCION;
	private JTextField textID;
	private JTextField textCARNET;
	private JTextField textNOMBRE;
	private JTextField textAPELLIDOS;
	private JTextField textEDAD;
	private JTextField textTELEFONO;
	private JTextField textCORREO;
	private JLabel lblAgrusuario;
	private JButton btnCANCELAR;
	private JButton btnGUARDAR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public FrmAddUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 715);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Arial", Font.PLAIN, 14));
		lblID.setBounds(27, 37, 59, 12);
		contentPane.add(lblID);
		
		textDIRECCION = new JTextField();
		textDIRECCION.setBounds(27, 562, 284, 30);
		contentPane.add(textDIRECCION);
		textDIRECCION.setColumns(10);
		
		JLabel lblCARNET = new JLabel("CARNET");
		lblCARNET.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCARNET.setBounds(27, 105, 59, 13);
		contentPane.add(lblCARNET);
		
		textID = new JTextField();
		textID.setBounds(27, 59, 284, 30);
		contentPane.add(textID);
		textID.setColumns(10);
		
		JLabel lblNOMBRE = new JLabel("NOMBRE");
		lblNOMBRE.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNOMBRE.setBounds(27, 178, 77, 12);
		contentPane.add(lblNOMBRE);
		
		textCARNET = new JTextField();
		textCARNET.setBounds(27, 128, 284, 30);
		contentPane.add(textCARNET);
		textCARNET.setColumns(10);
		
		JLabel lblAPELLIDOS = new JLabel("APELLIDOS");
		lblAPELLIDOS.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAPELLIDOS.setBounds(27, 250, 85, 12);
		contentPane.add(lblAPELLIDOS);
		
		textNOMBRE = new JTextField();
		textNOMBRE.setBounds(27, 200, 284, 30);
		contentPane.add(textNOMBRE);
		textNOMBRE.setColumns(10);
		
		JLabel lblEDAD = new JLabel("EDAD");
		lblEDAD.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEDAD.setBounds(27, 320, 44, 12);
		contentPane.add(lblEDAD);
		
		textAPELLIDOS = new JTextField();
		textAPELLIDOS.setBounds(27, 272, 284, 30);
		contentPane.add(textAPELLIDOS);
		textAPELLIDOS.setColumns(10);
		
		JLabel lblTELEFONO = new JLabel("TELEFONO");
		lblTELEFONO.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTELEFONO.setBounds(27, 393, 85, 12);
		contentPane.add(lblTELEFONO);
		
		textEDAD = new JTextField();
		textEDAD.setBounds(27, 342, 284, 30);
		contentPane.add(textEDAD);
		textEDAD.setColumns(10);
		
		JLabel lblCORREO = new JLabel("CORREO");
		lblCORREO.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCORREO.setBounds(27, 466, 77, 12);
		contentPane.add(lblCORREO);
		
		textTELEFONO = new JTextField();
		textTELEFONO.setBounds(27, 415, 284, 30);
		contentPane.add(textTELEFONO);
		textTELEFONO.setColumns(10);
		
		JLabel lblDIRECCION = new JLabel("DIRECCIÓN");
		lblDIRECCION.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDIRECCION.setBounds(27, 540, 99, 12);
		contentPane.add(lblDIRECCION);
		
		textCORREO = new JTextField();
		textCORREO.setBounds(27, 488, 284, 30);
		contentPane.add(textCORREO);
		textCORREO.setColumns(10);
		
		lblAgrusuario = new JLabel("Agregar usuario");
		lblAgrusuario.setFont(new Font("Arial", Font.BOLD, 16));
		lblAgrusuario.setBounds(137, 10, 160, 19);
		contentPane.add(lblAgrusuario);
		
		btnCANCELAR = new JButton("CANCELAR");
		btnCANCELAR.setBackground(new Color(0, 0, 0));
		btnCANCELAR.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCANCELAR.setBounds(23, 630, 116, 38);
		contentPane.add(btnCANCELAR);
		
		btnGUARDAR = new JButton("GUARDAR");
		btnGUARDAR.setFont(new Font("Arial", Font.PLAIN, 14));
		btnGUARDAR.setBackground(new Color(0, 0, 0));
		btnGUARDAR.setBounds(195, 631, 116, 39);
		contentPane.add(btnGUARDAR);

	}

}
