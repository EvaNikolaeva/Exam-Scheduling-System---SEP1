package View;

import Mediator.Model;
import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Region;
import javafx.scene.control.DatePicker;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class EditController {
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

    private Region root;
    private ViewHandler viewHandler;
    private Model model;

    public void init(ViewHandler viewHandler,Model model, Region root) {
        this.root = root;
        this.viewHandler = viewHandler;
        this.model=model;

        ArrayList<String> types = new ArrayList<>();
        types.add("Oral");
        types.add("Written");
        TypePicker.getItems().clear();
        TypePicker.getItems().addAll(types);

        reset();
    }

    public void reset() {
        ExamPicker.getItems().clear();
        Examiner1Picker.getItems().clear();
        Examiner2Picker.getItems().clear();
        RoomPicker.getItems().clear();

        ExamPicker.getItems().addAll(model.getDisplayableExamList());
        Examiner1Picker.getItems().addAll(model.getDisplayableExaminerList());
        Examiner2Picker.getItems().addAll(model.getDisplayableExaminerList());
        RoomPicker.getItems().addAll(model.getDisplayableRoomList());
    }

    public Region getRoot() {
        return root;
    }

    public void onSaveButtonPressed(ActionEvent actionEvent) throws IOException
    {
        model.deleteExam((Exam)ExamPicker.getSelectionModel().getSelectedItem());
        LocalDate date= DatePicker.getValue();
        Month month=date.getMonth();
        MyDate mydate = new MyDate(date.getDayOfMonth(), month.getValue(), date.getYear());
        Examiner examiner = (Examiner)Examiner1Picker.getValue();
        Examiner examiner2 = (Examiner)Examiner2Picker.getValue();
        Room room = (Room)RoomPicker.getValue();
        Course course = (Course)ExamPicker.getValue();
        Exam exam = new Exam(mydate, course, room, examiner, examiner2);
        model.saveExam(exam);

        viewHandler.closeView();
        viewHandler.openView(viewHandler.MAIN_ID);
    }

    public void onCancelButtonPressed(ActionEvent actionEvent) {
        viewHandler.closeView();
        viewHandler.openView(viewHandler.MAIN_ID);
    }
}
