package redVendedores.model;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.image.Image;
import redVendedores.exceptions.MeGustaException;
import redVendedores.exceptions.VendedorException;


public class Red implements Serializable{


	/*
	 * Atributos de la clase Red
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Producto> listaProductos;
	private Administrador administrador;

	/*
	 * Constructores de la clase Red
	 */

	public Red(String nombre) {
		super();
		this.nombre = nombre;
		listaClientes = new ArrayList<Cliente>();
		this.administrador = new Administrador();
		listaProductos = new ArrayList<Producto>();
	}

	public Red(){
		super();
		
	}

	/*
	 * Getters & setters de la clase Red
	 */

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}



	public ArrayList<Cliente> getlistaClientes() {
		return listaClientes;
	}

	public void setlistaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	

	/*
	 * metodo equals de la clase Red
	 */


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Red other = (Red) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	/*
	 *toString de la clase Red
	 */

	@Override
	public String toString() {
		return "Biblioteca [nombre=" + nombre + "]";
	}

	//----------------------------------------------------

	/*
	 * Metodo que llama a la clase Vendedor para verificar si el documento (usuario) y la contrasenia son correctas
	 */

	public boolean verificarUsuario(String usuario, String contrasenia) {
		for (Cliente cliente : listaClientes) {
			if(cliente.verificarUsuario(usuario,contrasenia)){
				return true;
			}
		}
		return false;
	}
	
	

	/*
	 * Metodo que verifica si el documento (Usuario) y contrasenia ingresados por el administrador son correctos
	 */

	public boolean verificarAdmin(String correo, String contrasenia){
		if(administrador.getCorreo().equals(correo)&& administrador.getContrasenia().equals(contrasenia)){
			return true;
		}
		return false;
	}

	/*
	 * Metodo que permite crear un vendedor dentro de la red
	 */

	public Cliente crearCliente(String nombre2, String apellidos, String documento,String direccion, 
			String contrasenia, String email, String usuario, Image imagen) throws VendedorException {
		Cliente cliente = new Cliente();
		cliente.setNombre(nombre2);
		cliente.setApellidos(apellidos);
		cliente.setDocumento(documento);
		cliente.setDireccion(direccion);
		cliente.setContrasenia(contrasenia);
		cliente.setCorreo(email);
		cliente.setUsuario(usuario);
		cliente.setImagen(imagen);

		if(verificarCorreo(email) == true){
			throw new VendedorException("Ya existe un cliente asociado a este correo");
		}
		listaClientes.add(cliente);
		return cliente;
	}
//
//	/*
//	 * Metodo que verifica si ya existe un vendedor en la red
//	 */
//
//	public boolean existeVendedor(String documento) {
//		for (Cliente vendedor : listaClientes) {
//			if(vendedor.getDocumento().equals(documento)){
//				return true;
//			}
//		}
//		return false;
//	}
//
	/*
	 * Metodo que verifica si ya existe un administrador dentro de la red
	 */

	public boolean existeAdministrador (String correo) {

			if(administrador.getCorreo().equals(correo)){
				return true;
			}

		return false;
	}

	/*
	 * Metodo que llama a la clase Vendedor para actualizar la contrasenia
	 */

	public void actualizarContrasenia( String correo, String nuevaContrasenia ) {
		for (Cliente cliente : listaClientes) {
			if(cliente.getCorreo().equals(correo)){
				cliente.setContrasenia(nuevaContrasenia);
			}
		}
	}

	/*
	 * Metodo que permite actualizar la contrasenia del administrador
	 */

	public void actualizarContraseniaAdmin(String correo, String nuevaContrasenia) {
		if(administrador.getCorreo().equals(correo)){
			administrador.setContrasenia(nuevaContrasenia);
			}
		}

	/*
	 * Metodo obtiene el nombre de un vendedor segun su numero de identificacion (documento)
	 */

	public String obtenerNombreCliente(String usuario) {
		String cadenaAux= "";
		for (Cliente cliente : listaClientes) {
			if(cliente.getUsuario().equals(usuario)){
				cadenaAux= cliente.getNombre()+" "+cliente.getApellidos();
			}
		}
		return cadenaAux;
	}
