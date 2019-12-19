package View;

import Mediator.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Region;
import Model.*;
import java.io.IOException;

public class RemoveController {
    @FXML
    private ComboBox deleteExamCombobox;
    private ViewHandler viewHandler;
    private Region root;
    private Model model;


    public void init(ViewHandler viewHandler, Model model, Region root) {
        this.root = root;
        this.viewHandler = viewHandler;
        this.model=model;

        reset();
    }

    public void reset() {
        deleteExamCombobox.getItems().clear();
        deleteExamCombobox.getItems().setAll(model.getDisplayableExamList());
    }

    public Region getRoot() {
        return this.root;
    }

    public void onDeleteExamButton(ActionEvent actionEvent) throws IOException
    {
        model.deleteExam((Exam)deleteExamCombobox.getSelectionModel().getSelectedItem());
        reset();

    }

    public void onCancelButton(ActionEvent actionEvent) {
        viewHandler.closeView();
        viewHandler.openView(viewHandler.MAIN_ID);
    }
}
