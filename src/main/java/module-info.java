module edu.kje.address {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.prefs;

    opens edu.kje.address to javafx.fxml;
    opens edu.kje.address.view to javafx.fxml;
    exports edu.kje.address;
}
