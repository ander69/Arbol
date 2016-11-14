package Arbol;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Arbol.JFrameArbol;

import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Borrar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;



	/**
	 * Create the dialog.
	 */
	
	public void Cargarlista(ArrayList<Arbol>lista){
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		for (Arbol a : lista){
			Object[] fila = new Object[table.getModel().getColumnCount()];
			fila[0]= a.getNombreVulgar();
			fila[1]= a.getNombreCientifico();
			fila[2]= a.getAlturaMedia();
			model.addRow(fila);
		}
	}
	public Borrar(ArrayList<Arbol>lista) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 408, 192);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre Vulgar", "Nombre Cientifico", "Altura Media"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(108);
		table.getColumnModel().getColumn(1).setPreferredWidth(121);
		table.getColumnModel().getColumn(2).setPreferredWidth(111);
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btBorrar = new JButton("Borrar");
				btBorrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int pos=-1;
						boolean eliminado=false;
						DefaultTableModel model= (DefaultTableModel)table.getModel();
						int fila = table.getSelectedRow();
						String nombre = (String) table.getValueAt(fila, 1);
						model.removeRow(table.getSelectedRow());
						for(Arbol a: lista){
							if (a.getNombreCientifico().equals(nombre))
							pos=lista.indexOf(a);
							eliminado=true;
						}
						lista.remove(lista.get(pos));
						if (eliminado==true){
							JOptionPane.showMessageDialog(null, "Arbol borrado", null, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("66737.gif"));
							JFrameArbol.GuardarListaarboles(lista);	
							
						}

					}
				});
				btBorrar.setActionCommand("OK");
				buttonPane.add(btBorrar);
				getRootPane().setDefaultButton(btBorrar);
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
		Cargarlista(lista);
	}
}
