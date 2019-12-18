package View;

import Mediator.Model;
import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class EditController {

    @FXML
    private Label ErrorLabel;
    @FXML
    private ComboBox ExamPicker;
    @FXML
    private ComboBox TypePicker;
    @FXML
    private DatePicker DatePicker;
    @FXML
    private ComboBox Examiner1Picker;
    @FXML
    private ComboBox Examiner2Picker;
    @FXML
    private ComboBox RoomPicker;
    @FXML
    private Button BtnSave;
    @FXML
    private Button cancelButton;


    private Region root;
    private ViewHandler viewHandler;
    private Model model;


    public void init(ViewHandler viewHandler,Model model, Region root) {
        this.root = root;
        this.viewHandler = viewHandler;
        this.model=model;
        ExamPicker.getItems().addAll(model.getDisplayableCourseList());
        ArrayList<String> types = new ArrayList<>();
        types.add("Oral");
        types.add("Written");
        TypePicker.getItems().addAll(types);
        Examiner1Picker.getItems().addAll(model.getDisplayableExaminerList());
        Examiner2Picker.getItems().addAll(model.getDisplayableExaminerList());
        RoomPicker.getItems().addAll(model.getDisplayableRoomList());
    }

    public void reset() {
        ExamPicker.getItems().clear();
        TypePicker.getItems().clear();
        Examiner1Picker.getItems().clear();
        Examiner2Picker.getItems().clear();
        RoomPicker.getItems().clear();
        ExamPicker.getItems().addAll(model.getDisplayableCourseList());
        ArrayList<String> types = new ArrayList<>();
        types.add("Oral");
        types.add("Written");
        TypePicker.getItems().addAll(types);
        Examiner1Picker.getItems().addAll(model.getDisplayableExaminerList());
        Examiner2Picker.getItems().addAll(model.getDisplayableExaminerList());
        RoomPicker.getItems().addAll(model.getDisplayableRoomList());
    }

    public Region getRoot() {
        return root;
    }

    public void onSaveButtonPressed(ActionEvent actionEvent) {
        LocalDate date= DatePicker.getValue();
        Month month=date.getMonth();
        MyDate mydate = new MyDate(date.getDayOfMonth(), month.getValue(), date.getYear());
        Examiner examiner = (Examiner)Examiner1Picker.getValue();
        Examiner examiner2 = (Examiner)Examiner2Picker.getValue();
        Room room = (Room)RoomPicker.getValue();
        Course course = (Course)ExamPicker.getValue();
        Exam exam = new Exam(mydate, course, room, examiner);
        viewHandler.closeView();
        viewHandler.openView(viewHandler.MAIN_ID);
    }

    public void onCancelButtonPressed(ActionEvent actionEvent) {
        viewHandler.closeView();
        viewHandler.openView(viewHandler.MAIN_ID);
    }
}
