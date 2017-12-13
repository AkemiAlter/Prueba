package login;

import java.awt.EventQueue;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import ConexionBD.Conexion;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class RegistroPersonal extends JInternalFrame {
	/**
	 * 
	 */
	private JTextField txtcod;
	private JTextField txtnom;
	private JTextField txtap;
	private JButton btnregistrar;
	
	DefaultTableModel model=new DefaultTableModel();
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTextField txttel;
	private JLabel label;
	private JTextField txtfecha;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JScrollPane scrollPane;
	private JTable table;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroPersonal frame = new RegistroPersonal();
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
	public RegistroPersonal() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		getContentPane().setForeground(Color.BLACK);
		setClosable(true);
		setMaximizable(true);
		setResizable(true);
	inicializar();	
	eventos();
	buscar("");
	}
	private void inicializar(){
		setBounds(100, 100, 566, 555);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Personal");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblNewLabel.setBounds(180, 28, 177, 16);
		getContentPane().add(lblNewLabel);
		
		txtcod = new JTextField();
		txtcod.setBounds(112, 55, 116, 22);
		getContentPane().add(txtcod);
		txtcod.setColumns(10);
		
		txtnom = new JTextField();
		txtnom.setColumns(10);
		txtnom.setBounds(112, 88, 116, 22);
		getContentPane().add(txtnom);
		
		txtap = new JTextField();
		txtap.setColumns(10);
		txtap.setBounds(112, 135, 116, 22);
		getContentPane().add(txtap);
		
		btnregistrar = new JButton("Registrar");
		btnregistrar.setForeground(Color.BLACK);
		
		btnregistrar.setBounds(34, 252, 97, 25);
		getContentPane().add(btnregistrar);
		
		btnNewButton = new JButton("Eliminar");
		btnNewButton.setForeground(Color.BLACK);
		
		btnNewButton.setBounds(165, 252, 97, 25);
		getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Nuevo");
		btnNewButton_1.setForeground(Color.BLACK);
		
		btnNewButton_1.setBounds(331, 252, 97, 25);
		getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.setForeground(Color.BLACK);
		
		btnNewButton_2.setBounds(441, 483, 97, 25);
		getContentPane().add(btnNewButton_2);
		
		txttel = new JTextField();
		
		txttel.setBounds(112, 180, 116, 22);
		getContentPane().add(txttel);
		txttel.setColumns(10);
		
		label = new JLabel("Fecha de nacimiento");
		label.setBounds(34, 218, 98, 14);
		getContentPane().add(label);
		
		txtfecha = new JTextField();
		txtfecha.setColumns(10);
		txtfecha.setBounds(142, 215, 103, 20);
		getContentPane().add(txtfecha);
		
		label_1 = new JLabel("Telefono");
		label_1.setBounds(56, 189, 46, 14);
		getContentPane().add(label_1);
		
		label_2 = new JLabel("Apellidos");
		label_2.setBounds(56, 143, 46, 14);
		getContentPane().add(label_2);
		
		label_3 = new JLabel("Nombres");
		label_3.setBounds(56, 99, 46, 14);
		getContentPane().add(label_3);
		
		label_4 = new JLabel("Codigo");
		label_4.setBounds(56, 58, 46, 14);
		getContentPane().add(label_4);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(44, 297, 404, 175);
		getContentPane().add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
	buscar("");
	}
		
	
public void eventos(){

	btnregistrar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			registrar();
			buscar("");
		}
	});
	
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			nuevo();
		}
	});
	
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			elminar();
			buscar("");
		}
	});
	btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		dispose();
		}
	});
	
	txttel.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent arg0) 
		{
			buscar(txttel.getText());
		}
	});
		
	
	
}
public void registrar()
{	try 
	{	Conexion cc= new Conexion();
		Connection con= cc.conexion();
		String sql=null;
		String Cod,nom, Ape, Telefono, Fecha;;
		Cod= txtcod.getText();
		nom= txtnom.getText();
		Ape= txtap.getText();
		Telefono= txttel.getText();
		Fecha= txtfecha.getText();
		sql= "INSERT INTO registro (COD, nombre, apellidos, Telefono, fecha)"+ "values (?,?,?,?,?)";
		PreparedStatement pst= con.prepareStatement(sql);
		pst.setString(1, Cod);
		pst.setString(2, nom);
		pst.setString(3, Ape);				
		pst.setString(4, Telefono);
		pst.setString(5, Fecha);
		
		
		int n= pst.executeUpdate();
		if(n>0)
		{ JOptionPane.showMessageDialog(null,"Personal Registrado");
		}		
		buscar("");
		
	} 
	catch (ClassNotFoundException | SQLException e) 
	{	e.printStackTrace();
	}
	
}
public void buscar(String valor)
{	String [] registro= {"COD", "nombre", "apellidos", "telefono","fecha"};
	String [] filas= new String[5];
	String sql= "SELECT *FROM registro where  nombre like '%" + valor+ "%'";
	
	model = new DefaultTableModel(null, registro);
	try 
	{	Conexion cc = new Conexion();
		Connection cn= cc.conexion();
		Statement st =cn.createStatement();
		ResultSet rs = st.executeQuery(sql);		
		while(rs.next())
		{	filas[0] = rs.getString("COD");
			filas[1] = rs.getString("nombre");
			filas[2] = rs.getString("apellidos");
			filas[3] = rs.getString("Telefono");
			filas[4] = rs.getString("fecha");
			model.addRow(filas);
		}
		table.setModel(model);
		
	} 
	catch (ClassNotFoundException | SQLException e) 
	{	e.printStackTrace();
	}		
}

public void nuevo(){
	
	txtcod.setText("");
	txtnom.setText("");		
	txtap.setText("");
	txttel.setText("");
	txtfecha.setText("");
}

public void elminar(){	
	
	try {	
		Conexion cc=new Conexion();
		Connection cn=cc.conexion();
		String sql=null;
		String cod;
		cod=txtcod.getText();
		sql="call spEliminarPersonal(?) ";
	    CallableStatement cCod=cn.prepareCall(sql);
		cCod.setString(1, cod);
		cCod.executeUpdate();
		
				JOptionPane.showMessageDialog(null, "Personal Eliminado");
		
		
	}	
	catch (ClassNotFoundException | SQLException e) {	
		
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "Personal NO ELIMINADO");
	}	
	
}
}	






