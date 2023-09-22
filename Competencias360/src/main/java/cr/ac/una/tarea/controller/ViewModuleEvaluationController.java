/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.tarea.controller;

import cr.ac.una.tarea.model.EvaluatedsDto;
import cr.ac.una.tarea.model.EvaluatorDto;
import cr.ac.una.tarea.model.JobDto;
import cr.ac.una.tarea.model.ProcesosevaDto;
import cr.ac.una.tarea.model.WorkerDto;
import cr.ac.una.tarea.service.EvaluatedService;
import cr.ac.una.tarea.service.EvaluatorService;
import cr.ac.una.tarea.service.JobsService;
import cr.ac.una.tarea.service.ProcesoevaService;
import cr.ac.una.tarea.service.WorkersService;
import cr.ac.una.tarea.soap.Evaluated;
import cr.ac.una.tarea.soap.EvaluatedDto;
import cr.ac.una.tarea.soap.ModuleProcesoeva;
import cr.ac.una.tarea.soap.ModuleProcesoeva_Service;
import cr.ac.una.tarea.soap.Procesoeva;
import cr.ac.una.tarea.soap.ProcesoevaDto;
import cr.ac.una.tarea.soap.Workers;
import cr.ac.una.tarea.soap.WorkersDto;
import cr.ac.una.tarea.util.FlowController;
import cr.ac.una.tarea.util.Mensaje;
import cr.ac.una.tarea.util.Respuesta;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Anderson
 */
public class ViewModuleEvaluationController extends Controller implements Initializable {

    @FXML
    private BorderPane OptionsMenuView;
    @FXML
    private BorderPane OptionsSettingView;
    @FXML
    private TextField JobMainField;
    @FXML
    private Pane viewChooseJobs;
    @FXML
    private TableView<JobDto> tableViewJobsW;
    @FXML
    private TableColumn<JobDto, String> tableColJobIdW;
    @FXML
    private TableColumn<JobDto, String> tableColJobNamW;
    @FXML
    private TableColumn<JobDto, String> tableColJobStaW;
    @FXML
    private TextField textFieldSJob_NameW;
    @FXML
    private TextField textFieldSJob_StateW;
    @FXML
    private BorderPane OptionsSettingWorkerView;
    @FXML
    private TableView<WorkerDto> tableViewWorkers;
    @FXML
    private TableColumn<WorkerDto, String> tableColAct;
    @FXML
    private TableColumn<WorkerDto, String> tableColIdentif;
    @FXML
    private TableColumn<WorkerDto, String> tableColName;
    @FXML
    private TableColumn<WorkerDto, String> tableColPsurname;
    @FXML
    private TableColumn<WorkerDto, String> tableColUserName;
    @FXML
    private TableColumn<WorkerDto, String> tableColEmail;
    @FXML
    private TableColumn<WorkerDto, String> tableColAdmi;
    @FXML
    private TextField textFieldSearch_Name;
    @FXML
    private TextField textFieldSearch_Pusername;
    @FXML
    private TextField textFieldSearch_State;
    @FXML
    private TableView<WorkerDto> tableViewSelWorkers;
    @FXML
    private TableColumn<WorkerDto, String> tableColSelAct;
    @FXML
    private TableColumn<WorkerDto, String> tableColSelIdentif;
    @FXML
    private TableColumn<WorkerDto, String> tableColSelName;
    @FXML
    private TableColumn<WorkerDto, String> tableColSelPsurname;
    @FXML
    private TableColumn<WorkerDto, String> tableColSelUserName;
    @FXML
    private TableColumn<WorkerDto, String> tableColSelEmail;
    @FXML
    private TableColumn<WorkerDto, String> tableColSelAdmi;

