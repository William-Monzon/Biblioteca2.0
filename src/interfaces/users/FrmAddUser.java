package interfaces.users;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class FrmAddUser extends JFrame {
	

	    private static final long serialVersionUID = 1L;

	    private JPanel contentPane;

	    public JTextField textID;
	    public JTextField textCARNET;

	    private JTextField textNOMBRE;
	    private JTextField textAPELLIDOS;
	    private JTextField textEDAD;
	    private JTextField textTELEFONO;
	    private JTextField textCORREO;
	    private JTextField textDIRECCION;

	    public JButton btnGUARDAR;
	    public JButton btnCANCELAR;

	   
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
	
	 public FrmAddUser() {

	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setBounds(100, 100, 400, 700);

	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JLabel lblTitle = new JLabel("AGREGAR USUARIO");
	        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
	        lblTitle.setBounds(100, 20, 250, 30);
	        contentPane.add(lblTitle);

	        JLabel lblID = new JLabel("ID");
	        lblID.setBounds(30, 70, 100, 20);
	        contentPane.add(lblID);

	        textID = new JTextField();
	        textID.setEditable(false);
	        textID.setBounds(30, 95, 300, 30);
	        contentPane.add(textID);

	        JLabel lblCarnet = new JLabel("CARNET");
	        lblCarnet.setBounds(30, 140, 100, 20);
	        contentPane.add(lblCarnet);

	        textCARNET = new JTextField();
	        textCARNET.setEditable(false);
	        textCARNET.setBounds(30, 165, 300, 30);
	        contentPane.add(textCARNET);

	        JLabel lblNombre = new JLabel("NOMBRE");
	        lblNombre.setBounds(30, 210, 100, 20);
	        contentPane.add(lblNombre);
	       
	        

	        textNOMBRE = new JTextField();
	        textNOMBRE.setBounds(30, 235, 300, 30);
	        contentPane.add(textNOMBRE);
	        
	        
	        

	        JLabel lblApellido = new JLabel("APELLIDOS");
	        lblApellido.setBounds(30, 280, 100, 20);
	        contentPane.add(lblApellido);
	      
	        

	        textAPELLIDOS = new JTextField();
	        textAPELLIDOS.setBounds(30, 305, 300, 30);
	        contentPane.add(textAPELLIDOS);

	        
	        
	        
	        
	        JLabel lblEdad = new JLabel("EDAD");
	        lblEdad.setBounds(30, 350, 100, 20);
	        contentPane.add(lblEdad);

	        textEDAD = new JTextField();
	        textEDAD.setBounds(30, 375, 300, 30);
	        contentPane.add(textEDAD);
	        
	        
	  

	        JLabel lblTelefono = new JLabel("TELÉFONO");
	        lblTelefono.setBounds(30, 420, 100, 20);
	        contentPane.add(lblTelefono);
	     

	        textTELEFONO = new JTextField();
	        textTELEFONO.setBounds(30, 445, 300, 30);
	        contentPane.add(textTELEFONO);
	        
	        

	        JLabel lblCorreo = new JLabel("CORREO");
	        lblCorreo.setBounds(30, 490, 100, 20);
	        contentPane.add(lblCorreo);


	        textCORREO = new JTextField();
	        textCORREO.setBounds(30, 515, 300, 30);
	        contentPane.add(textCORREO);
	        
	        

	        JLabel lblDireccion = new JLabel("DIRECCIÓN");
	        lblDireccion.setBounds(30, 560, 100, 20);
	        contentPane.add(lblDireccion);

	        textDIRECCION = new JTextField();
	        textDIRECCION.setBounds(30, 585, 300, 30);
	        contentPane.add(textDIRECCION);

	        btnCANCELAR = new JButton("CANCELAR");
	        btnCANCELAR.setBounds(30, 630, 130, 40);
	        contentPane.add(btnCANCELAR);

	        btnGUARDAR = new JButton("GUARDAR");
	        btnGUARDAR.setBounds(200, 630, 130, 40);
	        contentPane.add(btnGUARDAR);
	    }

	    public void setData(String id, String carnet) {

	        textID.setText(id);
	        textCARNET.setText(carnet);
	    }

	    public JTextField getTextID() {
	        return textID;
	    }

	    public JTextField getTextCARNET() {
	        return textCARNET;
	    }

	    public JTextField getTextNOMBRE() {
	        return textNOMBRE;
	    }

	    public JTextField getTextAPELLIDOS() {
	        return textAPELLIDOS;
	    }

	    public JTextField getTextEDAD() {
	        return textEDAD;
	    }

	    public JTextField getTextTELEFONO() {
	        return textTELEFONO;
	    }

	    public JTextField getTextCORREO() {
	        return textCORREO;
	    }

	    public JTextField getTextDIRECCION() {
	        return textDIRECCION;
	    }
	}

