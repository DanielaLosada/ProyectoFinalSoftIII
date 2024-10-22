package redVendedores.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.util.Duration;
import redVendedores.aplication.Aplicacion;

public class Daviplata3Controller {
	
	@FXML
    private Text fecha;

    @FXML
    private Label hora;

	@FXML
	private Button btnSalir;

	@FXML
	private Button btnDetalle;
	
	private Aplicacion aplicacion;
	
	private String precio; 
	
	private String fecha2; 
	
	private String usuario; 
	
	private String correo;
	
	private String producto; 
	
	private int num;

	public void setAplicacion(Aplicacion aplicacion, String precio, String fecha2, String usuario, String correo, String producto, int num) {
		this.aplicacion = aplicacion;
		this.precio= precio; 
		this.fecha2= fecha2; 
		this.usuario= usuario; 
		this.correo= correo;
		this.producto= producto; 
		this.num= num;
		
		LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        String fechaComoString = fechaActual.format(formato);
        fecha.setText(fechaComoString);
	}
	
	@FXML
    void initialize() {
		updateClock(); // Actualizar la hora al cargar la ventana
		Timeline timeline = new Timeline(
	            new KeyFrame(Duration.minutes(1), event -> updateClock())
	        );
	        timeline.setCycleCount(Timeline.INDEFINITE);
	        timeline.play();
		
	}
	
	public void updateClock() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");
        String currentTime = sdf.format(new Date());
        hora.setText(currentTime);
    }

	@FXML
	void mostrarDetalleEvent(ActionEvent event) {
		aplicacion.mostrarVentanaDaviplata4(fecha2, precio, usuario, correo, producto, num);
	}

	@FXML
	void salirEvent(ActionEvent event) {
		
		aplicacion.mostrarVentanaPrincipal(usuario, correo);

	}

}
