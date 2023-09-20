/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.tarea.controller;

import cr.ac.una.tarea.model.JobDto;
import cr.ac.una.tarea.model.ProcesosevaDto;
import cr.ac.una.tarea.model.WorkerDto;
import cr.ac.una.tarea.service.JobsService;
import cr.ac.una.tarea.service.ProcesoevaService;
import cr.ac.una.tarea.service.WorkersService;
import cr.ac.una.tarea.util.FlowController;
import cr.ac.una.tarea.util.Mensaje;
import cr.ac.una.tarea.util.Respuesta;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
public class ViewModuleEvaluationController implements Initializable {

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
    private ObservableList<JobDto> jobsList;
    List<WorkerDto> workersListSel = new ArrayList<>();
    @FXML
    private Text textEvaJob;
    JobDto jobDto;
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
     WorkerDto workerDto;
   
    @FXML
    private ChoiceBox<String> choiceBoxStateEva;
    String states[]={"En construcción", "En aplicación", "En revisión", "Finalizada"};
    @FXML
    private BorderPane OptionsEvaConfigView;
    @FXML
    private TableView<?> tableViewProEva;
    @FXML
    private TableColumn<?, ?> tableColProEva_State;
    @FXML
    private TableColumn<?, ?> tableColProEva_Name;
    @FXML
    private TableColumn<?,?> tableColProEva_IniPer;
    @FXML
    private TableColumn<?, ?> tableColProEva_FinalPer;
    @FXML
    private TableColumn<?, ?> tableColProEva_Apli;
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
    private TableView<?> tableViewWorkersPE;
    @FXML
    private TableColumn<?, ?> tableColActPE;
    @FXML
    private TableColumn<?, ?> tableColIdentifPE;
    @FXML
    private TableColumn<?, ?> tableColNamePE;
    @FXML
    private TableColumn<?, ?> tableColPsurnamePE;
    @FXML
    private TableColumn<?, ?> tableColUserNamePE;
    @FXML
    private TableColumn<?, ?> tableColEmailPE;
    @FXML
    private TableColumn<?, ?> tableColAdmiPE;
    @FXML
    private TableView<?> tableViewSelWorkers1;
    @FXML
    private TableColumn<?, ?> tableColSelIdentifPE;
    @FXML
    private TableColumn<?, ?> tableColSelNamePE;
    @FXML
    private TableColumn<?, ?> tableColSelPsurnamePE;
    @FXML
    private TableColumn<?, ?> tableColSelUserNamePE;
    @FXML
    private TableColumn<?, ?> tableColSelEmailPE;
    @FXML
    private TableColumn<?, ?> tableColSelConPE;
    @FXML
    private TextField textFieldSearchPE_Name;
    @FXML
    private TextField textFieldSearchPE_Pusername;
    @FXML
    private TextField textFieldSearchPE_State;
    @FXML
    private Text textNameWorker;
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        choiceBoxStateEva.getItems().addAll(states);
         OptionsEvaConfigView.toFront();
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
        

    }

    @FXML
    private void openEvaluations(MouseEvent event) {
    }


    @FXML
    private void CompetencesModi(ActionEvent event) {
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
                //new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "No existe un trabajo en este campo.");
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
            ObservableList<WorkerDto> workersAss = FXCollections.observableArrayList(workersListSel);

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
        List<WorkerDto> list = (List<WorkerDto>) respuesta.getResultado("Usuarios");
        changeTextAdmi(list);
        workerList = FXCollections.observableArrayList(list);
        this.tableViewWorkersCRE.refresh();
        this.tableViewWorkersCRE.setItems(workerList);
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

    @FXML
    private void addAllWorkers(ActionEvent event) {
        this.tableViewSelWorkers.refresh();
        this.tableViewSelWorkers.setItems(workerList);
    }

    @FXML
    private void addEvaluateWorkers(ActionEvent event) {
    }

    @FXML
    private void backSettings(ActionEvent event) {
        OptionsSettingView.toFront();
    }

    @FXML
    private void OpenSelectWorkers(ActionEvent event) {
        ImportListWorker();
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
                WorkerCREMainField.setText(workerDto.getName()+" "+workerDto.getPsurname()+" "+workerDto.getSsurname());
                textCREJob.setText("Puesto: "+workerDto.getJob().getJsName());
                textCREIdent.setText("Numero de Identificacion: "+workerDto.getIden());
                viewSelectedWorker.toFront();

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

    @FXML
    private void openSettingRelational(ActionEvent event) {
        ImportListWorker();
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
    //procesosevaDto.setApplication(/*campode aplication*/);
    //asi con los otros 2
    }


    @FXML
    private void jobClicked(MouseEvent event) {
    }

    @FXML
    private void searchJob_Name(KeyEvent event) {
    }

    @FXML
    private void searchJob_State(KeyEvent event) {
    }

    @FXML
    private void openSettingEva(MouseEvent event) {
         OptionsMenuView.toFront();
    }

    @FXML
    private void backMaintenance(MouseEvent event) {
        FlowController.getInstance().goMain("ViewOptionsModules");
    }

    @FXML
    private void addEvaluators(ActionEvent event) {
    }

    @FXML
    private void openSelectEvaluators(ActionEvent event) {
        OptionsSettingEvaluatorsView.toFront();
    }

}
