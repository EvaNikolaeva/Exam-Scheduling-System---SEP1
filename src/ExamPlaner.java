import GUI.ViewHandler;
import Model.Model;
import Model.ModelManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class ExamPlaner extends Application {

    @Override
    public void start(Stage primaryStage) {
        Model model = new ModelManager();
        ViewHandler view = new ViewHandler(model);
        view.start(primaryStage);

    }
}
