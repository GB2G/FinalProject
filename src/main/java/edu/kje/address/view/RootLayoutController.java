package edu.kje.address.view;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import edu.kje.address.MainApp;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a many bar and space where other JavaFX
 * elements can be placed
 * 
 * @author Marco Jakob
 */

public class RootLayoutController {

    //Reference the main application
    private MainApp mainApp;

    /**
     * Is called by the main application to give reference back to itself
     * 
     * @param mainApp
     */

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
    }

    /**
     * Creates an empty address book
     */

    @FXML
    private void handleNew(){
        mainApp.getPersonData().clear();
        mainApp.setPersonFilePath(null);

    }

    /**
     * Opensthe file chooser to let the user slect an addressbook to load
     */
    @FXML
    private void handleOpen(){
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show open file dialog
        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

        if (file != null) {
            mainApp.loadPersonDataFromFile(file);
        }
    }

    /**
     * Saves the file to the person file that is currently open
     * If there is no open file, Save As dialog is shown
     */
    @FXML
    private void handleSave(){
        File personFile = mainApp.getPersonFilePath();
        if (personFile != null){
            mainApp.savePersonDataToFile(personFile);
        }

        else {
            handleSaveAs();
        }
    }

    /**
     * Opens a File Chooser to let the user select a file to save to
     */
    @FXML
    private void handleSaveAs() {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter 
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save dialog
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

        if (file != null){
            //Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")){
                file = new File(file.getPath() + ".xml"); //Add .xml to the end of the file name
            }
            mainApp.savePersonDataToFile(file);
        }
    }

    
    /**
     * Opens an about dialog.
     */
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("AddressApp");
        alert.setHeaderText("About");
        alert.setContentText("Tutorial followed made by: Marco Jakob\nWebsite: http://code.makery.ch");

        alert.showAndWait();
    }

    /**
     * Opens the birthday statistics.
     */
    @FXML
    private void handleShowBirthdayStatistics() {
    mainApp.showBirthdayStatistics();
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
    
}