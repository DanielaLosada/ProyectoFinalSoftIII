package redVendedores.controllers;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import redVendedores.aplication.Aplicacion;

public class PagoRechazadoController {
	
	@FXML
	private Label monto;

	@FXML
	private Text medioPago;

	@FXML
	private Label fecha;

	@FXML
	private Label nroTrans;

	@FXML
	private Text banco;

	@FXML
	private Label total;

	@FXML
	private Button btnCerrar;
	
	private Aplicacion aplicacion;
	
	private String precio;
	
	private String fecha2; 
	
	private String banco2;
	
	private String usuario; 
	
	private String correo;

	public void setAplicacion(Aplicacion aplicacion, String precio, String fecha2, String banco2, String usuario, String correo) {
		this.aplicacion = aplicacion;
		this.usuario= usuario; 
		this.correo= correo;
		total.setText(precio);
		monto.setText(precio);
		banco.setText(banco2);
		fecha.setText(fecha2);
		nroTrans.setText(generarNroTransaccion());
	}
	
	public static String generarNroTransaccion() {
        Random random = new Random();
        StringBuilder numeroAleatorio = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            int digito = random.nextInt(10);
            numeroAleatorio.append(digito);
        }
        return numeroAleatorio.toString();
    }

	@FXML
	void cerrarEvent(ActionEvent event) {
		aplicacion.mostrarVentanaPrincipal(usuario, correo);
	}

}
