package gui;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.border.LineBorder;

import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;

import java.awt.Component;
import javax.swing.border.TitledBorder;

import conexion.Conexion;
import dao.OrganizadorDAO;
import dao.UsuarioDAO;
import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import jdk.nashorn.internal.ir.SetSplitState;
import modelos.Organizador;
import modelos.Usuario;

import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JList;


public class PanelView extends JFrame implements ActionListener  {
	 public void CentrarJFrame(){
	      Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	      int height = pantalla.height;
	      int width = pantalla.width;
	      setSize(644, 384);		

	      setLocationRelativeTo(null);		
	      setVisible(true);
	  }
	
	public PanelView() {
		setTitle("Login");
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		int h = 100;
		CentrarJFrame();
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 642, 473);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblNewLabel.setIcon(new ImageIcon(PanelView.class.getResource("/assets/BART_HOME_preview_rev_1.png")));
		lblNewLabel.setBounds(0, 0, 638, 346);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(180, 42, 364, 256);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("There are your titles, select one to see more:");
		lblNewLabel_1.setBounds(73, 11, 218, 14);
		panel_1.add(lblNewLabel_1);
		
				
		
		JList<String> list_1 = new JList<String>();
		JScrollPane listScroller =new JScrollPane(list_1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//listScroller.setAutoscrolls(false);
        //listScroller.setViewportView(list_1);
        listScroller.setBounds(10, 56, 100, 100);
        list_1.setLayoutOrientation(JList.VERTICAL);
		list_1.setSelectionForeground(Color.YELLOW);
		list_1.setSelectionBackground(Color.WHITE);
		list_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		list_1.setBounds(10, 56, 344, 144);
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		//list_1.setBorder(BorderFactory.createLineBorder(Color.black));
		OrganizadorDAO miOrganizadorDAO = new OrganizadorDAO();
		//JScrollPane scrollLista = new JScrollPane();
		//scrollLista.setBounds(73, 53,198, 147);
		//scrollLista.setViewportView(list_1);
		//ArrayList<Organizador> organizadorList = new ArrayList<Organizador>();
		//organizadorList = miOrganizadorDAO.mostrarDatos();
		
		try {
			miOrganizadorDAO.populateJList(list_1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel_1.add(listScroller);
		//panel_1.add(list_1);
		
		JButton btnNo_2 = new JButton("Back");
		btnNo_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					miOrganizadorDAO.populateJList(list_1);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				panel_1.add(list_1);
				panel_1.add(listScroller);
			}
		});
		
		btnNo_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnNo_2.setBorder(null);
		btnNo_2.setBackground(Color.WHITE);
		btnNo_2.setBounds(90, 211, 96, 25);
		panel_1.add(btnNo_2);
		
		JButton btnNo_2_1 = new JButton("New");
		btnNo_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateSSpaceView menu = new CreateSSpaceView(); 
				menu.setLocationRelativeTo(null);
				dispose();
				menu.setVisible(true);
			}
		});
		btnNo_2_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnNo_2_1.setBorder(null);
		btnNo_2_1.setBackground(Color.WHITE);
		btnNo_2_1.setBounds(188, 211, 96, 25);
		panel_1.add(btnNo_2_1);

		

		list_1.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				System.out.println(list_1.getSelectedValuesList());
				String selected = list_1.getSelectedValuesList().toString();
				selected = selected.replace("[", "");
				selected = selected.replace("]", "");
				try {
					miOrganizadorDAO.cargarDatos(list_1, selected);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(PanelView.class.getResource("/assets/LOGOBART.png")));
		lblNewLabel_3.setBounds(532, 0, 100, 115);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Your password has been sent you to your email. Take care! It may be in spam.");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_4.setBounds(235, 301, 330, 59);
		
		
		
		
		
		Dimension pantallaTamano = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension tamano = (pantallaTamano);
		
		//Tomo el tamaño de la pantalla
				
		}		
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//launch(args);
					
					PanelView frame = new PanelView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
					
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*
	public void abrir(ActionEvent e) {
		String acceso = new String(psdfContrasena.getPassword());		
		VentaVentana ventaVentana;
		miUsuario = miUsuarioDao.pruebaLogin(txtfUsuario.getText(), acceso);	
	}
*/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}