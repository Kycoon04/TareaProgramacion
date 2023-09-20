package cr.ac.una.tarea;

import cr.ac.una.tarea.util.FlowController;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.image.Image;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FlowController.getInstance().InitializeFlow(stage, null);
        stage.getIcons().add(new Image(App.class.getResourceAsStream("/cr/ac/una/tarea/resources/LogoEmpresa.png")));
        stage.setTitle("Competencias 360");
        FlowController.getInstance().goMain("ViewModuleWorkers");

    }

    public static void main(String[] args) {
        launch();
    }
}
