package Arbol;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Arbol.Arbol;
import Arbol.JFrameArbol;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Añadir extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfNombreVulgar;
	private JTextField tfNombreCientifico;
	private JTextField tfAlturaMedia;

	/**
	 * Create the dialog.
	 */
	public Añadir(ArrayList <Arbol> lista) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre Vulgar:");
		lblNewLabel.setBounds(12, 13, 110, 16);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre Cientifico:");
		lblNewLabel_1.setBounds(12, 75, 110, 16);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Altura Media:");
		lblNewLabel_2.setBounds(12, 140, 110, 16);
		contentPanel.add(lblNewLabel_2);
		
		tfNombreVulgar = new JTextField();
		tfNombreVulgar.setBounds(146, 10, 116, 22);
		contentPanel.add(tfNombreVulgar);
		tfNombreVulgar.setColumns(10);
		
		tfNombreCientifico = new JTextField();
		tfNombreCientifico.setBounds(146, 75, 116, 22);
		contentPanel.add(tfNombreCientifico);
		tfNombreCientifico.setColumns(10);
		
		tfAlturaMedia = new JTextField();
		tfAlturaMedia.setBounds(146, 137, 116, 22);
		contentPanel.add(tfAlturaMedia);
		tfAlturaMedia.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btAñadir = new JButton("A\u00F1adir");
				btAñadir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boolean repetido=false;
						String nombreVulgar = tfNombreVulgar.getText();
						String nombreCientifico= tfNombreCientifico.getText();
						Double alturaMedia = Double.parseDouble(tfAlturaMedia.getText());
						for(Arbol a : lista){
							if (nombreCientifico.equals(a.getNombreCientifico())){
								repetido=true;
							}
						}
						if (repetido==false){
						Arbol ar1 = new Arbol(nombreVulgar,nombreCientifico,alturaMedia);
						lista.add(ar1);
						JFrameArbol.GuardarListaarboles(lista);
						tfNombreVulgar.setText("");
						tfNombreCientifico.setText("");
						tfAlturaMedia.setText("");
						JOptionPane.showMessageDialog(null, "Arbol añadido a la lista");
						}else{
							JOptionPane.showMessageDialog(null, "Ya esta en la lista");
						}
					}
				});
				btAñadir.setActionCommand("OK");
				buttonPane.add(btAñadir);
				getRootPane().setDefaultButton(btAñadir);
			}
			{
				JButton btCancelar = new JButton("Cancelar");
				btCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(btCancelar);
			}
		}
	}
}