//
//	/*
//	 * Metodo que retorna una lista de productos de un vendedor
//	 */
//
//	public ArrayList<Producto> obtenerProductos(String documento) {
//		ArrayList<Producto> listaProducto = new ArrayList<>();
//		for (Cliente vendedor : listaClientes) {
//			if(vendedor.getDocumento().equals(documento)){
//				listaProducto.addAll(vendedor.getListaProductos());
//			}
//		}
//		return listaProducto;
//	}
//


//	/*
//	 * Metodo que verifica si el nombre ingresado es igual al almacenado
//	 */
//
//	public boolean obtenerInformacion(String nombre2) {
//		for (Cliente vendedor : listaClientes) {
//			String nombreVendedor= vendedor.getNombre()+" "+vendedor.getApellidos();
//			if(nombreVendedor.equals(nombre2)){
//				return true;
//			}
//		}
//		return false;
//	}
//

//	 * Metodo que llama a la clase Vendedor para poder dar Me Gusta a un producto
//	 */
//
//	public boolean darMeGusta(String codigo, String nombre, String documento){
//		for (Cliente vendedor : listaClientes) {
//			String nombreVendedor= vendedor.getNombre()+" "+vendedor.getApellidos();
//			if(nombreVendedor.equals(nombre)){
//				try {
//					return vendedor.darMeGusta(codigo,documento);
//				} catch (MeGustaException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//		return false;
//	}
//
//	/*
//	 * Metodo que llama a la clase Vendedor para saber el numero de Me Gustas de un producto
//	 */
//	
//	
//	public String obtenerNumeroMeGustas(String nombre, String codigo) {
//		for (Cliente vendedor : listaClientes) {
//			String nombreVendedor= vendedor.getNombre()+" "+vendedor.getApellidos();
//			if(nombreVendedor.equals(nombre)){
//				return vendedor.obtenerMeGustas(codigo);
//			}
//		}
//		return null;
//
//	}
//

//	
//	public String obtenerNumeroMeGustas2(String codigo, String documento) {
//		for (Cliente vendedor : listaClientes) {
//			if(vendedor.getDocumento().equals(documento)){
//				return vendedor.obtenerMeGustas2(codigo);
//			}
//		}
//		return null;
//	}

