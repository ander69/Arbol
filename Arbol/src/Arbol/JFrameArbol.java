package Arbol;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Arbol.Modificar;
import Arbol.Mostrar;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class JFrameArbol extends JFrame {
	final static String nomfich = "Fich05.obj";
	static ArrayList<Arbol> listaArboles = new ArrayList<Arbol>();


	
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		CargarListaarboles(listaArboles);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameArbol frame = new JFrameArbol();
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
	public JFrameArbol() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 321);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button btAñadir = new Button("A\u00F1adir");
		btAñadir.setBackground(new Color(255, 153, 153));
		btAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Añadir(listaArboles).setVisible(true);
				
			}
		});
		btAñadir.setBounds(77, 73, 79, 24);
		contentPane.add(btAñadir);
		
		Button btBorrar = new Button("Borrar");
		btBorrar.setBackground(new Color(255, 153, 153));
		btBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Borrar(listaArboles).setVisible(true);
			}
		});
		btBorrar.setBounds(77, 136, 79, 24);
		contentPane.add(btBorrar);
		
		Button btMostrar = new Button("Mostrar");
		btMostrar.setBackground(new Color(255, 153, 153));
		btMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Mostrar(listaArboles).setVisible(true);
			}
		});
		btMostrar.setBounds(240, 73, 79, 24);
		contentPane.add(btMostrar);
		
		Button btModificar = new Button("Modificar");
		btModificar.setBackground(new Color(255, 153, 153));
		btModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Modificar(listaArboles).setVisible(true);
			}
		});
		btModificar.setBounds(240, 136, 79, 24);
		contentPane.add(btModificar);
		
		Button btSalir = new Button("Salir");
		btSalir.setBackground(new Color(255, 153, 153));
		btSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btSalir.setBounds(160, 194, 79, 24);
		contentPane.add(btSalir);
		
		JLabel label = new JLabel("VIVERO DE ARBOLES");
		label.setForeground(new Color(255, 153, 153));
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setBounds(77, 13, 262, 54);
		contentPane.add(label);
	}
	private static void CargarListaarboles (ArrayList <Arbol> lista){
		File fich = new File (nomfich);
		
		try{
			if (fich.exists()){
				FileInputStream fe = new FileInputStream(fich);
				ObjectInputStream fie = new ObjectInputStream(fe);
				Arbol a = (Arbol)fie.readObject();
				while(a!= null){
					lista.add(a);
					a = (Arbol)fie.readObject();
				}
				fie.close();
				
			}
			
		}catch (Exception e){
			
		}
		
	}
	static void GuardarListaarboles(ArrayList<Arbol>lista){
		
		FileOutputStream f = null;
		try{
			f = new FileOutputStream(nomfich);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		try{
			ObjectOutputStream fis=new ObjectOutputStream(f);
			for (Arbol a: lista) fis.writeObject(a);
			fis.close();
			
		}catch(IOException e){
			e.printStackTrace();
			
		}
		
	}
}
