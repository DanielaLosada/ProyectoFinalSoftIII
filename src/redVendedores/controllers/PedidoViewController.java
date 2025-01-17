package redVendedores.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import redVendedores.model.MyListener;
import redVendedores.model.Producto;

public class PedidoViewController {
	
    @FXML
    private ImageView imagen;

    @FXML
    private TextField txtNombreProducto;

    @FXML
    private TextField txtPrecio;

    @FXML
    private Label txtDescripcion;

    @FXML
    void click(MouseEvent event) {
    	 myListener.onClickListener(producto);
    }
    
    private Producto producto;
    private MyListener myListener;

    public void setData(Producto fruit, MyListener myListener) {
        this.producto = fruit;
        this.myListener = myListener;
        txtNombreProducto.setText(fruit.getNombre());
        txtPrecio.setText(fruit.getPrecio());
        txtDescripcion.setText(fruit.getDescripcion());
        Image imagen2= new Image("file:/"+fruit.getImagen());
        imagen.setImage(imagen2);
    }
    
    

}
