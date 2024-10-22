package redVendedores.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import redVendedores.exceptions.VendedorException;
import redVendedores.model.Administrador;
import redVendedores.model.Producto;
import redVendedores.model.Red;
import redVendedores.model.Cliente;
import redVendedores.persistencia.ArchivoUtil;
import redVendedores.persistencia.Persistencia;


public class ModelFactoryController {
	
	Red red;
	

	//------------------------------  Singleton ------------------------------------------------
	// Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder {
		// El constructor de Singleton puede ser llamado desde aqu� al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	// M�todo para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}

	public ModelFactoryController() {
		//1. inicializar datos y luego guardarlo en archivos
				//iniciarSalvarDatosPrueba();

				//2. Cargar los datos de los archivos
				//cargarDatosDesdeArchivos();
		
				//3. Guardar y Cargar el recurso serializable binario
				//guardarResourceBinario();
				//cargarResourceBinario();

				//4. Guardar y Cargar el recurso serializable XML

				try {
					guardarResourceXML();
					guardarResourceBinario();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
				// Siempre se debe verificar si la raiz del recurso es null
				if (red == null) {
					System.out.println("es null la red");
					iniciarSalvarDatosPrueba();
					// crearCopias();
					// guardarResourceSerializable();
					guardarResourceXML();
					guardarResourceBinario();
		
				}
	}
	
	
    private void iniciarSalvarDatosPrueba() {
		inicializarDatos();
		try {

			Persistencia.guardarVendedores(getRed().getlistaClientes());
			Persistencia.guardarAdministrador(getRed().getAdministrador());
			Persistencia.guardarProductos(getRed().getlistaClientes());
			
			Persistencia.guardarRecursoBancoBinario(red);
			Persistencia.guardarRecursoBancoXML(red);

			//Persistencia.cargarDatosArchivos(getBanco());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Se inicializaron los datos");
	}
    
    private void inicializarDatos() {
    	
    	red= new Red("Delicias DEliza");
    	
    	ArrayList<Cliente>listaClientes= new ArrayList<>();
    	
    	Cliente vendedor = new Cliente();
		vendedor.setNombre("Daniela");
		vendedor.setApellidos("Losada");
		vendedor.setUsuario("DanielaL");
		vendedor.setCorreo("danielai.losadar@uqvirtual.edu.co");
		vendedor.setDocumento("1092455518");
		vendedor.setDireccion("Barrio las Americas");
		Image imagen= new Image("/imagenes/foto1.jpg");
		vendedor.setImagen(imagen);
		vendedor.setContrasenia("Daniela20.");
		
		Cliente vendedor2 = new Cliente();
		vendedor2.setNombre("Ximena");
		vendedor2.setApellidos("Ruiz");
		vendedor2.setDocumento("1095550251");
		vendedor2.setCorreo("angieruiz564@gmail.com");
		vendedor2.setUsuario("XimenaR");
		vendedor2.setDireccion("Cra 29 #38-35");
		Image imagen2= new Image("/imagenes/foto2.jpg");
		vendedor2.setImagen(imagen2);
		vendedor2.setContrasenia("Xruiz26@");
		
		listaClientes.add(vendedor);
		listaClientes.add(vendedor2);
		
		
    	ArrayList<Producto>listaProductos= new ArrayList<>();

		Producto producto= new Producto();
		producto.setNombre("Postre");
		producto.setCodigo("1456");
		producto.setPrecio("$10000");
		producto.setCategoria("Postres");
		producto.setEstado("Publicado");
		producto.setDescripcion("Torta de chocolate con crema");
		producto.setFechaHora(ArchivoUtil.cargarFechaSistema());
		URL ruta= getClass().getResource("/imagenes/postre1.jpg");
		producto.setImagen(ruta.getPath().substring(1));

		Producto producto1= new Producto();
		producto1.setNombre("Postre durazno");
		producto1.setCodigo("8976");
		producto1.setPrecio("$10000");
		producto1.setCategoria("Postres");
		producto1.setEstado("Publicado");
		producto1.setDescripcion("Postre tres leches y durazno");
		producto1.setFechaHora(ArchivoUtil.cargarFechaSistema());
		URL ruta2= getClass().getResource("/imagenes/postre2.jpg");
		producto1.setImagen(ruta2.getPath().substring(1));


		Producto producto2= new Producto();
		producto2.setNombre("Postre red velvet");
		producto2.setCodigo("7990");
		producto2.setPrecio("$10000");
		producto2.setCategoria("Postres");
		producto2.setEstado("Publicado");
		producto2.setDescripcion("Postre 9 onzas ");
		producto2.setFechaHora(ArchivoUtil.cargarFechaSistema());
		URL ruta3= getClass().getResource("/imagenes/postre3.jpg");
		producto2.setImagen(ruta3.getPath().substring(1));


		Producto producto3= new Producto();
		producto3.setNombre("Arroz con leche");
		producto3.setCodigo("4656");
		producto3.setPrecio("$3000");
		producto3.setCategoria("Postres");
		producto3.setEstado("Publicado");
		producto3.setDescripcion("Arroz con leche");
		producto3.setFechaHora(ArchivoUtil.cargarFechaSistema());
		URL ruta4= getClass().getResource("/imagenes/postre4.jpg");
		producto3.setImagen(ruta4.getPath().substring(1));



		Producto producto4= new Producto();
		producto4.setNombre("Ancheta Brownies");
		producto4.setCodigo("7777");
		producto4.setPrecio("$25000");
		producto4.setCategoria("Anchetas");
		producto4.setEstado("Publicado");
		producto4.setDescripcion("Brownies x6");
		producto4.setFechaHora(ArchivoUtil.cargarFechaSistema());
		URL ruta5= getClass().getResource("/imagenes/postre6.jpg");
		producto4.setImagen(ruta5.getPath().substring(1));

		Producto producto5= new Producto();
		producto5.setNombre("Torta");
		producto5.setCodigo("2321");
		producto5.setPrecio("$60000");
		producto5.setCategoria("Tortas");
		producto5.setEstado("Publicado");
		producto5.setDescripcion("Deliciosa torta por libra");
		producto5.setFechaHora(ArchivoUtil.cargarFechaSistema());
		URL ruta6= getClass().getResource("/imagenes/postre5.jpg");
		producto5.setImagen(ruta6.getPath().substring(1));
		
		Producto producto6= new Producto();
		producto6.setNombre("Desayuno sorpresa");
		producto6.setCodigo("2321");
		producto6.setPrecio("$120000");
		producto6.setCategoria("Desayunos");
		producto6.setEstado("Publicado");
		producto6.setDescripcion("Para tu persona especial");
		producto6.setFechaHora(ArchivoUtil.cargarFechaSistema());
		URL ruta7= getClass().getResource("/imagenes/postre9.jpg");
		producto6.setImagen(ruta7.getPath().substring(1));


		Producto producto7= new Producto();
		producto7.setNombre("Desayuno Sorpresa");
		producto7.setCodigo("2321");
		producto7.setPrecio("$45000");
		producto7.setCategoria("Desayunos");
		producto7.setEstado("Publicado");
		producto7.setDescripcion("Desayuno + torta");
		producto7.setFechaHora(ArchivoUtil.cargarFechaSistema());
		URL ruta8= getClass().getResource("/imagenes/postre7.jpg");
		producto7.setImagen(ruta8.getPath().substring(1));


		
		Producto producto8= new Producto();
		producto8.setNombre("Fresas con crema");
		producto8.setCodigo("2321");
		producto8.setPrecio("$7500");
		producto8.setCategoria("Postres");
		producto8.setEstado("Publicado");
		producto8.setDescripcion("Deliciosas en 9 onzas");
		producto8.setFechaHora(ArchivoUtil.cargarFechaSistema());
		URL ruta9= getClass().getResource("/imagenes/postre8.jpg");
		producto8.setImagen(ruta9.getPath().substring(1));


		Producto producto9= new Producto();
		producto9.setNombre("Desayuno sorpresa");
		producto9.setCodigo("2321");
		producto9.setPrecio("$120000");
		producto9.setCategoria("Desayuno");
		producto9.setEstado("Publicado");
		producto9.setDescripcion("");
		producto9.setFechaHora(ArchivoUtil.cargarFechaSistema());
		URL ruta10= getClass().getResource("/imagenes/postre10.jpg");
		producto9.setImagen(ruta10.getPath().substring(1));


		Producto producto10= new Producto();
		producto10.setNombre("Postre tres leches");
		producto10.setCodigo("2321");
		producto10.setPrecio("$4000");
		producto10.setCategoria("Postres");
		producto10.setEstado("Publicado");
		producto10.setDescripcion("Delicioso postre, especial para ti");
		producto10.setFechaHora(ArchivoUtil.cargarFechaSistema());
		URL ruta11= getClass().getResource("/imagenes/postre11.jpg");
		producto10.setImagen(ruta11.getPath().substring(1));


		Producto producto11= new Producto();
		producto11.setNombre("Merienda");
		producto11.setCodigo("2321");
		producto11.setPrecio("$30000");
		producto11.setCategoria("Meriendas");
		producto11.setEstado("Publicado");
		producto11.setDescripcion("");
		producto11.setFechaHora(ArchivoUtil.cargarFechaSistema());
		URL ruta12= getClass().getResource("/imagenes/postre12.jpg");
		producto11.setImagen(ruta12.getPath().substring(1));


		Producto producto12= new Producto();
		producto12.setNombre("Postre maracuya");
		producto12.setCodigo("2321");
		producto12.setPrecio("$4500");
		producto12.setCategoria("Postres");
		producto12.setEstado("Publicado");
		producto12.setDescripcion("Postre delicioso maracuya y relleno de mora");
		producto12.setFechaHora(ArchivoUtil.cargarFechaSistema());
		URL ruta13= getClass().getResource("/imagenes/postre13.jpg");
		producto12.setImagen(ruta13.getPath().substring(1));
		
		listaProductos.add(producto);
		listaProductos.add(producto1);
		listaProductos.add(producto2);
		listaProductos.add(producto3);
		listaProductos.add(producto4);
		listaProductos.add(producto5);
		listaProductos.add(producto6);
		listaProductos.add(producto7);
		listaProductos.add(producto8);
		listaProductos.add(producto9);
		listaProductos.add(producto10);
		listaProductos.add(producto11);
		listaProductos.add(producto12);
		
		Administrador administrador= new Administrador();
		 administrador.setCorreo("iaschool602@gmail.com");
		 administrador.setContrasenia("Delicioso5#");
		
		red.setlistaClientes(listaClientes);
		red.setListaProductos(listaProductos);
		red.setAdministrador(administrador);
		
		


	}

	public void cargarResourceBinario() {

		red = Persistencia.cargarRecursoBancoBinario();
	}


	public void guardarResourceBinario() {

	    Persistencia.guardarRecursoBancoBinario(red);
	}


	public void cargarResourceXML() {

		red = Persistencia.cargarRecursoBancoXML();
	}


	public void guardarResourceXML() {

	    Persistencia.guardarRecursoBancoXML(red);
	}
	
	public void crearCopias(){
		try {
			Persistencia.crearCopias();
			System.out.println("Se guardaron copias");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Red getRed() {
		return red;
	}

	public void setRed(Red red) {
		this.red= red;
	}


	public Cliente crearCliente(String nombre, String apellido, String cedula, String direccion, String contrasenia
			,String email, String usuario, Image imagen) throws VendedorException {


		Cliente cliente = null;

		try {
			cliente = getRed().crearCliente(nombre, apellido, cedula, direccion, contrasenia, email, usuario, imagen);
			Persistencia.guardarVendedores(getRed().getlistaClientes());
			Persistencia.guardaRegistroLog("Se ha creado un nuevo vendedor en la red "+cedula, 1, "crear vendedor");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Persistencia.guardaRegistroLog("No se ha podido crear el vendedor", 2, "crear vendedor");
		}

		return cliente;

	}

	

	public boolean verificarUsuario(String usuario, String contrasenia) {
		if(red.verificarUsuario(usuario, contrasenia)){
			Persistencia.guardaRegistroLog("Inicio de sesion del usuario: "+usuario, 1, "inicio Sesion");
		}else{
			Persistencia.guardaRegistroLog("Error de sesion del usuario", 2, "inicio Sesion");
		}
		return red.verificarUsuario(usuario,contrasenia);
	}

	public boolean verificarAdmin(String usuario, String contrasenia){
		if(red.verificarAdmin(usuario, contrasenia)){
			Persistencia.guardaRegistroLog("Inicio de sesion del usuario: "+usuario, 1, "inicio Sesion");
		}else{
			Persistencia.guardaRegistroLog("Error de sesion del usuario", 2, "inicio Sesion");
		}
		return red.verificarAdmin(usuario, contrasenia);
	}

	public boolean verificarCorreoAdmin(String correo) {
		return red.existeAdministrador(correo);
	}

	public void actualizarContrasenia(String correo, String nuevaContrasenia) {
		red.actualizarContrasenia(correo, nuevaContrasenia);
	}

	public void actualizarContraseniaAdmin(String nuevaContrasenia, String identificacion) {
		red.actualizarContraseniaAdmin(nuevaContrasenia, identificacion);

	}

	public String obtenerNombre(String usuario) {
		return red.obtenerNombreCliente(usuario);
	}

	public ArrayList<Producto> obtenerProductos() {
		return red.getListaProductos();
	}
//
//	public Producto crearProducto(String nombre, String codigo, String precio, String estado, String categoria,
//			String fechaAux, String documento) throws ProductoException {
//		Persistencia.guardaRegistroLog("el vendedor"+documento+"ha creado un producto", 1, "crear producto");
//		return red.crearProducto(nombre, codigo, precio, estado, categoria, fechaAux, documento);
//	
//		
//	}
//
//	public void actualizarProducto(String codigo, String nombre, String codigo2, String precio, String estado,
//			String categoria, String fechaAux, String documento) {
//		Persistencia.guardaRegistroLog("el vendedor"+documento+"ha actualizado un producto", 1, "actualizar producto");
//		red.actualizarProducto(codigo, nombre, codigo2, precio, estado, categoria, fechaAux, documento);
//		
//
//	}
//
//	public boolean eliminarProducto(String codigo, String documento) {
//		Persistencia.guardaRegistroLog("el vendedor "+documento+" ha eliminado un producto", 1, "eliminar producto");
//		if( red.eliminarProducto(codigo, documento) ) {
//			Persistencia.guardarRecursoBancoXML(red);
//			Persistencia.guardarRecursoBancoBinario(red);
//			return true;
//		}
//		return false;
//	}
//
//	public ArrayList<Cliente> obtenerAmigos(String documento) {
//		return red.obtenerAmigos(documento);
//	}
//
//	public boolean obtenerInformacion(String nombre) {
//		return red.obtenerInformacion(nombre);
//	}
//
//	public ArrayList<Producto> obtenerProductosAmigo(String nombre) {
//		return red.obtenerProductosAmigos(nombre);
//	}
//
//	public boolean darMeGusta(String codigo, String nombre, String documento) {
//		Persistencia.guardaRegistroLog("el vendedor"+documento+"le ha dado un me gusta a "+nombre, 1, "dar me gusta");
//		return red.darMeGusta(codigo, nombre, documento);
//
//	}
//
//	public String obtenerMeGustas(String nombre, String codigo) {
//		return red.obtenerNumeroMeGustas(nombre, codigo);
//	}
//	
//	public String obtenerMeGustas2(String codigo, String documento) {
//		return red.obtenerNumeroMeGustas2(codigo, documento);
//	}
//
//	public ArrayList<Producto> obtenerProductosTop() {
//		return red.obtenerProductosTop();
//	}
//
//	public void escribirComentario(String codigo, String nombre) throws ComentarioException {
//		red.escribirComentario(codigo, nombre);
//		
//	}
//
//	public ArrayList<Comentario> obtenerComentarios(String codigo, String documento) {
//		return red.obtenerComentarios(codigo, documento);
//	}
//
//	public boolean agregarAmigo(String nombre, String documento) {
//		Persistencia.guardaRegistroLog("el vendedor"+documento+"le ha enviado una solicitud a "+nombre, 1, "agregar amigo");
//		return red.agregarAmigo(nombre, documento);
//	}
//
//	public ArrayList<Cliente> obtenerSolicitudes(String documento) {
//		return red.obtenerSolicitudes(documento);
//	}
//
//	public boolean aceptarSolicitud(String nombreSolicitud, String documento) {
//		Persistencia.guardaRegistroLog("el vendedor"+documento+"ahora es amigo de "+nombreSolicitud, 1, "aceptar solicitud");
//		return red.aceptarSolicitud(nombreSolicitud, documento);
//		
//	}
//
//	public boolean eliminarSolicitud(String documentoAmigoS, String documento) {
//		Persistencia.guardaRegistroLog("el vendedor"+documento+"ha eliminado la solitud de amistad de "+documentoAmigoS, 1, "eliminar solicitud");
//		return red.eliminarSolicitud(documentoAmigoS, documento);
//		
//	}

	public boolean verificarCorreo(String correo) {
		return red.verificarCorreo(correo);
	}

	public String traerNombre(String correo) {
		return red.conseguirNombre(correo);
	}

	public int calcularTotal(Integer newValue, String codigo) {
		return red.calcularTotal(newValue, codigo);
	}

	public String traerCorreo(String usuario) {
		return red.traerCorreo(usuario);
	}

	public Image traerFoto(String usuario) {
		return red.traerFoto(usuario);
	}

	public boolean agregarAlCarrito(Producto producto, String usuario) {
		return red.agregarAlCarrito(producto,usuario);
	}

	public ArrayList<Producto> obtenerProductosCarrito(String usuario) {
		return red.obtenerProductosCarrito(usuario);
	}

	public String obtenerNroPC(String usuario) {
		return red.obtenerNroPC(usuario);
	}

	public String obtenerPrecio(String usuario) {
		return red.obtenerPrecio(usuario);
	}

	public void eliminarPCarrito(Producto producto, String usuario) {
		red.eliminarProductoCarrio(producto, usuario);
	}

	public boolean darMeGusta(Producto producto, String usuario2, String correo2) {
		return red.darMeGusta(producto, usuario2, correo2);
	}

	public ArrayList<Producto> obtenerProductosFavoritos(String usuario) {
		return red.obtenerProductosFavoritos(usuario);
	}

	public ArrayList<Producto> obtenerProductosPedido(String usuario) {
		return red.obtenerProductosPedido(usuario);
	}

	public void guardarPedido(String usuario, String precio, String producto) {
		red.guardarPedido(usuario, precio, producto);
	}
	

	

	

}
