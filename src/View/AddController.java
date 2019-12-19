package View;

import Mediator.*;
import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

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

    private Region root;
    private ViewHandler viewHandler;
    private Model model;


    public void init(ViewHandler viewHandler, Model model, Region root) {
        this.root = root;
        this.viewHandler = viewHandler;
        this.model = model;
        reset();
    }

    public void reset() {
        ExamPicker.getItems().clear();
        Examiner1Picker.getItems().clear();
        Examiner2Picker.getItems().clear();
        roomCombobox.getItems().clear();
        ExamPicker.getItems().addAll(model.getDisplayableCourseList());
        Examiner1Picker.getItems().addAll(model.getDisplayableExaminerList());
        Examiner2Picker.getItems().addAll(model.getDisplayableExaminerList());
        roomCombobox.getItems().addAll(model.getDisplayableRoomList());
    }

    public Region getRoot() {
        init(viewHandler, model, root);
        return this.root;
    }


    public void onSavePressed(ActionEvent actionEvent) throws IOException
    {
        //todo: add save logic.
        LocalDate date= DatePicker.getValue();
        Month month=date.getMonth();
        MyDate mydate = new MyDate(date.getDayOfMonth(), month.getValue(), date.getYear());
        Examiner examiner = (Examiner)Examiner1Picker.getValue();
        Examiner examiner2 = (Examiner)Examiner2Picker.getValue();
        Room room = (Room)roomCombobox.getValue();
        Course course = (Course)ExamPicker.getValue();
        Exam exam = new Exam(mydate, course, room, examiner, examiner2);
        model.saveExam(exam);

        viewHandler.closeView();
        viewHandler.openView(viewHandler.MAIN_ID);
    }

    public void onCancelPressed(ActionEvent actionEvent) {
        viewHandler.closeView();
        viewHandler.openView(viewHandler.MAIN_ID);
    }
}
