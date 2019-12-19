import View.ViewHandler;
import Mediator.Model;
import Mediator.ModelManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class ExamPlaner extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException
    {
        Model model = new ModelManager();
        ViewHandler view = new ViewHandler(model);
        view.start(primaryStage);
    }
}
