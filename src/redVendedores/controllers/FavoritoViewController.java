package redVendedores.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import redVendedores.aplication.Aplicacion;
import redVendedores.model.MyListener;
import redVendedores.model.Producto;

public class FavoritoViewController {
	
	@FXML
	private TextField txtNombreProducto;

	@FXML
	private TextField txtPrecio;

	@FXML
	private ImageView imagenProducto;

	@FXML
	private Label txtCodigo;

	@FXML
	private Label txtCategoria;

	@FXML
	private Label txtDescripcion;
	
	private String usuario; 
	
	private String correo;
	
	private Aplicacion aplicacion;
	
	@FXML
    private Label comprarProducto;

    @FXML
    void comprarEvent(MouseEvent event) {
    	comprarProducto.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent ->{
   
    				aplicacion.mostrarVentanaCompra(usuario, correo, 1, producto.getPrecio(), producto.getNombre());
    			});
   
    }
	
	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
		
	}
	
	 @FXML
	    private void click(MouseEvent mouseEvent) {
	        myListener.onClickListener(producto);
	    }

	    private Producto producto;
	    private MyListener myListener;

	    public void setData(Producto fruit, MyListener myListener) {
	        this.producto = fruit;
	        this.myListener = myListener;
	        txtNombreProducto.setText(fruit.getNombre());
	        txtPrecio.setText(fruit.getPrecio());
	        txtCategoria.setText(fruit.getCategoria());
	        txtDescripcion.setText(fruit.getDescripcion());
	        txtCodigo.setText(fruit.getCodigo());
	        Image imagen2= new Image("file:/"+fruit.getImagen());
	        imagenProducto.setImage(imagen2);
	    }
	    
	    


}
