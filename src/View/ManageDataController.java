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
    private ComboBox courseSemesterComboBox;
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
    private static final List VALIDESEMESTERS= new List();

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
        else
        {
            examinerRadioButtonInternal.setSelected(false);
            examinerRadioButtonExternal.setSelected(false);
        }
        this.examinerSelected = true;

    }

    public void onExaminerDeleteButtonPressed(ActionEvent actionEvent) throws FileNotFoundException
    {
        Examiner examiner = examinerChooseCombobox.getSelectionModel().getSelectedItem();
        model.deleteExaminer(examiner);
        reset();
    }

    public void onExaminerSaveButtonPressed(ActionEvent actionEvent) throws FileNotFoundException
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
    public void onCourseSaveButtonPressed(ActionEvent actionEvent) throws FileNotFoundException
    {
        if(!(courseSelected))
        {
            String type = toggleGroupCourse.getSelectedToggle().toString();
            Course course = new Course(courseNameTextField.getText(), type, Integer.parseInt(courseNumberOfStudents.getText()),
                    Integer.parseInt(courseSemesterComboBox.getValue().toString()));
            model.saveCourse(course);
            reset();
        }
        if(courseSelected)
        {
            model.deleteCourse((Course)courseChooseComboBox.getSelectionModel().getSelectedItem());
            String type = toggleGroupCourse.getSelectedToggle().toString();
            Course course = new Course(courseNameTextField.getText(), type, Integer.parseInt(courseNumberOfStudents.getText()),
                    Integer.parseInt(courseSemesterComboBox.getValue().toString()));
            model.saveCourse(course);
            model.orderCourseList();
            this.courseSelected = false;
            reset();
        }
    }

    public void onCourseRemoveButtonPressed(ActionEvent actionEvent) throws FileNotFoundException
    {
        Course course = (Course) courseChooseComboBox.getValue();
        model.deleteCourse(course);
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
        else
        {
            courseTypeOralRadioButton.setSelected(false);
            courseTypeWrittenRadioButton.setSelected(false);
        }
        this.courseSelected = true;
    }
    //-------ROOM TAB---------------------------------------

    public void onRoomSaveButtonPressed(ActionEvent actionEvent) throws FileNotFoundException
    {
            if(!(roomSelected))
            {
                Equipment equipment = new Equipment(roomEquipmentCableCheck.isSelected(), roomEquipmentProjectorCheck.isSelected(), Integer.parseInt(roomNumberOfChairsTextField.getText()), Integer.parseInt(roomNumberOfTablesTextField.getText()));
                Room room = new Room(equipment, roomNumbertextField.getText());
                model.saveRoom(room);
                model.orderRoomList();
                roomChooseComboBox.getItems().clear();
                roomChooseComboBox.getItems().addAll(model.getDisplayableRoomList());
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

    public void onRoomRemoveButtonPressed(ActionEvent actionEvent) throws FileNotFoundException
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

        courseTypeWrittenRadioButton.setToggleGroup(toggleGroupCourse);
        courseTypeOralRadioButton.setToggleGroup(toggleGroupCourse);

        examinerRadioButtonExternal.setToggleGroup(toggleGroupExaminer);
        examinerRadioButtonInternal.setToggleGroup(toggleGroupExaminer);


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
        courseChooseComboBox.getItems().clear();
        roomChooseComboBox.getItems().clear();
        examinerCourseComboBox.getItems().clear();
        examinerCourseComboBox.getItems().clear();

        courseChooseComboBox.getItems().addAll(model.getDisplayableCourseList());
        roomChooseComboBox.getItems().addAll(model.getDisplayableRoomList());
        examinerChooseCombobox.getItems().addAll(model.getDisplayableExaminerList());
        examinerCourseComboBox.getItems().addAll(model.getDisplayableCourseList());

        roomEquipmentCableCheck.setSelected(false);
        roomEquipmentProjectorCheck.setSelected(false);
        roomNumbertextField.setText("");
        roomNumberOfChairsTextField.setText("");
        roomNumberOfTablesTextField.setText("");

    }

    public Region getRoot() {
        return root;
    }

    public void onGoBackButton(ActionEvent actionEvent) {
        viewHandler.closeView();
        viewHandler.openView(viewHandler.MAIN_ID);
    }

}
