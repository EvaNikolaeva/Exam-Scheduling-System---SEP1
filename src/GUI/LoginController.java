package GUI;

import Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;

public class LoginController {
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField userNameField;
    @FXML
    private Button loginButton;
    @FXML
    private Label errorLabel;


    private Region root;
    private ViewHandler viewHandler;
    private Model model;

    public LoginController() {

    }

    public void init(ViewHandler viewHandler, Model model, Region root) {
        this.root = root;
        this.viewHandler = viewHandler;
        this.model = model;

        errorLabel.setText("Wrong password! Try again.");
        errorLabel.setVisible(false);
        System.out.println(errorLabel.getText());

    }

    public void reset() {
        passwordField.setText("");
        userNameField.setText("");

    }

    public Region getRoot() {
        return root;
    }

    public void LoginButtonPressed(ActionEvent actionEvent) {
        System.out.println("LoginButton Action");
        if (model.validateLogin(userNameField.getText(), passwordField.getText())) {
            viewHandler.closeView();
            viewHandler.openView("Main");
        } else {
            errorLabel.setVisible(true);

        }

    }

    public void OnEnterTyped(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            System.out.println(" Action");
            if (model.validateLogin(userNameField.getText(), passwordField.getText())) {
                viewHandler.closeView();
                viewHandler.openView("Main");
            } else {
                errorLabel.setVisible(true);

            }
            //todo: fix this enter event.

        }
    }
}
