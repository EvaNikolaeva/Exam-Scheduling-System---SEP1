package GUI;

import Model.Model;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Region;

public class RemoveController {
    public ComboBox deleteExamCombobox;
    private ViewHandler viewHandler;
    private Region root;
    private Model model;


    public void init(ViewHandler viewHandler, Model model, Region root) {
        this.root = root;
        this.viewHandler = viewHandler;
        this.model=model;
    }

    public void reset() {
    }

    public Region getRoot() {
        return this.root;
    }

    public void onDeleteExamButton(ActionEvent actionEvent) {
        //Todo: add delete logic.
        viewHandler.closeView();
        viewHandler.openView(viewHandler.MAIN_ID);
    }

    public void onCancelButton(ActionEvent actionEvent) {
        viewHandler.closeView();
        viewHandler.openView(viewHandler.MAIN_ID);
    }
}
