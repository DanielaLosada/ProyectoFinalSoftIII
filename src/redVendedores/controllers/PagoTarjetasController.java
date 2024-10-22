package redVendedores.controllers;

import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import redVendedores.aplication.Aplicacion;

public class PagoTarjetasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNroTarjeta;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtFechaVencimiento;

    @FXML
    private TextField txtCodigo;
    
    ModelFactoryController modelFactoryController; 

    @FXML
    private Button btnContinuar;
    
    private String producto; 
    
    private String precio; 
    
    private int num; 
    
    private String correo; 
    
    private String usuario; 
    
    
    private Aplicacion aplicacion;

    @FXML
    void ContinuarEvent(ActionEvent event) {
    	if(verificarTarjeta(txtNroTarjeta.getText())){
    		if(verificarNombre(txtNombre.getText())){
    			if(verificarVencimiento(txtFechaVencimiento.getText())){
    				if(verificarCodigo(txtCodigo.getText())){
    					enviarCorreo(correo);
    					aplicacion.mostrarVentanaFactura(precio, "Tarjeta", producto, num, usuario, correo);
    					modelFactoryController.guardarPedido(usuario, precio, producto);
    				}else{
    					JOptionPane.showMessageDialog(null, "Codigo incorrecto");
    				}
    			}else{
    				JOptionPane.showMessageDialog(null, "Fecha incorrecta");
    			}
    		}else{
    			JOptionPane.showMessageDialog(null, "nombre incorrecto");
    		}
    	}else{
    		JOptionPane.showMessageDialog(null, "tarjeta incorrecta");
    	}
    }
    
    public void setAplicacion(Aplicacion aplicacion, String producto, String precio, int num, String correo, String usuario) {
		this.aplicacion = aplicacion;
		this.producto= producto; 
		this.precio= precio; 
		this.num= num;
		this.usuario= usuario; 
		this.correo= correo;
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
			mensaje.setText("¡Se ha realizado con exito tu compra!" + "\n" + "Tu pedido correspondiente"
					+ "\n" + "con el valor de: " + precio + "\n"
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

	private boolean verificarNombre(String nombre) {
		String regex = "^[a-zA-Z ]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(nombre);
		return matcher.matches();
	}

	private boolean verificarTarjeta(String tarjeta) {
		String regex = "^[0-9]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(tarjeta);
		return matcher.matches();
	}

	private boolean verificarVencimiento(String fecha) {
		String regex = "^(0[1-9]|1[0-2])/(\\d{2})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(fecha);
		return matcher.matches();
	}
	
	private boolean verificarCodigo(String codigo) {
	    String regex = "^[0-9]{3}$";
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(codigo);
	    return matcher.matches();
	}
	
	 @FXML
		void initialize() {
			modelFactoryController = ModelFactoryController.getInstance();
		}

    
    

}