//
//	public void escribirComentario(String codigo, String nombre2) throws ComentarioException{
//		for (Cliente vendedor : listaClientes) {
//			String nombreVendedor= vendedor.getNombre()+" "+vendedor.getApellidos();
//			if(nombreVendedor.equals(nombre2)){
//				 vendedor.escribirComentario(codigo);
//			}
//		}
//		
//	}
//
//	public ArrayList<Comentario> obtenerComentarios(String codigo, String documento) {
//		for (Cliente vendedor : listaClientes) {
//			if(vendedor.getDocumento().equals(documento)){
//				return vendedor.obtenerComentarios(codigo);
//			}
//		}
//		return null;
//		
//	}
//



	public boolean verificarCorreo(String correo) {
		for (Cliente vendedor : listaClientes) {
			if(vendedor.getCorreo().equals(correo)){
				return true;
			}
		}
		return false;
	}

	public String conseguirNombre(String correo) {
		for (Cliente vendedor : listaClientes) {
			if(vendedor.getCorreo().equals(correo)){
				return vendedor.getNombre();
			}
		}
		return correo;
	}

	public int calcularTotal(Integer newValue, String codigo) {
		int total= 0;
		for(Producto producto: listaProductos){
			if(producto.getCodigo().equals(codigo)){
				String precio = producto.getPrecio(); 
				precio = precio.replaceAll("[^0-9.]", "");
				total= newValue * (Integer.parseInt(precio));
			}
		}
		return total;
		
	}

	public String traerCorreo(String usuario) {
		for (Cliente vendedor : listaClientes) {
			if(vendedor.getUsuario().equals(usuario)){
				return vendedor.getCorreo();
			}
		}
		return null;
		
	}

	public Image traerFoto(String usuario) {
		for (Cliente vendedor : listaClientes) {
			if(vendedor.getUsuario().equals(usuario)){
				return vendedor.getImagen();
			}
		}
		return null;
	}

	public boolean agregarAlCarrito(Producto producto, String usuario) {
		for (Cliente vendedor : listaClientes) {
			if(vendedor.getUsuario().equals(usuario)){
				if(verificarProducto(producto.getCodigo(), usuario)==false){
					vendedor.getListaProductos().add(producto);
					return true;
				}
			}
		}
		return false;
	}

	private boolean verificarProducto(String codigo, String usuario) {
		for (Cliente vendedor : listaClientes) {
			if(vendedor.getUsuario().equals(usuario)){
				for(Producto producto : vendedor.getListaProductos()){
					if(producto.getCodigo().equals(codigo)){
						return true;
					}
				}
			}
		}
		return false;
	}

	public ArrayList<Producto> obtenerProductosCarrito(String usuario) {
		for (Cliente vendedor : listaClientes) {
			if(vendedor.getUsuario().equals(usuario)){
				return vendedor.getListaProductos();
			}
		}
		return null;
	}

	public String obtenerNroPC(String usuario) {
		for (Cliente vendedor : listaClientes) {
			if(vendedor.getUsuario().equals(usuario)){
				String numero= Integer.toString(vendedor.getListaProductos().size());
				return numero;
			}
		}
		return null;
	}

	public String obtenerPrecio(String usuario) {
		for (Cliente vendedor : listaClientes) {
			if(vendedor.getUsuario().equals(usuario)){
				String numero= Integer.toString(vendedor.obtenerPrecio());
				return numero;
			}
		}
		return null;
	}

	public void eliminarProductoCarrio(Producto producto, String usuario) {
		for (Cliente vendedor : listaClientes) {
			if(vendedor.getUsuario().equals(usuario)){
				vendedor.eliminarProducto(producto);
			}
		}
	}

	public boolean darMeGusta(Producto productoSeleccionado, String usuario2, String correo2) {
		for (Cliente vendedor : listaClientes) {
			if(vendedor.getUsuario().equals(usuario2)){
				if(verificarProductoF(productoSeleccionado.getCodigo(), usuario2)==false){
					vendedor.getListaFavoritos().add(productoSeleccionado);
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean verificarProductoF(String codigo, String usuario) {
		for (Cliente vendedor : listaClientes) {
			if(vendedor.getUsuario().equals(usuario)){
				for(Producto producto : vendedor.getListaFavoritos()){
					if(producto.getCodigo().equals(codigo)){
						return true;
					}
				}
			}
		}
		return false;
	}

	public ArrayList<Producto> obtenerProductosFavoritos(String usuario) {
		for (Cliente vendedor : listaClientes) {
			if(vendedor.getUsuario().equals(usuario)){
				return vendedor.getListaFavoritos();
			}
		}
		return null;
	}

	public ArrayList<Producto> obtenerProductosPedido(String usuario) {
		for (Cliente vendedor : listaClientes) {
			if(vendedor.getUsuario().equals(usuario)){
				return vendedor.getListaPedidos();
			}
		}
		return null;
	}

	public void guardarPedido(String usuario, String precio, String producto2) {
		for (Cliente vendedor : listaClientes) {
			if(vendedor.getUsuario().equals(usuario)){
				for(Producto producto : listaProductos){
					if(producto.getNombre().equals(producto2)){
						vendedor.getListaPedidos().add(producto);
					}
				}
			}
		}
	}
	
	
	












}
