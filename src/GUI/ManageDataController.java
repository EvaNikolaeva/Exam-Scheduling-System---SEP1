package GUI;

import Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import Model.Course;
import Model.Examiner;
import Model.Equipment;
import Model.*;

import java.awt.*;
import java.util.ArrayList;

public class ManageDataController {
    @FXML
    private TextField examinerNameTextField;
    @FXML
    private Button examinerSaveButton;
    @FXML
    private ComboBox examinerChooseCombobox;
    @FXML
    private Button examinerDeleteButton;
    @FXML
    private ComboBox examinerCourseComboBox;

    @FXML
    private TextField examinerPhoneTextField;

    @FXML
    private TextField courseNameTextField;
    @FXML
    private TextField courseNumberOfStudents;
    @FXML
    private RadioButton courseTypeWrittenRadioButton;
    @FXML
    private RadioButton courseTypeOralRadioButton;
    @FXML
    private Button courseSaveButton;
    @FXML
    private Button courseRemoveButton;
    @FXML
    private ComboBox courseChooseComboBox;

    @FXML
    private TextField roomNumbertextField;
    @FXML
    private TextField roomNumberOfChairsTextField;
    @FXML
    private Button roomSaveButton;
    @FXML
    private TextField roomNumberOfTablesTextField;
    @FXML
    private ComboBox roomChooseComboBox;
    @FXML
    private Button roomRemoveButton;


    @FXML
    private TextField examinerIdTextfield;
    @FXML
    private RadioButton examinerRadioButtonInternal;
    @FXML
    private RadioButton examinerRadioButtonExternal;
    @FXML
    private ComboBox courseSemesterComboBox;
    @FXML
    private CheckBox roomEquipmentCableCheck;
    @FXML
    private CheckBox roomEquipmentProjectorCheck;

    @FXML
    private ToggleGroup toggleGroup;

    private ViewHandler viewHandler;
    private Region root;
    private Model model;
    private static final List VALIDESEMESTERS= new List();


    //----------ExaminerTab
    public void onExaminerComboBoxSelected(ActionEvent actionEvent) {

    }

    public void onExaminerDeleteButtonPressed(ActionEvent actionEvent) {
        Examiner examiner = (Examiner) examinerCourseComboBox.getValue();
        model.deleteExaminer(examiner);

    }

    public void onExaminerSaveButtonPressed(ActionEvent actionEvent) {
        Examiner examiner = new Examiner(examinerNameTextField.getText(), examinerPhoneTextField.getText(), examinerIdTextfield.getText(), (Course) examinerCourseComboBox.getValue(),true);
        model.saveExaminer(examiner);
    }

    //-----------COURSE TAB-----------------------------------------
    public void onCourseSaveButtonPressed(ActionEvent actionEvent) {
        String type = toggleGroup.getSelectedToggle().toString();
        System.out.println("." + courseNameTextField.getText() + ".");
        Course course = new Course(courseNameTextField.getText(), type, Integer.parseInt(courseNumberOfStudents.getText()), Integer.parseInt(courseSemesterComboBox.getValue().toString()));
        model.saveCourse(course);

    }

    public void onCourseRemoveButtonPressed(ActionEvent actionEvent) {

    }

    public void onCourseChooseComboboxSelected(ActionEvent actionEvent) {

    }
    //-------ROOM TAB---------------------------------------

    public void onRoomSaveButtonPressed(ActionEvent actionEvent) {
        try {
            Equipment equipment = new Equipment(roomEquipmentCableCheck.isSelected(), roomEquipmentProjectorCheck.isSelected(), Integer.parseInt(roomNumberOfChairsTextField.getText()), Integer.parseInt(roomNumberOfTablesTextField.getText()));
            Room room = new Room(equipment, roomNumbertextField.getText());
            model.saveRoom(room);
            System.out.println(model.getDisplayableRoomList().size());
            roomChooseComboBox.getItems().addAll(model.getDisplayableRoomList());
        } catch (Exception e) {
            e.getMessage();
        }


    }

    public void onRoomChooseComboBoxSelexted(ActionEvent actionEvent) {

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
        ArrayList<Integer> semesters = new ArrayList<>();
        semesters.add(1);
        semesters.add(2);
        semesters.add(3);
        semesters.add(4);
        courseSemesterComboBox.getItems().addAll(semesters);
        courseChooseComboBox.getItems().addAll(model.getDisplayableCourseList());
        roomChooseComboBox.getItems().addAll(model.getDisplayableRoomList());

    }

    public void reset() {
        courseChooseComboBox.getItems().addAll(model.getDisplayableCourseList());
        roomChooseComboBox.getItems().addAll(model.getDisplayableRoomList());
        examinerChooseCombobox.getItems().addAll(model.getDisplayableExaminerList());


    }

    public Region getRoot() {
        return root;
    }

    public void onGoBackButton(ActionEvent actionEvent) {
        viewHandler.closeView();
        viewHandler.openView(viewHandler.MAIN_ID);
    }

}
