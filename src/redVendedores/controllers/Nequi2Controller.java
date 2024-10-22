package redVendedores.controllers;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import redVendedores.aplication.Aplicacion;

public class Nequi2Controller {
	@FXML
	private Label referencia;

	@FXML
	private Label valor;

	@FXML
	private Label nroReferencia;

	@FXML
	private RadioButton rBtnDisponible;

	@FXML
	private Button btnPagar;
	
	private Aplicacion aplicacion;
	
	private String precio;
	
	private String correo;
	
	private String usuario;
	
	private String producto; 
	
	private int num; 

	public void setAplicacion(Aplicacion aplicacion, String precio, String correo, String usuario, String producto, int num) {
		this.aplicacion = aplicacion;
		this.precio= precio;
		this.correo= correo;
		this.usuario= usuario;
		this.producto= producto;
		this.num= num; 
		
		referencia.setText(generarReferencia());
		valor.setText(precio);
		nroReferencia.setText(generarNroReferencia());
	}
	
	public static String generarReferencia() {
        Random random = new Random();
        StringBuilder numeroAleatorio = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            int digito = random.nextInt(10);
            numeroAleatorio.append(digito);
        }
        return numeroAleatorio.toString();
    }
	
	public static String generarNroReferencia() {
        Random random = new Random();
        int primerDigito = random.nextInt(10);
        int segundoDigito = random.nextInt(10);
        StringBuilder numeroStringBuilder = new StringBuilder();
        numeroStringBuilder.append(primerDigito);
        numeroStringBuilder.append(segundoDigito);
        return numeroStringBuilder.toString();
    }
	

	@FXML
	void pagarEvent(ActionEvent event) {
		aplicacion.mostrarVentanaNequi3(precio, correo, usuario, producto, num);
	}

}
