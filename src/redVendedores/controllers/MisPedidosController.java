package redVendedores.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import redVendedores.aplication.Aplicacion;
import redVendedores.model.MyListener;
import redVendedores.model.Producto;

public class MisPedidosController {
	
	private Aplicacion aplicacion;

	@FXML
	private ImageView flechaRegresar;

	@FXML
	private ScrollPane scrollCarrito;

	@FXML
	private GridPane grid;
	
	private ArrayList<Producto> productos = new ArrayList<>();

	ModelFactoryController modelFactoryController;
	
	private String usuario; 
	
	private String correo; 
	
	private MyListener myListener;

	@FXML
	void initialize() {
		modelFactoryController = ModelFactoryController.getInstance();
	}

	public void setAplicacion(Aplicacion aplicacion, String usuario, String correo) {
		this.aplicacion = aplicacion;
		this.usuario = usuario; 
		this.correo= correo;
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
		int row = 2; 
		try {
			for (int i = 0; i < productos.size(); i++) {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Aplicacion.class.getResource("../views/productoPedidos.fxml"));

				AnchorPane rootLayout = (AnchorPane) loader.load();

				PedidoViewController itemController = loader.getController();
				itemController.setData(productos.get(i), myListener);

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
		return modelFactoryController.obtenerProductosPedido(usuario);
	}
	
	 @FXML
	    void flechaRegresarEvent(MouseEvent event) {
	    	flechaRegresar.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent ->{
	    		aplicacion.mostrarVentanaPrincipal(usuario, correo);
	    	});

	    }

}
