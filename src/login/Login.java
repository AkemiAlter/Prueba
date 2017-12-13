package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtusuario;
	private JPasswordField txtpass;
	private JButton btnIngresar;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/configuracion-personal_318-46663.jpg")));
	inicializar();
	eventos();
	}

 private void inicializar(){
	 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 247);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(83, 42, 79, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setBounds(65, 100, 97, 16);
		contentPane.add(lblNewLabel_1);
		
		txtusuario = new JTextField();
		txtusuario.setBounds(194, 40, 116, 22);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(194, 98, 116, 22);
		contentPane.add(txtpass);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setSelectedIcon(new ImageIcon(Login.class.getResource("/Imagenes/descarga (1).jpg")));
		btnIngresar.setForeground(Color.GRAY);
		btnIngresar.setFont(new Font("Castellar", Font.BOLD | Font.ITALIC, 10));
		btnIngresar.setBounds(71, 166, 116, 25);
		contentPane.add(btnIngresar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.GRAY);
		btnSalir.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 11));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(260, 166, 97, 25);
		contentPane.add(btnSalir);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(116, 11, 46, 14);
		contentPane.add(lblLogin);
	 
 }
 public void eventos(){
	 btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				char []con =txtpass.getPassword();	
				String contra = new String (con);
			
				if(txtusuario.getText().equals("akemi")&&contra.equals("homura")){
					dispose();
				JOptionPane.showMessageDialog(null,"Bienvenido Administrador ","Admin",JOptionPane.INFORMATION_MESSAGE);		
				MDI1 go = new MDI1();
				go.setVisible(true);
				
				}
				else
				{
				JOptionPane.showMessageDialog(null, "Usuario y/o contra incorrecta","ponga bien joven",JOptionPane.ERROR_MESSAGE);	
				
				txtusuario.setText("");
				txtpass.setText("");
				txtusuario.requestFocus();
				}
				
					
				
				
			}
		});
	 
 }
}
