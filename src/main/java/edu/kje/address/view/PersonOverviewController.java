package edu.kje.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;

import java.time.LocalDate;

import edu.kje.address.MainApp;
import edu.kje.address.model.Person;
import edu.kje.address.util.DateUtil;

public class PersonOverviewController {

    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;


    @FXML
    private Label firstNameLabel;
    @FXML 
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    private MainApp mainApp;


    /**
     * The constructor
     * The constructor is called before the initialize method
     */

     public PersonOverviewController(){

     }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */


     @FXML
     private void initialize() {
         // Initialize the person table with the two columns.
         firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
         lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

         //Clear person details
         showPersonDetails(null);

         //Listen for selection changes and show the person details when changed
         personTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));
         
     }
 
     /**
      * Is called by the main application to give a reference back to itself.
      * 
      * @param mainApp
      */
     public void setMainApp(MainApp mainApp) {
         this.mainApp = mainApp;
 
         // Add observable list data to the table
         personTable.setItems(mainApp.getPersonData());
    }

    private void showPersonDetails(Person person){
        if (person != null){
            //Fill the label with the infor from the person object
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            streetLabel.setText(person.getStreet());
            postalCodeLabel.setText(person.getPhoneNum());
            cityLabel.setText(person.getCity());

            birthdayLabel.setText(DateUtil.format(person.getBirthday()));
        }
    }

    @FXML
    private void handleDeletePerson(){
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if(selectedIndex >= 0){
            personTable.getItems().remove(selectedIndex);
        }

        else{
            //Nothing Selected
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table to delete.");

            alert.showAndWait();
        }
        
        
    }

    @FXML
    private void handleNewPerson(){
        Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditingDialog(tempPerson);
        if(okClicked){
            mainApp.getPersonData().add(tempPerson);
        }
    }

    @FXML
    private void handleEditPerson(){
        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null){
            boolean okClicked = mainApp.showPersonEditingDialog(selectedPerson);
            if(okClicked){
                showPersonDetails(selectedPerson);
            }
        }

        else {
            //Nothing Selected
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select the person you would like to edit in the table");
            
            alert.showAndWait();
        }
    }
}
    

