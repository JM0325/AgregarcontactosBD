
package agregarcontacto;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Conexion;


public class FXMLDocumentController implements Initializable {

//    @FXML
//    private GridPane Gpdatos;
//    @FXML
//    private Label LbIdContactos;
//    @FXML
//    private Label LbNombre;
//    @FXML
//    private Label LbApellidos;
//    @FXML
//    private Label LbEdad;
//    @FXML
//    private TextField TfidCOntacto;
    @FXML
    public TextField txtNombres;
    @FXML
    public TextField txtApellidos;
    @FXML
    public TextField txtEdad;
    @FXML
    public Button btnNuevo;
    @FXML
    public Button btnAgregar;
    @FXML
    public Button btnConsultar;

    Connection conex = Conexion.conectar();
    PreparedStatement preparar;
    
    String nombre;
    String apellido;
    String edad;
    
    Node nodo;
    Stage stage;
    Parent parent;
    Scene root;
    @FXML
    private GridPane Gpdatos;
    @FXML
    private Label LbNombre;
    @FXML
    private Label LbApellidos;
    @FXML
    private Label LbEdad;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Actnuevo(ActionEvent event) {
        
    }

    @FXML
    private void Actagregar(ActionEvent event) {
        nombre = txtNombres.getText();
        apellido = txtApellidos.getText();
        edad = txtEdad.getText();
        
        String sql = "INSERT INTO contactos (Nombres, Apellidos, Edad) VALUES (?,?,?)";
        try{
        preparar = conex.prepareStatement(sql);
        
        preparar.setString(1, nombre);
        preparar.setString(2, apellido);
        preparar.setString(3, edad);
        preparar.executeUpdate();
        
        System.out.println("El usuario ha sido registrado");
//        preparar.close();
//        conex.close();
        
        }catch(SQLException ex){
            Logger.getLogger(FXMLDocumentController.class.getName());
            System.out.println("El usuario no ha sido registrado");
        }
    }
    
    @FXML
    private void Actconsultar(ActionEvent event) throws IOException {
        nodo = (Node)event.getSource();
        stage = (Stage) nodo.getScene().getWindow();
        
        parent = FXMLLoader.load(getClass().getResource("view.Consultar.fxml"));
        
        root = new Scene(parent);
        stage.setScene(root);
        stage.centerOnScreen();
        stage.setTitle("Consultar Registros");
        stage.setHeight(445);
        stage.setWidth(549);
        stage.show();
    }
    
}
