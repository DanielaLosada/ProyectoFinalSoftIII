package redVendedores.aplication;

import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import redVendedores.controllers.CarritoController;
import redVendedores.controllers.Compra2Controller;
import redVendedores.controllers.CompraController;
import redVendedores.controllers.Daviplata2Controller;
import redVendedores.controllers.Daviplata3Controller;
import redVendedores.controllers.Daviplata4Controller;
import redVendedores.controllers.FacturaController;
import redVendedores.controllers.FavoritosController;
import redVendedores.controllers.IniciarRedController;
import redVendedores.controllers.LoginAdministradorController;
import redVendedores.controllers.LoginVendedorController;
import redVendedores.controllers.MisPedidosController;
import redVendedores.controllers.Nequi2Controller;
import redVendedores.controllers.Nequi3Controller;
import redVendedores.controllers.Nequi4Controller;
import redVendedores.controllers.Nequi5Controller;
import redVendedores.controllers.NuevoVendedorController;
import redVendedores.controllers.PQRSController;
import redVendedores.controllers.PagoPSEController;
import redVendedores.controllers.PagoRechazadoController;
import redVendedores.controllers.PagoTarjetasController;
import redVendedores.controllers.RedPrincipalAdminController;
import redVendedores.controllers.ReedController;
import redVendedores.controllers.RestablecerContrasena2AdminController;
import redVendedores.controllers.RestablecerContrasena2Controller;
import redVendedores.controllers.RestablecerContrasenaAdminController;
import redVendedores.controllers.RestablecerContrasenaController;
import redVendedores.model.Red;


 public class Aplicacion extends Application{

	private Stage primaryStage;

	Red red = new Red ("Shopify MarketPlace");




	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Shopify MarketPlace");
		this.primaryStage.centerOnScreen();

		mostrarVentanaIniciarRed();

	}

	public void mostrarVentanaIniciarRed() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/IniciarRed.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			IniciarRedController iniciarRedController= loader.getController();
			iniciarRedController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			//primaryStage.setResizable(false);
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void mostrarVentanaPrincipal(String documento, String correo) {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/Reed.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			ReedController reedController = loader.getController();
			reedController.setAplicacion(this, documento, correo);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mostrarVentanaPrincipalAdmin(String documento) {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/RedPrincipalAdmin.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			RedPrincipalAdminController redPrincipalAdminController = loader.getController();
			redPrincipalAdminController.setAplicacion(this, documento);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public void mostrarVentanaLoginVendedor() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/LoginVendedor.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			LoginVendedorController loginController = loader.getController();
			loginController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mostrarVentanaRestablecerContrasena() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/RestablecerContrasena.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			RestablecerContrasenaController restablecerController = loader.getController();
			restablecerController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mostrarVentanaRestablecerContrasena2(String correo, String codigoGenerado) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/RestablecerContrasena2.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			RestablecerContrasena2Controller restablecer2Controller = loader.getController();
			restablecer2Controller.setAplicacion(this,correo, codigoGenerado);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void mostrarVentanaNuevoVendedor() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/NuevoVendedor.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			NuevoVendedorController nuevoVendedorController = loader.getController();
			nuevoVendedorController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void mostrarVentanaLoginAdmin(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/LoginAdministrador.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			LoginAdministradorController loginAdministradorController = loader.getController();
			loginAdministradorController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaFactura(String totalPagar, String metodo, String nombre, Integer numP, String usuario, String correo){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/Factura.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			FacturaController loginAdministradorController = loader.getController();
			loginAdministradorController.setAplicacion(this, totalPagar, metodo, nombre, numP, usuario, correo);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mostrarVentanaRestablecerContrasena2Admin(String correo, String codigoGenerado) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/RestablecerContrasena2Admin.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			RestablecerContrasena2AdminController restablecerContrasena2AdminController = loader.getController();
			restablecerContrasena2AdminController.setAplicacion(this, correo, codigoGenerado);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void mostrarVentanaRestablecerContrasenaAdmin() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/RestablecerContrasenaAdmin.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			RestablecerContrasenaAdminController restablecerContrasenaAdminController = loader.getController();
			restablecerContrasenaAdminController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaCarrito(String documento, String correo){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/Carrito.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			CarritoController carritoController = loader.getController();
			carritoController.setAplicacion(this, documento, correo);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaCompra(String usuario, String correo, int num, String precio, String producto){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/Compra.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			CompraController compraController = loader.getController();
			compraController.setAplicacion(this, usuario, correo, num, precio,producto);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaCompra2(String usuario, String correo, int num, String precio, String producto){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/Compra2.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			Compra2Controller compraController = loader.getController();
			compraController.setAplicacion(this, usuario, correo, num, precio,producto);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaPagoTarjetas(String producto, String precio, int num, String correo, String usuario){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/PagoTarjetas.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			PagoTarjetasController pagoTarjetasController = loader.getController();
			pagoTarjetasController.setAplicacion(this, producto, precio, num, correo, usuario);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaPagoPSE(String precio, String correo, String usuario, String producto, int num){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/pagoPSE.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			PagoPSEController pagoPSEController = loader.getController();
			pagoPSEController.setAplicacion(this, precio,correo, usuario, producto, num);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaDaviplata2(String precio, String correo, String usuario, String codigo, String producto, int num){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/Daviplata2.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			Daviplata2Controller daviplata2Controller = loader.getController();
			daviplata2Controller.setAplicacion(this,precio, correo, usuario, codigo, producto, num);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaDaviplata3(String precio, String fecha2, String usuario, String correo, String producto, int num){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/Daviplata3.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			Daviplata3Controller daviplata3Controller = loader.getController();
			daviplata3Controller.setAplicacion(this, precio, fecha2, usuario, correo, producto, num);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaDaviplata4(String fecha2, String precio, String usuario, String correo, String producto, int num){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/Daviplata4.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			Daviplata4Controller daviplata4Controller = loader.getController();
			daviplata4Controller.setAplicacion(this, fecha2, precio, usuario, correo, producto, num);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaNequi2(String precio, String correo, String usuario, String producto, int num){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/Nequi2.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			Nequi2Controller nequi2Controller = loader.getController();
			nequi2Controller.setAplicacion(this, precio,correo, usuario, producto, num);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaNequi3(String precio, String correo, String usuario, String producto, int num){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/Nequi3.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			Nequi3Controller nequi3Controller = loader.getController();
			nequi3Controller.setAplicacion(this,precio, correo, usuario, producto, num);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaNequi4(String precio, String codigo, String correo, String usuario, String producto, int num){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/Nequi4.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			Nequi4Controller nequi4Controller = loader.getController();
			nequi4Controller.setAplicacion(this,precio,codigo, correo, usuario, producto, num);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaNequi5(String precio, String usuario, String correo, String producto, int num){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/Nequi5.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			Nequi5Controller nequi5Controller = loader.getController();
			nequi5Controller.setAplicacion(this,precio, usuario, correo, producto, num);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaPagoRechazado(String precio, String fecha, String banco, String usuario, String correo){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/PagoRechazado.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			PagoRechazadoController pagoRechazadoController = loader.getController();
			pagoRechazadoController.setAplicacion(this,precio,fecha,banco, usuario, correo);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaFavoritos(String usuario, String correo) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/Favoritos.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			FavoritosController favoritoController = loader.getController();
			favoritoController.setAplicacion(this, usuario, correo);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaPedidos(String usuario, String correo) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/MisPedidos.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			MisPedidosController favoritoController = loader.getController();
			favoritoController.setAplicacion(this, usuario, correo);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	public void mostrarVentanaPQRS(String usuario, String correo, String nombre) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/Pqrs.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			PQRSController pqrsController = loader.getController();
			pqrsController.setAplicacion(this, usuario, correo, nombre);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	




	public static void main(String[] args) {
		launch(args);
	}
	

 }
