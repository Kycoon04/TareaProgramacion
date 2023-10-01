package cr.ac.una.tarea.controller;

import cr.ac.una.tarea.model.CharacteristicsDto;
import cr.ac.una.tarea.model.CompetenceDto;
import cr.ac.una.tarea.model.EvaJobCompetenceDto;
import cr.ac.una.tarea.model.InformationDto;
import cr.ac.una.tarea.model.JobDto;
import cr.ac.una.tarea.model.WorkerDto;
import cr.ac.una.tarea.service.CharacteristicService;
import cr.ac.una.tarea.service.ComInformationService;
import cr.ac.una.tarea.service.CompetencesService;
import cr.ac.una.tarea.service.JobsCompetencesService;
import cr.ac.una.tarea.service.JobsService;
import cr.ac.una.tarea.service.WorkersService;
import cr.ac.una.tarea.soap.Competences;
import cr.ac.una.tarea.soap.Jobs;
import cr.ac.una.tarea.util.FlowController;
import cr.ac.una.tarea.util.Mensaje;
import cr.ac.una.tarea.util.Respuesta;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author jomav
 */
public class ViewOptionsModulesController extends Controller implements Initializable {

    @FXML
    private BorderPane OptionsWorkesView;
    @FXML
    private BorderPane OptionsMenuView;
    @FXML
    private TextField userMainField;
    @FXML
    private TextField surname1MainField;
    @FXML
    private TextField surname2MainField;
    @FXML
    private TextField identMainField;
    @FXML
    private TextField phoneNumberMainField;
    @FXML
    private Circle UserMainPhoto;
    @FXML
    private TextField usernameMainField;
    @FXML
    private TextField emailMainField;
    @FXML
    private TextField landlineMainField;
    @FXML
    private RadioButton radioButtonEmplo;
    @FXML
    private RadioButton radioButtonAdmi;
    @FXML
    private TableColumn<WorkerDto, String> tableColIdentif = new TableColumn<>();
    @FXML
    private TableColumn<WorkerDto, String> tableColName = new TableColumn<>();
    @FXML
    private TableColumn<WorkerDto, String> tableColPsurname = new TableColumn<>();
    @FXML
    private TableColumn<WorkerDto, String> tableColSsurname = new TableColumn<>();
    @FXML
    private TableColumn<WorkerDto, String> tableColEmail = new TableColumn<>();
    @FXML
    private TableColumn<WorkerDto, String> tableColTelephone = new TableColumn<>();
    @FXML
    private TableColumn<WorkerDto, String> tableColAdmi = new TableColumn<>();
    @FXML
    private TableColumn<WorkerDto, String> tableColUserName = new TableColumn<>();
    @FXML
    private TableColumn<WorkerDto, String> tableColAct;
    @FXML
    private TableView<WorkerDto> tableViewWorkers;
    @FXML
    private BorderPane OptionsInformationView;
    @FXML
    private TextField NameInformationField;
    @FXML
    private TextField InfoInformationField;
    @FXML
    private TextField EmailInformationField;
    @FXML
    private BorderPane OptionsCompetencesView;
    @FXML
    private TextField NameCompetencesField;
    @FXML
    private BorderPane OptionsPuestosView;
    @FXML
    private TextField PositionJobField;
    @FXML
    private TextField textFieldSearch_Name;
    @FXML
    private TextField textFieldSearch_Pusername;
    @FXML
    private TextField textFieldSearch_Identification;
    @FXML
    private TextField textFieldSearch_Rol;
    @FXML
    private TextField textFieldSearch_Susername;
    @FXML
    private CheckBox ActiveJobsCheck;
    @FXML
    private CheckBox StateCompetencesCheck;
    @FXML
    private TableView<CompetenceDto> tableViewCompetences;
    @FXML
    private TableColumn<CompetenceDto, String> tableColCompName;
    @FXML
    private TableColumn<CompetenceDto, String> tableColCompSta;
    @FXML
    private TableView<JobDto> tableViewJobs;
    @FXML
    private TableColumn<JobDto, String> tableColJobId;
    @FXML
    private TableColumn<JobDto, String> tableColJobNam;
    @FXML
    private TableColumn<JobDto, String> tableColJobSta;
    @FXML
    private TextField textFieldSJob_Name;
    @FXML
    private TextField textFieldSJob_State;
    @FXML
    private TextField textFieldSComp_Name;
    @FXML
    private TextField textFieldSComp_State;
    @FXML
    private TableView<JobDto> tableViewJobsW;
    @FXML
    private TableColumn<JobDto, String> tableColJobIdW;
    @FXML
    private TableColumn<JobDto, String> tableColJobNamW;
    @FXML
    private TableColumn<JobDto, String> tableColJobStaW;
    @FXML
    private Pane viewChooseJobs;
    @FXML
    private TextField JobMainField;
    @FXML
    private TextField textFieldSJob_NameW;
    @FXML
    private TextField textFieldSJob_StateW;
    @FXML
    private TextField textFieldSearch_State;
    @FXML
    private Circle InformationMainPhoto;
    @FXML
    private BorderPane OptionsAssociateCompView;
    @FXML
    private Text textFieldAsJob;
    @FXML
    private TableView<CompetenceDto> tableViewAsCompetences;
    @FXML
    private TableColumn<CompetenceDto, String> tableColAsCompName;
    @FXML
    private TableColumn<CompetenceDto, String> tableColAsCompSta;
    @FXML
    private Button deleteWorkerBtn;
    @FXML
    private Label txtEliminarPuesto;
    @FXML
    private BorderPane OptionsCharacteristicsView;
    @FXML
    private TextField NameCharacteristicField;
    @FXML
    private TableView<CharacteristicsDto> tableViewCharacteristics;
    @FXML
    private TableColumn<CharacteristicsDto, String> tableColCharactComp;
    @FXML
    private TableColumn<CharacteristicsDto, String> tableColCharactName;
    @FXML
    private TextField textFieldMCharact_Name;
    @FXML
    private TextField CompetenceCharacteristicField;
    @FXML
    private AnchorPane viewChooseCompetence;
    @FXML
    private Pane viewChooseJobs1;
    @FXML
    private AnchorPane viewSettingsCharacteristics;
    @FXML
    private Tab tabMantComp;
    @FXML
    private TabPane tabPaneMantComp;
    @FXML
    private TabPane tabPaneMantJob;
    @FXML
    private Tab tabMantJob;
    @FXML
    private TabPane tabPaneMantWorkers;
    @FXML
    private Tab tabMantWorkers;
    @FXML
    private TabPane tabPaneMantCharact;
    @FXML
    private Tab tabMantCharact;
    @FXML
    private TextField InfoKeytxt1;
    @FXML
    private AnchorPane root6;
    @FXML
    private TextField textFieldMCharact_NameComp;
    @FXML
    private TextField textFieldAComp_Name;
    @FXML
    private TextField textFieldAComp_State;
    @FXML
    private TableView<CompetenceDto> tableViewCCompetencesAssoc;
    @FXML
    private TableColumn<CompetenceDto, String> tableColCCompNameAssoc;
    @FXML
    private TableColumn<CompetenceDto, String> tableColCCompStaAssoc;

