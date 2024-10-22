package redVendedores.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
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
import javafx.scene.control.Button;
import redVendedores.aplication.Aplicacion;

public class Nequi3Controller {
	@FXML
	private Button btnPedirCodigo;

	@FXML
	private Button btnCancelar;
	
	private Aplicacion aplicacion;
	private String precio;
	private String correo;
	private String usuario;
	
	private String codigo;
	
	private String fecha;
	
	private String producto; 
	
	private int num;

	public void setAplicacion(Aplicacion aplicacion, String precio, String correo, String usuario, String producto, int num) {
		this.aplicacion = aplicacion;
		this.precio= precio;
		this.correo= correo;
		this.usuario= usuario;
		this.producto= producto; 
		this.num= num; 
		
		LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        fecha = fechaActual.format(formato);
	}
	
	@FXML
    void initialize() {
		cadenaAleatoria();
    }

	@FXML
	void cancelarEvent(ActionEvent event) {
		aplicacion.mostrarVentanaPagoRechazado(precio, fecha, "NEQUI", usuario, correo);
	}

	@FXML
	void pedirCodigoEvent(ActionEvent event) {
		enviarCorreo(correo);
		aplicacion.mostrarVentanaNequi4(precio,codigo, correo, usuario, producto, num);
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

	
	private void enviarCorreo(String destinatario) {
		
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
          mensaje.setSubject("Código Nequi");
          mensaje.setText("Tu código Nequi es: "+codigo);

          // Enviar el mensaje
          Transport.send(mensaje);

          System.out.println("Correo electrónico enviado con éxito.");
      } catch (MessagingException e) {
          e.printStackTrace();
          System.err.println("Error al enviar el correo electrónico: " + e.getMessage());
      }
  }

}
