/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.tarea.controller;

import cr.ac.una.tarea.model.EvaluatedsDto;
import cr.ac.una.tarea.model.EvaluatorDto;
import cr.ac.una.tarea.model.ProcesosevaDto;
import cr.ac.una.tarea.model.WorkerDto;
import cr.ac.una.tarea.service.EvaluatedService;
import cr.ac.una.tarea.service.ProcesoevaService;
import cr.ac.una.tarea.soap.ProcesoevaDto;
import cr.ac.una.tarea.util.FlowController;
import cr.ac.una.tarea.util.Mensaje;
import cr.ac.una.tarea.util.Respuesta;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
public class ViewOptionsEvaluationsController extends Controller implements Initializable {

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
    ProcesosevaDto procesoDto;
    List<ProcesosevaDto> listProcesos = new ArrayList<>();
    ObservableList<ProcesosevaDto> procesosList;
    List<EvaluatedsDto> listEvaluateds = new ArrayList<>();
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
    @FXML
    private BorderPane OptionsSelectEvaluateView;
    @FXML
    private Text textNameProcess;
    @FXML
    private TableView<EvaluatedsDto> tableViewEvaluated;
    @FXML
    private TableColumn<EvaluatedsDto, String> tableColEvaluated_Ident;
    @FXML
    private TableColumn<EvaluatedsDto, String> tableColEvaluated_Name;
    @FXML
    private TableColumn<EvaluatedsDto, String> tableColEvaluated_Psurname;
    @FXML
    private TableColumn<EvaluatedsDto, String> tableColEvaluated_Ssurname;
    @FXML
    private TableColumn<EvaluatedsDto, String> tableColEvaluated_User;
    @FXML
    private TableColumn<?, ?> tableColEvaluated_Email;
    @FXML
    private TableColumn<?, ?> tableColEvaluated_State;

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
        textWorker_Name.setText(workerDto.getName() + " " + workerDto.getPsurname() + " " + workerDto.getSsurname());
        textWorker_Ident.setText(workerDto.getIden());
        textWorker_Email.setText(workerDto.getEmail());
        textWorker_Job.setText(workerDto.getJob().getJsName());
        OptionsInformationWorker.toFront();
    }

    @FXML
    private void openProcessEva(MouseEvent event) {
        ImportListProcesoEva();
        OptionsProcessEva.toFront();
    }

    public void ImportListEvaluated() {
        EvaluatedService service = new EvaluatedService();
        Respuesta respuesta = service.getEvaluateds();
        listEvaluateds = (List<EvaluatedsDto>) respuesta.getResultado("Evaluated");
        listEvaluateds = listEvaluateds.stream().filter(x -> x.getEsWorker().getWrId().equals(workerDto.getId())).toList();
        ProcesoevaService serviceProceso = new ProcesoevaService();

        for (EvaluatedsDto evaluated : listEvaluateds) {
            ProcesosevaDto proceso = new ProcesosevaDto();
            proceso.setName(evaluated.getEsProcesoeva().getEnName());
            proceso.setState(evaluated.getEsProcesoeva().getEnState());
            proceso.setId(evaluated.getEsProcesoeva().getEnId());
            respuesta = serviceProceso.getProcesos();
            List<ProcesosevaDto> listProcesosDto = (List<ProcesosevaDto>) respuesta.getResultado("ProcesosevaDto");
            ProcesosevaDto dates = listProcesosDto.stream().filter(x -> x.getId().equals(evaluated.getEsProcesoeva().getEnId())).findAny().get();

            proceso.setsetApplication(dates.getApplication().toString());
            proceso.setsetFinalperiod(dates.getFinalperiod().toString());
            proceso.setsetInicialperiod(dates.getInicialperiod().toString());

            listProcesos.add(proceso);
        }
        System.out.println(listProcesos.get(0).getState());
        listProcesos = listProcesos.stream().filter(getState.negate()).toList();
    }
    Predicate<ProcesosevaDto> getState = x -> x.getState().equals("En construcción");

    public void ImportListProcesoEva() {
        ImportListEvaluated();
        procesosList = FXCollections.observableArrayList(listProcesos);
        this.tableViewProEva.refresh();
        this.tableViewProEva.setItems(procesosList);
    }

    @FXML
    private void procesoevaClicked(MouseEvent event) {
        if (event.getClickCount() == 2) {
            try {
                procesoDto = tableViewProEva.getSelectionModel().getSelectedItem();
                textNameProcess.setText(procesoDto.getName());
                OptionsSelectEvaluateView.toFront();
            } catch (Exception ex) {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "No existe un proceso en este campo.");
            }
        }
    }

    @FXML
    private void procesoEvaluatedClicked(MouseEvent event) {

    }

    @FXML
    private void backProEvaluator(MouseEvent event) {
        OptionsProcessEva.toFront();

    }

    @FXML
    private void openEvaluations(MouseEvent event) {
    }

    @FXML
    private void evaluateClicked(MouseEvent event) {
    }

    @Override
    public void initialize() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
