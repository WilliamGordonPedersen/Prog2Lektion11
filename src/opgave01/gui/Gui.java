package opgave01.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import opgave01.controller.Controller;
import opgave01.models.Person;
import opgave01.models.Role;
import opgave01.storage.EaaaFileStorage;

import java.io.PrintWriter;

public class Gui extends Application {
    private TextField test = new TextField();
    private ListView<Person> personListView = new ListView<>();
    private CheckBox rdbStudent = new CheckBox("Student");
    private CheckBox rdbTeacher = new CheckBox("Teacher");


    @Override
    public void start(Stage stage) throws Exception {
        Controller controller = new Controller();
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10));
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void stop() {

    }

    private void initContent(GridPane pane) {

        pane.add(test, 0, 1);

        personListView.getItems().setAll(EaaaFileStorage.getPersons());

        Button btnAddPerson = new Button("Add Person");
        pane.add(btnAddPerson, 4, 5);
        btnAddPerson.setOnAction(event -> AddNewPerson());

        pane.add(rdbStudent, 1, 1);

        pane.add(rdbTeacher, 1, 1);


        rdbTeacher.setOnAction(event -> setStateTeacher());


        pane.add(personListView, 1, 0);

        Label inputTitle = new Label("Insert Name: ");

        VBox boxy = new VBox();
        HBox boxX = new HBox();
        HBox box2 = new HBox();

        boxy.setPadding(new Insets(10));
        boxX.setPadding(new Insets(10));
        box2.setPadding(new Insets(20));

        boxy.getChildren().addAll(personListView);
        boxX.getChildren().addAll(inputTitle, test);
        box2.getChildren().addAll(rdbStudent, rdbTeacher);

        pane.add(boxX, 0, 1);
        pane.add(boxy, 0, 0);
        pane.add(box2, 0, 2);


    }

    private void setStateTeacher() {

    }

    private void AddNewPerson() {
        Controller controller = new Controller();

        String inputUser = test.getText();

        if (inputUser.length()==0) {
            Alert beggeAdded = new Alert(Alert.AlertType.ERROR);
            beggeAdded.setHeaderText("Input fejl");
            beggeAdded.setContentText("text er tomt.");
            beggeAdded.showAndWait();
        }
        if (!rdbStudent.isSelected() && !rdbTeacher.isSelected()) {
            Alert beggeAdded = new Alert(Alert.AlertType.ERROR);
            beggeAdded.setHeaderText("Input fejl");
            beggeAdded.setContentText("Man skal vælge en rolle.");
            beggeAdded.showAndWait();
        }
        else if (rdbTeacher.isSelected() && rdbStudent.isSelected()) {
            Alert beggeAdded = new Alert(Alert.AlertType.ERROR);
            beggeAdded.setHeaderText("Input fejl");
            beggeAdded.setContentText("Man kan altså ikke være to roller på samme tid.");
            beggeAdded.showAndWait();
        }

        else if (rdbStudent.isSelected()) {
            Person person = controller.createPerson(inputUser, Role.STUDENT);
            personListView.getItems().addAll(person);
            System.out.println("Student Created");

        }
        else if (rdbTeacher.isSelected()) {
            Person person = controller.createPerson(inputUser, Role.TEACHER);
            personListView.getItems().addAll(person);
            System.out.println("Teacher Created");
        }



    }
}
