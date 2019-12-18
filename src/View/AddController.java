package View;

import Mediator.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;


public class AddController {
    @FXML
    private ComboBox roomCombobox;
    @FXML
    private Label ErrorLabel;
    @FXML
    private ComboBox ExamPicker;
    @FXML
    private javafx.scene.control.DatePicker DatePicker;
    @FXML
    private ComboBox Examiner1Picker;
    @FXML
    private ComboBox Examiner2Picker;
    @FXML
    private Button BtnSave;
    @FXML

    private Region root;
    private ViewHandler viewHandler;
    private Model model;


    public void init(ViewHandler viewHandler, Model model, Region root) {
        this.root = root;
        this.viewHandler = viewHandler;
        this.model = model;

    }

    public void reset() {

    }

    public Region getRoot() {
        return this.root;

    }


    public void onSavePressed(ActionEvent actionEvent) {
        //todo: add save logic.
        viewHandler.closeView();
        viewHandler.openView(viewHandler.MAIN_ID);
    }

    public void onCancelPressed(ActionEvent actionEvent) {
        viewHandler.closeView();
        viewHandler.openView(viewHandler.MAIN_ID);
    }
}
