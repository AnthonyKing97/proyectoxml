/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creacionarchivosxml;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Empleado;

/**
 *
 * @author anthony.arce
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label lTitulo;
    @FXML
    private Label lnombre;
    @FXML
    private Label ldireccion;
    @FXML
    private Label ledad;
    @FXML
    private Label lcodigo;
    @FXML
    private Label ldepartamento;
    @FXML
    private TextField tnombre;
    @FXML
    private TextField tdireccion;
    @FXML
    private TextField tedad;
     @FXML
    private TextField tcodigo;
      @FXML
    private TextField tdepartamento;
    
      LinkedList <Empleado> listaEmpleados;
      
    @FXML
    private void agregarEmpleado(ActionEvent event) {
        
       String nombre = tnombre.getText();
       String departamento= tdepartamento.getText();
       int codigo = Integer.parseInt(tcodigo.getText());
       int edad = Integer.parseInt(tedad.getText());
       String direccion = tdireccion.getText();
       
        listaEmpleados.add(new Empleado(codigo,departamento,nombre,direccion,edad));
        

    }
    
      @FXML
    private void crearXML(ActionEvent event) {
        Empleado obj = new Empleado();
        boolean guardar=obj.crearFileXML(listaEmpleados);
       
        

    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listaEmpleados = new LinkedList<>();
    }    
    
}