    private ObservableList<WorkerDto> workerList;
    private ObservableList<WorkerDto> workerListCRE;
    private ObservableList<JobDto> jobsList;
    private ObservableList<ProcesosevaDto> procesosList;
    private ObservableList<WorkerDto> workersAss = FXCollections.observableArrayList();
    List<WorkerDto> workersListSel = new ArrayList<>();
    @FXML
    private Text textEvaJob;
    JobDto jobDto;
    WorkerDto workerDto;
    ProcesosevaDto procesoDto;
    @FXML
    private BorderPane viewSelectedJob;
    @FXML
    private BorderPane viewChooseJob;
    @FXML
    private BorderPane OptionsSettingRelationalView;
    @FXML
    private BorderPane viewChooseWorker;
    @FXML
    private TableView<WorkerDto> tableViewWorkersCRE;
    @FXML
    private TableColumn<WorkerDto, String> tableColCREAct;
    @FXML
    private TableColumn<WorkerDto, String> tableColCREIdentif;
    @FXML
    private TableColumn<WorkerDto, String> tableColCREName;
    @FXML
    private TableColumn<WorkerDto, String> tableColCREPsurname;
    @FXML
    private TableColumn<WorkerDto, String> tableColCRESsurname;
    @FXML
    private TableColumn<WorkerDto, String> tableColCREUserName;
    @FXML
    private TableColumn<WorkerDto, String> tableColCREEmail;
    @FXML
    private TableColumn<WorkerDto, String> tableColCRETelephone;
    @FXML
    private TableColumn<WorkerDto, String> tableColCREAdmi;
    @FXML
    private TextField textFieldSearchCRE_Name;
    @FXML
    private TextField textFieldSearchCRE_Pusername;
    @FXML
    private TextField textFieldSearchCRE_Ident;
    @FXML
    private TextField textFieldSearchCRE_Rol;
    @FXML
    private TextField textFieldSearchCRE_Susername;
    @FXML
    private TextField textFieldSearchCRE_State;
    @FXML
    private BorderPane viewSelectedWorker;
    @FXML
    private TextField WorkerCREMainField;
    @FXML
    private Text textCREJob;
    @FXML
    private Text textCREIdent;
    @FXML
    private ChoiceBox<String> choiceBoxStateEva;
    String states[] = {"En construcción", "En aplicación", "En revisión", "Finalizada"};
    @FXML
    private BorderPane OptionsEvaConfigView;
    //private TableView<ProcesoevaDto> tableViewProEva;
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
    private DatePicker DateProEva_Inicial;
    @FXML
    private DatePicker DateProEva_Final;
    @FXML
    private DatePicker DateProEva_Application;
    @FXML
    private TextField TitleEvaField;
    @FXML
    private TextField textFieldProEva_Name;
    @FXML
    private TextField textFieldProEva_State;
    @FXML
    private BorderPane OptionsSettingEvaluatorsView;
    @FXML
    private TableView<WorkerDto> tableViewWorkersPE;
    @FXML
    private TableColumn<WorkerDto, String> tableColActPE;
    @FXML
    private TableColumn<WorkerDto, String> tableColIdentifPE;
    @FXML
    private TableColumn<WorkerDto, String> tableColNamePE;
    @FXML
    private TableColumn<WorkerDto, String> tableColPsurnamePE;
    @FXML
    private TableColumn<WorkerDto, String> tableColUserNamePE;
    @FXML
    private TableColumn<WorkerDto, String> tableColEmailPE;
    @FXML
    private TableColumn<WorkerDto, String> tableColAdmiPE;

    @FXML
    private TableView<EvaluatorDto> tableViewSelWorkersPE;
    @FXML
    private TableColumn<EvaluatorDto, String> tableColSelIdentifPE;
    @FXML
    private TableColumn<EvaluatorDto, String> tableColSelNamePE;
    @FXML
    private TableColumn<EvaluatorDto, String> tableColSelPsurnamePE;
    @FXML
    private TableColumn<EvaluatorDto, String> tableColSelUserNamePE;
    @FXML
    private TableColumn<EvaluatorDto, String> tableColSelEmailPE;
    @FXML
    private TableColumn<EvaluatorDto, String> tableColSelConPE;
    @FXML
    private TextField textFieldSearchPE_Name;
    @FXML
    private TextField textFieldSearchPE_Pusername;
    @FXML
    private TextField textFieldSearchPE_State;
    @FXML
    private Text textNameWorker;
    EvaluatedsDto evaluatedDto = new EvaluatedsDto();
    WorkerDto selectedWorker = new WorkerDto();
    List<WorkerDto> listWorkers = new ArrayList<>();
    List<WorkerDto> listWorkersEvaluated = new ArrayList<>();
    List<EvaluatorDto> listEvaluators = new ArrayList<>();
    List<EvaluatedsDto> listEvaluatedDto = new ArrayList<>();
    List<EvaluatorDto> listEvaluatorAss =new ArrayList<>();
    @FXML
    private TableView<ProcesosevaDto> tableViewProEva;
    @FXML
    private Text textProcesoEva_title;
    @FXML
    private Text textEvaluator;
    @FXML
    private ChoiceBox<String> choiceBoxConEvaluator;
    String connection[] = {"Jefatura", "Compañero", "Cliente"};
    @FXML
    private BorderPane OptionsFollowUpView;
    @FXML
    private Text textProcesoEva_title1;
    @FXML
    private Pane viewChooseJobs1;
    @FXML
    private TextField textFieldSJob_NameW1;
    @FXML
    private TextField textFieldSJob_StateW1;
    @FXML
    private TableView<WorkerDto> tableViewWorkersFU;
    @FXML
    private TableColumn<WorkerDto, String> tableColFUAct;
    @FXML
    private TableColumn<WorkerDto, String> tableColFUIdentif;
    @FXML
    private TableColumn<WorkerDto, String> tableColFUName;
    @FXML
    private TableColumn<WorkerDto, String> tableColFUPsurname;
    @FXML
    private TableColumn<WorkerDto, String> tableColFUUserName;
    @FXML
    private TableColumn<WorkerDto, String> tableColFUEmail;
    @FXML
    private TableColumn<WorkerDto, String> tableColFUTelephone;
    @FXML
    private TableColumn<WorkerDto, String> tableColFUAdmi;
    @FXML
    private TextField textFieldFollowUp_Name;
    @FXML
    private BorderPane viewFollowUpEvaluated;
    @FXML
    private BorderPane viewFollowUpInfoEvd;
    @FXML
    private Text textInfoE_Name;
    @FXML
    private Text textInfoE_Identificacion;
    @FXML
    private Text textInfoE_Email;
    @FXML
    private TableView<EvaluatorDto> tableViewEvaluatorsFU;
    @FXML
    private TableColumn<EvaluatorDto, String> tableColEvaluator_Ident;
    @FXML
    private TableColumn<EvaluatorDto, String> tableColEvaluator_Name;
    @FXML
    private TableColumn<EvaluatorDto, String> tableColEvaluator_Psurname;
    @FXML
    private TableColumn<EvaluatorDto, String> tableColEvaluator_Email;
    @FXML
    private TableColumn<EvaluatorDto, String> tableColEvaluator_Conecction;
    @FXML
    private TableColumn<EvaluatorDto, String> tableColEvaluator_State;
    @FXML
    private Text textInfoPro_Name;
    @FXML
    private Text textInfoPro_State;
    @FXML
    private Text textInfoPro_DAppli;
    @FXML
    private Text textInfoPro_DInicial;
    @FXML
    private Text textInfoPro_DFinal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        choiceBoxStateEva.getItems().addAll(states);
        choiceBoxConEvaluator.getItems().addAll(connection);
        ImportListProcesoEva();
        OptionsEvaConfigView.toFront();