    CharacteristicsDto selectedCharacteristics;
    boolean delete = false;
    private ObservableList<CharacteristicsDto> selectedCharacteristicList;
    private ObservableList<CharacteristicsDto> characteristicList;
    private ObservableList<WorkerDto> workerList;
    private ObservableList<JobDto> jobsList;
    private ObservableList<CompetenceDto> competencesList;
    ObservableList<CompetenceDto> competenceAssoc;
    List<CompetenceDto> competencesListAss = new ArrayList<>();
    List<CompetenceDto> listComp= new ArrayList<>();
    WorkerDto workerDto;
    InformationDto informationDto;
    CompetenceDto competenceDto;
    JobDto jobDto;
    public static ToggleGroup role;
    List<InformationDto> list;
    @FXML
    private TableView<CompetenceDto> tableViewCompetencesAssoc;
    @FXML
    private TableColumn<CompetenceDto, String> tableColCompNameAssoc;
    @FXML
    private TableColumn<CompetenceDto, String> tableColCompStaAssoc;
    @FXML
    private TextField NameCompTextField;
    @FXML
    private TextField StateCompTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        OptionsMenuView.toFront();

        this.tableColAct.setCellValueFactory(new PropertyValueFactory("Actives"));
        this.tableColIdentif.setCellValueFactory(new PropertyValueFactory("iden"));
        this.tableColName.setCellValueFactory(new PropertyValueFactory("name"));
        this.tableColPsurname.setCellValueFactory(new PropertyValueFactory("psurname"));
        this.tableColSsurname.setCellValueFactory(new PropertyValueFactory("ssurname"));
        this.tableColUserName.setCellValueFactory(new PropertyValueFactory("username"));
        this.tableColEmail.setCellValueFactory(new PropertyValueFactory("email"));
        this.tableColTelephone.setCellValueFactory(new PropertyValueFactory("telephone"));
        this.tableColAdmi.setCellValueFactory(new PropertyValueFactory("administrator"));
        //this.tableColJob.setCellValueFactory(new PropertyValueFactory("job"));

        this.tableColCompSta.setCellValueFactory(new PropertyValueFactory("States"));
        this.tableColCompName.setCellValueFactory(new PropertyValueFactory("Name"));

        this.tableColAsCompSta.setCellValueFactory(new PropertyValueFactory("States"));
        this.tableColAsCompName.setCellValueFactory(new PropertyValueFactory("Name"));

        this.tableColCharactComp.setCellValueFactory(new PropertyValueFactory("CcComName"));
        this.tableColCharactName.setCellValueFactory(new PropertyValueFactory("CcName"));

