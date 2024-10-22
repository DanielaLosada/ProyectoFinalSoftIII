package redVendedores.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import redVendedores.aplication.Aplicacion;
import redVendedores.model.MyListener;
import redVendedores.model.Producto;

public class CarritoController {
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ScrollPane scrollCarrito;

	@FXML
	private GridPane grid;

	@FXML
	private Label NroProductos;

	@FXML
	private TextField txtPrecio;

	@FXML
	private ComboBox<String> comboBoxZonaEnvio;

	@FXML
	private TextField txtValorEnvio;

	@FXML
	private TextField txtTotal;

	@FXML
	private Button btnComprar;
	
	private Aplicacion aplicacion;
	
	private String usuario; 
	
	private String correo;
	
	ModelFactoryController modelFactoryController; 

	@FXML
	private ImageView flechaRegresar;
	
	private ArrayList<Producto> productos = new ArrayList<>();
	private MyListener myListener;

	@FXML
	void flechaRegresarEvent(MouseEvent event) {
		flechaRegresar.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent ->{
	    		aplicacion.mostrarVentanaPrincipal(usuario, correo);
    	});
	}

	@FXML
	void ComprarEvent(ActionEvent event) {
		aplicacion.mostrarVentanaCompra2(usuario, correo, productos.size(), txtPrecio.getText(), filtrarNombres());
	}
	
	@FXML
	void initialize() {
		modelFactoryController = ModelFactoryController.getInstance();

//		comboBoxZonaEnvio.getItems().addAll("Centro", "Norte", "Sur");
//		comboBoxZonaEnvio.setOnAction(this::filtrarEnvio);
	}
	
	public void setAplicacion(Aplicacion aplicacion, String usuario, String correo) {
		this.aplicacion = aplicacion;
		this.usuario = usuario;
		this.correo = correo;
		NroProductos.setText("("+modelFactoryController.obtenerNroPC(usuario)+")");
		txtPrecio.setText(modelFactoryController.obtenerPrecio(usuario));
		txtTotal.setText(txtPrecio.getText());
		getListaProductosData();
		productos.addAll(getListaProductosData());
		System.out.println(productos);
		if (productos.size() > 0) {
			myListener = new MyListener() {
				@Override
				public void onClickListener(Producto producto) {
				}
			};
		}
		int column = 0;
		int row = 1;
		try {
			for (int i = 0; i < productos.size(); i++) {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Aplicacion.class.getResource("../views/ProductoCarrito.fxml"));

				AnchorPane rootLayout = (AnchorPane) loader.load();

				ProductoCarritoController itemController = loader.getController();
				itemController.setData(productos.get(i), myListener, usuario, aplicacion, correo);

				if (column == 1) {
					column = 0;
					row++;
				}

				grid.add(rootLayout, column++, row); // (child,column,row)
				// set grid width
				grid.setMinWidth(Region.USE_COMPUTED_SIZE);
				grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
				grid.setMaxWidth(Region.USE_PREF_SIZE);

				// set grid height
				grid.setMinHeight(Region.USE_COMPUTED_SIZE);
				grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
				grid.setMaxHeight(Region.USE_PREF_SIZE);

				GridPane.setMargin(rootLayout, new Insets(10));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private ArrayList<Producto> getListaProductosData() {
		return modelFactoryController.obtenerProductosCarrito(usuario);
	}
	
	public String filtrarNombres(){
		String cadenaAux= ""; 
		for (Producto producto : productos) {
			cadenaAux= producto.getNombre()+", ";
		}
		return cadenaAux;
	}
//	
//	public int filtrarEnvio(ActionEvent event) {
//		String selectedState = comboBoxZonaEnvio.getSelectionModel().getSelectedItem();
//		int precio= 0;
//		int total= 0;
//		if (selectedState != null) {
//			if (selectedState.equals("Centro")) {
//				precio= 5000;
//				txtValorEnvio.setText(Integer.toString(precio));
//				total= precio+(Integer.parseInt(txtPrecio.getText()));
//				txtTotal.setText(Integer.toString(total));
//			}
//			if (selectedState.equals("Sur")) {
//				precio= 4000;
//				txtValorEnvio.setText(Integer.toString(precio));
//				total= precio+(Integer.parseInt(txtPrecio.getText()));
//				txtTotal.setText(Integer.toString(total));
//			}
//			if (selectedState.equals("Norte")) {
//				precio=7000;
//				txtValorEnvio.setText(Integer.toString(precio));
//				total= precio+(Integer.parseInt(txtPrecio.getText()));
//				txtTotal.setText(Integer.toString(total));
//			}
//		}
//		return precio;
//	}
//	
//	

}
