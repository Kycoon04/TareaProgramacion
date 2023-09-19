/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.tarea.controller;

import cr.ac.una.tarea.util.FlowController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Anderson
 */
public class ViewOptionsEvaluationsController implements Initializable {

    @FXML
    private BorderPane OptionsMenuView;
    boolean admi=ViewModuleWorkersController.admi;
    @FXML
    private Button optionSignOff;
    @FXML
    private Button optionBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(admi){
            optionSignOff.setVisible(false);
        }else{
            optionBack.setVisible(false);
        }
        // TODO
    }    


    @FXML
    private void SignOff(ActionEvent event) {
        FlowController.getInstance().goMain("ViewModuleWorkers");
        
    }

    @FXML
    private void Back(ActionEvent event) {
        FlowController.getInstance().goMain("ViewOptionsModules");
    }
    
}
