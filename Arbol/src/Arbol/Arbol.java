package Arbol;

import java.io.*;
public class Arbol implements Serializable {
	
	private String nombreVulgar;
	private String nombreCientifico;
	private double alturaMedia;
	
	public Arbol(String nombreVulgar, String nombreCientifico, double alturaMedia){
		super();
		this.nombreVulgar = nombreVulgar;
		this.nombreCientifico = nombreCientifico;
		this.alturaMedia = alturaMedia;
	}

	@Override
	public String toString() {
		return "arbol nombreVulgar=" + nombreVulgar + ", nombreCientifico=" + nombreCientifico + ", alturaMedia="
				+ alturaMedia + "]";
	}

	public String getNombreVulgar() {
		return nombreVulgar;
	}

	public void setNombreVulgar(String nombreVulgar) {
		this.nombreVulgar = nombreVulgar;
	}

	public String getNombreCientifico() {
		return nombreCientifico;
	}

	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}

	public double getAlturaMedia() {
		return alturaMedia;
	}

	public void setAlturaMedia(double alturaMedia) {
		this.alturaMedia = alturaMedia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreCientifico == null) ? 0 : nombreCientifico.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arbol other = (Arbol) obj;
		if (nombreCientifico == null) {
			if (other.nombreCientifico != null)
				return false;
		} else if (!nombreCientifico.equals(other.nombreCientifico))
			return false;
		return true;
	}
	

}
