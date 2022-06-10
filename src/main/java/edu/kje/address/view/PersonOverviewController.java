package edu.kje.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import edu.kje.address.MainApp;
import edu.kje.address.model.Person;

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
 }
//https://code.makery.ch/library/javafx-tutorial/part2/
    
}
