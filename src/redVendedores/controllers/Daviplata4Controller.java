package redVendedores.controllers;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import redVendedores.aplication.Aplicacion;

public class Daviplata4Controller {
	
	@FXML
	private Label fecha;

	@FXML
	private Label nroAprobacion;

	@FXML
	private Label valorTransaccion;

	@FXML
	private Label referencia;

	@FXML
	private Button btnSalir;
	
	private Aplicacion aplicacion;
	
	private String fecha2; 
	
	private String precio; 
	
	private String usuario; 
	
	private String correo;
	
	private String producto; 
	
	private int num;
	
	ModelFactoryController modelFactoryController; 

	public void setAplicacion(Aplicacion aplicacion, String fecha2, String precio, String usuario, String correo, String producto, int num) {
		this.aplicacion = aplicacion;
		this.fecha2 = fecha2; 
		this.precio= precio; 
		this.usuario= usuario; 
		this.correo= correo;
		this.producto= producto; 
		this.num= num; 
		
		fecha.setText(fecha2);
		valorTransaccion.setText(precio);
		nroAprobacion.setText(generarNroAprobacion());
		referencia.setText(generarNroAprobacion());
	}
	
	public static String generarNroAprobacion() {
        Random random = new Random();
        StringBuilder numeroAleatorio = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            int digito = random.nextInt(10);
            numeroAleatorio.append(digito);
        }
        return numeroAleatorio.toString();
    }

	@FXML
	void salirEvent(ActionEvent event) {
		enviarCorreo(correo);
		aplicacion.mostrarVentanaFactura(precio, "Daviplata", producto, num, usuario, correo);
		modelFactoryController.guardarPedido(usuario,precio, producto );
	}
	

	private void enviarCorreo(String destinatario) {
		// String nombre= modelFactoryController.traerNombre(correo);
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com"); // Cambia esto al
															// servidor SMTP que
															// desees utilizar
		properties.put("mail.smtp.port", "587"); // Cambia esto al puerto SMTP
													// adecuado
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true"); // Habilita
																// STARTTLS para
																// la seguridad

		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("deliciasd.elizaseguridad@gmail.com", "bxlg szks nsqa ntus");
			}
		});

		try {
			// Crear un objeto de mensaje
			Message mensaje = new MimeMessage(session);

			// Configurar el remitente y los destinatarios
			mensaje.setFrom(new InternetAddress(destinatario));
			mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
			mensaje.setSubject("¡Compra exitosa! - Delicias D' Eliza");
			mensaje.setText("¡Se ha realizado con exito tu compra!" + "\n" + "Tu pedido con el valor de: " + precio + "\n"
					+ "Esta en proceso de empaquetado y proximo a ser despachado a su direccion de residencia" + "\n"
					+ "¡GRACIAS POR TU COMPRA!");

			// Enviar el mensaje
			Transport.send(mensaje);

			System.out.println("Correo electrónico enviado con éxito.");
		} catch (MessagingException e) {
			e.printStackTrace();
			System.err.println("Error al enviar el correo electrónico: " + e.getMessage());
		}
	}
	
	 @FXML
		void initialize() {
			modelFactoryController = ModelFactoryController.getInstance();
		}


}
