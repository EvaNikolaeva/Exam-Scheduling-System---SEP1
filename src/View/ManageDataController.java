package View;

import Mediator.Model;
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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ManageDataController {
    @FXML
    private TextField examinerNameTextField;
    @FXML
    private Button examinerSaveButton;
    @FXML
    private ComboBox<Examiner> examinerChooseCombobox;
    @FXML
    private Button examinerDeleteButton;
    @FXML
    private ComboBox<Course> examinerCourseComboBox;

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
    private ComboBox<Course> courseChooseComboBox;

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
    private CheckBox roomEquipmentCableCheck;
    @FXML
    private CheckBox roomEquipmentProjectorCheck;

    @FXML
    private ToggleGroup toggleGroupCourse;

    @FXML
    private ToggleGroup toggleGroupExaminer;

    private ViewHandler viewHandler;
    private Region root;
    private Model model;

    private boolean examinerSelected;
    private boolean courseSelected;
    private boolean roomSelected;

    //----------ExaminerTab------------------------------------------------
    public void onExaminerComboBoxSelected(ActionEvent actionEvent) {
        Examiner examiner = (Examiner)examinerChooseCombobox.getValue();
        examinerNameTextField.setText(examiner.getName());
        examinerPhoneTextField.setText(examiner.getPhoneNumber());
        examinerIdTextfield.setText(examiner.getTeacherId());
        examinerCourseComboBox.getSelectionModel().select(examiner.getCourse());
        examinerRadioButtonInternal.setSelected(false);
        examinerRadioButtonExternal.setSelected(false);
        if(examiner.isExternal())
        {
            examinerRadioButtonExternal.fire();
        }
        else if(!(examiner.isExternal()))
        {
            examinerRadioButtonInternal.fire();
        }
        this.examinerSelected = true;
    }

    public void onExaminerDeleteButtonPressed(ActionEvent actionEvent) throws IOException
    {
        Examiner examiner = examinerChooseCombobox.getSelectionModel().getSelectedItem();
        model.deleteExaminer(examiner);
        reset();
    }

    public void onExaminerSaveButtonPressed(ActionEvent actionEvent) throws IOException
    {
            if (!(examinerSelected))
            {
                Examiner examiner = new Examiner(examinerNameTextField.getText(), examinerPhoneTextField.getText(),
                        examinerIdTextfield.getText(), (Course) examinerCourseComboBox.getValue(), examinerRadioButtonExternal.isSelected());
                model.saveExaminer(examiner);
                reset();
            }
            if(examinerSelected)
            {
                model.deleteExaminer((Examiner)examinerChooseCombobox.getSelectionModel().getSelectedItem());
                Examiner examiner = new Examiner(examinerNameTextField.getText(), examinerPhoneTextField.getText(),
                        examinerIdTextfield.getText(), (Course) examinerCourseComboBox.getValue(), examinerRadioButtonExternal.isSelected());
                model.saveExaminer(examiner);
                model.orderExaminerList();
                this.examinerSelected = false;
                reset();
            }
    }

    //-----------COURSE TAB-----------------------------------------
    public void onCourseSaveButtonPressed(ActionEvent actionEvent) throws IOException
    {
        if(!(courseSelected))
        {
            String type = (String) toggleGroupCourse.getSelectedToggle().getUserData();
            Course course = new Course(courseNameTextField.getText(), type, Integer.parseInt(courseNumberOfStudents.getText()));
            model.saveCourse(course);
            reset();
        }
        if(courseSelected)
        {
            model.deleteCourse(courseChooseComboBox.getSelectionModel().getSelectedItem().getName());
            String type = toggleGroupCourse.getSelectedToggle().toString();
            Course course = new Course(courseNameTextField.getText(), type, Integer.parseInt(courseNumberOfStudents.getText()));
            model.saveCourse(course);
            model.orderCourseList();
            this.courseSelected = false;
            reset();
        }
    }

    public void onCourseRemoveButtonPressed(ActionEvent actionEvent) throws IOException
    {
        model.deleteCourse(courseChooseComboBox.getValue().getName());
        this.courseSelected = false;
        reset();
    }

    public void onCourseChooseComboboxSelected(ActionEvent actionEvent) {
        Course course = courseChooseComboBox.getSelectionModel().getSelectedItem();
        courseNameTextField.setText(course.getName());
        courseNumberOfStudents.setText(Integer.toString(course.getNumberOfStudents()));
        courseTypeOralRadioButton.setSelected(false);
        courseTypeWrittenRadioButton.setSelected(false);

        if(course.getType().equalsIgnoreCase("Written"))
        {
            courseTypeWrittenRadioButton.fire();
        }
        else if(course.getType().equalsIgnoreCase("Oral"))
        {
            courseTypeOralRadioButton.fire();
        }

        this.courseSelected = true;
    }
    //-------ROOM TAB---------------------------------------

    public void onRoomSaveButtonPressed(ActionEvent actionEvent) throws IOException
    {

            if(!(roomSelected))
            {
                Equipment equipment = new Equipment(roomEquipmentCableCheck.isSelected(), roomEquipmentProjectorCheck.isSelected(), Integer.parseInt(roomNumberOfChairsTextField.getText()), Integer.parseInt(roomNumberOfTablesTextField.getText()));
                Room room = new Room(equipment, roomNumbertextField.getText());
                model.saveRoom(room);
                model.orderRoomList();
                reset();
            }
            if(roomSelected)
            {
                model.deleteRoom((Room)roomChooseComboBox.getSelectionModel().getSelectedItem());
                Equipment equipment = new Equipment(roomEquipmentCableCheck.isSelected(), roomEquipmentProjectorCheck.isSelected(), Integer.parseInt(roomNumberOfChairsTextField.getText()), Integer.parseInt(roomNumberOfTablesTextField.getText()));
                Room room = new Room(equipment, roomNumbertextField.getText());
                model.saveRoom(room);
                model.orderRoomList();
                this.roomSelected = false;
                reset();
            }

    }

    public void onRoomChooseComboBoxSelected(ActionEvent actionEvent) {
        Room room = (Room)roomChooseComboBox.getSelectionModel().getSelectedItem();
        roomNumbertextField.setText(room.getRoom());
        roomNumberOfChairsTextField.setText(Integer.toString(room.getEquipment().getNumberOfChairs()));
        roomNumberOfTablesTextField.setText(Integer.toString(room.getEquipment().getNumberOfTables()));
        roomEquipmentCableCheck.setSelected(false);
        roomEquipmentProjectorCheck.setSelected(false);
        if(room.getEquipment().getCables())
        {
            roomEquipmentCableCheck.fire();
        }
        if(room.getEquipment().getProjector())
        {
            roomEquipmentProjectorCheck.fire();
        }
        this.roomSelected = true;
    }

    public void onRoomRemoveButtonPressed(ActionEvent actionEvent) throws IOException
    {
        Room room = (Room) roomChooseComboBox.getValue();
        model.deleteRoom(room);
        reset();
    }
    //-----------------------------------------------------------------

    public void init(ViewHandler viewHandler, Model model, Region root) {
        this.root = root;
        this.viewHandler = viewHandler;
        this.model = model;
        reset();
    }

    public void reset(){
        courseTypeWrittenRadioButton.setToggleGroup(toggleGroupCourse);
        courseTypeOralRadioButton.setToggleGroup(toggleGroupCourse);

        examinerRadioButtonExternal.setToggleGroup(toggleGroupExaminer);
        examinerRadioButtonInternal.setToggleGroup(toggleGroupExaminer);

        courseTypeWrittenRadioButton.setUserData(new String("written"));
        courseTypeOralRadioButton.setUserData(new String("oral"));
        examinerRadioButtonInternal.setUserData(new String("internal"));
        examinerRadioButtonExternal.setUserData(new String("external"));

        examinerNameTextField.setText("");
        examinerPhoneTextField.setText("");
        examinerIdTextfield.setText("");

        courseNameTextField.setText("");
        courseNumberOfStudents.setText("");

        roomNumbertextField.setText("");
        roomNumberOfChairsTextField.setText("");
        roomNumberOfTablesTextField.setText("");

        courseChooseComboBox.getItems().clear();
        roomChooseComboBox.getItems().clear();
        examinerCourseComboBox.getItems().clear();
        examinerChooseCombobox.getItems().clear();

        examinerRadioButtonInternal.setSelected(false);
        examinerRadioButtonExternal.setSelected(false);
        courseTypeOralRadioButton.setSelected(false);
        courseTypeWrittenRadioButton.setSelected(false);
        roomEquipmentCableCheck.setSelected(false);
        roomEquipmentProjectorCheck.setSelected(false);

        courseChooseComboBox.getItems().addAll(model.getDisplayableCourseList());
        examinerCourseComboBox.getItems().addAll(model.getDisplayableCourseList());
        roomChooseComboBox.getItems().addAll(model.getDisplayableRoomList());
        examinerChooseCombobox.getItems().addAll(model.getDisplayableExaminerList());
    }

    public Region getRoot() {
        init(viewHandler,model,root);
        return root;
    }

    public void onGoBackButton(ActionEvent actionEvent) {
        viewHandler.closeView();
        viewHandler.openView(viewHandler.MAIN_ID);
    }

}
