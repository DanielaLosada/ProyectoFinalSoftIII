package redVendedores.model;

import java.io.Serializable;

public class Administrador implements Serializable {
	
	/*
	 * Atributos de la clase Administrador
	 */
	private static final long serialVersionUID = 1L;
	private String contrasenia;
	private String correo;
	
	/*
	 * Constructores de la clase Administrador
	 */

	public Administrador( String contrasenia, String correo) {
		super();

		this.contrasenia = contrasenia;
		this.correo = correo;
	}

	public Administrador(){
		super();
	}
	
	//-----------------------------------
	
	/*
	 * Getters & Setters de la clase Administrador
	 */
	

	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	/*
	 * toString de la clase Administrador
	 */

	@Override
	public String toString() {
		return "Administrador [ contrasenia=" + contrasenia
				+ ", documento=" + correo + "]";
	}
	
	/*
	 * Metodo equals de la clase Administrador
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contrasenia == null) ? 0 : contrasenia.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
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
		Cliente other = (Cliente) obj;
		if (contrasenia == null) {
			if (other.getContrasenia() != null)
				return false;
		} else if (!contrasenia.equals(other.getContrasenia()))
			return false;
		if (correo == null) {
			if (other.getDocumento() != null)
				return false;
		} else if (!correo.equals(other.getDocumento()))
			return false;
		return true;
	}
	
	//-------------------------------------------
	
	
	/*
	 * Metodo que verifica si el documento (usuario) y la contrasenia son iguales a las almacenadas
	 */

	public boolean verificarDocumento(String documento2, String contrasenia2) {
		if(getCorreo().equals(documento2) && getContrasenia().equals(contrasenia2)){
			return true;
		}
		return false;
	}





}
