package redVendedores.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import redVendedores.aplication.Aplicacion;

public class FacturaController {
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label labelFecha;

    @FXML
    private Label labelProducto;

    @FXML
    private Label labelCantidadP;

    @FXML
    private Label labelMetodoPago;

    @FXML
    private Label labelTotalPagar;
    
    @FXML
    private ImageView flechaRegresar;
    
    
    private String totalPagar;
    
    private String metodo; 
    
    private String nombre;
    
    private Integer numP;
    
    private String usuario; 
    
    private String correo;
    
	public void setAplicacion(Aplicacion aplicacion, String totalPagar, String metodo, String nombre, Integer numP, String usuario, String correo) {
		this.aplicacion = aplicacion;
		this.totalPagar = totalPagar; 
		this.metodo = metodo; 
		this.nombre = nombre; 
		this.numP = numP;
		this.usuario= usuario; 
		this.correo= correo;
		
		labelProducto.setText(nombre);
		labelCantidadP.setText(numP.toString());
		labelMetodoPago.setText(metodo);
		labelTotalPagar.setText( totalPagar);
		
		LocalDate fechaActual = LocalDate.now();

        // Define un formato para la fecha (opcional)
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Convierte la fecha en una cadena de texto
        String fechaComoString = fechaActual.format(formato);
        
        labelFecha.setText(fechaComoString);	

	}
	
	private Aplicacion aplicacion;
    
    @FXML
    void flechaRegresarEvent(MouseEvent event) {
    	
    	aplicacion.mostrarVentanaPrincipal(usuario, correo);

    }
    
 
}

	

