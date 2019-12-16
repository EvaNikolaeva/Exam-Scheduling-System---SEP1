package GUI;

import Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import Model.Course;
import Model.Examiner;
import Model.Equipment;
import Model.*;

import java.util.ArrayList;

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
    public TextField examinerPhoneTextField;

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
    public TextField roomNumberOfTablesTextField;
    @FXML
    public ComboBox roomChooseComboBox;
    @FXML
    public Button roomRemoveButton;


    @FXML
    public TextField examinerIdTextfield;
    @FXML
    public RadioButton examinerRadioButtonInternal;
    @FXML
    public RadioButton examinerRadioButtonExtarnal;
    @FXML
    public ComboBox courseSemesterComboBox;
    public CheckBox roomEquipmentCableCheck;
    public CheckBox roomEquipmentProjectorCheck;

    @FXML ToggleGroup toggleGroup;

    private ViewHandler viewHandler;
    private Region root;
    private Model model;



    //----------ExaminerTab
    public void onExaminerComboBoxSelected(ActionEvent actionEvent) {

    }

    public void onExaminerDeleteButtonPressed(ActionEvent actionEvent) {
        Examiner examiner= (Examiner) examinerCourseComboBox.getValue();
        model.deleteExaminer(examiner);

    }
    public void onExaminerSaveButtonPressed(ActionEvent actionEvent) {
        Examiner examiner= new Examiner(examinerNameTextField.getText(),examinerPhoneTextField.getText(),examinerIdTextfield.getText(), (Course) examinerCourseComboBox.getValue());
        model.saveExaminer(examiner);
    }
    //-----------COURSE TAB-----------------------------------------
    public void onCourseSaveButtonPressed(ActionEvent actionEvent) {
        String type= toggleGroup.getSelectedToggle().toString();
        System.out.println("."+courseNameTextField.getText()+".");
        Course course= new Course(courseNameTextField.getText(),type,Integer.parseInt(courseNumberOfStudents.getText()),Integer.parseInt(courseSemesterComboBox.getValue().toString()));
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
        }catch (Exception e){
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
        ArrayList<Integer> semesters= new ArrayList<>();
        semesters.add(1);semesters.add(2); semesters.add(3);
        courseSemesterComboBox.getItems().addAll(semesters);
        courseChooseComboBox.getItems().addAll(model.getDisplayableCourseList());
        roomChooseComboBox.getItems().addAll(model.getDisplayableRoomList());

    }

    public void reset() {
        courseChooseComboBox.getItems().addAll(model.getDisplayableCourseList());
        roomChooseComboBox.getItems().addAll(model.getDisplayableRoomList());


    }

    public Region getRoot() {
        return root;
    }

    public void onGoBackButton(ActionEvent actionEvent) {
        viewHandler.closeView();
        viewHandler.openView(viewHandler.MAIN_ID);
    }

}
