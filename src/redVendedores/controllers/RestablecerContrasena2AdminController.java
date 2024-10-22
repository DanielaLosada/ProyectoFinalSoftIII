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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import redVendedores.aplication.Aplicacion;

public class RestablecerContrasena2AdminController {
	 @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private Label txtCodigoVerificacion;

	    @FXML
	    private Button btnRestablecer;

	    @FXML
	    private PasswordField txtContraseniaAgain;

	    @FXML
	    private Label ingresa;

	    @FXML
	    private TextField txtCodigoIngresado;

	    @FXML
	    private PasswordField txtNuevaContrasenia;

	    @FXML
	    private Button btnVerificar;

	    private String correo;
	    
	    private String codigoGenerado;

	    private Aplicacion aplicacion;
	    
	    @FXML
	    private Label identificador;
	    
	    ModelFactoryController modelFactoryController; 

	    @FXML
	    void verificarCodigoEvent(ActionEvent event) {
	    	verificarCodigo();
	    }

	    @FXML
	    void restablecerContrasenaFinalEvent(ActionEvent event) {
	    	actualizarContrasenia();
	    }

	    @FXML
	    void ingresaEvent(MouseEvent event) {
	    	ingresa.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent ->{
	    		aplicacion.mostrarVentanaLoginAdmin();
	    	});
	    }

	@FXML
	void initialize() {
		modelFactoryController = ModelFactoryController.getInstance();
		txtNuevaContrasenia.setEditable(false);
		txtContraseniaAgain.setEditable(false);
 }

	public void setAplicacion(Aplicacion aplicacion, String correo, String codigoGenerado) {
		this.aplicacion = aplicacion;
		this.correo= correo;
		this.codigoGenerado = codigoGenerado;
		identificador.setText(correo);
	}


	private void verificarCodigo(){
		String codigo = codigoGenerado;
		String codigoIngresado = txtCodigoIngresado.getText();

    		if(!(codigoIngresado.equals(""))){
        		if(codigo.equals(codigoIngresado)){
        			mostrarMensaje("Notificaci�n codigo", "Codigo correcto", "El codigo fue ingresado correctamente, a continuaci�n restablezca su contrase�a", AlertType.INFORMATION);
        			txtNuevaContrasenia.setEditable(true);
        			txtContraseniaAgain.setEditable(true);
        		}else{
        			mostrarMensaje("Notificaci�n codigo", "Codigo incorrecto", "El codigo ingresado es incorrecto, vuelva a escribirlo", AlertType.ERROR);
        		}
        	}else{
        		mostrarMensaje("Notificaci�n codigo", "Datos Incompletos", "Debe ingresar el codigo para poder restablecer su contrase�a, despues de 3 intentos se bloqueara el usuario", AlertType.WARNING);
        		txtNuevaContrasenia.setEditable(false);
    			txtContraseniaAgain.setEditable(false);
        	}
    }


	private void actualizarContrasenia(){
		String nuevaContrasenia = txtNuevaContrasenia.getText();
		String contraseniaAgain = txtContraseniaAgain.getText();
		String email = correo;

			if(datosValidos(nuevaContrasenia, contraseniaAgain)){
				if(nuevaContrasenia.equals(contraseniaAgain)){
					if(verificarContrase�a(nuevaContrasenia)){
						modelFactoryController.actualizarContraseniaAdmin(email, nuevaContrasenia);
						mostrarMensaje("Notificaci�n contrase�a", "Contrase�a correcta", "Su contrase�a ha sido ingresada correctamente y se ha actualizado", AlertType.INFORMATION);
						enviarCorreo(email);
						aplicacion.mostrarVentanaLoginAdmin();
					}else{
						mostrarMensaje("Notificaci�n contrase�a", "contrase�a invalida", "La contrase�a debe tener una mayuscula, un n�mero, una minuscula y un simbolo. y debe contener minimo 8 caracteres", AlertType.ERROR);
					}
				}else{
					mostrarMensaje("Notificaci�n contrase�a", "Contrase�a incorrecta", "Las contrase�as no coinciden, vuelva a digitarlas", AlertType.ERROR);
				}
			}else{
				mostrarMensaje("Notificaci�n contrase�a", "Datos Incompletos", "Debe ingresar la nueva contrase�a para poder restablecerla, despues de 3 intentos se bloqueara el usuario", AlertType.WARNING);
			}
	}
	
	public static boolean verificarContrase�a(String contrase�a) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!.,?��-]).{8}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(contrase�a);

        return matcher.matches();
    }
	
	private void enviarCorreo(String destinatario) {
		//String nombre= modelFactoryController.traerNombre(correo);
		 Properties properties = new Properties();
	        properties.put("mail.smtp.host", "smtp.gmail.com"); // Cambia esto al servidor SMTP que desees utilizar
	        properties.put("mail.smtp.port", "587"); // Cambia esto al puerto SMTP adecuado
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true"); // Habilita STARTTLS para la seguridad

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
           mensaje.setSubject("Contrase�a restablecida - Delicias�D'�Eliza");
           mensaje.setText("�Felicitaciones!  has restablecido tu contrase�a correctamente. " +  "\n"+ "Ahora puedes ingresar a tu cuenta con normalidad" );

           // Enviar el mensaje
           Transport.send(mensaje);

           System.out.println("Correo electr�nico enviado con �xito.");
       } catch (MessagingException e) {
           e.printStackTrace();
           System.err.println("Error al enviar el correo electr�nico: " + e.getMessage());
       }
   }




	public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

		Alert alert = new Alert(alertType);
		alert.setTitle(titulo);
		alert.setHeaderText(header);
		alert.setContentText(contenido);
		alert.showAndWait();
	}

	private boolean datosValidos(String codigoGenerado, String codigoIngresado) {
		if(codigoGenerado.equals("") || codigoIngresado.equals("")){
			return false;
		}
		return true;
	}







}
