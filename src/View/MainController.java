package View;

import Mediator.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Region;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import Model.Exam;

public class MainController{

    public MenuItem mainMenuItemAbout;

    private ViewHandler viewHandler;
    private Region root;
    private Model model;

    @FXML
    private ListView<Exam> listView;


    public void onAddExamBtn(ActionEvent actionEvent) {
        viewHandler.closeView();
        viewHandler.openView(viewHandler.ADD_ID);
    }

    public void onEditExamBtn(ActionEvent actionEvent) {
        viewHandler.closeView();
        viewHandler.openView(viewHandler.EDIT_ID);

    }

    public void onRemoveExamBtn(ActionEvent actionEvent) {
        viewHandler.closeView();
        viewHandler.openView(viewHandler.REMOVE_ID);
    }

    public void onExportBtn(ActionEvent actionEvent) {

    }

    public void onManageDataBtn(ActionEvent actionEvent) {
        viewHandler.closeView();
        viewHandler.openView(viewHandler.MANAGE_ID);
    }

    public void init(ViewHandler viewHandler, Model model, Region root) {
        this.root = root;
        this.viewHandler = viewHandler;
        this.model=model;

        reset();
    }

    public void reset() {
        listView.getItems().clear();
        listView.getItems().addAll(model.getDisplayableExamList());
    }

    public Region getRoot() {
        return this.root;
    }

    public void onMenuItemSelected(ActionEvent actionEvent) {
        try{
            URL homepage= new URL("file:///E:/SEP1/Exam-Scheduling-System-SEP1/WebSite/aboutus.html");
            openWebpage(homepage);
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
    }

    public static boolean openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean openWebpage(URL url) {
        try {
            return openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void onMainMenuItemSelected(ActionEvent actionEvent) {
        viewHandler.closeView();
    }
}
