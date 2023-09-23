package cr.ac.una.tarea.controller;

import cr.ac.una.tarea.model.WorkerDto;
import cr.ac.una.tarea.service.WorkersService;
import cr.ac.una.tarea.util.Email;
import cr.ac.una.tarea.util.FlowController;
import cr.ac.una.tarea.util.Formato;
import cr.ac.una.tarea.util.Mensaje;
import cr.ac.una.tarea.util.Respuesta;
import cr.ac.una.tarea.model.JobDto;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author jomav
 */
public class ViewModuleWorkersController extends Controller implements Initializable {

    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField userRegisField;
    @FXML
    private TextField surname1RegisField;
    @FXML
    private TextField surname2RegisField;
    @FXML
    private TextField idRegisField;
    @FXML
    private TextField emailRegisField;
    @FXML
    private TextField landlineRegisField;
    @FXML
    private TextField phoneNumberRegisField;
    @FXML
    private TextField passwordRegisField;
    @FXML
    private TextField password2RegisField;
    @FXML
    private BorderPane RegisterView;
    @FXML
    private BorderPane LoginView;
    @FXML
    private TextField emailRecoverField;
    @FXML
    private BorderPane RecoverView;
    @FXML
    private Text btnForgetPassword;
    @FXML
    private Circle UserPhoto;

    @FXML
    private TextField usernameField;
    @FXML
    private TextField usernameRegisField;
    @FXML
    private BorderPane RecoverFinalView;
    @FXML
    private TextField AceptRecoverField;
    WorkerDto workerDto;
    List<Node> requeridos = new ArrayList<>();
    static boolean admi;
    @FXML
    private Button generate;

    @Override
    @SuppressWarnings("empty-statement")
    public void initialize(URL url, ResourceBundle rb) {

        LoginView.toFront();
        usernameField.setTextFormatter(Formato.getInstance().UsernameFormat(30));
        usernameRegisField.setTextFormatter(Formato.getInstance().UsernameFormat(30));
        passwordField.setTextFormatter(Formato.getInstance().maxLengthFormat(15));
        userRegisField.setTextFormatter(Formato.getInstance().letrasFormat(30));
        surname1RegisField.setTextFormatter(Formato.getInstance().letrasFormat(15));
        surname2RegisField.setTextFormatter(Formato.getInstance().letrasFormat(15));
        idRegisField.setTextFormatter(Formato.getInstance().cedulaFormat(40));
        emailRegisField.setTextFormatter(Formato.getInstance().maxLengthFormat(80));
        passwordRegisField.setTextFormatter(Formato.getInstance().maxLengthFormat(15));
        landlineRegisField.setTextFormatter(Formato.getInstance().integerFormat());
        phoneNumberRegisField.setTextFormatter(Formato.getInstance().integerFormat());
        workerDto = new WorkerDto();
        nuevoEmpleado();
        IndicateRequired();
    }

    private void nuevoEmpleado() {
        unbindEmpleado();
        this.workerDto = new WorkerDto();
        bindEmpleado(true);
    }

    @Override
    public void initialize() {
    }

    private void AcceptAccess() {
        WorkersService workersService = new WorkersService();
        Mensaje mensaje = new Mensaje();
        Respuesta existe = workersService.getUsuario(usernameField.getText(), passwordField.getText());
        Respuesta temporal = workersService.isTempPassword(usernameField.getText(), passwordField.getText());
        Respuesta isAdmi = workersService.isAdminWorker(usernameField.getText(), passwordField.getText());

        if (existe.getEstado()) {
            Respuesta Usuario = workersService.getEmpleado(usernameField.getText(), passwordField.getText());
            workerDto = (WorkerDto) Usuario.getResultado("Usuario");
            if (workerDto.getActive().equals("S")) {
                if (!temporal.getEstado()) {
                    if (isAdmi.getEstado()) {
                         FlowController.worker=workerDto;
                        FlowController.getInstance().goMain("ViewOptionsModules");
                        admi = true;
                    } else {
                        FlowController.worker=workerDto;
                        FlowController.getInstance().goMain("ViewOptionsEvaluations");
                        admi = false;
                    }
                } else {
                    RecoverFinalView.toFront();
                }
            } else {
                mensaje.show(Alert.AlertType.ERROR, "Acceso denegado", "No esta activo");
            }
        } else {
            mensaje.show(Alert.AlertType.ERROR, "Acceso denegado", "No mi rey, no sos parte de la empresa");
        }
    }

