package redVendedores.controllers;

import java.util.Optional;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import redVendedores.aplication.Aplicacion;

public class UsuarioController {
    @FXML
    private Label nombreVendedor;

    @FXML
    private ImageView foto;

    @FXML
    private Text labelPQRS;

    @FXML
    private Text labelSalir;
    
    private Aplicacion aplicacion;
    
    private String usuario; 
    
    private String correo;
    
    private String nombre; 
    
    ModelFactoryController modelFactoryController;

	@FXML
	void initialize() {
		modelFactoryController = ModelFactoryController.getInstance();
	}
    
    public void setAplicacion(Aplicacion aplicacion, String usuario, String correo, String nombre2) {
		this.aplicacion = aplicacion;
		this.usuario= usuario; 
		this.correo= correo;
		this.nombre= nombre2;
		
		nombreVendedor.setText(nombre);
		foto.setImage(modelFactoryController.traerFoto(usuario));

		Circle clip = new Circle(foto.getFitWidth() / 2, foto.getFitHeight() / 2, foto.getFitWidth() / 2);

		// Aplica la máscara al ImageView
		foto.setClip(clip);

		// Asegúrate de que el ImageView tenga las dimensiones adecuadas
		foto.setFitWidth(100); // Ancho deseado
		foto.setFitHeight(100); // Alto deseado
		
	}

    @FXML
    void pqrsEvent(MouseEvent event) {
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.close();
    	aplicacion.mostrarVentanaPQRS(usuario, correo, nombre);
    }

	@FXML
	void salirEvent(MouseEvent event) {

		if (mostrarMensajeInformacion("¿Deseas cerrar la sesión?")) {
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.close();
			aplicacion.mostrarVentanaIniciarRed();
		} else {
			JOptionPane.showMessageDialog(null, "Sigue navengo a traves de nuestra pagina");
		}

	}

    @FXML
    void usuarioEvent(MouseEvent event) {

    }
    
    private boolean mostrarMensajeInformacion(String mensaje) {

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Información");
		alert.setHeaderText(null);
		alert.setContentText(mensaje);

		Optional<ButtonType> action = alert.showAndWait();

		if (action.get() == ButtonType.OK) {
			return true;
		} else {
			return false;
		}
	}


}
