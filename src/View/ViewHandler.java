package View;

import Mediator.Model;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Stage;


public class ViewHandler {
    public static final String LOGIN = "Login.fxml";
    public static final String MAIN = "Main.fxml";
    public static final String ADD = "Add.fxml";
    public static final String EDIT = "Edit.fxml";
    public static final String REMOVE = "Remove.fxml";
    public static final String MANAGE = "ManageData.fxml";

    public static final String MAIN_ID = "Main";
    public static final String ADD_ID = "Add";
    public static final String EDIT_ID = "Edit";
    public static final String REMOVE_ID = "Remove";
    public static final String LOGIN_ID = "Login";
    public static final String MANAGE_ID = "Manage";

    private MainController mainController;
    private AddController addController;
    private RemoveController removeController;
    private EditController editController;
    private LoginController loginController;
    private ManageDataController manageDataController;

    private Scene currentScene;
    private Stage primaryStage;
    private Model model;


    public ViewHandler(Model model) {

        currentScene = new Scene(loadLoginView());
        this.model = model;
    }

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        openView(LOGIN);
    }

    public void openView(String id) {
        String title = "";
        Region root = null;
        switch (id) {
            case MAIN_ID:
                root = loadMainView();
                title = MAIN_ID;
                break;
            case ADD_ID:
                root = loadAddView();
                title = ADD_ID;
                break;
            case EDIT_ID:
                root = loadEditView();
                title = EDIT_ID;
                break;
            case LOGIN:
                root = loadLoginView();
                title = LOGIN_ID;
                break;
            case MANAGE_ID:
                root = loadManageView();
                title = MANAGE_ID;
                break;
            case REMOVE_ID:
                root = loadRemoveView();
                title = REMOVE_ID;
                break;
        }
        currentScene.setRoot(root);
        primaryStage.setTitle(title);
        primaryStage.getIcons().add(new Image("Icon.png"));
        primaryStage.setScene(currentScene);
//            primaryStage.setWidth(root.getPrefWidth());
//            primaryStage.setHeight(root.getPrefHeight());
        primaryStage.show();
    }

    private Region loadRemoveView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(REMOVE));
            Region root = loader.load();
            removeController = loader.getController();
            removeController.init(this, model, root);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return removeController.getRoot();
    }

    private Region loadManageView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(MANAGE));
            Region root = loader.load();
            manageDataController = loader.getController();
            manageDataController.init(this, model, root);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return manageDataController.getRoot();
    }


    private Region loadLoginView() {
        {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(LOGIN));
                Region root = loader.load();
                loginController = loader.getController();
                loginController.init(this, model, root);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return loginController.getRoot();
        }
    }

    public void closeView() {
        primaryStage.close();
    }

    private Region loadEditView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(EDIT));
            Region root = loader.load();
            editController = loader.getController();
            editController.init(this, model, root);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return editController.getRoot();
    }


    private Region loadAddView() {
        {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(ADD));
                Region root = loader.load();
                addController = loader.getController();
                addController.init(this, model, root);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return addController.getRoot();
        }
    }


    public Region loadMainView() {
        {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(MAIN));
                Region root = loader.load();

                mainController = loader.getController();
                mainController.init(this, model, root);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return mainController.getRoot();
        }

    }
}
