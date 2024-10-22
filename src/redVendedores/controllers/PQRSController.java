package redVendedores.controllers;

import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import redVendedores.aplication.Aplicacion;

public class PQRSController {
	@FXML
    private TextField txtCampoTexto;

    @FXML
    private Button btnEnviarP;
    
    private Aplicacion aplicacion;
    
    private String usuario; 
    
    private String correo; 
    
    private String nombre;
    
    private String codigo;
    
    @FXML
    private ImageView flechaRegresar;

    
    public void setAplicacion(Aplicacion aplicacion, String usuario, String correo, String nombre) {
		this.aplicacion = aplicacion;
		this.usuario= usuario;
		this.correo= correo;
		this.nombre= nombre; 
	}
    private String cadenaAleatoria() {
        String banco = "1234567890";
        String cadenaAux= "";
        for (int x = 0; x < 5; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
            char caracterAleatorio = banco.charAt(indiceAleatorio);
            cadenaAux+=caracterAleatorio;
            codigo =cadenaAux;
        }
		return codigo;
	}
    
    private int numeroAleatorioEnRango(int minimo, int maximo) {
		return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
	}
    @FXML
    void initialize() {
		cadenaAleatoria();
    }
    @FXML
    void flechaRegresarEvent(MouseEvent event) {
    	flechaRegresar.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent ->{
    		aplicacion.mostrarVentanaPrincipal(usuario, correo);;
    	});

    }
    @FXML
    void enviarPEvent(ActionEvent event) {
    	String mensaje= txtCampoTexto.getText();
    	if(mensaje!=null){
    		enviarCorreo(mensaje);
    		mostrarMensaje("Notificación PQRS", "Envio", "Se ha enviado y creado con exito su peticion, queja, sugerencia u reclamo. El numero de radico es: "+codigo+" prontamente recibira respuesta", AlertType.ERROR);
    		txtCampoTexto.setText("");
    	}else{
    		mostrarMensaje("Notificación PQRS", "Campo vacio", "Debe escribir algo para poder enviar una peticion, queja, sugerencia o reclamo", AlertType.ERROR);
    		txtCampoTexto.setText("");
    	}
    }
    
    private void enviarCorreo(String mensaje2) {
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
				return new PasswordAuthentication(correo, "fpxl yyqb yiaw hfsx");
			}
		});

		try {
			// Crear un objeto de mensaje
			Message mensaje = new MimeMessage(session);

			// Configurar el remitente y los destinatarios
			mensaje.setFrom(new InternetAddress("deliciasd.elizaseguridad@gmail.com"));
			mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse("deliciasd.elizaseguridad@gmail.com"));
			mensaje.setSubject("PQRS - Solicitud cliente");
			mensaje.setText(mensaje2);

			// Enviar el mensaje
			Transport.send(mensaje);

			System.out.println("Correo electrónico enviado con éxito.");
		} catch (MessagingException e) {
			e.printStackTrace();
			System.err.println("Error al enviar el correo electrónico: " + e.getMessage());
		}
	}
    
    public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

		Alert alert = new Alert(alertType);
		alert.setTitle(titulo);
		alert.setHeaderText(header);
		alert.setContentText(contenido);
		alert.showAndWait();
	}



}
