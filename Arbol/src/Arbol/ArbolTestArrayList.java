package Arbol;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArbolTestArrayList {
	
	final static String nomfich = "Fich05.obj";

	public static void main(String[] args) {
		int esta;
		
		ArrayList<Arbol> listaArboles = new ArrayList<Arbol>();
		CargarListaarboles(listaArboles);
		//Arbol ar1 = new Arbol("Tilo","Tilus",43);
		//listaArboles.add(ar1);
		//ar1 = new Arbol("Manzano","Manzanus",5);
		//listaArboles.add(ar1);
		esta=Buscararbol(listaArboles, "Manzanus");
		System.out.println(esta);
		GuardarListaarboles(listaArboles);
		MostrarListaarboles(listaArboles);
		//Borrararbol(listaArboles,"Manzanus");
		//MostrarListaarboles(listaArboles);
		Añadirarbol(listaArboles);
		//Modificararbol(listaArboles,"Tilus");
	}
	private static void Modificararbol(ArrayList<Arbol> lista,String nombre){
		String nombrenormal="pepe",nombrecientifico="garcia";
		int altura=69;
		for(Arbol a: lista){
			if(a.getNombreCientifico().equals(nombre)){
				a.setNombreVulgar(nombrenormal);
				a.setNombreCientifico(nombrecientifico);
				a.setAlturaMedia(altura);
			}
		}
		GuardarListaarboles(lista);
		
		
	}
	private static void Añadirarbol(ArrayList <Arbol> lista){
		Arbol ar1 = new Arbol("Tilo","Tilus",43);
		lista.add(ar1);
		GuardarListaarboles(lista);
	}
	private static void Borrararbol(ArrayList<Arbol>lista,String nombre){
		int pos=-1;
		List<Arbol> borrar = new ArrayList<Arbol>();
		for(Arbol a: lista){
			if(a.getNombreCientifico().equals(nombre)){
				pos=lista.indexOf(a);
				borrar.add(a);
			}
		}
		for(Arbol a : borrar){
			lista.remove(a);
		}
		System.out.println(lista.size());
		GuardarListaarboles(lista);
		
	}
	
	
	
	private static int Buscararbol(ArrayList<Arbol>lista,String nombre){
		int dev=-1;
		for (Arbol a: lista){
			if (a.getNombreCientifico().equals(nombre) ){
				dev=1;
				return dev;	
			}
		}
		return dev;
		
	}
		
	private static void CargarListaarboles (ArrayList <Arbol> lista){
		File fich = new File (nomfich);
		
		try{
			if (fich.exists()){
				System.out.println("El fichero existe");
				FileInputStream fe = new FileInputStream(fich);
				ObjectInputStream fie = new ObjectInputStream(fe);
				
				Arbol a = (Arbol)fie.readObject();
				
				while(a!= null){
					System.out.println("Entro en el while");
					System.out.println(a);
					lista.add(a);
					a = (Arbol)fie.readObject();
				}
				fie.close();
				
			}
			
		}catch (Exception e){
			System.out.println("****Fin Fichero Entrada***** \n");
			
		}
		
	}
	private static void GuardarListaarboles(ArrayList<Arbol>lista){
		
		FileOutputStream f = null;
		try{
			f = new FileOutputStream(nomfich);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		try{
			ObjectOutputStream fis=new ObjectOutputStream(f);
			for (Arbol a: lista) fis.writeObject(a);
			System.out.println("se han escrito "+lista.size()+" arboles");
			fis.close();
			
		}catch(IOException e){
			e.printStackTrace();
			
		}
		
	}
	private static void MostrarListaarboles(ArrayList<Arbol>lista){
		System.out.println("\n\nLos arboles introducidos son: \n");
		for (Arbol a: lista){
			System.out.println(a);
		}
	}

}
