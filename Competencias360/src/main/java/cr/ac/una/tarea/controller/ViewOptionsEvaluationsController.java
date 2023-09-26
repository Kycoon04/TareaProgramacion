/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.tarea.controller;

import cr.ac.una.tarea.model.CharacteristicsDto;
import cr.ac.una.tarea.model.CompetenceDto;
import cr.ac.una.tarea.model.EvaJobCompetenceDto;
import cr.ac.una.tarea.model.EvaluatedsDto;
import cr.ac.una.tarea.model.EvaluatorDto;
import cr.ac.una.tarea.model.EvaluatorResultsDto;
import cr.ac.una.tarea.model.ProcesosevaDto;
import cr.ac.una.tarea.model.WorkerDto;
import cr.ac.una.tarea.service.CharacteristicService;
import cr.ac.una.tarea.service.CompetencesService;
import cr.ac.una.tarea.service.EvaluatedService;
import cr.ac.una.tarea.service.EvaluatorResultsService;
import cr.ac.una.tarea.service.EvaluatorService;
import cr.ac.una.tarea.service.JobsCompetencesService;
import cr.ac.una.tarea.service.ProcesoevaService;
import cr.ac.una.tarea.soap.Evaluators;
import cr.ac.una.tarea.soap.ProcesoevaDto;
import cr.ac.una.tarea.util.FlowController;
import cr.ac.una.tarea.util.Mensaje;
import cr.ac.una.tarea.util.Respuesta;
import java.io.ByteArrayInputStream;
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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import org.apache.poi.ss.formula.functions.Delta;

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
    EvaluatorDto evaluatorDto;
    List<EvaJobCompetenceDto> listCompetences = new ArrayList<>();
    List<ProcesosevaDto> listProcesos = new ArrayList<>();
    List<ProcesosevaDto> listProEvaluados = new ArrayList<>();
    List<ProcesosevaDto> listProFinalizados = new ArrayList<>();
    ObservableList<ProcesosevaDto> procesosList;
    ObservableList<ProcesosevaDto> procesosEvaList;
    ObservableList<ProcesosevaDto> procesosFinalList;
    List<EvaluatorDto> listEvaluators = new ArrayList<>();
    List<EvaluatedsDto> listEvaluateds = new ArrayList<>();
    List<EvaluatorDto> evaluateds = new ArrayList<>();
    ObservableList<EvaluatorDto> evaluatedList;
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
    private TableView<EvaluatorDto> tableViewEvaluated;
    @FXML
    private TableColumn<EvaluatorDto, String> tableColEvaluated_Ident;
    @FXML
    private TableColumn<EvaluatorDto, String> tableColEvaluated_Name;
    @FXML
    private TableColumn<EvaluatorDto, String> tableColEvaluated_Psurname;
    @FXML
    private TableColumn<EvaluatorDto, String> tableColEvaluated_Ssurname;
    @FXML
    private TableColumn<EvaluatorDto, String> tableColEvaluated_User;
    @FXML
    private TableColumn<EvaluatorDto, String> tableColEvaluated_Email;
    @FXML
    private TableColumn<EvaluatorDto, String> tableColEvaluated_State;
    @FXML
    private Circle UserMainPhoto;
    @FXML
    private BorderPane OptionsEvaluationView;
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
    private Button btnDragEva;
    @FXML
    private TextArea textEvaluation_Feedback;
    @FXML
    private ImageView check;
    @FXML
    private AnchorPane anchorDrag;
    GridPane gridPane = new GridPane();
    @FXML
    private GridPane grid;
    @FXML
    private GridPane gridHeader;
    double startX, startY;
    double xTab, yTab;
    EvaluatorResultsDto evaluatorResultsDto = new EvaluatorResultsDto();
    boolean delet = false;
    @FXML
    private TableView<ProcesosevaDto> tableColResEvaluated;
    @FXML
    private TableColumn<ProcesosevaDto, String> tableColResEvaluated_State;
    @FXML
    private TableColumn<ProcesosevaDto, String> tableColResEvaluated_Name;
    @FXML
    private TableColumn<ProcesosevaDto, String> tableColResEvaluated_IniPer;
    @FXML
    private TableColumn<ProcesosevaDto, String> tableColResEvaluated_FinalPer;
    @FXML
    private TableColumn<ProcesosevaDto, String> tableColResEvaluated_Apli;
    @FXML
    private BorderPane OptionsEvaluationGeneralView;
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
    private GridPane gridHeaderResGeneral;
    @FXML
    private GridPane gridHeaderResGeneral1;
    @FXML
    private GridPane gridEvaGeneral;
    @FXML
    private GridPane gridResGeneral;

    @FXML
    private void backEvaluationGen(ActionEvent event) {
        OptionsProcessEva.toFront();
    }

    @FXML
    private void procesoResultClicked(MouseEvent event) {
         if (event.getClickCount() == 2) {
            try {
                procesoDto = tableColResEvaluated.getSelectionModel().getSelectedItem();
                textEvaluationGen_Name.setText(workerDto.getName() + " " + workerDto.getPsurname() + " " + workerDto.getSsurname());
                textEvaluationGen_Job.setText(workerDto.getJob().getJsName());
                textEvaluationGen_Period.setText(procesoDto.getInicialperiod().getYear() + " - " + procesoDto.getFinalperiod().getYear());
                textEvaluationGen_Apli.setText(procesoDto.getApplication().toString());
               OptionsEvaluationGeneralView.toFront();
            } catch (Exception ex) {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "No existe un proceso en este campo.");
            }
        }
    }

    class cordenadas {

        double x, y;
    }

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
        this.tableColProEva_State.setCellValueFactory(new PropertyValueFactory("State"));
        this.tableColProEva_Name.setCellValueFactory(new PropertyValueFactory("Name"));
        this.tableColProEva_IniPer.setCellValueFactory(new PropertyValueFactory("Inicialperiod"));
        this.tableColProEva_FinalPer.setCellValueFactory(new PropertyValueFactory("Finalperiod"));
        this.tableColProEva_Apli.setCellValueFactory(new PropertyValueFactory("Application"));

        this.tableColProEvaluated_State.setCellValueFactory(new PropertyValueFactory("State"));
        this.tableColProEvaluated_Name.setCellValueFactory(new PropertyValueFactory("Name"));
        this.tableColProEvaluated_IniPer.setCellValueFactory(new PropertyValueFactory("Inicialperiod"));
        this.tableColProEvaluated_FinalPer.setCellValueFactory(new PropertyValueFactory("Finalperiod"));
        this.tableColProEvaluated_Apli.setCellValueFactory(new PropertyValueFactory("Application"));
        
        this.tableColResEvaluated_State.setCellValueFactory(new PropertyValueFactory("State"));
        this.tableColResEvaluated_Name.setCellValueFactory(new PropertyValueFactory("Name"));
        this.tableColResEvaluated_IniPer.setCellValueFactory(new PropertyValueFactory("Inicialperiod"));
        this.tableColResEvaluated_FinalPer.setCellValueFactory(new PropertyValueFactory("Finalperiod"));
        this.tableColResEvaluated_Apli.setCellValueFactory(new PropertyValueFactory("Application"));

        this.tableColEvaluated_Ident.setCellValueFactory(new PropertyValueFactory("EvIden"));
        this.tableColEvaluated_Name.setCellValueFactory(new PropertyValueFactory("EvName"));
        this.tableColEvaluated_Psurname.setCellValueFactory(new PropertyValueFactory("EvPsurname"));
        this.tableColEvaluated_Ssurname.setCellValueFactory(new PropertyValueFactory("EvSsurname"));
        this.tableColEvaluated_User.setCellValueFactory(new PropertyValueFactory("EvUsername"));
        this.tableColEvaluated_Email.setCellValueFactory(new PropertyValueFactory("EvEmail"));
        this.tableColEvaluated_State.setCellValueFactory(new PropertyValueFactory("EvsStateList"));
        mouseBton();
    }

    @FXML
    private void mouse(MouseEvent event) {
    }

    @FXML
    private void delete(MouseEvent event) {
        List<Button> botonesParaEliminar = new ArrayList<>();
        ObservableList<Node> children = grid.getChildren();

        for (Node node : children) {
            if (node instanceof Button) {
                botonesParaEliminar.add((Button) node);
            }
        }

        for (Button boton : botonesParaEliminar) {
            grid.getChildren().remove(boton);
        }

    }

    private void mouseBton() {
        btnDragEva.setOnMousePressed((t) -> {
            startX = t.getSceneX();
            startY = t.getSceneY();
        });
        btnDragEva.setOnMouseDragged((t) -> {
            ImageView asiento = (ImageView) btnDragEva.getGraphic();
            asiento.setTranslateX(t.getSceneX() - startX);
            asiento.setTranslateY(t.getSceneY() - startY);
            xTab = t.getSceneX() - 300;
            yTab = t.getSceneY() - 400;
        });
        btnDragEva.setOnMouseReleased((t) -> {
            int posX = (int) (xTab / grid.getCellBounds(0, 0).getMaxX());
            int posY = (int) (yTab / grid.getCellBounds(0, 0).getMaxY());

            if (posX >= 0 && posX < grid.getColumnCount() && posY >= 0 && posY < 4) {
                if (!isColumnOccupied(grid, posX)) {
                    Button asientoButton = crearAsiento(posX + "", posY + "");
                    grid.add(asientoButton, posX, posY);
                    agregarEventoArrastrar(asientoButton, posX, posY);
                } else {
                    mostrarAlerta("La columna " + posX + " ya está ocupada.");
                }
            }
            check.setTranslateX(0);
            check.setTranslateY(0);
        });
    }

    private void agregarEventoArrastrar(Button boton, int initialColumn, int initialRow) {
        final cordenadas dragDelta = new cordenadas();
        double cellWidth = grid.getWidth() / grid.getColumnCount();
        double cellHeight = grid.getHeight() / grid.getRowCount();

        final int[] newInitialColumn = {initialColumn};
        final int[] newInitialRow = {initialRow};

        boton.setOnMousePressed(mouseEvent -> {
            if (delet == true) {
                grid.getChildren().remove(boton);
                delet = false;
            }
        });

        boton.setOnMousePressed((mouseEvent) -> {
            dragDelta.x = boton.getLayoutX() - mouseEvent.getSceneX();
            dragDelta.y = boton.getLayoutY() - mouseEvent.getSceneY();
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

            for (int i = 0; i < grid.getColumnCount(); i++) {
                double minX = grid.localToScene(grid.getBoundsInLocal()).getMinX() + i * cellWidth;
                double maxX = grid.localToScene(grid.getBoundsInLocal()).getMinX() + (i + 1) * cellWidth;
                if (sceneX >= minX && sceneX < maxX) {
                    columnIndex = i;
                    break;
                }
            }

            for (int i = 0; i < grid.getRowCount(); i++) {
                double minY = grid.localToScene(grid.getBoundsInLocal()).getMinY() + i * cellHeight;
                double maxY = grid.localToScene(grid.getBoundsInLocal()).getMinY() + (i + 1) * cellHeight;
                if (sceneY >= minY && sceneY < maxY) {
                    rowIndex = i;
                    break;
                }
            }

            if (columnIndex >= 0 && columnIndex < grid.getColumnCount() && rowIndex >= 0 && rowIndex < 4) {
                if (columnIndex == newInitialColumn[0] && rowIndex != newInitialRow[0]) {
                    GridPane.setConstraints(boton, columnIndex, rowIndex);
                    newInitialColumn[0] = columnIndex;
                    newInitialRow[0] = rowIndex;

                    boton.setTooltip(new Tooltip("Numero: " + columnIndex + " Numero: " + rowIndex));
                } else {
                    if (!isColumnOccupied(grid, columnIndex)) {
                        if (!isCellOccupied(grid, columnIndex, rowIndex)) {
                            GridPane.setConstraints(boton, columnIndex, rowIndex);
                            newInitialColumn[0] = columnIndex;
                            newInitialRow[0] = rowIndex;
                            boton.setTooltip(new Tooltip("Fila: " + columnIndex + " Numero: " + rowIndex));
                        } else {
                            mostrarAlerta("La celda en la columna " + columnIndex + " y fila " + rowIndex + " ya está ocupada.");
                            grid.setConstraints(boton, newInitialColumn[0], newInitialRow[0]);
                        }
                    } else {
                        mostrarAlerta("La columna " + columnIndex + " ya está ocupada.");
                        grid.setConstraints(boton, newInitialColumn[0], newInitialRow[0]);
                    }
                }
            } else {
                grid.setConstraints(boton, newInitialColumn[0], newInitialRow[0]);
            }
        });

        boton.setOnContextMenuRequested(event -> {
            grid.getChildren().remove(boton);
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

    @FXML
    private void getxy(MouseEvent event) {
        System.out.println(event.getSceneX());
        System.out.println(event.getSceneY());
    }

    private Button crearAsiento(String letra, String numero) {
        Button asiento = new Button();

        ImageView imagen = new ImageView();
        asiento.setMaxSize(40, 40);
        asiento.setTooltip(new Tooltip("Fila: " + letra + " Numero: " + numero));
        ajustarImagen(imagen);
        imagen.setImage(imagen.getImage());
        asiento.setGraphic(imagen);
        return asiento;
    }

    private void ajustarImagen(ImageView imagen) {
        imagen.setImage(check.getImage());
        imagen.setFitHeight(25);
        imagen.setFitWidth(25);
        imagen.setScaleX(3);
        imagen.setScaleY(1.5);
    }

    @FXML
    private void SignOff(ActionEvent event) {
        FlowController.getInstance().goMain("ViewModuleWorkers");

    }

    @FXML
    private void Back(ActionEvent event) {
        grid.getChildren().clear();
        FlowController.getInstance().goMain("ViewOptionsModules");
    }

    @FXML
    private void openInformation(MouseEvent event) {
        textWorker_Name.setText(workerDto.getName() + " " + workerDto.getPsurname() + " " + workerDto.getSsurname());
        textWorker_Ident.setText("Identificación: " + workerDto.getIden());
        textWorker_Email.setText("Correo: " + workerDto.getEmail());
        textWorker_Job.setText("Puesto: " + workerDto.getJob().getJsName());

        /*ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(workerDto.getPhoto());
        Image image = new Image(byteArrayInputStream);
        UserMainPhoto.setFill(new ImagePattern(image));*/
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

            listProEvaluados.add(proceso);
        }
        listProEvaluados = listProEvaluados.stream().filter(getState.negate()).toList();
    }
    Predicate<ProcesosevaDto> getStateFinal = x -> x.getState().equals("Finalizada");
    public void ImportListProResult() {
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

            listProFinalizados.add(proceso);
        }
        listProFinalizados = listProFinalizados.stream().filter(getState.negate().and(getStateFinal)).toList();
    }
    public void ImportListEvaluator() {
        EvaluatorService service = new EvaluatorService();
        Respuesta respuesta = service.getEvaluators();
        listEvaluators = (List<EvaluatorDto>) respuesta.getResultado("Evaluators");
        listEvaluators = listEvaluators.stream()
                .filter(x -> x.getEvsWorker().getWrId().equals(workerDto.getId()))
                .collect(Collectors.toMap(
                        evaluator -> evaluator.getEvsEvaluated().getEsProcesoeva().getEnName(),
                        evaluator -> evaluator,
                        (existing, replacement) -> existing)).values()
                .stream()
                .toList();

        ProcesoevaService serviceProceso = new ProcesoevaService();

        for (EvaluatorDto evaluated : listEvaluators) {

            ProcesosevaDto proceso = new ProcesosevaDto();
            proceso.setName(evaluated.getEvsEvaluated().getEsProcesoeva().getEnName());
            proceso.setState(evaluated.getEvsEvaluated().getEsProcesoeva().getEnState());
            proceso.setId(evaluated.getEvsEvaluated().getEsProcesoeva().getEnId());

            respuesta = serviceProceso.getProcesos();
            List<ProcesosevaDto> listProcesosDto = (List<ProcesosevaDto>) respuesta.getResultado("ProcesosevaDto");
            ProcesosevaDto dates = listProcesosDto.stream().filter(x -> x.getId().equals(evaluated.getEvsEvaluated().getEsProcesoeva().getEnId())).findAny().get();

            proceso.setsetApplication(dates.getApplication().toString());
            proceso.setsetFinalperiod(dates.getFinalperiod().toString());
            proceso.setsetInicialperiod(dates.getInicialperiod().toString());

            listProcesos.add(proceso);
        }
        listProcesos = listProcesos.stream().filter(getState.negate()).toList();
    }
    Predicate<ProcesosevaDto> getState = x -> x.getState().equals("En construcción");

    public void ImportListProcesoEva() {
        ImportListEvaluator();
        ImportListEvaluated();
        ImportListProResult();
        procesosList = FXCollections.observableArrayList(listProcesos);
        procesosEvaList = FXCollections.observableArrayList(listProEvaluados);
        procesosFinalList= FXCollections.observableArrayList(listProFinalizados);
        this.tableViewProEva.refresh();
        this.tableViewProEva.setItems(procesosList);
        this.tableColProEvaluated.refresh();
        this.tableColProEvaluated.setItems(procesosEvaList);
        this.tableColResEvaluated.refresh();
        this.tableColResEvaluated.setItems(procesosFinalList);
        
        
    }
    Predicate<EvaluatorDto> getEvaluator = x -> x.getEvsEvaluated().getEsProcesoeva().getEnId().equals(procesoDto.getId());

    public void ImportEvaluated() {
        EvaluatorService service = new EvaluatorService();
        Respuesta respuesta = service.getEvaluators();
        evaluateds = (List<EvaluatorDto>) respuesta.getResultado("Evaluators");
        evaluateds = evaluateds.stream().filter(getEvaluator.and(x -> x.getEvsWorker().getWrId().equals(workerDto.getId()))).toList();
        evaluatedList = FXCollections.observableArrayList(evaluateds);
        this.tableViewEvaluated.refresh();
        this.tableViewEvaluated.setItems(evaluatedList);
        
        
    }

    @FXML
    private void procesoevaClicked(MouseEvent event) {
        if (event.getClickCount() == 2) {
            try {
                procesoDto = tableViewProEva.getSelectionModel().getSelectedItem();
                textNameProcess.setText(procesoDto.getName());
                OptionsSelectEvaluateView.toFront();
                ImportEvaluated();
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

        CharacteristicService serviceChara = new CharacteristicService();
        Respuesta respuestaChara = serviceChara.getCharacteristic();
        String concatenatedNames = "";
        List<CharacteristicsDto> characteristics = (List<CharacteristicsDto>) respuestaChara.getResultado("Characteristic");
        List<CharacteristicsDto> aux;

        if (event.getClickCount() == 2) {
            try {
                JobsCompetencesService service = new JobsCompetencesService();
                evaluatorDto = tableViewEvaluated.getSelectionModel().getSelectedItem();
                textEvaluation_Process.setText(procesoDto.getName());
                textEvaluation_Name.setText(evaluatorDto.getEvsEvaluated().getEsWorker().getWrName() + "" + evaluatorDto.getEvsEvaluated().getEsWorker().getWrPsurname() + "" + evaluatorDto.getEvsEvaluated().getEsWorker().getWrSsurname());
                textEvaluation_Job.setText(evaluatorDto.getEvsEvaluated().getEsWorker().getWrJob().getJsName());
                textEvaluation_Period.setText(procesoDto.getInicialperiod().getYear() + " - " + procesoDto.getFinalperiod().getYear());
                textEvaluation_Apli.setText(procesoDto.getApplication().toString());
                Respuesta respuesta = service.getjCompetences();
                listCompetences = (List<EvaJobCompetenceDto>) respuesta.getResultado("JobsCompetences");
                listCompetences = listCompetences.stream().filter(x -> x.getJobs().getJsName().equals(evaluatorDto.getEvsEvaluated().getEsWorker().getWrJob().getJsName())).toList();
                if (listCompetences.size() == 0) {
                    OptionsSelectEvaluateView.toFront();
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "No hay competencias para esta evaluacion.");
                } else {
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
                    OptionsEvaluationView.toFront();
                }
            } catch (Exception ex) {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "No existe un evaluado en este campo.");
            }
        }
    }

    @Override
    public void initialize() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        grid.setGridLinesVisible(true);

        gridHeader.getColumnConstraints().clear();
        gridHeader.getColumnConstraints().add(originalConstraints);
        gridHeader.setGridLinesVisible(true);
        textEvaluation_Feedback.setText(" ");

        for (Button boton : botonesParaEliminar) {
            grid.getChildren().remove(boton);
        }
        OptionsSelectEvaluateView.toFront();
    }

    @FXML
    private void Summit(ActionEvent event) {
        EvaluatorResultsService service = new EvaluatorResultsService();
        EvaluatorService serviceEvaluator = new EvaluatorService();
        boolean isAnyColumnEmpty = false;
        int Aux[] = new int[listCompetences.size()];
        int k = 0;

        for (Node node : grid.getChildren()) {

            if (node instanceof Button) {
                Integer colIndex = GridPane.getColumnIndex(node);
                Integer rowIndex = GridPane.getRowIndex(node);

                if (node == null) {
                    continue;
                } else {
                    Aux[k - 1] = 1;
                }
            }
            k++;
        }
        for (int i = 0; i < listCompetences.size(); i++) {
            if (Aux[i] == 0) {
                isAnyColumnEmpty = true;
            }
        }
        if (isAnyColumnEmpty) {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "Hay una competencia vacia");
        } else {
            for (Node node : grid.getChildren()) {
                if (node instanceof Button) {
                    Integer colIndex = GridPane.getColumnIndex(node);
                    Integer rowIndex = GridPane.getRowIndex(node);

                    colIndex = colIndex == null ? 0 : colIndex;
                    rowIndex = rowIndex == null ? 0 : rowIndex;

                    if (node == null) {
                        continue;
                    } else {
                        evaluatorResultsDto.setErCompe(listCompetences.get(colIndex).getJxcCompetence());
                        evaluatorResultsDto.setNota(Math.abs((rowIndex - 4)));

                        evaluatorDto.setEvsFeedback(textEvaluation_Feedback.getText());
                        evaluatorDto.setEvsState("S");
                        serviceEvaluator.SaveEvaluator(evaluatorDto, procesoDto);

                        Evaluators evaluator = new Evaluators();
                        evaluator.setEvsId(evaluatorDto.getEvsId());
                        evaluator.setEvsState(evaluatorDto.getEvsState());
                        evaluator.setEvsWorker(evaluatorDto.getEvsWorker());
                        evaluator.setEvsFeedback(evaluator.getEvsFeedback());
                        evaluator.setEvsEvaluated(evaluator.getEvsEvaluated());
                        evaluator.setEvsConnection(evaluator.getEvsConnection());
                        evaluatorResultsDto.setErEvaluator(evaluator);
                        service.SaveEvaluatorResult(evaluatorResultsDto);
                    }
                }
            }
        }
    }
}