    @FXML
    private void AcceptLogin(ActionEvent event) {
        AcceptAccess();
    }

    private void SignOff(ActionEvent event) {
        LoginView.toFront();
    }

    @FXML
    private void AceptPassword(ActionEvent event) {
        WorkersService workersService = new WorkersService();
        Respuesta existe = workersService.getEmpleado(usernameField.getText(), passwordField.getText());
        workerDto = (WorkerDto) existe.getResultado("Usuario");
        workerDto.setPassword(AceptRecoverField.getText());
        workerDto.setRecover("N");
        Respuesta respuesta = workersService.guardarEmpleado(workerDto);
        if (!respuesta.getEstado()) {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar empleado", getStage(), respuesta.getMensaje());
        } else {
            new Mensaje().showModal(Alert.AlertType.INFORMATION, "Guardar empleado", getStage(), "Empleado actualizado correctamente.");
        }
    }

    @FXML
    private void Register(ActionEvent event) {
        UserPhoto.setFill(Color.WHITE);
        RegisterView.toFront();
    }

    @FXML
    private void SelectImage(ActionEvent event) throws IOException {
        openImageChooser();
    }

    @FXML
    private void Back(ActionEvent event) {
        nuevoEmpleado();
        LoginView.toFront();
    }

    @FXML
    private void ConfirmRegister(ActionEvent event) {
        try {
            if (password2RegisField.getText().equals(passwordRegisField.getText())&& userRegisField.getText()!=null && surname1RegisField.getText()!=null && usernameRegisField.getText()!=null && surname2RegisField.getText()!=null ) {
                WorkersService workersService = new WorkersService();
                workerDto.setCode(CodeRamdon());
                Respuesta respuesta = workersService.guardarEmpleado(workerDto);
                if (!respuesta.getEstado()) {
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar empleado", getStage(), respuesta.getMensaje());
                } else {
                    Email email;
                    email = new Email(emailRegisField.getText(), userRegisField.getText() + " " + surname1RegisField.getText(), "Activacion de usuario");
                    email.envioDeCorreos("http://localhost:8080/Competencias360Ws/ActivacionWeb.html?Code=" + workerDto.getCode());
                    unbindEmpleado();
                    workerDto = (WorkerDto) respuesta.getResultado("Empleado");
                    bindEmpleado(false);
                    new Mensaje().showModal(Alert.AlertType.INFORMATION, "Guardar empleado", getStage(), "Empleado actualizado correctamente.");
                }
            }else{
            new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar Empleado", getStage(), "Verifica los campos.");
            }
        } catch (Exception ex) {
            Logger.getLogger(ViewModuleWorkersController.class
                    .getName()).log(Level.SEVERE, "Error guardando el empleado.", ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar Empleado", getStage(), "Ocurrio un error guardando el empleado.");
        }
    }

    @FXML
    private void PasswordForget(MouseEvent event) {
        RecoverView.toFront();
    }

    @FXML
    private void RecoverPassword(ActionEvent event) {
        try {
            Email email;
            String tempPasword = PasswordRamdon();
            email = new Email(emailRecoverField.getText(), userRegisField.getText() + " " + surname1RegisField.getText(), "Recuperar contrañesa");
            email.envioCmbClave(tempPasword);

            WorkersService workersService = new WorkersService();
            Respuesta respuesta = workersService.TempPassword(emailRecoverField.getText(), tempPasword);
            if (!respuesta.getEstado()) {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Cambiar Contraseña", getStage(), respuesta.getMensaje());
            } else {
                new Mensaje().showModal(Alert.AlertType.INFORMATION, "Cambiar Contraseña", getStage(), "Contraseña actualizada correctamente.");
            }
        } catch (Exception ex) {
            Logger.getLogger(ViewModuleWorkersController.class
                    .getName()).log(Level.SEVERE, "Error al cambiar Contraseña.", ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Cambiar Contraseña", getStage(), "Ocurrio un error cambiando contraseña.");
        }
    }

    private void IndicateRequired() {
        requeridos.clear();
        requeridos.addAll(Arrays.asList(userRegisField, idRegisField, passwordRegisField, password2RegisField));
    }

    public String validateRequired() {
        Boolean validos = true;
        String invalidos = "";
        for (Node node : requeridos) {
            if (node instanceof TextField && ((TextField) node).getText().isBlank()) {
                if (validos) {
                    invalidos += ((TextField) node).getPromptText();
                } else {
                    invalidos += "," + ((TextField) node).getPromptText();
                }
                validos = false;
            } else if (node instanceof PasswordField && ((PasswordField) node).getText().isEmpty()) {
                if (validos) {
                    invalidos += ((PasswordField) node).getPromptText();
                } else {
                    invalidos += "," + ((PasswordField) node).getPromptText();
                }
                validos = false;
            }
        }
        if (validos) {
            return "";
        } else {
            return "Campos requeridos o con problemas de formato [" + invalidos + "].";
        }
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
        UserPhoto.setFill(new ImagePattern(image));
    }

    public void imageToBytes(File file) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        int bytesRead = fis.read(buffer);
        workerDto.setPhoto(buffer);
    }

    private void CheckFields() {
        try {
            if (true) {
                throw new IllegalArgumentException("Complete todos los campos");
            } else {
                FlowController.getInstance().goMain("ViewModuleWorkers");
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    private void bindEmpleado(Boolean nuevo) {
        idRegisField.textProperty().bindBidirectional(workerDto.identification);
        userRegisField.textProperty().bindBidirectional(workerDto.name);
        surname1RegisField.textProperty().bindBidirectional(workerDto.psurname);
        surname2RegisField.textProperty().bindBidirectional(workerDto.ssurname);
        usernameRegisField.textProperty().bindBidirectional(workerDto.username);
        passwordRegisField.textProperty().bindBidirectional(workerDto.password);
        phoneNumberRegisField.textProperty().bindBidirectional(workerDto.telephone);
        landlineRegisField.textProperty().bindBidirectional(workerDto.landline);
        emailRegisField.textProperty().bindBidirectional(workerDto.email);
        emailRegisField.textProperty().bindBidirectional(workerDto.email);
    }

    private void unbindEmpleado() {
        idRegisField.textProperty().unbindBidirectional(workerDto.identification);
        userRegisField.textProperty().unbindBidirectional(workerDto.name);
        surname1RegisField.textProperty().unbindBidirectional(workerDto.psurname);
        surname2RegisField.textProperty().unbindBidirectional(workerDto.ssurname);
        usernameRegisField.textProperty().unbindBidirectional(workerDto.username);
        passwordRegisField.textProperty().unbindBidirectional(workerDto.password);
        phoneNumberRegisField.textProperty().unbindBidirectional(workerDto.telephone);
        landlineRegisField.textProperty().unbindBidirectional(workerDto.landline);
        emailRegisField.textProperty().unbindBidirectional(workerDto.email);
    }

    String PasswordRamdon() {
        char c1;
        String s = "";
        int i, r;
        for (i = 0; i < 6; i++) {
            r = (int) (Math.random() * (90 - 48 + 1) + 48);
            if ((r > 47 && r < 58) || (r > 64 && r < 91)) {
                c1 = (char) r;
                s += c1;
            } else {
                i--;
            }
        }
        return s;
    }

    String CodeRamdon() {
        char c1;
        String s = "";
        int i, r;
        for (i = 0; i < 14; i++) {
            r = (int) (Math.random() * (90 - 48 + 1) + 48);
            if ((r > 47 && r < 58) || (r > 64 && r < 91)) {
                c1 = (char) r;
                s += c1;
            } else {
                i--;
            }
        }
        return s;
    }

    @FXML
    private void AcceptLoginEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            AcceptAccess();
        }

    }

    @FXML
    private void generate(ActionEvent event) {

        System.out.print(" ssdfsf");
        FlowController.getInstance().goMain("Drag");
    }

}
