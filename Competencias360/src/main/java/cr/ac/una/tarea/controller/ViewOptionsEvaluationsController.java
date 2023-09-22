/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.tarea.controller;

import cr.ac.una.tarea.model.EvaluatedsDto;
import cr.ac.una.tarea.model.ProcesosevaDto;
import cr.ac.una.tarea.model.WorkerDto;
import cr.ac.una.tarea.service.EvaluatedService;
import cr.ac.una.tarea.service.ProcesoevaService;
import cr.ac.una.tarea.soap.ProcesoevaDto;
import cr.ac.una.tarea.util.FlowController;
import cr.ac.una.tarea.util.Respuesta;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Anderson
 */
public class ViewOptionsEvaluationsController implements Initializable {

    @FXML
    private BorderPane OptionsMenuView;
    boolean admi = ViewModuleWorkersController.admi;
    @FXML
    private Button optionSignOff;
    @FXML
    private Button optionBack;
    @FXML
    private BorderPane OptionsProcessEva;
    @FXML
    private Button optionSignOff1;
    @FXML
    private Button optionBack1;
    @FXML
    private TableView<ProcesosevaDto> tableViewProEva;
    @FXML
    private TableColumn<ProcesosevaDto, String> tableColProEva_State;
    @FXML
    private TableColumn<ProcesosevaDto, String> tableColProEva_Name;
    @FXML
    private TableColumn<ProcesosevaDto, String> tableColProEva_IniPer;
    @FXML
    private TableColumn<ProcesosevaDto, String> tableColProEva_FinalPer;
    @FXML
    private TableColumn<ProcesosevaDto, String> tableColProEva_Apli;
    @FXML
    private TableView<ProcesosevaDto> tableColProEvaluated;
    @FXML
    private TableColumn<ProcesosevaDto, String> tableColProEvaluated_State;
    @FXML
    private TableColumn<ProcesosevaDto, String> tableColProEvaluated_Name;
    @FXML
    private TableColumn<ProcesosevaDto, String> tableColProEvaluated_IniPer;
    @FXML
    private TableColumn<ProcesosevaDto, String> tableColProEvaluated_FinalPer;
    @FXML
    private TableColumn<ProcesosevaDto, String> tableColProEvaluated_Apli;

    WorkerDto workerDto;
    List<ProcesosevaDto> listProcesos=new ArrayList<>();
    ObservableList<ProcesosevaDto> procesosList;
    List<EvaluatedsDto> listEvaluateds=new ArrayList<>();
    @FXML
    private BorderPane OptionsInformationWorker;
    @FXML
    private Button optionSignOff2;
    @FXML
    private Button optionBack2;
    @FXML
    private Text textWorker_Name;
    @FXML
    private Text textWorker_Ident;
    @FXML
    private Text textWorker_Email;
    @FXML
    private Text textWorker_Job;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         OptionsMenuView.toFront();
        if (admi) {
            optionSignOff.setVisible(false);
        } else {
            optionBack.setVisible(false);
        }
        workerDto = FlowController.worker;
        workerDto.getName();
        tableColProEva_State.setCellValueFactory(new PropertyValueFactory("State"));
        tableColProEva_Name.setCellValueFactory(new PropertyValueFactory("Name"));
        tableColProEva_IniPer.setCellValueFactory(new PropertyValueFactory("Inicialperiod"));
        tableColProEva_FinalPer.setCellValueFactory(new PropertyValueFactory("Finalperiod"));
        tableColProEva_Apli.setCellValueFactory(new PropertyValueFactory("Application"));

        tableColProEvaluated_State.setCellValueFactory(new PropertyValueFactory("State"));
        tableColProEvaluated_Name.setCellValueFactory(new PropertyValueFactory("Name"));
        tableColProEvaluated_IniPer.setCellValueFactory(new PropertyValueFactory("Inicialperiod"));
        tableColProEvaluated_FinalPer.setCellValueFactory(new PropertyValueFactory("Finalperiod"));
        tableColProEvaluated_Apli.setCellValueFactory(new PropertyValueFactory("Application"));

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

    @FXML
    private void openInformation(MouseEvent event) {
        textWorker_Name.setText(workerDto.getName()+" "+workerDto.getPsurname()+" "+workerDto.getSsurname());
        textWorker_Ident.setText(workerDto.getIden());
        textWorker_Email.setText(workerDto.getEmail());
        textWorker_Job.setText(workerDto.getJob().getJsName());
        OptionsInformationWorker.toFront();
    }

    @FXML
    private void openProcessEva(MouseEvent event) {
        OptionsProcessEva.toFront();
    }
    public List<EvaluatedsDto> getEvaluateds= listEvaluateds.stream().
            filter(x->x.getEsWorker().getWrId().equals(workerDto.getId())).collect(Collectors.toList());
    
    public void ImportListEvaluated(){
        EvaluatedService service = new EvaluatedService();
        Respuesta respuesta = service.getEvaluateds();
        listEvaluateds = (List<EvaluatedsDto>) respuesta.getResultado("Evaluated");
        listEvaluateds=getEvaluateds;
        for(EvaluatedsDto evaluated :listEvaluateds ){
            ProcesosevaDto proceso = new ProcesosevaDto();
            proceso.setName(evaluated.getEsProcesoeva().getEnName());
            proceso.setState(evaluated.getEsProcesoeva().getEnState());
            proceso.setId(evaluated.getEsProcesoeva().getEnId());
            //proceso.setApplication(evaluated.getEsProcesoeva().get);
            //listProcesos.add();
        }
        
       
    }
    
    public void ImportListProcesoEva() {
        ProcesoevaService service = new ProcesoevaService();
        Respuesta respuesta = service.getProcesos();
        listProcesos = (List<ProcesosevaDto>) respuesta.getResultado("ProcesosevaDto");
        procesosList = FXCollections.observableArrayList(listProcesos);

        this.tableViewProEva.refresh();
        this.tableViewProEva.setItems(procesosList);
    }

    @FXML
    private void procesoevaClicked(MouseEvent event) {
    }

    @FXML
    private void procesoEvaluatedClicked(MouseEvent event) {
    }
    
    

}
