package edu.kje.address;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import edu.kje.address.model.Person;
import edu.kje.address.view.PersonEditDialogController;
import edu.kje.address.view.PersonOverviewController;

/**
 * JavaFX App
 */
public class MainApp extends Application {

    /**
     * The data is an observable list of Persons
     */

	private ObservableList<Person> personData = FXCollections.observableArrayList();

	/**
	 * Constructor
	 */
	public MainApp() {
		// Add some sample data
		personData.add(new Person("Hans", "Muster"));
		personData.add(new Person("Ruth", "Mueller"));
		personData.add(new Person("Heinz", "Kurz"));
		personData.add(new Person("Cornelia", "Meier"));
		personData.add(new Person("Werner", "Meyer"));
		personData.add(new Person("Lydia", "Kunz"));
		personData.add(new Person("Anna", "Best"));
		personData.add(new Person("Stefan", "Meier"));
		personData.add(new Person("Martin", "Mueller"));
	}
  
	/**
	 * Returns the data as an observable list of Persons. 
	 * @return
	 */
	public ObservableList<Person> getPersonData() {
		return personData;
	}

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Address App");

        //set the app icon
        this.primaryStage.getIcons().add(new Image("file:resources/address_book_32.png"));

        initRootLayout();
        showPersonOverview();

    }


    public void initRootLayout(){
        try {
            //Load the layout from FXML File
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            //Show the scene containing Root Layout
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout 
     * */

    public void showPersonOverview() {
        
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of the root layout
            rootLayout.setCenter(personOverview);

            //Give the controller access to the main app
            PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public boolean showPersonEditingDialog(Person person){
        try{
            //Load the fxml file and create a new stage and popup dialog
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            //Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person Details");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            //Set the person into the controller
            PersonEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            //Show the dialog window until the user closes it
            dialogStage.showAndWait();

            return controller.isOKClicked();

        } catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Returns the main stage
     * @return
     */
    public Stage getPrimaryStage(){
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

}