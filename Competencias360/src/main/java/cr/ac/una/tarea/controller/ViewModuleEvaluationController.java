/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.tarea.controller;

import cr.ac.una.tarea.model.CharacteristicsDto;
import cr.ac.una.tarea.model.EvaJobCompetenceDto;
import cr.ac.una.tarea.model.EvaluatedsDto;
import cr.ac.una.tarea.model.EvaluatorDto;
import cr.ac.una.tarea.model.EvaluatorResultsDto;
import cr.ac.una.tarea.model.JobDto;
import cr.ac.una.tarea.model.ProcesosevaDto;
import cr.ac.una.tarea.model.ResultsDto;
import cr.ac.una.tarea.model.WorkerDto;
import cr.ac.una.tarea.service.CharacteristicService;
import cr.ac.una.tarea.service.EvaluatedService;
import cr.ac.una.tarea.service.EvaluatorResultsService;
import cr.ac.una.tarea.service.EvaluatorService;
import cr.ac.una.tarea.service.JobsCompetencesService;
import cr.ac.una.tarea.service.JobsService;
import cr.ac.una.tarea.service.ProcesoevaService;
import cr.ac.una.tarea.service.ResultsService;
import cr.ac.una.tarea.service.WorkersService;
import cr.ac.una.tarea.soap.Evaluated;
import cr.ac.una.tarea.soap.Evaluators;
import cr.ac.una.tarea.soap.Procesoeva;
import cr.ac.una.tarea.soap.Workers;
import cr.ac.una.tarea.util.FlowController;
import cr.ac.una.tarea.util.Mensaje;
import cr.ac.una.tarea.util.Respuesta;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
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
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
    private List<EvaluatorResultsDto> evaluatorsDto;
    private ObservableList<WorkerDto> workerList;
    private ObservableList<WorkerDto> workerListCopy;
    private List<EvaJobCompetenceDto> listCompetences = new ArrayList<>();
    private ObservableList<WorkerDto> workerListCRE;
    private ObservableList<JobDto> jobsList;
    private ObservableList<ProcesosevaDto> procesosList;
    private ObservableList<EvaluatorDto> listEvaluator;
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
    private Text textNameWorker;
    EvaluatedsDto evaluatedDto = new EvaluatedsDto();
    WorkerDto selectedWorker = new WorkerDto();
    List<WorkerDto> listWorkers = new ArrayList<>();
    List<WorkerDto> listWorkersCopy = new ArrayList<>();
    EvaluatorDto evaluatorDto;

    List<WorkerDto> listWorkersEvaluated = new ArrayList<>();
    List<EvaluatorDto> listEvaluators = new ArrayList<>();
    List<EvaluatedsDto> listEvaluatedDto = new ArrayList<>();
    List<EvaluatorDto> listEvaluatorAss = new ArrayList<>();
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
    @FXML
    private TextField textFieldSearchPE_Psurname;
    @FXML
    private TextField textFieldSearchPE_Ident;
    @FXML
    private TextField textFieldSearch_Ident;
    private boolean eliminar = false;
    @FXML
    private TextField textFieldEvaFU_Name;
    @FXML
    private TextField textFieldEvaFU_Ident;
    @FXML
    private TextField textFieldEvaFU_State;
    @FXML
    private BorderPane OptionsEvaluationResView;
    @FXML
    private Text textEvaluation_Process;
    @FXML
    private Text textEvaluation_Name;
    @FXML
    private Text textEvaluation_Job;
    @FXML
    private Text textEvaluation_Period;
    @FXML
    private Text textEvaluation_Apli;
    @FXML
    private TextArea textEvaluation_Feedback;
    @FXML
    private Text textEvaluation_Evaluator;
    @FXML
    private AnchorPane anchorDrag;
    @FXML
    private GridPane grid;
    @FXML
    private GridPane gridHeader;
    @FXML
    private Button btnDragEva;
    @FXML
    private ImageView check;
    @FXML
    private BorderPane OptionsEvaluationGeneralView;
    //private Text textEvaluationGen_Process;
    @FXML
    private Text textEvaluationGen_Name;
    @FXML
    private Text textEvaluationGen_Job;
    @FXML
    private Text textEvaluationGen_Period;
    @FXML
    private Text textEvaluationGen_Apli;
    @FXML
    private TextArea textEvaluationGen_Feedback;
    @FXML
    private AnchorPane anchorDrag1;
    @FXML
    private GridPane gridResGeneral;
    @FXML
    private GridPane gridHeaderResGeneral;
    @FXML
    private GridPane gridHeaderResGeneral1;
    @FXML
    private GridPane gridEvaGeneral;
    HashMap<String, Float> resultado = new HashMap<>();
    @FXML
    private Button btnConfigEva;
    @FXML
    private Button btnConfigMenu;
    @FXML
    private Button btnAssignMenu;
    @FXML
    private Button btnConfigSetting;
    @FXML
    private Button btnAssignSetting;
    @FXML
    private Button btnConfigRelational;
    @FXML
    private Button btnAssignRelational;
    @FXML
    private Button btnConfigFollowUp;
    @FXML
    private Button btnAssignFollowUp;
    @FXML
    private Button btnResultGeneral;

    @FXML
    private void SummitFinal(ActionEvent event) {
        System.out.println("ho;las");
        ResultsService resultService = new ResultsService();
        ResultsDto resultDto = new ResultsDto();
        EvaluatedService service = new EvaluatedService();

        Respuesta respuesta = service.getEvaluateds();
        ProcesoevaService serviceProceso = new ProcesoevaService();
        for (int i = 0; i < resultado.size(); i++) {
            resultDto.setRsCompe(listCompetences.get(i).getJxcCompetence());
            resultDto.setRsNotasis(floatToShort(resultado.get(listCompetences.get(i).getJxcCompetence().getCsName())));
            resultDto.setRsEvaluated(evaluatorsDto.get(i).getErEvaluator().getEvsEvaluated());
            for (Node node : gridEvaGeneral.getChildren()) {
                if (node instanceof Button) {
                    Integer colIndex = GridPane.getColumnIndex(node);
                    Integer rowIndex = GridPane.getRowIndex(node);

                    colIndex = colIndex == null ? 0 : colIndex;
                    rowIndex = rowIndex == null ? 0 : rowIndex;

                    if (node == null) {
                        continue;
                    } else {
                        if (colIndex == i) {
                            resultDto.setRsNotajefatura((short) Math.abs((rowIndex - 4)));
                        }
                    }
                }
            }
            respuesta = serviceProceso.getProcesos();
            List<ProcesosevaDto> listProcesosDto = (List<ProcesosevaDto>) respuesta.getResultado("ProcesosevaDto");
            ProcesosevaDto dates = listProcesosDto.stream().filter(x -> x.getId().equals(resultDto.getRsEvaluated().getEsProcesoeva().getEnId())).findAny().get();

            procesoDto.setsetApplication(dates.getApplication().toString());
            procesoDto.setsetFinalperiod(dates.getFinalperiod().toString());
            procesoDto.setsetInicialperiod(dates.getInicialperiod().toString());
            resultService.SaveResult(resultDto, procesoDto);
        }

    }

    public static short floatToShort(float x) {
        if (x < Short.MIN_VALUE) {
            return Short.MIN_VALUE;
        }
        if (x > Short.MAX_VALUE) {
            return Short.MAX_VALUE;
        }
        return (short) Math.round(x);
    }

    class cordenadas {

        double x, y;
    }

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
        procesoDto = new ProcesosevaDto();

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
        this.tableColEvaluator_State.setCellValueFactory(new PropertyValueFactory("EvsStateList"));
    }

    @FXML
    private void openEvaluations(MouseEvent event) {
    }

    public void reviewStateProcess() {
        if (choiceBoxStateEva.getValue() == "En revisión") {
            btnConfigEva.setText("Revisar Nota");
            btnConfigMenu.setVisible(false);
            btnAssignMenu.setVisible(false);
            btnConfigSetting.setVisible(false);
            btnAssignSetting.setVisible(false);
            btnConfigRelational.setVisible(false);
            btnAssignRelational.setVisible(false);
            btnConfigFollowUp.setVisible(false);
            btnAssignFollowUp.setVisible(false);
            btnResultGeneral.setVisible(true);
        } else {
            btnResultGeneral.setVisible(false);
            btnConfigEva.setText("Configuración Evaluación");
            btnConfigMenu.setVisible(true);
            btnAssignMenu.setVisible(true);
            btnConfigSetting.setVisible(true);
            btnAssignSetting.setVisible(true);
            btnConfigRelational.setVisible(true);
            btnAssignRelational.setVisible(true);
            btnConfigFollowUp.setVisible(true);
            btnAssignFollowUp.setVisible(true);
        }
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
            listWorkersEvaluated.add(selectedWorker);
            workersListSel.add(selectedWorker);
            listWorkers.remove(selectedWorker);
            workerList = FXCollections.observableArrayList(listWorkers);
            this.tableViewWorkers.refresh();
            this.tableViewWorkers.setItems(workerList);
            workersAss = FXCollections.observableArrayList(listWorkersEvaluated);
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
    private void searchWorker_Ident(KeyEvent event) {
        FilteredList<WorkerDto> filteredWorker = new FilteredList<>(workerList, f -> true);

        textFieldSearch_Ident.textProperty().addListener((observable, value, newValue) -> {
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
        filteredWorkers(filteredWorker);
    }

    private void filteredWorkers(FilteredList<WorkerDto> list) {
        SortedList<WorkerDto> sorted = new SortedList<>(list);
        sorted.comparatorProperty().bind(tableViewWorkers.comparatorProperty());
        tableViewWorkers.setItems(sorted);
    }

    public void ImportListWorkerEvaluators() {
        EvaluatorService serviceEvaluator = new EvaluatorService();
        Respuesta respuesta = serviceEvaluator.getEvaluators();
        listEvaluators = (List<EvaluatorDto>) respuesta.getResultado("Evaluators");
        for (int i = 0; i < listEvaluators.size(); i++) {
            for (int j = 0; j < listWorkers.size(); j++) {
                if (listWorkers.get(j).getName().equals(listEvaluators.get(i).getEvsWorker().getWrName())
                        && listWorkers.get(j).getName().equals(listEvaluators.get(i).getEvsEvaluated().getEsWorker().getWrName())) {
                    listWorkers.remove(j);
                }
            }
        }
        ObservableList<EvaluatorDto> evaluatorsList = FXCollections.observableArrayList(listEvaluators);
        this.tableViewSelWorkersPE.refresh();
        this.tableViewSelWorkersPE.setItems(evaluatorsList);
    }

    public void ImportListWorker() {
        WorkersService service = new WorkersService();
        Respuesta respuesta = service.getUsuarios();
        listWorkers = (List<WorkerDto>) respuesta.getResultado("Usuarios");
        changeTextAdmi(listWorkers);
        ImportListWorkerEvaluators();
        workerList = FXCollections.observableArrayList(listWorkers);
        this.tableViewWorkersPE.refresh();
        this.tableViewWorkersPE.setItems(workerList);
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
    Predicate<EvaluatorDto> getProEvaluators = x -> x.getEvsEvaluated().getEsProcesoeva().getEnId().equals(procesoDto.getId());

    public List<EvaluatorDto> getEvaluators(int idEvaluated) {
        return listEvaluatorAss.stream().
                filter(getProEvaluators.and(x -> x.getEvsEvaluated().getEsWorker().getWrId().equals(idEvaluated))).collect(Collectors.toList());
    }

    public void ImportListEvaluators() {
        EvaluatorService service = new EvaluatorService();
        Respuesta respuesta = service.getEvaluators();

        listEvaluatorAss = (List<EvaluatorDto>) respuesta.getResultado("Evaluators");
        listEvaluatorAss = getEvaluators(selectedWorker.getId());
        listEvaluator = FXCollections.observableArrayList(listEvaluatorAss);
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
        this.tableViewSelWorkers.refresh();
        this.tableViewSelWorkers.setItems(workersAss);
        OptionsMenuView.toFront();
    }
    Predicate<WorkerDto> WorkerNull = worker -> worker.getJob() != null;

    public List<WorkerDto> getWorkersJobs(List<WorkerDto> list, String name) {
        return list.stream().
                filter(WorkerNull.and(x -> x.getJob().getJsName().equals(name))).collect(Collectors.toList());
    }

    public void ImportListWorkerEvaluated() {
        for (int i = 0; i < listWorkersEvaluated.size(); i++) {
            for (int j = 0; j < listWorkers.size(); j++) {
                if (listWorkers.get(j).getName().equals(listWorkersEvaluated.get(i).getName())) {
                    listWorkers.remove(j);
                }
            }
        }
    }

    @FXML
    private void OpenSelectWorkers(ActionEvent event) {
        if (!JobMainField.getText().isEmpty()) {
            ImportListWorker();
            listWorkers = getWorkersJobs(listWorkers, jobDto.getName());
            importEvaluators();
            ImportListWorkerEvaluated();

            workerList = FXCollections.observableArrayList(listWorkers);
            this.tableViewWorkers.refresh();
            this.tableViewWorkers.setItems(workerList);
            textEvaJob.setText(jobDto.getName());

            listWorkersEvaluated = getWorkersJobs(listWorkersEvaluated, jobDto.getName());
            ObservableList<WorkerDto> WorkerEvaluated = FXCollections.observableArrayList(listWorkersEvaluated);
            this.tableViewSelWorkers.refresh();
            this.tableViewSelWorkers.setItems(WorkerEvaluated);
            OptionsSettingWorkerView.toFront();
        } else {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "Debes agregar un puesto.");
        }
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
                new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "No existe un trabajo en este campo.");
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
        viewSelectedWorker.toFront();
        OptionsSettingRelationalView.toFront();
    }

    @FXML
    private void viewChooseWorker(MouseEvent event) {
        viewChooseWorker.toFront();
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

        for (int i = 0; i < listEvaluators.size(); i++) {
            for (int j = 0; j < listWorkers.size(); j++) {
                if (listWorkers.get(j).getName().equals(listEvaluators.get(i).getName())) {
                    listWorkers.remove(j);
                }
            }
        }
        workerList = FXCollections.observableArrayList(listWorkers);
        this.tableViewWorkersPE.refresh();
        this.tableViewWorkersPE.setItems(workerList);

    }

    Predicate<EvaluatorDto> pProceso = x -> x.getEvsEvaluated().getEsProcesoeva().getEnName().equals(procesoDto.getName());

    public List<EvaluatorDto> getlistEvaluators() {
        return new ArrayList<>(listEvaluators.stream()
                .filter(pProceso.and(x -> x.getEvsEvaluated().getEsWorker().getWrName().equals(workerDto.getName())))
                .collect(Collectors.toList()));
    }

    @FXML
    private void openSelectEvaluators(ActionEvent event) {
        if (!WorkerCREMainField.getText().isEmpty()) {
            ImportListWorker();
            listEvaluators = getlistEvaluators();
            ObservableList<EvaluatorDto> evaluatorsList = FXCollections.observableArrayList(listEvaluators);
            this.tableViewSelWorkersPE.refresh();
            this.tableViewSelWorkersPE.setItems(evaluatorsList);
            OptionsSettingEvaluatorsView.toFront();
        } else {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "Debes agregar un trabajador.");
        }

    }

    @FXML
    private void procesoevaClicked(MouseEvent event) {
        if (event.getClickCount() == 2) {
            try {
                procesoDto = tableViewProEva.getSelectionModel().getSelectedItem();

                TitleEvaField.setText(procesoDto.getName());
                choiceBoxStateEva.setValue(procesoDto.getState());
                DateProEva_Inicial.setValue(procesoDto.getInicialperiod());
                DateProEva_Final.setValue(procesoDto.getFinalperiod());
                DateProEva_Application.setValue(procesoDto.getApplication());
                reviewStateProcess();
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
        textInfoPro_State.setText("Estado: " + procesoDto.getState());
        textInfoPro_DAppli.setText("Fecha de Aplicación: " + procesoDto.getApplication().toString());
        textInfoPro_DInicial.setText("Fecha de Inicio de Periodo: " + procesoDto.getInicialperiod().toString());
        textInfoPro_DFinal.setText("Fecha de Final de Periodo: " + procesoDto.getFinalperiod().toString());
        viewFollowUpEvaluated.toFront();
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
            textInfoE_Name.setText(selectedWorker.getName() + "" + selectedWorker.getPsurname() + "" + selectedWorker.getSsurname());
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

    @FXML
    private void searchWorkerPE_Name(KeyEvent event) {
        FilteredList<WorkerDto> filteredWorker = new FilteredList<>(workerList, f -> true);

        textFieldSearchPE_Name.textProperty().addListener((observable, value, newValue) -> {
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
        filteredWorkerPE(filteredWorker);
    }

    @FXML
    private void searchWorkerPE_Pusername(KeyEvent event) {
        FilteredList<WorkerDto> filteredWorker = new FilteredList<>(workerList, f -> true);

        textFieldSearchPE_Psurname.textProperty().addListener((observable, value, newValue) -> {
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
        filteredWorkerPE(filteredWorker);
    }

    @FXML
    private void searchWorkerPE_Ident(KeyEvent event) {
        FilteredList<WorkerDto> filteredWorker = new FilteredList<>(workerList, f -> true);

        textFieldSearchPE_Ident.textProperty().addListener((observable, value, newValue) -> {
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
        filteredWorkerPE(filteredWorker);
    }

    private void filteredWorkerPE(FilteredList<WorkerDto> list) {
        SortedList<WorkerDto> sorted = new SortedList<>(list);
        sorted.comparatorProperty().bind(tableViewWorkersPE.comparatorProperty());
        tableViewWorkersPE.setItems(sorted);
    }

    @FXML
    private void eliminarConEva(MouseEvent event) {
        eliminar = true;
    }

    @FXML
    private void workerClickedSel(MouseEvent event) {
        EvaluatorDto ev = new EvaluatorDto();
        if (event.getClickCount() == 1) {
            if (eliminar == true) {
                ev = tableViewSelWorkersPE.getSelectionModel().getSelectedItem();
                EvaluatorService valor = new EvaluatorService();
                valor.eliminarEvaluator(ev.getEvsId());
                ImportListWorker();
                ImportListWorkerEvaluators();
                eliminar = false;
            }
        }
    }

    @FXML
    private void searchEvaFU_Name(KeyEvent event) {
        FilteredList<EvaluatorDto> filteredEvaluator = new FilteredList<>(listEvaluator, f -> true);

        textFieldEvaFU_Name.textProperty().addListener((observable, value, newValue) -> {
            filteredEvaluator.setPredicate(EvaluatorDto -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();
                if (EvaluatorDto.getEvsWorker().getWrName().toLowerCase().contains(search)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        filteredEvaluatedFU(filteredEvaluator);
    }

    @FXML
    private void searchEvaFU_Ident(KeyEvent event) {
        FilteredList<EvaluatorDto> filteredEvaluator = new FilteredList<>(listEvaluator, f -> true);

        textFieldEvaFU_Ident.textProperty().addListener((observable, value, newValue) -> {
            filteredEvaluator.setPredicate(EvaluatorDto -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();
                if (EvaluatorDto.getEvsWorker().getWrIdentification().toLowerCase().contains(search)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        filteredEvaluatedFU(filteredEvaluator);

    }

    @FXML
    private void searchEvaFU_State(KeyEvent event) {
        FilteredList<EvaluatorDto> filteredEvaluator = new FilteredList<>(listEvaluator, f -> true);

        textFieldEvaFU_State.textProperty().addListener((observable, value, newValue) -> {
            filteredEvaluator.setPredicate(EvaluatorDto -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();
                if (EvaluatorDto.getEvsState().toLowerCase().contains(search)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        filteredEvaluatedFU(filteredEvaluator);

    }

    private void filteredEvaluatedFU(FilteredList<EvaluatorDto> list) {
        SortedList<EvaluatorDto> sorted = new SortedList<>(list);
        sorted.comparatorProperty().bind(tableViewEvaluatorsFU.comparatorProperty());
        tableViewEvaluatorsFU.setItems(sorted);
    }

    @FXML
    private void evaluatorResClicked(MouseEvent event) {
        CharacteristicService serviceChara = new CharacteristicService();
        Respuesta respuestaChara = serviceChara.getCharacteristic();
        String concatenatedNames = "";
        List<CharacteristicsDto> characteristics = (List<CharacteristicsDto>) respuestaChara.getResultado("Characteristic");
        List<CharacteristicsDto> aux;

        if (event.getClickCount() == 2) {
            JobsCompetencesService service = new JobsCompetencesService();
            evaluatorDto = tableViewEvaluatorsFU.getSelectionModel().getSelectedItem();
            textEvaluation_Process.setText(procesoDto.getName());
            textEvaluation_Name.setText(selectedWorker.getName() + " " + selectedWorker.getPsurname() + " " + selectedWorker.getSsurname());
            textEvaluation_Job.setText(selectedWorker.getJob().getJsName());
            textEvaluation_Period.setText(procesoDto.getInicialperiod().getYear() + " - " + procesoDto.getFinalperiod().getYear());
            textEvaluation_Apli.setText(procesoDto.getApplication().toString());
            textEvaluation_Evaluator.setText("Evaluador: " + evaluatorDto.getName() + " " + evaluatorDto.getPsurname() + " " + evaluatorDto.getSsurname());
            Respuesta respuesta = service.getjCompetences();
            listCompetences = (List<EvaJobCompetenceDto>) respuesta.getResultado("JobsCompetences");
            listCompetences = listCompetences.stream().filter(x -> x.getJobs().getJsName().equals(evaluatorDto.getEvsEvaluated().getEsWorker().getWrJob().getJsName())).toList();
            ColumnConstraints originalConstraints = grid.getColumnConstraints().get(0);
            for (int i = 1; i < listCompetences.size(); i++) {
                ColumnConstraints newConstraints = new ColumnConstraints();
                newConstraints.setFillWidth(originalConstraints.isFillWidth());
                newConstraints.setHalignment(originalConstraints.getHalignment());
                newConstraints.setHgrow(originalConstraints.getHgrow());
                newConstraints.setMaxWidth(originalConstraints.getMaxWidth());
                newConstraints.setMinWidth(originalConstraints.getMinWidth());
                newConstraints.setPercentWidth(originalConstraints.getPercentWidth());
                newConstraints.setPrefWidth(originalConstraints.getPrefWidth());
                grid.getColumnConstraints().add(newConstraints);
            }
            originalConstraints = grid.getColumnConstraints().get(0);

            for (int i = 1; i < listCompetences.size(); i++) {

                ColumnConstraints newConstraints = new ColumnConstraints();
                newConstraints.setFillWidth(originalConstraints.isFillWidth());
                newConstraints.setHalignment(originalConstraints.getHalignment());
                newConstraints.setHgrow(originalConstraints.getHgrow());
                newConstraints.setMaxWidth(originalConstraints.getMaxWidth());
                newConstraints.setMinWidth(originalConstraints.getMinWidth());
                newConstraints.setPercentWidth(originalConstraints.getPercentWidth());
                newConstraints.setPrefWidth(originalConstraints.getPrefWidth());
                gridHeader.getColumnConstraints().add(newConstraints);
            }
            for (int i = 0; i < listCompetences.size(); i++) {
                final int Cant = i;
                aux = characteristics.stream().filter(x -> x.getCcComid().getCsName().equals(listCompetences.get(Cant).getJxcCompetence().getCsName())).toList();

                for (int j = 0; j < aux.size(); j++) {
                    concatenatedNames += (aux.get(j).getCcName() + " ");
                }

                Label label = new Label(listCompetences.get(i).getJxcCompetence().getCsName());
                String fontFamily = "Tw Cen MT";
                double fontSize = 23.0;
                String textColor = "white";
                label.setStyle("-fx-font-family: '" + fontFamily + "'; -fx-font-size: " + fontSize + "px;" + "-fx-text-fill: " + textColor + ";");
                label.setTooltip(new Tooltip(concatenatedNames));
                gridHeader.add(label, i, 0);
                concatenatedNames = "";
            }
            EvaluatorResultsService evaluatorResultService = new EvaluatorResultsService();
            respuesta = evaluatorResultService.getEvaluatorResults();
            evaluatorsDto = (List<EvaluatorResultsDto>) respuesta.getResultado("EvaluatorsDto");
            evaluatorsDto = evaluatorsDto.stream().filter(x -> x.getErEvaluator().getEvsId().equals(evaluatorDto.getEvsId())).toList();

            for (int i = 0; i < evaluatorsDto.size(); i++) {
                ImageView checkInstance = new ImageView(check.getImage());
                checkInstance.setFitHeight(50);
                checkInstance.setFitWidth(50);
                grid.add(checkInstance, i, Math.abs(evaluatorsDto.get(i).getNota() - 4));
                textEvaluation_Feedback.setText(evaluatorsDto.get(i).getErEvaluator().getEvsFeedback());
            }

            OptionsEvaluationResView.toFront();
        }

    }

    @FXML
    private void backEvaluation(ActionEvent event) {
        List<Button> botonesParaEliminar = new ArrayList<>();
        ObservableList<Node> children = grid.getChildren();

        for (Node node : children) {
            if (node instanceof Button) {
                botonesParaEliminar.add((Button) node);
            }
        }
        ColumnConstraints originalConstraints = grid.getColumnConstraints().get(0);
        grid.getColumnConstraints().clear();
        grid.getColumnConstraints().add(originalConstraints);
        gridHeader.getColumnConstraints().clear();
        gridHeader.getColumnConstraints().add(originalConstraints);
        grid.setGridLinesVisible(true);
        gridHeader.setGridLinesVisible(true);

        textEvaluation_Feedback.setText(" ");
        for (Button boton : botonesParaEliminar) {
            grid.getChildren().remove(boton);
        }
        OptionsFollowUpView.toFront();
    }

    @FXML
    private void Summit(ActionEvent event) {
    }

    @FXML
    private void delete(MouseEvent event) {
    }

    @FXML
    private void getxy(MouseEvent event) {
    }

    @FXML
    private void mouse(MouseEvent event) {
    }

    @FXML
    private void openEvaluationGeneral(MouseEvent event) {
        ResultSis();
        //textEvaluationGen_Process.setText(procesoDto.getName());
        textEvaluationGen_Name.setText(selectedWorker.getName() + " " + selectedWorker.getPsurname() + " " + selectedWorker.getSsurname());
        textEvaluationGen_Job.setText(selectedWorker.getJob().getJsName());
        textEvaluationGen_Period.setText(procesoDto.getInicialperiod().getYear() + " - " + procesoDto.getFinalperiod().getYear());
        textEvaluationGen_Apli.setText(procesoDto.getApplication().toString());
        OptionsEvaluationGeneralView.toFront();
    }

    @FXML
    private void backEvaluationGen(ActionEvent event) {
        List<Button> botonesParaEliminar = new ArrayList<>();
        List<Button> botonesParaEliminar2 = new ArrayList<>();
        List<VBox> botonesParaEliminar3 = new ArrayList<>();
        ObservableList<Node> children = gridEvaGeneral.getChildren();
        ObservableList<Node> children2 = gridResGeneral.getChildren();
        ObservableList<Node> children3 = gridResGeneral.getChildren();
        for (Node node : children) {
            if (node instanceof Button) {
                botonesParaEliminar.add((Button) node);
            }
        }
        for (Node node : children3) {
            if (node instanceof VBox) {
                botonesParaEliminar3.add((VBox) node);
            }
        }
        for (Node node : children2) {
            if (node instanceof Button) {
                botonesParaEliminar2.add((Button) node);
            }
        }
        ColumnConstraints originalConstraints = gridEvaGeneral.getColumnConstraints().get(0);
        gridEvaGeneral.getColumnConstraints().clear();
        gridEvaGeneral.getColumnConstraints().add(originalConstraints);

        gridHeaderResGeneral.getColumnConstraints().clear();
        gridHeaderResGeneral.getColumnConstraints().add(originalConstraints);
        gridEvaGeneral.setGridLinesVisible(true);

        gridHeaderResGeneral.setGridLinesVisible(true);

        textEvaluation_Feedback.setText(" ");
        for (Button boton : botonesParaEliminar) {
            gridEvaGeneral.getChildren().remove(boton);
        }
        for (VBox vBox : botonesParaEliminar3) {
            gridEvaGeneral.getChildren().remove(vBox);
        }
        for (Button boton : botonesParaEliminar2) {
            gridResGeneral.getChildren().remove(boton);
        }
        OptionsFollowUpView.toFront();
    }

    @FXML
    private void UpdateProceso(ActionEvent event) {
        ProcesoevaService service = new ProcesoevaService();
        ProcesosevaDto procesosevaDto = new ProcesosevaDto();

        procesosevaDto.setState(choiceBoxStateEva.getValue());
        procesosevaDto.setName(TitleEvaField.getText());
        procesosevaDto.setId(procesoDto.getId());
        reviewStateProcess();
        if (DateProEva_Inicial.getValue().isBefore(DateProEva_Final.getValue())) {
            procesosevaDto.setApplication(DateProEva_Application.getValue());
            procesosevaDto.setInicialperiod(DateProEva_Inicial.getValue());
            procesosevaDto.setFinalperiod(DateProEva_Final.getValue());
            Respuesta respuesta = service.SaveProceso(procesosevaDto);
            if (!respuesta.getEstado()) {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar proceso de evaluación", getStage(), respuesta.getMensaje());
            } else {
                new Mensaje().showModal(Alert.AlertType.INFORMATION, "Guardar proceso de evaluación", getStage(), "Proceso de evaluación actualizado correctamente.");
            }
            ImportListProcesoEva();
        } else {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "Seleccione una fecha de inicio menor a la fecha de finalizacion");
        }

    }

    Predicate<EvaluatorResultsDto> pProcesos = x -> x.getErEvaluator().getEvsEvaluated().getEsProcesoeva().getEnName().equals(procesoDto.getName());

    Predicate<EvaluatorResultsDto> pConexion(String conexion) {
        return x -> x.getErEvaluator().getEvsConnection().equals(conexion);
    }

    public void ResultSis() {

        CharacteristicService serviceChara = new CharacteristicService();
        Respuesta respuestaChara = serviceChara.getCharacteristic();
        JobsCompetencesService service = new JobsCompetencesService();
        String concatenatedNames = "";
        float cantidad = listEvaluatorAss.stream().filter(x -> x.getEvsState().equals("S")).count();
        listEvaluatorAss = listEvaluatorAss.stream().filter(x -> x.getEvsState().equals("S")).toList();
        List<CharacteristicsDto> characteristics = (List<CharacteristicsDto>) respuestaChara.getResultado("Characteristic");
        List<CharacteristicsDto> aux;
        EvaluatorResultsService evaluatorResultService = new EvaluatorResultsService();
        Respuesta respuesta = evaluatorResultService.getEvaluatorResults();
        evaluatorsDto = (List<EvaluatorResultsDto>) respuesta.getResultado("EvaluatorsDto");
        evaluatorsDto = evaluatorsDto.stream().filter(pProcesos.and(x -> x.getErEvaluator().getEvsEvaluated().getEsWorker().getWrName().equals(selectedWorker.getName()))).toList();
        respuesta = service.getjCompetences();
        listCompetences = (List<EvaJobCompetenceDto>) respuesta.getResultado("JobsCompetences");
        listCompetences = listCompetences.stream().filter(x -> x.getJobs().getJsName().equals(selectedWorker.getJob().getJsName())).toList();

        ColumnConstraints originalConstraints = gridEvaGeneral.getColumnConstraints().get(0);
        for (int i = 1; i < listCompetences.size(); i++) {
            ColumnConstraints newConstraints = new ColumnConstraints();
            newConstraints.setFillWidth(originalConstraints.isFillWidth());
            newConstraints.setHalignment(originalConstraints.getHalignment());
            newConstraints.setHgrow(originalConstraints.getHgrow());
            newConstraints.setMaxWidth(originalConstraints.getMaxWidth());
            newConstraints.setMinWidth(originalConstraints.getMinWidth());
            newConstraints.setPercentWidth(originalConstraints.getPercentWidth());
            newConstraints.setPrefWidth(originalConstraints.getPrefWidth());
            gridEvaGeneral.getColumnConstraints().add(newConstraints);
        }
        originalConstraints = gridEvaGeneral.getColumnConstraints().get(0);

        for (int i = 1; i < listCompetences.size(); i++) {

            ColumnConstraints newConstraints = new ColumnConstraints();
            newConstraints.setFillWidth(originalConstraints.isFillWidth());
            newConstraints.setHalignment(originalConstraints.getHalignment());
            newConstraints.setHgrow(originalConstraints.getHgrow());
            newConstraints.setMaxWidth(originalConstraints.getMaxWidth());
            newConstraints.setMinWidth(originalConstraints.getMinWidth());
            newConstraints.setPercentWidth(originalConstraints.getPercentWidth());
            newConstraints.setPrefWidth(originalConstraints.getPrefWidth());
            gridHeaderResGeneral.getColumnConstraints().add(newConstraints);
        }
        for (int i = 0; i < listCompetences.size(); i++) {
            final int Cant = i;
            aux = characteristics.stream().filter(x -> x.getCcComid().getCsName().equals(listCompetences.get(Cant).getJxcCompetence().getCsName())).toList();

            for (int j = 0; j < aux.size(); j++) {
                concatenatedNames += (aux.get(j).getCcName() + " ");
            }

            Label label = new Label(listCompetences.get(i).getJxcCompetence().getCsName());
            String fontFamily = "Tw Cen MT";
            double fontSize = 23.0;
            String textColor = "white";
            label.setStyle("-fx-font-family: '" + fontFamily + "'; -fx-font-size: " + fontSize + "px;" + "-fx-text-fill: " + textColor + ";");
            label.setTooltip(new Tooltip(concatenatedNames));
            gridHeaderResGeneral.add(label, i, 0);
            concatenatedNames = "";
        }

        for (int i = 0; i < listCompetences.size(); i++) {
            final int cont = i;
            List<EvaluatorResultsDto> ResultAux = evaluatorsDto.stream().filter(x -> x.getErCompe().getCsId().equals(listCompetences.get(cont).getJxcCompetence().getCsId())).toList();

            for (int j = 0; j < 4; j++) {
                final int cont2 = j;
                VBox vbox = new VBox();
                HBox hbox = new HBox();
                vbox.setAlignment(Pos.CENTER);
                hbox.setAlignment(Pos.CENTER);
                int jefatura = (int) ResultAux.stream().filter(pConexion("Jefatura").and(x -> x.getNota().equals(Math.abs(cont2 - 4)))).count();
                int Cliente = (int) ResultAux.stream().filter(pConexion("Cliente").and(x -> x.getNota().equals(Math.abs(cont2 - 4)))).count();
                int Companero = (int) ResultAux.stream().filter(pConexion("Compañero").and(x -> x.getNota().equals(Math.abs(cont2 - 4)))).count();

                if (!(jefatura == 0 && Cliente == 0 && Companero == 0)) {
                    String fontFamily = "Tw Cen MT";
                    double fontSize = 22.0;
                    Label label = new Label("$  " + jefatura);
                    vbox.getChildren().add(label);
                    label.setStyle("-fx-font-family: '" + fontFamily + "'; -fx-font-size: " + fontSize + "px;");
                    label = new Label("*  " + Cliente);
                    vbox.getChildren().add(label);
                    label.setStyle("-fx-font-family: '" + fontFamily + "'; -fx-font-size: " + fontSize + "px;");
                    label = new Label("#  " + Companero);
                    vbox.getChildren().add(label);
                    label.setStyle("-fx-font-family: '" + fontFamily + "'; -fx-font-size: " + fontSize + "px;");
                    gridEvaGeneral.add(vbox, i, j);
                }
            }
        }

        for (int i = 0; i < listCompetences.size(); i++) {
            final int Cont = i;
            float sum = evaluatorsDto.stream().filter(x -> x.getErCompe().getCsId().equals(listCompetences.get(Cont).getJxcCompetence().getCsId())).mapToLong(x -> x.getNota()).sum();
            resultado.put(listCompetences.get(Cont).getJxcCompetence().getCsName(), sum / cantidad);
        }
        String Texto = "";
        float sumaTotal = 0;
        for (int i = 0; i < listCompetences.size(); i++) {

            ImageView checkInstance = new ImageView(check.getImage());
            ImageView checkPositive = new ImageView(new Image("/cr/ac/una/tarea/view/CheckPositive.png"));
            ImageView checkNegative = new ImageView(new Image("/cr/ac/una/tarea/view/CheckNegative.png"));

            checkInstance.setFitHeight(50);
            checkInstance.setFitWidth(50);
            checkPositive.setFitHeight(50);
            checkPositive.setFitWidth(50);
            checkNegative.setFitHeight(50);
            checkNegative.setFitWidth(50);

            Button btn = new Button();
            double fontSize = 18.0;
            String fondo = "-fx-background-color: transparent";
            btn.setStyle(fondo);

            int Redondeo = (int) Math.round(resultado.get(listCompetences.get(i).getJxcCompetence().getCsName()));
            float valor = resultado.get(listCompetences.get(i).getJxcCompetence().getCsName());
            if (Redondeo > valor) {
                btn.setGraphic(checkPositive);
                gridEvaGeneral.add(btn, i, Math.abs((int) valor - 4));
                agregarEventoArrastrar(btn, i, Math.abs((int) valor - 4));
            } else {
                if (Redondeo < valor) {
                    btn.setGraphic(checkNegative);
                    gridEvaGeneral.add(btn, i, Math.abs((int) valor - 4));
                    agregarEventoArrastrar(btn, i, Math.abs((int) valor - 4));
                } else {
                    btn.setGraphic(checkInstance);
                    gridEvaGeneral.add(btn, i, Math.abs((int) valor - 4));
                    agregarEventoArrastrar(btn, i, Math.abs((int) valor - 4));
                }
            }
            sumaTotal += resultado.get(listCompetences.get(i).getJxcCompetence().getCsName());
        }
        for (int i = 0; i < listEvaluatorAss.size(); i++) {
            Texto += listEvaluatorAss.get(i).getName() + ": " + listEvaluatorAss.get(i).getEvsFeedback() + "\n";
        }
        ImageView checkInstance = new ImageView(check.getImage());
        checkInstance.setFitHeight(50);
        checkInstance.setFitWidth(50);
        gridResGeneral.add(checkInstance, 0, Math.abs(((int) Math.floor(sumaTotal / listCompetences.size()) - 4)));
        textEvaluationGen_Feedback.setText(Texto);
    }

    private void agregarEventoArrastrar(Button boton, int initialColumn, int initialRow) {
        final cordenadas dragDelta = new cordenadas();
        double cellWidth = gridEvaGeneral.getWidth() / gridEvaGeneral.getColumnCount();
        double cellHeight = gridEvaGeneral.getHeight() / gridEvaGeneral.getRowCount();

        final int[] newInitialColumn = {initialColumn};
        final int[] newInitialRow = {initialRow};

        boton.setOnMousePressed((mouseEvent) -> {
            dragDelta.x = boton.getLayoutX() - mouseEvent.getSceneX();
            dragDelta.y = boton.getLayoutY() - mouseEvent.getSceneY();
            System.out.println(dragDelta.x);
            System.out.println(dragDelta.y);
        });

        boton.setOnMouseDragged((mouseEvent) -> {
            boton.setLayoutX(mouseEvent.getSceneX() + dragDelta.x);
            boton.setLayoutY(mouseEvent.getSceneY() + dragDelta.y);
        });

        boton.setOnMouseReleased((mouseEvent) -> {
            double sceneX = mouseEvent.getSceneX();
            double sceneY = mouseEvent.getSceneY();

            int columnIndex = -1;
            int rowIndex = -1;

            for (int i = 0; i < gridEvaGeneral.getColumnCount(); i++) {
                double minX = gridEvaGeneral.localToScene(gridEvaGeneral.getBoundsInLocal()).getMinX() + i * cellWidth;
                double maxX = gridEvaGeneral.localToScene(gridEvaGeneral.getBoundsInLocal()).getMinX() + (i + 1) * cellWidth;
                if (sceneX >= minX && sceneX < maxX) {
                    columnIndex = i;
                    break;
                }
            }

            for (int i = 0; i < gridEvaGeneral.getRowCount(); i++) {
                double minY = gridEvaGeneral.localToScene(gridEvaGeneral.getBoundsInLocal()).getMinY() + i * cellHeight;
                double maxY = gridEvaGeneral.localToScene(gridEvaGeneral.getBoundsInLocal()).getMinY() + (i + 1) * cellHeight;
                if (sceneY >= minY && sceneY < maxY) {
                    rowIndex = i;
                    break;
                }
            }

            if (columnIndex >= 0 && columnIndex < gridEvaGeneral.getColumnCount() && rowIndex >= 0 && rowIndex < 4) {
                if (columnIndex == newInitialColumn[0] && rowIndex != newInitialRow[0]) {
                    GridPane.setConstraints(boton, columnIndex, rowIndex);
                    newInitialColumn[0] = columnIndex;
                    newInitialRow[0] = rowIndex;

                    //   boton.setTooltip(new Tooltip("Numero: " + columnIndex + " Numero: " + rowIndex));
                } else {
                    if (!isColumnOccupied(gridEvaGeneral, columnIndex)) {
                        if (!isCellOccupied(gridEvaGeneral, columnIndex, rowIndex)) {
                            GridPane.setConstraints(boton, columnIndex, rowIndex);
                            newInitialColumn[0] = columnIndex;
                            newInitialRow[0] = rowIndex;
                            //     boton.setTooltip(new Tooltip("Fila: " + columnIndex + " Numero: " + rowIndex));
                        } else {
                            mostrarAlerta("La celda en la columna " + columnIndex + " y fila " + rowIndex + " ya está ocupada.");
                            gridEvaGeneral.setConstraints(boton, newInitialColumn[0], newInitialRow[0]);
                        }
                    } else {
                        mostrarAlerta("La columna " + columnIndex + " ya está ocupada.");
                        gridEvaGeneral.setConstraints(boton, newInitialColumn[0], newInitialRow[0]);
                    }
                }
            } else {
                gridEvaGeneral.setConstraints(boton, newInitialColumn[0], newInitialRow[0]);
            }
        });

    }

    private boolean isCellOccupied(GridPane grid, int column, int row) {
        for (Node node : grid.getChildren()) {
            Integer columnIndex = GridPane.getColumnIndex(node);
            Integer rowIndex = GridPane.getRowIndex(node);

            if (columnIndex != null && rowIndex != null && columnIndex == column && rowIndex == row) {
                return true;
            }
        }
        return false;
    }

    private boolean isColumnOccupied(GridPane grid, int column) {
        for (Node node : grid.getChildren()) {
            Integer columnIndex = GridPane.getColumnIndex(node);
            if (columnIndex != null && columnIndex.intValue() == column && node instanceof Button) {
                return true;
            }
        }
        return false;
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Columna ocupada");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
