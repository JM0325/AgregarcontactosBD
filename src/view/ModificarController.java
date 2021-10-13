/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Conexion;

public class ModificarController implements Initializable {

    @FXML
    public TextField txtIdentificacion;
    @FXML
    public TextField txtNombres;
    @FXML
    public TextField txtApellidos;
    @FXML
    public TextField txtEdad;
    @FXML
    public Button btnRetornar;
    @FXML
    public Button btnModificar;
    @FXML
    public Button btnConsultar2;

    Node nodo;
    Stage stage;
    Parent parent;
    Scene scene;

    //Connection conex = Conexion.conectar();
    PreparedStatement preparar;
    String consultar;
    ResultSet result;

    @FXML
    private void actModificar(ActionEvent event) {
        Connection conex = Conexion.conectar();
        consultar = "UPDATE contactos SET Nombres=?,Apellidos=?,Edad=? WHERE IdContactos='".concat(txtIdentificacion.getText()).concat("'");
       
        try {
            preparar = conex.prepareStatement(consultar);
            preparar.setString(1, txtNombres.getText());
            preparar.setString(2, txtApellidos.getText());
            preparar.setString(3, txtEdad.getText());
            
            System.out.println("Se ha Modificado el Registro");
            
        } catch (SQLException ex) {
            Logger.getLogger(ModificarController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }   
    @FXML
    private void actRetornar(ActionEvent event) {

    }

    @FXML
    private void actConsultar2(ActionEvent event) {
        Connection conex = Conexion.conectar();
        consultar = "SELECT Nombres, Apellidos, Edad FROM listado WHERE IdContactos ='".concat(txtIdentificacion.getText()).concat("'");
        try {
            preparar = conex.prepareStatement(consultar);
            result = preparar.executeQuery();
            while (result.next()) {
                txtNombres.setText(result.getString(1));
                txtApellidos.setText(result.getString(2));
                txtEdad.setText(result.getString(3));
            }
            System.out.println("Se ha consultado al USUARIO");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("NO Se ha consultado al USUARIO");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
