package redVendedores.controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import redVendedores.aplication.Aplicacion;

public class CompraController {

    @FXML
    private ImageView flechaRegresar1;

    @FXML
    private Label NroProductos;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtValorEnvio;

    @FXML
    private TextField txtTotal;

    @FXML
    private ComboBox<String> comboBoxZonaEnvio;

    @FXML
    private TextField txtDireccion;

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnContinuar;
    
    @FXML
    private RadioButton rBtnTC;

    @FXML
    private RadioButton rBtnTD;

    @FXML
    private RadioButton rBtnPSE;
    
    private Aplicacion aplicacion;
    
    private String usuario; 
    
    private String correo;
    
    private int num; 
    
    private String precio;
    
    private String producto;
    
    ModelFactoryController modelFactoryController; 
    
    private ToggleGroup grupoOpciones = new ToggleGroup();

    @FXML
    void AceptarEvent(ActionEvent event) {
    	if(txtDireccion.getText().equals("")){
    		JOptionPane.showMessageDialog(null, "Debe ingresar la dirección");
    	}else{
    		JOptionPane.showMessageDialog(null, "Se ha guardado correctamente la dirección");
    	}
    }

	@FXML
	void ContinuarEvent(ActionEvent event) {
		String selectedState = comboBoxZonaEnvio.getSelectionModel().getSelectedItem();
		if(txtDireccion.getText()!= ("")){
			if(selectedState!=null){
				if (grupoOpciones.getSelectedToggle() != null) {
					RadioButton radioButtonSeleccionado = (RadioButton) grupoOpciones.getSelectedToggle();
					String textoDelRadioButton = radioButtonSeleccionado.getText();
					if (textoDelRadioButton.equals("Tarjeta de crédito") || textoDelRadioButton.equals("Tarjeta de débito")) {
						aplicacion.mostrarVentanaPagoTarjetas(producto, precio, num, correo, usuario);
					} else {
						aplicacion.mostrarVentanaPagoPSE(txtTotal.getText(), correo, usuario, producto, num);
					}
				}else{
					JOptionPane.showMessageDialog(null, "Debe seleccionar una opción para poder continuar");
				}
			}else{
				JOptionPane.showMessageDialog(null, "Debe seleccionar la zona de envio para poder continuar");
			}
		}else{
			JOptionPane.showMessageDialog(null, "Debe ingresar la dirección para poder continuar");
		}
		
	}

    @FXML
    void flechaRegresarEvent(MouseEvent event) {
    	aplicacion.mostrarVentanaCarrito(usuario, correo);
    }
    
    @FXML
	void initialize() {
		modelFactoryController = ModelFactoryController.getInstance();

		comboBoxZonaEnvio.getItems().addAll("Centro", "Norte", "Sur");
		
		rBtnTC.setToggleGroup(grupoOpciones);
		rBtnTD.setToggleGroup(grupoOpciones);
		rBtnPSE.setToggleGroup(grupoOpciones);
		
		comboBoxZonaEnvio.setOnAction(this::filtrarEnvio);
	}
	
    
    public void setAplicacion(Aplicacion aplicacion, String usuario, String correo, int num, String precio, String producto) {
		this.aplicacion = aplicacion;
		this.usuario= usuario; 
		this.correo= correo;
		this.num= num; 
		this.precio= precio;
		this.producto= producto;
		 
		NroProductos.setText("("+Integer.toString(num)+")");
		txtPrecio.setText(precio);
	}
    
    public int filtrarEnvio(ActionEvent event) {
		String selectedState = comboBoxZonaEnvio.getSelectionModel().getSelectedItem();
		int precio= 0;
		int total= 0;
		if (selectedState != null) {
			if (selectedState.equals("Centro")) {
				precio= 5000;
				txtValorEnvio.setText(Integer.toString(precio));
				total= precio+(Integer.parseInt(txtPrecio.getText()));
				txtTotal.setText(Integer.toString(total));
			}
			if (selectedState.equals("Sur")) {
				precio= 4000;
				txtValorEnvio.setText(Integer.toString(precio));
				total= precio+(Integer.parseInt(txtPrecio.getText()));
				txtTotal.setText(Integer.toString(total));
			}
			if (selectedState.equals("Norte")) {
				precio=7000;
				txtValorEnvio.setText(Integer.toString(precio));
				total= precio+(Integer.parseInt(txtPrecio.getText()));
				txtTotal.setText(Integer.toString(total));
			}
		}
		return precio;
	}
}