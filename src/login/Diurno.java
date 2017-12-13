package login;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ConexionBD.Conexion;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Diurno extends JInternalFrame {
	private JTextField txtnom;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Diurno frame = new Diurno();
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
	DefaultTableModel model = new DefaultTableModel();
	public Diurno() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setForeground(Color.BLACK);
		setClosable(true);
		setMaximizable(true);
		setResizable(true);
	inicializar();	
	eventos();
	buscar("");
	}
	private void eventos() {
		// TODO Auto-generated method stub
		
	}
	private void inicializar(){
		setBounds(100, 100, 558, 463);
		getContentPane().setLayout(null);
		
		JLabel lblPersonalDiurno = new JLabel("Personal Diurno");
		lblPersonalDiurno.setBounds(228, 11, 112, 14);
		getContentPane().add(lblPersonalDiurno);
		
		JLabel lblBuscarPorNombres = new JLabel("Buscar por nombres");
		lblBuscarPorNombres.setBounds(32, 61, 117, 14);
		getContentPane().add(lblBuscarPorNombres);
		
		txtnom = new JTextField();
		txtnom.setBounds(175, 58, 86, 20);
		getContentPane().add(txtnom);
		txtnom.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(Diurno.class.getResource("/Imagenes/descarga (1).jpg")));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar("");
			}
		});
		btnBuscar.setBounds(387, 57, 89, 23);
		getContentPane().add(btnBuscar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setBounds(387, 97, 89, 23);
		getContentPane().add(btnSalir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 210, 506, 193);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		buscar("");
	}

		private void buscar(String valor) {
		{	String [] registro= {"COD", "nombre", "apellidos", "telefono","fecha"};
		String [] filas= new String[5];
		String sql= "SELECT *FROM diurno where  nombre like '%" + valor+ txtnom.getText() + "%'";
		
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

		
	}
}