        this.tableColActPE.setCellValueFactory(new PropertyValueFactory("Actives"));
        this.tableColIdentifPE.setCellValueFactory(new PropertyValueFactory("iden"));
        this.tableColNamePE.setCellValueFactory(new PropertyValueFactory("name"));
        this.tableColPsurnamePE.setCellValueFactory(new PropertyValueFactory("psurname"));
        this.tableColUserNamePE.setCellValueFactory(new PropertyValueFactory("username"));
        this.tableColEmailPE.setCellValueFactory(new PropertyValueFactory("email"));
        this.tableColAdmiPE.setCellValueFactory(new PropertyValueFactory("administrator"));

        this.tableColSelIdentifPE.setCellValueFactory(new PropertyValueFactory("iden"));
        this.tableColSelNamePE.setCellValueFactory(new PropertyValueFactory("name"));
        this.tableColSelPsurnamePE.setCellValueFactory(new PropertyValueFactory("psurname"));
        this.tableColSelUserNamePE.setCellValueFactory(new PropertyValueFactory("username"));
        this.tableColSelEmailPE.setCellValueFactory(new PropertyValueFactory("email"));
        this.tableColSelConPE.setCellValueFactory(new PropertyValueFactory("EvsConnection"));

        this.tableColAct.setCellValueFactory(new PropertyValueFactory("Actives"));
        this.tableColIdentif.setCellValueFactory(new PropertyValueFactory("iden"));
        this.tableColName.setCellValueFactory(new PropertyValueFactory("name"));
        this.tableColPsurname.setCellValueFactory(new PropertyValueFactory("psurname"));
        this.tableColUserName.setCellValueFactory(new PropertyValueFactory("username"));
        this.tableColEmail.setCellValueFactory(new PropertyValueFactory("email"));
        this.tableColAdmi.setCellValueFactory(new PropertyValueFactory("administrator"));

        this.tableColSelAct.setCellValueFactory(new PropertyValueFactory("Actives"));
        this.tableColSelIdentif.setCellValueFactory(new PropertyValueFactory("iden"));
        this.tableColSelName.setCellValueFactory(new PropertyValueFactory("name"));
        this.tableColSelPsurname.setCellValueFactory(new PropertyValueFactory("psurname"));
        this.tableColSelUserName.setCellValueFactory(new PropertyValueFactory("username"));
        this.tableColSelEmail.setCellValueFactory(new PropertyValueFactory("email"));
        this.tableColSelAdmi.setCellValueFactory(new PropertyValueFactory("administrator"));

        this.tableColCREAct.setCellValueFactory(new PropertyValueFactory("Actives"));
        this.tableColCREIdentif.setCellValueFactory(new PropertyValueFactory("iden"));
        this.tableColCREName.setCellValueFactory(new PropertyValueFactory("name"));
        this.tableColCREPsurname.setCellValueFactory(new PropertyValueFactory("psurname"));
        this.tableColCRESsurname.setCellValueFactory(new PropertyValueFactory("ssurname"));
        this.tableColCREUserName.setCellValueFactory(new PropertyValueFactory("username"));
        this.tableColCREEmail.setCellValueFactory(new PropertyValueFactory("email"));
        this.tableColCRETelephone.setCellValueFactory(new PropertyValueFactory("telephone"));
        this.tableColCREAdmi.setCellValueFactory(new PropertyValueFactory("administrator"));

        this.tableColJobIdW.setCellValueFactory(new PropertyValueFactory("Id"));
        this.tableColJobNamW.setCellValueFactory(new PropertyValueFactory("Name"));
        this.tableColJobStaW.setCellValueFactory(new PropertyValueFactory("States"));

        this.tableColProEva_State.setCellValueFactory(new PropertyValueFactory("State"));

        this.tableColProEva_Name.setCellValueFactory(new PropertyValueFactory("Name"));

        this.tableColProEva_IniPer.setCellValueFactory(new PropertyValueFactory("Inicialperiod"));

        this.tableColProEva_FinalPer.setCellValueFactory(new PropertyValueFactory("Finalperiod"));

