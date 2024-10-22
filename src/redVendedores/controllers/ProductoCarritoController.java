package redVendedores.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import redVendedores.aplication.Aplicacion;
import redVendedores.model.MyListener;
import redVendedores.model.Producto;

public class ProductoCarritoController {
	

    @FXML
    private ImageView imagen;

    @FXML
    private TextField txtNombreProducto;

    @FXML
    private TextField txtPrecio;

    @FXML
    private Spinner<Integer> nroProductos;

    @FXML
    private Label txtDescripcion;

    @FXML
    private Label eliminarPCarrito;

    @FXML
    private Label comprarProducto;
    
    private String usuario;
    
    private Aplicacion aplicacion;
    
    private String correo;

    @FXML
    void comprarEvent(MouseEvent event) {

    }

    @FXML
    void eliminarEvent(MouseEvent event) {
    	eliminarPCarrito.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent ->{
    		modelFactoryController.eliminarPCarrito(producto, usuario);
    		aplicacion.mostrarVentanaCarrito(usuario, correo);
    	});
    }
    
    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(producto);
    }

    private Producto producto;
    private MyListener myListener;
    
    ModelFactoryController modelFactoryController; 

    public void setData(Producto fruit, MyListener myListener, String usuario, Aplicacion aplicacion, String correo) {
        this.producto = fruit;
        this.myListener = myListener;
        this.usuario= usuario;
        this.correo= correo;
        this.aplicacion= aplicacion;
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
		nroProductos.setValueFactory(valueFactory);
        txtNombreProducto.setText(fruit.getNombre());
        txtPrecio.setText(fruit.getPrecio());
        txtDescripcion.setText(fruit.getDescripcion());
        Image imagen2= new Image("file:/"+fruit.getImagen());
        imagen.setImage(imagen2);
    }
    
    @FXML
	void initialize() {
		modelFactoryController = ModelFactoryController.getInstance();
	}
    

}
