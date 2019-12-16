package GUI;

import Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import Model.Course;

public class ManageDataController {
    @FXML
    public TextField examinerNameTextField;
    @FXML
    public Button examinerSaveButton;
    @FXML
    public ComboBox examinerChooseCombobox;
    @FXML
    public Button examinerDeleteButton;
    @FXML
    public ComboBox examinerCourseComboBox;
    @FXML
    public TextField courseNameTextField;
    @FXML
    public TextField courseNumberOfStudents;
    @FXML
    public RadioButton courseTypeWrittenRadioButton;
    @FXML
    public RadioButton courseTypeOralRadioButton;
    @FXML
    public Button courseSaveButton;
    @FXML
    public Button courseRemoveButton;
    @FXML
    public ComboBox courseChooseComboBox;
    @FXML
    public TextField roomNumbertextField;
    @FXML
    public TextField roomNumberOfChairsTextField;
    @FXML
    public Button roomSaveButton;
    @FXML
    public CheckBox roomPortsHDMICheck;
    @FXML
    public CheckBox roomPortsVGACheck;
    @FXML
    public TextField roomNumberOfTablesTextField;
    @FXML
    public ComboBox roomChooseComboBox;
    @FXML
    public Button roomRemoveButton;
    @FXML
    public TextField examinerPhoneTextField;
    @FXML
    public TextField examinerIdTextfield;

    @FXML ToggleGroup toggleGroup;

    private ViewHandler viewHandler;
    private Region root;
    private Model model;



    //----------ExaminerTab
    public void onExaminerComboBoxSelected(ActionEvent actionEvent) {

    }

    public void onExaminerDeleteButtonPressed(ActionEvent actionEvent) {

    }
    //-----------COURSE TAB-----------------------------------------
    public void onCourseSaveButtonPressed(ActionEvent actionEvent) {

    }

    public void onCourseRemoveButtonPressed(ActionEvent actionEvent) {

    }

    public void onCourseChooseComboboxSelected(ActionEvent actionEvent) {

    }
    //-------ROOM TAB---------------------------------------

    public void onRoomSaveButtonPressed(ActionEvent actionEvent) {

    }

    public void onRoomChooseComboBoxSelected(ActionEvent actionEvent) {

    }

    public void onRoomRemoveButtonPressed(ActionEvent actionEvent) {

    }
    //-----------------------------------------------------------------

    public void init(ViewHandler viewHandler, Model model, Region root) {
        this.root = root;
        this.viewHandler = viewHandler;
        this.model = model;
        courseTypeWrittenRadioButton.setToggleGroup(toggleGroup);
        courseTypeOralRadioButton.setToggleGroup(toggleGroup);

    }
    public void onExaminerSaveButtonPressed(ActionEvent actionEvent) {
        model.saveExaminer(examinerNameTextField.getText(),examinerPhoneTextField.getText(),examinerIdTextfield.getText(), (Course) examinerCourseComboBox.getValue());
    }
    public void reset() {


    }

    public Region getRoot() {
        return root;
    }

    public void onGoBackButton(ActionEvent actionEvent) {
        viewHandler.closeView();
        viewHandler.openView(viewHandler.MAIN_ID);
    }


    public onExaminerSaveButtonPressed (ActionEvent actionEvent) {
    }
}
