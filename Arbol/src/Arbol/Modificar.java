package Arbol;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Modificar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfNombreCientifico;
	private JTextField tfNombreVulgar;
	private JTextField tfAlturaMedia;

	/**
	 * Create the dialog.
	 */
	public Modificar(ArrayList<Arbol>lista) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		tfNombreCientifico = new JTextField();
		tfNombreCientifico.setBounds(151, 13, 116, 22);
		contentPanel.add(tfNombreCientifico);
		tfNombreCientifico.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre Cientifico:");
		lblNewLabel.setBounds(33, 16, 106, 16);
		contentPanel.add(lblNewLabel);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean encontrado =false;
				String nombreCientifico=tfNombreCientifico.getText();

				for(Arbol a: lista){
					if(a.getNombreCientifico().equals(nombreCientifico)){
						tfNombreVulgar.setText(a.getNombreVulgar());
						tfAlturaMedia.setText(String.valueOf(a.getAlturaMedia()));
						encontrado=true;
					}
				}
				if(encontrado==true){
					JOptionPane.showMessageDialog(null, "Arbol encontrado");
						
				}else{
					JOptionPane.showMessageDialog(null, "Arbol no encontrado");
						
				}
				
			}
		});
		btnBuscar.setBounds(279, 12, 97, 25);
		contentPanel.add(btnBuscar);
		
		JLabel lblNombreVulgar = new JLabel("Nombre Vulgar:");
		lblNombreVulgar.setBounds(33, 83, 106, 16);
		contentPanel.add(lblNombreVulgar);
		
		JLabel lblAlturaMedia = new JLabel("Altura Media:");
		lblAlturaMedia.setBounds(33, 145, 97, 16);
		contentPanel.add(lblAlturaMedia);
		
		tfNombreVulgar = new JTextField();
		tfNombreVulgar.setBounds(151, 80, 116, 22);
		contentPanel.add(tfNombreVulgar);
		tfNombreVulgar.setColumns(10);
		
		tfAlturaMedia = new JTextField();
		tfAlturaMedia.setBounds(151, 142, 116, 22);
		contentPanel.add(tfAlturaMedia);
		tfAlturaMedia.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btModificar = new JButton("Modificar");
				btModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nombreCientifico=tfNombreCientifico.getText();
						String nombreVulgar=tfNombreVulgar.getText();
						String alturaMedia=tfAlturaMedia.getText();
						
						for(Arbol a: lista){
							if(a.getNombreCientifico().equals(nombreCientifico)){
								a.setNombreVulgar(nombreVulgar);
								a.setAlturaMedia (Double.parseDouble(alturaMedia));
								JOptionPane.showMessageDialog(null, "Arbol modificado");
							}
						}
						JFrameArbol.GuardarListaarboles(lista);	
						
					}
				});
				btModificar.setActionCommand("OK");
				buttonPane.add(btModificar);
				getRootPane().setDefaultButton(btModificar);
			}
			{
				JButton btCancelar = new JButton("Cancel");
				btCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btCancelar.setActionCommand("Cancel");
				buttonPane.add(btCancelar);
			}
		}
	}
}
