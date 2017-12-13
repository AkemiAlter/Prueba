package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class Pagos extends JFrame {

	private JPanel contentPane;
	private JTextField txtCod;
	private JTextField txtApe;
	private JTextField txtNom;
	private JTextField txtH;
	private JTextField txtPago;
	private JTextField txtRim;
	private JTextField txtSal;
	private JTextField txtBon;
	private JTextField txtDesc;

	DefaultListModel lista = new DefaultListModel();
	DefaultTableModel tabla = new DefaultTableModel();
	int sal=0;
	double bonF=0;
	double rin=0;
	double salt=0;
	private JComboBox cboMes;
	private JComboBox cboTurno;
	private JComboBox cboGrado;
	private JComboBox cboDias;
	private JLabel lblH;
	private JLabel lblPago;
	private JButton btnNewButton_2;
	private JButton btnNewButton;
	private JButton btnNewButton_3;
	private JScrollPane scrollPane;
	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pagos frame = new Pagos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Pagos() {
		inicializar();
		events();
		llenarLista();
		llenarCombo1();
		llenarCombo2();
		llenarCombo3();
		tabla();
		dias();
		calculo();
	}
		
		
	private void inicializar()
{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 654);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlanillaDeDocentes = new JLabel("Sueldo trabajador");
		lblPlanillaDeDocentes.setBackground(Color.RED);
		lblPlanillaDeDocentes.setBounds(217, 11, 286, 35);
		lblPlanillaDeDocentes.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(lblPlanillaDeDocentes);
		
		JLabel lblM = new JLabel("Mes");
		lblM.setBounds(32, 61, 26, 14);
		lblM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblM);
		
		cboMes = new JComboBox();
		cboMes.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		cboMes.setBounds(68, 60, 96, 20);
		contentPane.add(cboMes);
		
		JLabel lblCodigo = new JLabel("CODIGO\r\n");
		lblCodigo.setBounds(24, 93, 46, 14);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblCodigo);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(24, 118, 86, 14);
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblApellido);
		
		JLabel lblNombre = new JLabel("NOMBRE\r\n");
		lblNombre.setBounds(24, 143, 86, 14);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblNombre);
		
		JLabel lblTurno = new JLabel("TURNO\r\n");
		lblTurno.setBounds(212, 94, 46, 14);
		lblTurno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblTurno);
		
		JLabel lblGradoAcademico = new JLabel("Personal");
		lblGradoAcademico.setBounds(212, 118, 130, 14);
		lblGradoAcademico.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblGradoAcademico);
		
		lblH = new JLabel("Nro HORAS");
		lblH.setBounds(460, 87, 59, 14);
		contentPane.add(lblH);
		
		lblPago = new JLabel("PAGO POR HORA");
		lblPago.setBounds(445, 144, 74, 14);
		contentPane.add(lblPago);
		
		txtCod = new JTextField();
		txtCod.setBounds(98, 91, 86, 20);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		txtApe = new JTextField();
		txtApe.setBounds(98, 116, 86, 20);
		contentPane.add(txtApe);
		txtApe.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setBounds(98, 141, 86, 20);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		cboTurno = new JComboBox();
		cboTurno.setBounds(340, 91, 74, 20);
		contentPane.add(cboTurno);
		
		cboGrado = new JComboBox();
		cboGrado.setBounds(340, 116, 74, 20);
		contentPane.add(cboGrado);
		
		txtH = new JTextField();
		txtH.setBounds(443, 112, 86, 20);
		contentPane.add(txtH);
		txtH.setColumns(10);
		
		txtPago = new JTextField();
		txtPago.setBounds(443, 169, 86, 20);
		txtPago.setEnabled(false);
		txtPago.setVerifyInputWhenFocusTarget(false);
		txtPago.setText("40.0");
		contentPane.add(txtPago);
		txtPago.setColumns(10);
		
		JLabel lblRim = new JLabel("RIM");
		lblRim.setBounds(24, 215, 46, 14);
		lblRim.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblRim);
		
		JLabel lblNroDeDias = new JLabel("Nro Dias Falta");
		lblNroDeDias.setBounds(24, 240, 72, 14);
		lblNroDeDias.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblNroDeDias);
		
		JLabel lblSueldoMensual = new JLabel("SUELDO MENSUAL");
		lblSueldoMensual.setBounds(24, 343, 121, 14);
		lblSueldoMensual.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblSueldoMensual);
		
		JLabel lblBonificaciones = new JLabel("BONIFICACIONES");
		lblBonificaciones.setBounds(270, 215, 102, 14);
		lblBonificaciones.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblBonificaciones);
		
		JLabel lblDescuentos = new JLabel("DESCUENTOS");
		lblDescuentos.setBounds(276, 270, 96, 14);
		lblDescuentos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblDescuentos);
		
		txtRim = new JTextField();
		txtRim.setBounds(108, 213, 86, 20);
		txtRim.setEnabled(false);
		contentPane.add(txtRim);
		txtRim.setColumns(10);
		
		txtSal = new JTextField();
		txtSal.setBounds(153, 337, 86, 20);
		contentPane.add(txtSal);
		txtSal.setColumns(10);
		
		txtBon = new JTextField();
		txtBon.setBounds(280, 239, 86, 20);
		contentPane.add(txtBon);
		txtBon.setColumns(10);
		
		txtDesc = new JTextField();
		txtDesc.setBounds(276, 295, 86, 20);
		contentPane.add(txtDesc);
		txtDesc.setColumns(10);
		btnNewButton = new JButton("NUEVO");
		
		
		btnNewButton.setBounds(34, 532, 96, 20);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCELAR");
		btnNewButton_1.setBounds(176, 532, 104, 20);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("GRABAR");
		
		btnNewButton_2.setBounds(318, 532, 96, 20);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("SALIR");
		
		btnNewButton_3.setBounds(453, 532, 96, 20);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(btnNewButton_3);
		
		cboDias = new JComboBox();
		cboDias.setBounds(106, 238, 78, 20);
		contentPane.add(cboDias);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 374, 540, 142);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	}
  public void events(){
	  
	  txtH.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				calculobolsa();
				calculo();
			}
			
		});
	  
	  cboGrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				grado();
				calculo();
			}
		});
	  
	  cboMes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				fiestas();
				calculo();
				
			}
		});
	  
	  btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtCod.getText()==""){
					JOptionPane.showMessageDialog(null,"FALTAN DATOS");
				}else{
				grabar();
				}
				}
		});
	  btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				borrar();
			}
		});
	  btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			salir();
			}
		});
  }
	
	private void llenarLista()
	{
	lista.addElement("Diurno");
	lista.addElement("Nocturno");
	
	
	}
	
	private void llenarCombo1()
	{
	cboMes.addItem("---Selecione---");
	cboMes.addItem("ENERO");
	cboMes.addItem("FEBRERO");
	cboMes.addItem("MARZO");
	cboMes.addItem("ABRIL");
	cboMes.addItem("MAYO");
	cboMes.addItem("JUNIO");
	cboMes.addItem("JULIO");
	cboMes.addItem("AGOSTO");
	cboMes.addItem("SETIEMBRE");
	cboMes.addItem("OCTUBRE");
	cboMes.addItem("NOVIEMBRE");
	cboMes.addItem("DICIEMBRE");	
	
	}
	private void llenarCombo2()
	{
	cboTurno.addItem("Diurno");
	cboTurno.addItem("Nocturno");
	
	}
	private void llenarCombo3(){
	cboGrado.addItem("NINGUNO");
	cboGrado.addItem("GUARDIA");
	cboGrado.addItem("SUPERVISOR");
	}
	private void tabla(){
		tabla.addColumn("Codigo");
		tabla.addColumn("Apellidos");
		tabla.addColumn("Nombres");
		tabla.addColumn("Turno");
		tabla.addColumn("Descuentos");
		tabla.addColumn("Bonificaciones");
		tabla.addColumn("Sueldo");
		table.setModel(tabla);
	}
	
   public void dias(){
		 for(int i=0;i<=31;i++){
			 cboDias.addItem(i);
			 
		 }
	 }
   public void calculobolsa(){
   	 int nh= Integer.parseInt(txtH.getText());
	  sal = nh*40;
	  txtRim.setText(String.valueOf(sal));
	  }
   public void fiestas(){  
	  int index = cboMes.getSelectedIndex();
	  switch (index){
	  case 7:
		   txtBon.setText("300");
		   txtDesc.setText("18.00");
		   bonF=300;
      break;
	  case 12:
		  txtBon.setText("300");
		   txtDesc.setText("18.00");
		   bonF=300;
     break;
     default:
    	 txtBon.setText("0.0");
		 txtDesc.setText("18.00");
		  bonF=0;
  }
  }
	  public void grado(){  
		  int index = cboGrado.getSelectedIndex();
		  switch (index){
		  case 0:
			  rin=sal*0;
	      break;
		  case 1:
			 rin=sal*0.10;
	     break;
		  case 2:
				 rin=sal*0.15;
		     break;
			  
	  }	      
	}
	  public void calculo(){
 
txtBon.setText(String.valueOf(bonF+rin));

   txtSal.setText(String.valueOf(sal+((bonF+rin)-18)));
   }
	  public void grabar(){
			Object[] fila = new Object[20];
			fila[0]= txtCod.getText();
			fila[1]= txtApe.getText();
			fila[2]= txtNom.getText();
			fila[3]= txtDesc.getText();
			fila[4]= txtBon.getText();
			fila[5]= txtSal.getText();
			tabla.addRow(fila);
			
			}
	  public void borrar(){
			txtCod.setText("");
			txtApe.setText("");
			txtNom.setText("");
			cboTurno.setSelectedIndex(0);
			cboGrado.setSelectedIndex(0);
			cboMes.setSelectedIndex(0);
			txtDesc.setText("");
			txtBon.setText("");
			txtSal.setText("");
		
			
			}
	  public void salir(){
		  dispose();
	  }
}


