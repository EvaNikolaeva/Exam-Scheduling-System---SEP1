package GUI;

import Model.Examiner;
import Model.Model;
import Model.MyDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;


public class AddController {
    @FXML
    public ComboBox roomCombobox;
    @FXML
    public Label ErrorLabel;
    @FXML
    public ComboBox ExamPicker;
    @FXML
    public javafx.scene.control.DatePicker DatePicker;
    @FXML
    public ComboBox Examiner1Picker;
    @FXML
    public ComboBox Examiner2Picker;
    @FXML
    public Button BtnSave;
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
