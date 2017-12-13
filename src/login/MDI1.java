package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import login.ImagenFondo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import java.awt.ScrollPane;

public class MDI1 extends JFrame {

	private JPanel contentPane;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_4;
	private JDesktopPane desktopPane;
	private JMenuItem mntmDiurno;
	private JMenuItem mntmNocturno_1;
	private JMenuItem mntmPagos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MDI1 frame = new MDI1();
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
	public MDI1() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MDI1.class.getResource("/Imagenes/Metrrrro.jpg")));
		inicializar();
		eventos();
		
		

		
	}
	
	private void inicializar(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 436);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setSelectedIcon(new ImageIcon(MDI1.class.getResource("/Imagenes/ARCHIVO.png")));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem_1 = new JMenuItem("Registro de personal");
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmDiurno = new JMenuItem("Diurno");
		mntmDiurno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		mntmDiurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnNewMenu.add(mntmDiurno);
		
		JMenuItem mntmNocturno = new JMenuItem("Nocturno");
		mntmNocturno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mntmNocturno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		mntmNocturno_1 = new JMenuItem("Nocturno");
		mntmNocturno_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmNocturno_1);
		
		mntmPagos = new JMenuItem("Pagos");
		mntmPagos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmPagos);
		
		mntmNewMenuItem_4 = new JMenuItem("Salir");
		mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		
		mnNewMenu.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setBorder(new ImagenFondo());
		this.setExtendedState(MDI1.MAXIMIZED_BOTH);
	
	}
	
	public void eventos(){
	
	mntmNewMenuItem_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
			RegistroPersonal ver1=new RegistroPersonal();
			ver1.setVisible(true);
			desktopPane.add(ver1);
			
		}
	});
	
	mntmDiurno.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			Diurno ver2=new Diurno();
			ver2.setVisible(true);
			desktopPane.add(ver2);
		}
	});
	
    mntmNocturno_1.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			Nocturno ver3=new Nocturno();
			ver3.setVisible(true);
			desktopPane.add(ver3);
		}
    	
    });
	
	mntmNewMenuItem_4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		dispose();
		}
	});
	mntmPagos.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			Pagos ver4=new Pagos();
			ver4.setVisible(true);
			desktopPane.add(ver4);
		}
    	
    });
	
	
}
	}
	
	
	