        this.tableColProEva_Apli.setCellValueFactory(new PropertyValueFactory("Application"));
        this.tableColFUAct.setCellValueFactory(new PropertyValueFactory("Actives"));
        this.tableColFUIdentif.setCellValueFactory(new PropertyValueFactory("iden"));
        this.tableColFUName.setCellValueFactory(new PropertyValueFactory("name"));
        this.tableColFUPsurname.setCellValueFactory(new PropertyValueFactory("psurname"));
        this.tableColFUUserName.setCellValueFactory(new PropertyValueFactory("username"));
        this.tableColFUEmail.setCellValueFactory(new PropertyValueFactory("email"));
        this.tableColFUTelephone.setCellValueFactory(new PropertyValueFactory("telephone"));
        this.tableColFUAdmi.setCellValueFactory(new PropertyValueFactory("administrator"));
        
        this.tableColEvaluator_Ident.setCellValueFactory(new PropertyValueFactory("iden"));
        this.tableColEvaluator_Name.setCellValueFactory(new PropertyValueFactory("name"));
        this.tableColEvaluator_Psurname.setCellValueFactory(new PropertyValueFactory("psurname"));
        this.tableColEvaluator_Email.setCellValueFactory(new PropertyValueFactory("email"));
        this.tableColEvaluator_Conecction.setCellValueFactory(new PropertyValueFactory("EvsConnection"));
        this.tableColEvaluator_State.setCellValueFactory(new PropertyValueFactory("EvsState"));
    }

    @FXML
    private void openEvaluations(MouseEvent event) {
    }

    @FXML
    private void viewChooseJob(MouseEvent event) {
        ImportListJobs();
        viewChooseJob.toFront();
    }

    @FXML
    private void jobClickedWorker(MouseEvent event) {
        if (event.getClickCount() == 2) {
            try {
                jobDto = tableViewJobsW.getSelectionModel().getSelectedItem();
                JobMainField.setText(jobDto.getName());
                viewSelectedJob.toFront();

            } catch (Exception ex) {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "No existe un trabajo en este campo.");
            }
        }
    }

    public void ImportListJobs() {
        JobsService jobsService = new JobsService();
        Respuesta respuesta = jobsService.getJobs();
        List<JobDto> list = (List<JobDto>) respuesta.getResultado("Jobs");
        jobsList = FXCollections.observableArrayList(list);
        this.tableViewJobsW.refresh();
        this.tableViewJobsW.setItems(jobsList);
    }

    @FXML
    private void searchJob_NameW(KeyEvent event) {
        FilteredList<JobDto> filteredJob = new FilteredList<>(jobsList, f -> true);

        textFieldSJob_NameW.textProperty().addListener((observable, value, newValue) -> {
            filteredJob.setPredicate(JobDto -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();
                if (JobDto.getName().toLowerCase().contains(search)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        filteredJobsWorker(filteredJob);
    }

    @FXML
    private void searchJob_StateW(KeyEvent event) {
        FilteredList<JobDto> filteredJob = new FilteredList<>(jobsList, f -> true);

        textFieldSJob_StateW.textProperty().addListener((observable, value, newValue) -> {
            filteredJob.setPredicate(JobDto -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();
                if (JobDto.getStates().toLowerCase().contains(search)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        filteredJobsWorker(filteredJob);
    }

    private void filteredJobsWorker(FilteredList<JobDto> list) {
        SortedList<JobDto> sorted = new SortedList<>(list);
        sorted.comparatorProperty().bind(tableViewJobsW.comparatorProperty());
        tableViewJobsW.setItems(sorted);
    }

    @FXML
    private void workerClicked(MouseEvent event) {
        if (event.getClickCount() == 2) {

            WorkerDto selectedWorker = tableViewWorkers.getSelectionModel().getSelectedItem();
            workersListSel.add(selectedWorker);
            workersAss = FXCollections.observableArrayList(workersListSel);

            this.tableViewSelWorkers.refresh();
            this.tableViewSelWorkers.setItems(workersAss);

        }
    }

    @FXML
    private void searchWorker_Name(KeyEvent event) {
        FilteredList<WorkerDto> filteredWorker = new FilteredList<>(workerList, f -> true);

        textFieldSearch_Name.textProperty().addListener((observable, value, newValue) -> {
            filteredWorker.setPredicate(WorkerDto -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();
                if (WorkerDto.getName().toLowerCase().contains(search)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        filteredWorkers(filteredWorker);
    }

    @FXML
    private void searchWorker_Pusername(KeyEvent event) {
        FilteredList<WorkerDto> filteredWorker = new FilteredList<>(workerList, f -> true);

        textFieldSearch_Pusername.textProperty().addListener((observable, value, newValue) -> {
            filteredWorker.setPredicate(WorkerDto -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();
                if (WorkerDto.getPsurname().toLowerCase().contains(search)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        filteredWorkers(filteredWorker);
    }

    @FXML
    private void searchWorker_State(KeyEvent event) {
        FilteredList<WorkerDto> filteredWorker = new FilteredList<>(workerList, f -> true);

        textFieldSearch_State.textProperty().addListener((observable, value, newValue) -> {
            filteredWorker.setPredicate(WorkerDto -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();
                if (WorkerDto.getActives().toLowerCase().contains(search)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        filteredWorkers(filteredWorker);

    }

    private void filteredWorkers(FilteredList<WorkerDto> list) {
        SortedList<WorkerDto> sorted = new SortedList<>(list);
        sorted.comparatorProperty().bind(tableViewWorkers.comparatorProperty());
        tableViewWorkers.setItems(sorted);
    }

    public void ImportListWorker() {

        WorkersService service = new WorkersService();
        Respuesta respuesta = service.getUsuarios();
        listWorkers = (List<WorkerDto>) respuesta.getResultado("Usuarios");
        changeTextAdmi(listWorkers);
        workerList = FXCollections.observableArrayList(listWorkers);

        this.tableViewWorkersPE.refresh();
        this.tableViewWorkersPE.setItems(workerList);
        this.tableViewWorkers.refresh();
        this.tableViewWorkers.setItems(workerList);
    }

    public List<EvaluatedsDto> getEvaluatorProcess(int IdProcess) {
        return listEvaluatedDto.stream().
                filter(x -> x.getEsProcesoeva().getEnId().equals(IdProcess)).collect(Collectors.toList());
    }

    public void importEvaluators() {

        WorkersService service = new WorkersService();
        EvaluatedService evaluatedservice = new EvaluatedService();

        Respuesta respuesta = evaluatedservice.getEvaluateds();
        listEvaluatedDto = (List<EvaluatedsDto>) respuesta.getResultado("Evaluated");
        listEvaluatedDto = getEvaluatorProcess(procesoDto.getId());
        this.listWorkersEvaluated.clear();
        for (EvaluatedsDto evaluated : listEvaluatedDto) {
            WorkerDto workerDto = new WorkerDto();
            workerDto.setPhoto(evaluated.getEsWorker().getWrPhoto());
            workerDto.setId(evaluated.getEsWorker().getWrId());
            workerDto.setJob(evaluated.getEsWorker().getWrJob());
            workerDto.setRecover(evaluated.getEsWorker().getWrRecover());
            workerDto.setActive(evaluated.getEsWorker().getWrActive());
            workerDto.setAdministrator(evaluated.getEsWorker().getWrAdmin());
            workerDto.setEmail(evaluated.getEsWorker().getWrEmail());
            workerDto.setIdentification(evaluated.getEsWorker().getWrIdentification());
            workerDto.setLandline(evaluated.getEsWorker().getWrLandline());
            workerDto.setName(evaluated.getEsWorker().getWrName());
            workerDto.setPassword(evaluated.getEsWorker().getWrPassword());
            workerDto.setPsurname(evaluated.getEsWorker().getWrPsurname());
            workerDto.setSsurname(evaluated.getEsWorker().getWrSsurname());
            workerDto.setTelephone(evaluated.getEsWorker().getWrTelephone());
            workerDto.setUsername(evaluated.getEsWorker().getWrUsername());
            listWorkersEvaluated.add(workerDto);
        }
        workerListCRE = FXCollections.observableArrayList(listWorkersEvaluated);
        this.tableViewWorkersCRE.refresh();
        this.tableViewWorkersCRE.setItems(workerListCRE);
        this.tableViewWorkersFU.refresh();
        this.tableViewWorkersFU.setItems(workerListCRE);

    }
    Predicate<EvaluatorDto> getProEvaluators=x->x.getEvsEvaluated().getEsProcesoeva().getEnId().equals(procesoDto.getId());

    public List<EvaluatorDto> getEvaluators(int idEvaluated){
        return listEvaluatorAss.stream().
                filter(getProEvaluators.and(x->x.getEvsEvaluated().getEsWorker().getWrId().equals(idEvaluated))).collect(Collectors.toList());
    }
    public void ImportListEvaluators(){
        EvaluatorService service= new EvaluatorService();
        Respuesta respuesta=service.getEvaluators();
                
        listEvaluatorAss= (List<EvaluatorDto>) respuesta.getResultado("Evaluators");
        listEvaluatorAss=getEvaluators(selectedWorker.getId());
        ObservableList<EvaluatorDto> listEvaluator =FXCollections.observableArrayList( listEvaluatorAss);
         this.tableViewEvaluatorsFU.refresh();
         this.tableViewEvaluatorsFU.setItems(listEvaluator);
         
    }

    public void changeTextAdmi(List<WorkerDto> list) {
        String role = "";
        for (int i = 0; i < list.size(); i++) {
            role = list.get(i).getAdministrator();
            if ("S".equals(role)) {
                list.get(i).setAdministrator("Administrador");
            } else {
                list.get(i).setAdministrator("Empleado");
            }
        }
    }

    @FXML
    private void addAllWorkers(ActionEvent event) {
        this.tableViewSelWorkers.refresh();
        this.tableViewSelWorkers.setItems(workerList);
    }

    @FXML
    private void addEvaluateWorkers(ActionEvent event) {
        EvaluatedService evaluated = new EvaluatedService();

        for (WorkerDto workerSel : workersListSel) {
            Procesoeva proceso = new Procesoeva();
            proceso.setEnId(procesoDto.getId());
            proceso.setEnName(procesoDto.getName());
            proceso.setEnState(procesoDto.getState());
            Workers worker = new Workers();
            worker.setWrCodeactive(workerSel.getCode());
            worker.setWrId(workerSel.getId());
            worker.setWrJob(workerSel.getJob());
            worker.setWrRecover(workerSel.getRecover());
            worker.setWrActive(workerSel.getActive());
            worker.setWrAdmin(workerSel.getAdministrator());
            worker.setWrEmail(workerSel.getEmail());
            worker.setWrPhoto(workerSel.getPhoto());
            worker.setWrIdentification(workerSel.getIden());
            worker.setWrLandline(workerSel.getLandline());
            worker.setWrName(workerSel.getName());
            worker.setWrPassword(workerSel.getPassword());
            worker.setWrPsurname(workerSel.getPsurname());
            worker.setWrSsurname(workerSel.getSsurname());
            worker.setWrTelephone(workerSel.getTelephone());
            worker.setWrUsername(workerSel.getUsername());
            evaluatedDto.setEsProcesoeva(proceso);
            evaluatedDto.setEsWorker(worker);
            evaluated.SaveEvaluated(evaluatedDto, procesoDto);
        }
    }

    @FXML
    private void backSettings(ActionEvent event) {
        listEvaluators.clear();
        workersListSel.clear();
        workersAss.clear();
        this.tableViewSelWorkers.refresh();
        //this.tableViewSelWorkers.setItems(workersAss);
        OptionsMenuView.toFront();
    }
    Predicate<WorkerDto> WorkerNull = worker -> worker.getJob() != null;

    public List<WorkerDto> getWorkersJobs(String name) {
        return listWorkers.stream().
                filter(WorkerNull.and(x -> x.getJob().getJsName().equals(name))).collect(Collectors.toList());
    }

    @FXML
    private void OpenSelectWorkers(ActionEvent event) {
        ImportListWorker();
        listWorkers = getWorkersJobs(jobDto.getName());
        workerList = FXCollections.observableArrayList(listWorkers);
        this.tableViewWorkers.refresh();
        this.tableViewWorkers.setItems(workerList);
        textEvaJob.setText(jobDto.getName());
        OptionsSettingWorkerView.toFront();
    }

    @FXML
    private void deleteWorkers(ActionEvent event) {
        workersListSel.clear();
        ObservableList<WorkerDto> workersAss = FXCollections.observableArrayList(workersListSel);
        this.tableViewSelWorkers.refresh();
        this.tableViewSelWorkers.setItems(workersAss);
    }

    @FXML
    private void assignEvaluations(ActionEvent event) {
        OptionsSettingView.toFront();
        viewSelectedJob.toFront();
    }

    @FXML
    private void back(MouseEvent event) {
        OptionsEvaConfigView.toFront();
    }

    @FXML
    private void workerClickedCRE(MouseEvent event) {
        if (event.getClickCount() == 2) {
            try {

                workerDto = tableViewWorkersCRE.getSelectionModel().getSelectedItem();
                WorkerCREMainField.setText(workerDto.getName() + " " + workerDto.getPsurname() + " " + workerDto.getSsurname());
                textCREJob.setText("Puesto: " + workerDto.getJob().getJsName());
                textCREIdent.setText("Numero de Identificacion: " + workerDto.getIden());
                textNameWorker.setText(workerDto.getName() + " " + workerDto.getPsurname() + " " + workerDto.getSsurname());
                viewSelectedWorker.toFront();

                Procesoeva proceso = new Procesoeva();
                proceso.setEnId(procesoDto.getId());
                proceso.setEnName(procesoDto.getName());
                proceso.setEnState(procesoDto.getState());

                Workers worker = new Workers();
                worker.setWrCodeactive(workerDto.getCode());
                worker.setWrId(workerDto.getId());
                worker.setWrJob(workerDto.getJob());
                worker.setWrRecover(workerDto.getRecover());
                worker.setWrActive(workerDto.getActive());
                worker.setWrAdmin(workerDto.getAdministrator());
                worker.setWrEmail(workerDto.getEmail());
                worker.setWrPhoto(workerDto.getPhoto());
                worker.setWrIdentification(workerDto.getIden());
                worker.setWrLandline(workerDto.getLandline());
                worker.setWrName(workerDto.getName());
                worker.setWrPassword(workerDto.getPassword());
                worker.setWrPsurname(workerDto.getPsurname());
                worker.setWrSsurname(workerDto.getSsurname());
                worker.setWrTelephone(workerDto.getTelephone());
                worker.setWrUsername(workerDto.getUsername());
                evaluatedDto.setEsProcesoeva(proceso);
                evaluatedDto.setEsWorker(worker);

            } catch (Exception ex) {
                //new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "No existe un trabajo en este campo.");
            }
        }

    }

    @FXML
    private void searchWorkerCRE_Name(KeyEvent event) {
        FilteredList<WorkerDto> filteredWorker = new FilteredList<>(workerList, f -> true);

        textFieldSearchCRE_Name.textProperty().addListener((observable, value, newValue) -> {
            filteredWorker.setPredicate(WorkerDto -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();
                if (WorkerDto.getName().toLowerCase().contains(search)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        filteredWorkersCRE(filteredWorker);
    }

    @FXML
    private void searchWorkerCRE_Pusername(KeyEvent event) {
        FilteredList<WorkerDto> filteredWorker = new FilteredList<>(workerList, f -> true);

        textFieldSearchCRE_Pusername.textProperty().addListener((observable, value, newValue) -> {
            filteredWorker.setPredicate(WorkerDto -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();
                if (WorkerDto.getPsurname().toLowerCase().contains(search)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        filteredWorkersCRE(filteredWorker);
    }

    @FXML
    private void searchWorkerCRE_Identification(KeyEvent event) {
        FilteredList<WorkerDto> filteredWorker = new FilteredList<>(workerList, f -> true);

        textFieldSearchCRE_Ident.textProperty().addListener((observable, value, newValue) -> {
            filteredWorker.setPredicate(WorkerDto -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();
                if (WorkerDto.getIden().toLowerCase().contains(search)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        filteredWorkersCRE(filteredWorker);
    }

    @FXML
    private void searchWorkerCRE_Rol(KeyEvent event) {
        FilteredList<WorkerDto> filteredWorker = new FilteredList<>(workerList, f -> true);

        textFieldSearchCRE_Rol.textProperty().addListener((observable, value, newValue) -> {
            filteredWorker.setPredicate(WorkerDto -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();
                if (WorkerDto.getAdministrator().toLowerCase().contains(search)) {
                    return true;

                } else {
                    return false;
                }
            });
        });
        filteredWorkersCRE(filteredWorker);
    }

    @FXML
    private void searchWorkerCRE_Susername(KeyEvent event) {
        FilteredList<WorkerDto> filteredWorker = new FilteredList<>(workerList, f -> true);

        textFieldSearchCRE_Susername.textProperty().addListener((observable, value, newValue) -> {
            filteredWorker.setPredicate(WorkerDto -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();
                if (WorkerDto.getSsurname().toLowerCase().contains(search)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        filteredWorkersCRE(filteredWorker);
    }

    @FXML
    private void searchWorkerCRE_State(KeyEvent event) {
        FilteredList<WorkerDto> filteredWorker = new FilteredList<>(workerList, f -> true);

        textFieldSearchCRE_State.textProperty().addListener((observable, value, newValue) -> {
            filteredWorker.setPredicate(WorkerDto -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();
                if (WorkerDto.getActives().toLowerCase().contains(search)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        filteredWorkersCRE(filteredWorker);
    }

    private void filteredWorkersCRE(FilteredList<WorkerDto> list) {
        SortedList<WorkerDto> sorted = new SortedList<>(list);
        sorted.comparatorProperty().bind(tableViewWorkersCRE.comparatorProperty());
        tableViewWorkersCRE.setItems(sorted);
    }

    public void ImportListProcesoEva() {
        ProcesoevaService service = new ProcesoevaService();
        Respuesta respuesta = service.getProcesos();
        List<ProcesosevaDto> listProcesos = (List<ProcesosevaDto>) respuesta.getResultado("ProcesosevaDto");
        procesosList = FXCollections.observableArrayList(listProcesos);

        this.tableViewProEva.refresh();
        this.tableViewProEva.setItems(procesosList);
    }

    @FXML
    private void openSettingRelational(ActionEvent event) {
        importEvaluators();
        viewSelectedJob.toFront();
        OptionsSettingRelationalView.toFront();
    }

    @FXML
    private void viewChooseWorker(MouseEvent event) {
        viewChooseWorker.toFront();
    }

    @FXML
    private void UpdateJob(ActionEvent event) {
        ProcesoevaService service = new ProcesoevaService();
        ProcesosevaDto procesosevaDto = new ProcesosevaDto();

        procesosevaDto.setState(choiceBoxStateEva.getValue());
        procesosevaDto.setName(TitleEvaField.getText());

        if(DateProEva_Inicial.getValue().isBefore(DateProEva_Final.getValue())){
        procesosevaDto.setApplication(DateProEva_Application.getValue());
        procesosevaDto.setInicialperiod(DateProEva_Inicial.getValue());
        procesosevaDto.setFinalperiod(DateProEva_Final.getValue());
        service.SaveProceso(procesosevaDto);
        ImportListProcesoEva();
        }else{
              new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "Seleccione una fecha de inicio menor a la fecha de finalizacion");
        }
    }

    @FXML
    private void searchJob_Name(KeyEvent event) {
    }

    @FXML
    private void searchJob_State(KeyEvent event) {
    }

    public boolean existsProcess(String name) {
        return procesosList.stream().
                anyMatch(x -> x.getName().equals(name));
    }

    @FXML
    private void openSettingEva(MouseEvent event) {

        if (!(TitleEvaField.getText().isEmpty() && (choiceBoxStateEva == null))) {
            if (existsProcess(TitleEvaField.getText())) {
                textProcesoEva_title.setText(TitleEvaField.getText());
                OptionsMenuView.toFront();
            } else {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "No se ha registrado este proceso.");
            }
        }
    }

    @FXML
    private void backMaintenance(MouseEvent event) {
        FlowController.getInstance().goMain("ViewOptionsModules");
    }

    Predicate<EvaluatedsDto> pName(String nombre) {
        return x -> x.getEsWorker().getWrName().equals(nombre);
    }

    Predicate<EvaluatedsDto> pProceso(String proceso) {
        return x -> x.getEsProcesoeva().getEnName().equals(proceso);
    }

    @FXML
    private void addEvaluators(ActionEvent event) {

        WorkerDto workerSel = tableViewWorkersPE.getSelectionModel().getSelectedItem();
        EvaluatorService cliente = new EvaluatorService();
        EvaluatorDto evaluator = new EvaluatorDto();

        evaluator.setEvsConnection(choiceBoxConEvaluator.getValue());
        evaluator.setEvsFeedback("N/A");
        evaluator.setEvsState("N");

        Workers worker = new Workers();
        worker.setWrCodeactive(workerSel.getCode());
        worker.setWrId(workerSel.getId());
        worker.setWrJob(workerSel.getJob());
        worker.setWrRecover(workerSel.getRecover());
        worker.setWrActive(workerSel.getActive());
        worker.setWrAdmin(workerSel.getAdministrator());
        worker.setWrEmail(workerSel.getEmail());
        worker.setWrPhoto(workerSel.getPhoto());
        worker.setWrIdentification(workerSel.getIden());
        worker.setWrLandline(workerSel.getLandline());
        worker.setWrName(workerSel.getName());
        worker.setWrPassword(workerSel.getPassword());
        worker.setWrPsurname(workerSel.getPsurname());
        worker.setWrSsurname(workerSel.getSsurname());
        worker.setWrTelephone(workerSel.getTelephone());
        worker.setWrUsername(workerSel.getUsername());
        evaluator.setEvsWorker(worker);

        Evaluated evaluated = new Evaluated();
        EvaluatedService evaluatedservice = new EvaluatedService();

        Respuesta respuesta = evaluatedservice.getEvaluateds();
        List<EvaluatedsDto> posible = (List<EvaluatedsDto>) respuesta.getResultado("Evaluated");

        List<EvaluatedsDto> lista = posible.stream().filter(
                pName(evaluatedDto.getEsWorker().getWrName())
                        .and(pProceso(evaluatedDto.getEsProcesoeva().getEnName()))).toList();

        evaluated.setEsId(lista.get(0).getId());
        evaluated.setEsProcesoeva(lista.get(0).getEsProcesoeva());
        evaluated.setEsWorker(lista.get(0).getEsWorker());

        evaluator.setEvsEvaluated(evaluated);
        listEvaluators.add(evaluator);
        ObservableList<EvaluatorDto> evaluatorsList = FXCollections.observableArrayList(listEvaluators);
        cliente.SaveEvaluator(evaluator, procesoDto);
        this.tableViewSelWorkersPE.refresh();
        this.tableViewSelWorkersPE.setItems(evaluatorsList);

    }

    @FXML
    private void openSelectEvaluators(ActionEvent event) {
        ImportListWorker();
        OptionsSettingEvaluatorsView.toFront();

    }

    @FXML
    private void procesoevaClicked(MouseEvent event) {
        if (event.getClickCount() == 2) {
            try {
                procesoDto = tableViewProEva.getSelectionModel().getSelectedItem();
                System.out.println("" + procesoDto.getName());

                TitleEvaField.setText(procesoDto.getName());
                choiceBoxStateEva.setValue(procesoDto.getState());
                DateProEva_Inicial.setValue(procesoDto.getInicialperiod());
                DateProEva_Final.setValue(procesoDto.getFinalperiod());
                DateProEva_Application.setValue(procesoDto.getApplication());
            } catch (Exception ex) {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "No existe un proceso en este campo.");
            }
        }
    }

    @Override
    public void initialize() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @FXML
    private void workerClickedPE(MouseEvent event) {
        if (event.getClickCount() == 2) {

            selectedWorker = tableViewWorkersPE.getSelectionModel().getSelectedItem();
            textEvaluator.setText(selectedWorker.getName() + " " + selectedWorker.getPsurname() + " " + selectedWorker.getSsurname());

        }
    }

    @FXML
    private void openFollowUpView(ActionEvent event) {
        importEvaluators();
        textInfoPro_Name.setText(procesoDto.getName());
        textInfoPro_State.setText("Estado: "+procesoDto.getState());
        textInfoPro_DAppli.setText("Fecha de Aplicación: "+procesoDto.getApplication().toString());
        textInfoPro_DInicial.setText("Fecha de Inicio de Periodo: "+procesoDto.getInicialperiod().toString());
        textInfoPro_DFinal.setText("Fecha de Final de Periodo: "+procesoDto.getFinalperiod().toString());
        OptionsFollowUpView.toFront();
    }


    @FXML
    private void searchCompetence_Name(KeyEvent event) {
    }

    @FXML
    private void backFUEvaluated(ActionEvent event) {
        viewFollowUpEvaluated.toFront();
    }

    @FXML
    private void evaluatorClickedFU(MouseEvent event) {
         if (event.getClickCount() == 2) {

            selectedWorker = tableViewWorkersFU.getSelectionModel().getSelectedItem();
            textInfoE_Name.setText(selectedWorker.getName()+""+selectedWorker.getPsurname()+""+selectedWorker.getSsurname());
            textInfoE_Identificacion.setText(selectedWorker.getIden());
            textInfoE_Email.setText(selectedWorker.getEmail());
            ImportListEvaluators();
            viewFollowUpInfoEvd.toFront();
            //textEvaluator.setText(selectedWorker.getName() + " " + selectedWorker.getPsurname() + " " + selectedWorker.getSsurname());

            /*workersListSel.add(selectedWorker);
            
            
            workersAss = FXCollections.observableArrayList(workersListSel);

            //this.tableViewSelWorkers1.refresh();
            //this.tableViewSelWorkers1.setItems(workersAss);*/
        }
    }

}
