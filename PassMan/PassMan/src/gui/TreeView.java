package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import dao.OrganizadorDAO;

public class TreeView extends JFrame {
	
	public void CentrarJFrame(){
	      Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	      int height = pantalla.height;
	      int width = pantalla.width;
	      setSize(644, 384);		

	      setLocationRelativeTo(null);		
	      setVisible(true);
	  }
	
	public TreeView() {
		//setTitle("Login");
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		CentrarJFrame();
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 640, 473);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TreeView.class.getResource("/assets/beak-g3edd93948_640_preview_rev_1.png")));
		lblNewLabel.setBounds(0, 0, 630, 372);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(176, 50, 454, 218);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		DefaultMutableTreeNode passman=new DefaultMutableTreeNode("PassMan");
		DefaultMutableTreeNode categorias=new DefaultMutableTreeNode("Categorias");
		passman.add(categorias);
		
		DefaultMutableTreeNode trabajo =new DefaultMutableTreeNode("Trabajo");
		DefaultMutableTreeNode banco=new DefaultMutableTreeNode("Banco");
		DefaultMutableTreeNode juegos=new DefaultMutableTreeNode("Juegos");
		DefaultMutableTreeNode ropa=new DefaultMutableTreeNode("Ropa");
		DefaultMutableTreeNode electronica=new DefaultMutableTreeNode("Electronica");
		DefaultMutableTreeNode musica=new DefaultMutableTreeNode("Musica");
		categorias.add(trabajo); categorias.add(banco); categorias.add(juegos); categorias.add(ropa);
		categorias.add(electronica);categorias.add(musica);
		
		DefaultMutableTreeNode t =new DefaultMutableTreeNode("Correo");
		DefaultMutableTreeNode t1 =new DefaultMutableTreeNode("Pantalla Inicio");
		DefaultMutableTreeNode t2 =new DefaultMutableTreeNode("Maquina Virtual");
		trabajo.add(t);trabajo.add(t1);trabajo.add(t2);
		
		DefaultMutableTreeNode a =new DefaultMutableTreeNode("bbva");
		trabajo.add(a);
		
		DefaultMutableTreeNode b =new DefaultMutableTreeNode("EASports");
		DefaultMutableTreeNode bb =new DefaultMutableTreeNode("Pantalla Inicio");
		trabajo.add(t);trabajo.add(t1);trabajo.add(t2);
		
		JTree jt=new JTree(categorias);
		jt.setSize(194, 218);
		jt.setLocation(0, 0);
		panel_1.add(jt);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(218, 1, 226, 217);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNo_1_1 = new JButton("Guardar una cuenta nueva");
		btnNo_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnNo_1_1.setFocusPainted(false);
		btnNo_1_1.setContentAreaFilled(false);
		btnNo_1_1.setBorderPainted(false);
		btnNo_1_1.setBorder(null);
		btnNo_1_1.setBackground(Color.WHITE);
		btnNo_1_1.setBounds(335, 267, 147, 77);
		panel.add(btnNo_1_1);
		
		JButton btnNo_1_1_1 = new JButton("Crear una categoria nueva");
		btnNo_1_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnNo_1_1_1.setFocusPainted(false);
		btnNo_1_1_1.setContentAreaFilled(false);
		btnNo_1_1_1.setBorderPainted(false);
		btnNo_1_1_1.setBorder(null);
		btnNo_1_1_1.setBackground(Color.WHITE);
		btnNo_1_1_1.setBounds(176, 269, 149, 75);
		panel.add(btnNo_1_1_1);
		
		JButton btnNo_1_1_2 = new JButton("Atr\u00E1s");
		btnNo_1_1_2.setForeground(Color.ORANGE);
		btnNo_1_1_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnNo_1_1_2.setFocusPainted(false);
		btnNo_1_1_2.setContentAreaFilled(false);
		btnNo_1_1_2.setBorderPainted(false);
		btnNo_1_1_2.setBorder(null);
		btnNo_1_1_2.setBackground(Color.ORANGE);
		btnNo_1_1_2.setBounds(489, 0, 141, 50);
		panel.add(btnNo_1_1_2);
		
		JButton btnNo_1_1_1_1 = new JButton("Ver");
		btnNo_1_1_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnNo_1_1_1_1.setFocusPainted(false);
		btnNo_1_1_1_1.setContentAreaFilled(false);
		btnNo_1_1_1_1.setBorderPainted(false);
		btnNo_1_1_1_1.setBorder(null);
		btnNo_1_1_1_1.setBackground(Color.WHITE);
		btnNo_1_1_1_1.setBounds(489, 269, 96, 75);
		panel.add(btnNo_1_1_1_1);
		btnNo_1_1_1_1.addActionListener(e -> {
            TreePath[] paths = jt.getSelectionPaths();
            for (TreePath path : paths != null ? paths : new TreePath[0]) {
                String selected = path.getLastPathComponent().toString();
                OrganizadorDAO miOrganizadorDAO = new OrganizadorDAO();
        	
        		
        		try {
        			miOrganizadorDAO.cargarDatos(lblNewLabel_1, selected);
        			
        		} catch (SQLException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
            }
        });
		panel_1.setVisible(true);
		;
		Dimension pantallaTamano = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension tamano = (pantallaTamano);
		
		//Tomo el tamaño de la pantalla
				
				
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//launch(args);
					
					TreeView frame = new TreeView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