        this.tableColCompStaAssoc.setCellValueFactory(new PropertyValueFactory("States"));
        this.tableColCompNameAssoc.setCellValueFactory(new PropertyValueFactory("Name"));

        this.tableColJobSta.setCellValueFactory(new PropertyValueFactory("States"));
        this.tableColJobNam.setCellValueFactory(new PropertyValueFactory("Name"));
        this.tableColJobId.setCellValueFactory(new PropertyValueFactory("Id"));

        this.tableColJobIdW.setCellValueFactory(new PropertyValueFactory("Id"));
        this.tableColJobNamW.setCellValueFactory(new PropertyValueFactory("Name"));
        this.tableColJobStaW.setCellValueFactory(new PropertyValueFactory("States"));

        this.tableColCCompNameAssoc.setCellValueFactory(new PropertyValueFactory("Name"));
        this.tableColCCompStaAssoc.setCellValueFactory(new PropertyValueFactory("States"));

        workerDto = new WorkerDto();
        informationDto = new InformationDto();
        competenceDto = new CompetenceDto();
        jobDto = new JobDto();
        role = new ToggleGroup();
        this.radioButtonAdmi.setToggleGroup(role);
        this.radioButtonEmplo.setToggleGroup(role);
    }

    @FXML
    private void OpenUpKeep(ActionEvent event) {
        ImportListWorker();
        ImportListJobs();
        ClearUpdateView();
        OptionsWorkesView.toFront();
    }

    @FXML
    private void SignOff(ActionEvent event) {
        FlowController.getInstance().goMain("ViewModuleWorkers");
    }

    @FXML
    private void SelectImage(ActionEvent event) throws IOException {
        openImageChooser();
    }

    @FXML
    private void UpdateWorker() {
        Jobs job = new Jobs();
        WorkersService workersService = new WorkersService();
        JobsService jobsService = new JobsService();

        workerDto.setName(userMainField.getText());
        workerDto.setPsurname(surname1MainField.getText());
        workerDto.setSsurname(surname2MainField.getText());
        workerDto.setIdentification(identMainField.getText());
        workerDto.setUsername(usernameMainField.getText());
        workerDto.setEmail(emailMainField.getText());
        workerDto.setLandline(landlineMainField.getText());
        workerDto.setTelephone(phoneNumberMainField.getText());
        if (radioButtonAdmi.isSelected()) {
            workerDto.setAdministrator("S");
        } else {
            if (radioButtonEmplo.isSelected()) {
                workerDto.setAdministrator("N");
            }
        }
        String contenido = JobMainField.getText();
        if (!contenido.isEmpty()) {
            Respuesta valor = jobsService.getJob(JobMainField.getText());
            JobDto j = (JobDto) valor.getResultado("Job");
            job.setJsId(j.getId());
            job.setJsName(j.getName());
            job.setJsState(j.getState());
            workerDto.setJob(job);
        }
        Respuesta respuesta = workersService.guardarEmpleado(workerDto);
        if (!respuesta.getEstado()) {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar empleado", getStage(), respuesta.getMensaje());
        } else {
            new Mensaje().showModal(Alert.AlertType.INFORMATION, "Guardar empleado", getStage(), "Empleado actualizado correctamente.");
        }
        ImportListWorker();
        ClearUpdateView();

    }

    private void ClearUpdateView() {
        UserMainPhoto.setFill(Color.WHITE);
        userMainField.setText("");
        surname1MainField.setText("");
        surname2MainField.setText("");
        identMainField.setText("");
        usernameMainField.setText("");
        emailMainField.setText("");
        landlineMainField.setText("");
        phoneNumberMainField.setText("");
        radioButtonAdmi.setSelected(false);
        radioButtonEmplo.setSelected(false);
        JobMainField.clear();
        JobMainField.setPromptText("Presionar");

    }

    private void UpdateWorker(ActionEvent event) {
        UpdateWorker();
    }

    @FXML
    private void workerClicked(MouseEvent event) {
        if (event.getClickCount() == 1) {
            if (delete == true) {
                workerDto = tableViewWorkers.getSelectionModel().getSelectedItem();
                WorkersService workersService = new WorkersService();
                workersService.eliminarEmpleado(workerDto.getId());
                ImportListWorker();
                delete = false;
            }
        } else {
            if (event.getClickCount() == 2) {
                try {
                    UserMainPhoto.setFill(Color.WHITE);
                    workerDto = tableViewWorkers.getSelectionModel().getSelectedItem();
                    userMainField.setText(String.valueOf(workerDto.getName()));
                    surname1MainField.setText(String.valueOf(workerDto.getPsurname()));
                    surname2MainField.setText(String.valueOf(workerDto.getSsurname()));
                    identMainField.setText(String.valueOf(workerDto.getIden()));
                    usernameMainField.setText(String.valueOf(workerDto.getUsername()));
                    emailMainField.setText(String.valueOf(workerDto.getEmail()));
                    landlineMainField.setText(String.valueOf(workerDto.getLandline()));
                    phoneNumberMainField.setText(String.valueOf(workerDto.getTelephone()));
                    if (workerDto.getAdministrator().equals("Administrador")) {
                        radioButtonAdmi.setSelected(true);
                    } else {
                        radioButtonEmplo.setSelected(true);
                    }
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(workerDto.getPhoto());
                    Image image = new Image(byteArrayInputStream);
                    UserMainPhoto.setFill(new ImagePattern(image));
                    JobMainField.setText(String.valueOf(workerDto.getJob().getJsName()));
                    tabPaneMantWorkers.getSelectionModel().select(tabMantWorkers);
                } catch (Exception ex) {
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "No existe un usuario en este campo.");
                }

            }
        }
    }

    public void ImportListWorker() {
        WorkersService service = new WorkersService();
        Respuesta respuesta = service.getUsuarios();
        List<WorkerDto> list = (List<WorkerDto>) respuesta.getResultado("Usuarios");
        changeTextAdmi(list);
        workerList = FXCollections.observableArrayList(list);
        this.tableViewWorkers.refresh();
        this.tableViewWorkers.setItems(workerList);
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

    @Override
    public void initialize() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void openImageChooser() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg"),
                new FileChooser.ExtensionFilter("Todos los archivos", "*.*")
        );
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            imageToBytes(selectedFile);
        }
        Image image = new Image(selectedFile.toURI().toString());
        UserMainPhoto.setFill(new ImagePattern(image));
    }

    public void imageToBytes(File file) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        int bytesRead = fis.read(buffer);
        workerDto.setPhoto(buffer);
    }

    public void imageToBytesInfo(File file) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        int bytesRead = fis.read(buffer);
        informationDto.setPhoto(buffer);
    }

    @FXML
    private void InformationGeneral(ActionEvent event) {
        ComInformationService comInformationService = new ComInformationService();
        Respuesta respuesta = comInformationService.getComInformation();
        if (!respuesta.getEstado()) {
            System.out.println("Vacia");
            OptionsInformationView.toFront();
        } else {
            list = (List<InformationDto>) respuesta.getResultado("ComInformation");
            NameInformationField.setText(list.get(0).getName());
            EmailInformationField.setText(list.get(0).getEmail());
            InfoInformationField.setText(list.get(0).getInformation());
            System.out.println(list.get(0).getCpKey());
            InfoKeytxt1.setText(list.get(0).getCpKey());

            System.out.println(list.get(0).getPhoto());
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(list.get(0).getPhoto());
            Image image = new Image(byteArrayInputStream);
            InformationMainPhoto.setFill(new ImagePattern(image));
            OptionsInformationView.toFront();
        }
    }

    @FXML
    private void UpdateInformation(ActionEvent event) {

        ComInformationService comInformationService = new ComInformationService();
        Respuesta respuesta1 = comInformationService.getComInformation();

        informationDto.setName(NameInformationField.getText());
        informationDto.setInformation(InfoInformationField.getText());
        informationDto.setEmail(EmailInformationField.getText());
        informationDto.setCpKey(InfoKeytxt1.getText());
        System.out.println(informationDto.getCpKey());
        if (respuesta1.getEstado()) {
            informationDto.setId(list.get(0).getId());
            Respuesta respuesta = comInformationService.SaveInformation(informationDto);
        }
        Respuesta respuesta = comInformationService.SaveInformation(informationDto);

        if (!respuesta.getEstado()) {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar empleado", getStage(), respuesta.getMensaje());
        } else {
            new Mensaje().showModal(Alert.AlertType.INFORMATION, "Guardar empleado", getStage(), "Empleado actualizado correctamente.");
        }

    }

    @FXML
    private void CompetencesModi(ActionEvent event) {
        clearMantCompetences();
        ImportListCompetences();
        OptionsCompetencesView.toFront();
    }

    @FXML
    private void UpdateCompetences(ActionEvent event) {
        CompetencesService competencesService = new CompetencesService();
        competenceDto.setName(NameCompetencesField.getText());

        if (StateCompetencesCheck.isSelected()) {
            competenceDto.setState("S");
        } else {
            competenceDto.setState("N");
        }
        Respuesta respuesta = competencesService.SaveCompetence(competenceDto);

        if (!respuesta.getEstado()) {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar competencia", getStage(), respuesta.getMensaje());
        } else {
            new Mensaje().showModal(Alert.AlertType.INFORMATION, "Guardar competencia", getStage(), "Competencia actualizada correctamente.");
        }
        ImportListCompetences();
    }

    @FXML
    private void JobsModi(ActionEvent event) {
        clearMantJobs();
        ImportListJobs();
        OptionsPuestosView.toFront();
    }

    @FXML
    private void UpdateJob(ActionEvent event) {
        JobsService jobsService = new JobsService();

        jobDto.setName(PositionJobField.getText());
        if (ActiveJobsCheck.isSelected()) {
            jobDto.setState("S");
        } else {
            jobDto.setState("N");
        }

        Respuesta respuesta = jobsService.SaveJob(jobDto);

        if (!respuesta.getEstado()) {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar puesto", getStage(), respuesta.getMensaje());
        } else {
            new Mensaje().showModal(Alert.AlertType.INFORMATION, "Guardar puesto", getStage(), "Puesto actualizado correctamente.");
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
    private void searchWorker_Identification(KeyEvent event) {
        FilteredList<WorkerDto> filteredWorker = new FilteredList<>(workerList, f -> true);

        textFieldSearch_Identification.textProperty().addListener((observable, value, newValue) -> {
            filteredWorker.setPredicate(WorkerDto -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();
                if (WorkerDto.getIden().toLowerCase().indexOf(search) == 0) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        filteredWorkers(filteredWorker);
    }

    @FXML
    private void searchWorker_Rol(KeyEvent event) {
        FilteredList<WorkerDto> filteredWorker = new FilteredList<>(workerList, f -> true);

        textFieldSearch_Rol.textProperty().addListener((observable, value, newValue) -> {
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
        filteredWorkers(filteredWorker);
    }

    @FXML
    private void searchWorker_Susername(KeyEvent event) {
        FilteredList<WorkerDto> filteredWorker = new FilteredList<>(workerList, f -> true);

        textFieldSearch_Susername.textProperty().addListener((observable, value, newValue) -> {
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
                if (WorkerDto.getActives().toLowerCase().indexOf(search) == 0) {
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

    @FXML
    private void UpdateWorkerEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            UpdateWorker();
        }
    }

    public void ImportListJobs() {
        JobsService jobsService = new JobsService();
        Respuesta respuesta = jobsService.getJobs();
        List<JobDto> list = (List<JobDto>) respuesta.getResultado("Jobs");
        jobsList = FXCollections.observableArrayList(list);
        this.tableViewJobs.refresh();
        this.tableViewJobs.setItems(jobsList);
        this.tableViewJobsW.refresh();
        this.tableViewJobsW.setItems(jobsList);
    }

    public void ImportListCompetences() {
        CompetencesService competencesService = new CompetencesService();
        Respuesta respuesta = competencesService.getCompetences();
        List<CompetenceDto> list = (List<CompetenceDto>) respuesta.getResultado("Competences");
        competencesList = FXCollections.observableArrayList(list);
        this.tableViewCompetences.refresh();
        this.tableViewCompetences.setItems(competencesList);
        this.tableViewCCompetencesAssoc.refresh();
        this.tableViewCCompetencesAssoc.setItems(competencesList);
    }

    @FXML
    private void searchJob_Name(KeyEvent event) {
        FilteredList<JobDto> filteredJob = new FilteredList<>(jobsList, f -> true);

        textFieldSJob_Name.textProperty().addListener((observable, value, newValue) -> {
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
        filteredJobs(filteredJob);
    }

    @FXML
    private void searchJob_State(KeyEvent event) {
        FilteredList<JobDto> filteredJob = new FilteredList<>(jobsList, f -> true);

        textFieldSJob_State.textProperty().addListener((observable, value, newValue) -> {
            filteredJob.setPredicate(JobDto -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();
                if (JobDto.getStates().toLowerCase().indexOf(search) == 0) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        filteredJobs(filteredJob);
    }

    private void filteredJobs(FilteredList<JobDto> list) {
        SortedList<JobDto> sorted = new SortedList<>(list);
        sorted.comparatorProperty().bind(tableViewJobs.comparatorProperty());
        tableViewJobs.setItems(sorted);
    }

    @FXML
    private void searchCompetence_Name(KeyEvent event) {
        FilteredList<CompetenceDto> filteredCompetence = new FilteredList<>(competencesList, f -> true);

        textFieldSComp_Name.textProperty().addListener((observable, value, newValue) -> {
            filteredCompetence.setPredicate(CompetenceDto -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();
                if (CompetenceDto.getName().toLowerCase().contains(search)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        filteredCompetences(filteredCompetence);
    }

    @FXML
    private void searchCompetence_State(KeyEvent event) {
        FilteredList<CompetenceDto> filteredCompetence = new FilteredList<>(competencesList, f -> true);

        textFieldSComp_State.textProperty().addListener((observable, value, newValue) -> {
            filteredCompetence.setPredicate(CompetenceDto -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();
                if (CompetenceDto.getStates().toLowerCase().indexOf(search) == 0) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        filteredCompetences(filteredCompetence);
    }

    private void filteredCompetences(FilteredList<CompetenceDto> list) {
        SortedList<CompetenceDto> sorted = new SortedList<>(list);
        sorted.comparatorProperty().bind(tableViewCompetences.comparatorProperty());
        tableViewCompetences.setItems(sorted);
    }

    @FXML
    private void competenceClicked(MouseEvent event) {
        if (event.getClickCount() == 1) {
            if (delete == true) {
                competenceDto = tableViewCompetences.getSelectionModel().getSelectedItem();
                CompetencesService competenceService = new CompetencesService();
                competenceService.eliminarCompe(competenceDto.getId());
                ImportListCompetences();
                delete = false;
            }
        }
        if (event.getClickCount() == 2) {
            try {
                competenceDto = tableViewCompetences.getSelectionModel().getSelectedItem();
                NameCompetencesField.setText(String.valueOf(competenceDto.getName()));
                if ("S".equals(competenceDto.getState())) {
                    StateCompetencesCheck.setSelected(true);
                } else {
                    StateCompetencesCheck.setSelected(false);
                }
                tabPaneMantComp.getSelectionModel().select(tabMantComp);

            } catch (Exception ex) {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "No existe una competencia en este campo.");
            }
        }
    }

    @FXML
    private void jobClicked(MouseEvent event) {
        if (event.getClickCount() == 1) {
            if (delete == true) {
                jobDto = tableViewJobs.getSelectionModel().getSelectedItem();
                JobsService valor = new JobsService();
                valor.deleteJob(jobDto.getId());
                ImportListJobs();
                delete = false;
            }
        } else {
            if (event.getClickCount() == 2) {
                try {
                    jobDto = tableViewJobs.getSelectionModel().getSelectedItem();
                    PositionJobField.setText(String.valueOf(jobDto.getName()));
                    if ("S".equals(jobDto.getState())) {
                        ActiveJobsCheck.setSelected(true);
                    } else {
                        ActiveJobsCheck.setSelected(false);
                    }
                    tabPaneMantJob.getSelectionModel().select(tabMantJob);

                } catch (Exception ex) {
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "No existe una competencia en este campo.");
                }
            }
        }

    }

    @FXML
    private void viewChooseJob(MouseEvent event) {
        viewChooseJobs.setVisible(!viewChooseJobs.isVisible());

    }

    @FXML
    private void jobClickedWorker(MouseEvent event) {
        if (event.getClickCount() == 2) {
            try {
                jobDto = tableViewJobsW.getSelectionModel().getSelectedItem();
                JobMainField.setText(jobDto.getName());
                viewChooseJobs.setVisible(false);

            } catch (Exception ex) {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "No existe un trabajo en este campo.");
            }
        }
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
                if (JobDto.getStates().toLowerCase().indexOf(search) == 0) {
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
    private void SelectImageInformation(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg"),
                new FileChooser.ExtensionFilter("Todos los archivos", "*.*")
        );
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            imageToBytesInfo(selectedFile);
        }
        Image image = new Image(selectedFile.toURI().toString());
        InformationMainPhoto.setFill(new ImagePattern(image));
    }

    @FXML
    private void openEvaluations(MouseEvent event) {
        FlowController.getInstance().goMain("ViewOptionsEvaluations");
    }

    @FXML
    private void AsoRoot(MouseEvent event) {
        if (!jobDto.getName().isEmpty()) {
            competencesListAss.clear();
            ImportCompXJobs();
            textFieldAsJob.setText(jobDto.getName());
            CompetencesService competencesService = new CompetencesService();
            Respuesta respuesta = competencesService.getCompetences();
             listComp = (List<CompetenceDto>) respuesta.getResultado("Competences");
            if (!competencesListAss.isEmpty()) {
                getListComp();
            }
            competencesList = FXCollections.observableArrayList(listComp);
            this.tableViewAsCompetences.refresh();
            this.tableViewAsCompetences.setItems(competencesList);

            OptionsAssociateCompView.toFront();
        } else {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Asociar competencias", getStage(), "Debes seleccionar un puesto");
        }
    }

    public void getListComp() {
        for (int i = 0; i < competencesListAss.size(); i++) {
            for (int j = 0; j < listComp.size(); j++) {
                if (competencesListAss.get(i).getId().equals(listComp.get(j).getId())) {
                    listComp.remove(j);
                }
            }
        }
    }

    public List<EvaJobCompetenceDto> getCompetencesXjob(List<EvaJobCompetenceDto> list) {
        return list.stream().filter(x -> x.getJobs().getJsId().equals(jobDto.getId())).collect(Collectors.toList());
    }

    public void ImportCompXJobs() {
        JobsCompetencesService serviceAssoc = new JobsCompetencesService();
        Respuesta respuesta = serviceAssoc.getjCompetences();
        List<EvaJobCompetenceDto> compList = (List<EvaJobCompetenceDto>) respuesta.getResultado("JobsCompetences");
        compList = getCompetencesXjob(compList);
        for (EvaJobCompetenceDto competence : compList) {
            CompetenceDto comp = new CompetenceDto();
            comp.setId(competence.getJxcCompetence().getCsId());
            comp.setName(competence.getJxcCompetence().getCsName());
            comp.setState(competence.getJxcCompetence().getCsState());
            competencesListAss.add(comp);
        }
        competenceAssoc = FXCollections.observableArrayList(competencesListAss);
        this.tableViewCompetencesAssoc.refresh();
        this.tableViewCompetencesAssoc.setItems(competenceAssoc);
    }

    @FXML
    private void competenceClick(MouseEvent event) {
        if (event.getClickCount() == 2) {

            CompetenceDto selectedCompetence = tableViewAsCompetences.getSelectionModel().getSelectedItem();
            competencesListAss.add(selectedCompetence);
            listComp.remove(selectedCompetence);
            competenceAssoc = FXCollections.observableArrayList(competencesListAss);
            competencesList = FXCollections.observableArrayList(listComp);
            this.tableViewAsCompetences.refresh();
            this.tableViewAsCompetences.setItems(competencesList);
            this.tableViewCompetencesAssoc.refresh();
            this.tableViewCompetencesAssoc.setItems(competenceAssoc);
        }
    }

    @FXML
    private void back(MouseEvent event) {
        if (!competenceAssoc.isEmpty()) {
            competenceAssoc.clear();
        }
        OptionsMenuView.toFront();

    }

    @FXML
    private void EvaluationsSettings(MouseEvent event) {
        FlowController.getInstance().goMain("ViewModuleEvaluation");
    }

    @FXML
    private void deleteClicked(MouseEvent event) {
        delete = true;
    }

    @FXML
    private void deletePuesto(MouseEvent event) {
        deleteClicked(event);
    }

    @FXML
    private void registerAsoci(MouseEvent event) {
        JobsCompetencesService jb = new JobsCompetencesService();
        Respuesta resp = new Respuesta();
        for (CompetenceDto selectedCompetence : competencesListAss) {
            EvaJobCompetenceDto evaJobCompetenceDto = new EvaJobCompetenceDto();
            Jobs job = new Jobs();
            Competences competence = new Competences();

            job.setJsId(jobDto.getId());
            job.setJsName(jobDto.getName());
            job.setJsState(jobDto.getState());

            competence.setCsId(selectedCompetence.getId());
            competence.setCsName(selectedCompetence.getName());
            competence.setCsState(selectedCompetence.getState());

            evaJobCompetenceDto.setEvaJobs(job);
            evaJobCompetenceDto.setJxcCompetence(competence);
            resp = jb.SaveJobCompetences(evaJobCompetenceDto);
        }
        if (!resp.getEstado()) {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Asociar Competencias", getStage(), resp.getMensaje());
        } else {
            new Mensaje().showModal(Alert.AlertType.INFORMATION, "Asociar Competencias", getStage(), "Competencias asociadas correctamente.");
        }
    }

    @FXML
    private void UpdateCharacteristics(ActionEvent event) {
        CharacteristicService cs = new CharacteristicService();
        CharacteristicsDto caract = new CharacteristicsDto();
        caract.setCcName(NameCharacteristicField.getText());

        Competences competence = new Competences();
        competence.setCsId(competenceDto.getId());
        competence.setCsName(competenceDto.getName());
        competence.setCsState(competenceDto.getState());
        caract.setCcComid(competence);
        Respuesta respuesta = cs.SaveCharacteristic(caract);
        if (!respuesta.getEstado()) {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar característica", getStage(), respuesta.getMensaje());
        } else {
            new Mensaje().showModal(Alert.AlertType.INFORMATION, "Guardar característica", getStage(), "Característica actualizada correctamente.");
        }
        ImportListCharacteristics();
    }

    @FXML
    private void characteristicClicked(MouseEvent event) {
        if (event.getClickCount() == 1) {
            if (delete == true) {
                selectedCharacteristics = tableViewCharacteristics.getSelectionModel().getSelectedItem();
                CharacteristicService characteristicService = new CharacteristicService();
                characteristicService.deleteCharacteristic(selectedCharacteristics.getCcId());
                ImportListCharacteristics();
                delete = false;
            }
        }
        if (event.getClickCount() == 2) {
            selectedCharacteristics = tableViewCharacteristics.getSelectionModel().getSelectedItem();
            NameCharacteristicField.setText(selectedCharacteristics.getCcName());
            CompetenceCharacteristicField.setText(selectedCharacteristics.getCcComid().getCsName());
            tabPaneMantCharact.getSelectionModel().select(tabMantCharact);
        }
    }

    public void ImportListCharacteristics() {
        CharacteristicService characteristicsService = new CharacteristicService();
        Respuesta respuesta = characteristicsService.getCharacteristic();
        List<CharacteristicsDto> list = (List<CharacteristicsDto>) respuesta.getResultado("Characteristic");
        if (respuesta.getEstado() && list.get(0) != null) {
            characteristicList = FXCollections.observableArrayList(list);
            this.tableViewCharacteristics.refresh();
            this.tableViewCharacteristics.setItems(characteristicList);
        }
    }

    @FXML
    private void CharacteristicsModi(ActionEvent event) {
        clearMantCharacteristics();
        ImportListCharacteristics();
        viewSettingsCharacteristics.toFront();
        OptionsCharacteristicsView.toFront();
    }

    @FXML
    private void associateCharacteristics(MouseEvent event) {
        ImportListCompetences();
        viewChooseCompetence.toFront();
    }

    @FXML
    private void competenceAssClicked(MouseEvent event) {
        if (event.getClickCount() == 2) {
            try {
                competenceDto = tableViewCCompetencesAssoc.getSelectionModel().getSelectedItem();
                CompetenceCharacteristicField.setText(competenceDto.getName());
                viewSettingsCharacteristics.toFront();
            } catch (Exception ex) {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "No existe un proceso en este campo.");
            }
        }
    }

    @FXML
    private void searchCharacteristic_Name(KeyEvent event) {
        FilteredList<CharacteristicsDto> filteredCharacteristics = new FilteredList<>(characteristicList, f -> true);

        textFieldMCharact_Name.textProperty().addListener((observable, value, newValue) -> {
            filteredCharacteristics.setPredicate(CharacteristicDto -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();
                if (CharacteristicDto.getCcName().toLowerCase().contains(search)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        filteredCharacateristics(filteredCharacteristics);
    }

    @FXML
    private void searchCharacteristic_NameComp(KeyEvent event) {
        FilteredList<CharacteristicsDto> filteredCharacteristics = new FilteredList<>(characteristicList, f -> true);

        textFieldMCharact_NameComp.textProperty().addListener((observable, value, newValue) -> {
            filteredCharacteristics.setPredicate(CharacteristicDto -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();
                if (CharacteristicDto.getCcComid().getCsName().toLowerCase().contains(search)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        filteredCharacateristics(filteredCharacteristics);

    }

    private void filteredCharacateristics(FilteredList<CharacteristicsDto> list) {
        SortedList<CharacteristicsDto> sorted = new SortedList<>(list);
        sorted.comparatorProperty().bind(tableViewCharacteristics.comparatorProperty());
        tableViewCharacteristics.setItems(sorted);
    }

    @FXML
    private void searchAComp_Name(KeyEvent event) {
        FilteredList<CompetenceDto> filteredCompetence = new FilteredList<>(competencesList, f -> true);

        textFieldAComp_Name.textProperty().addListener((observable, value, newValue) -> {
            filteredCompetence.setPredicate(CompetenceDto -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();
                if (CompetenceDto.getName().toLowerCase().contains(search)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        filteredACompetences(filteredCompetence);
    }

    @FXML
    private void searchAComp_State(KeyEvent event) {
        FilteredList<CompetenceDto> filteredCompetence = new FilteredList<>(competencesList, f -> true);

        textFieldAComp_State.textProperty().addListener((observable, value, newValue) -> {
            filteredCompetence.setPredicate(CompetenceDto -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();
                if (CompetenceDto.getStates().toLowerCase().indexOf(search) == 0) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        filteredACompetences(filteredCompetence);
    }

    private void filteredACompetences(FilteredList<CompetenceDto> list) {
        SortedList<CompetenceDto> sorted = new SortedList<>(list);
        sorted.comparatorProperty().bind(tableViewCCompetencesAssoc.comparatorProperty());
        tableViewCCompetencesAssoc.setItems(sorted);
    }

    @FXML
    private void searchNameCompAssoc(KeyEvent event) {
        FilteredList<CompetenceDto> filteredCompetence = new FilteredList<>(competencesList, f -> true);

        NameCompTextField.textProperty().addListener((observable, value, newValue) -> {
            filteredCompetence.setPredicate(CompetenceDto -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();
                if (CompetenceDto.getName().toLowerCase().contains(search)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        filteredCompetencesAssoc(filteredCompetence);
    }

    @FXML
    private void searchStateCompAssoc(KeyEvent event) {
        FilteredList<CompetenceDto> filteredCompetence = new FilteredList<>(competencesList, f -> true);

        StateCompTextField.textProperty().addListener((observable, value, newValue) -> {
            filteredCompetence.setPredicate(CompetenceDto -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String search = newValue.toLowerCase();
                if (CompetenceDto.getStates().toLowerCase().indexOf(search) == 0) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        filteredCompetencesAssoc(filteredCompetence);
    }

    private void filteredCompetencesAssoc(FilteredList<CompetenceDto> list) {
        SortedList<CompetenceDto> sorted = new SortedList<>(list);
        sorted.comparatorProperty().bind(tableViewAsCompetences.comparatorProperty());
        tableViewAsCompetences.setItems(sorted);
    }

    public void clearMantJobs() {
        PositionJobField.clear();
        ActiveJobsCheck.setSelected(false);
    }

    public void clearMantCompetences() {
        NameCompetencesField.clear();
        StateCompetencesCheck.setSelected(false);
    }

    public void clearMantCharacteristics() {
        NameCharacteristicField.clear();
        CompetenceCharacteristicField.clear();
    }

}
