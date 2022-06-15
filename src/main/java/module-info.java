module edu.kje.address {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.prefs;
    requires java.xml.bind;

    opens edu.kje.address to javafx.fxml;
    opens edu.kje.address.model to java.xml.bind;
    opens edu.kje.address.view to javafx.fxml;
    exports edu.kje.address;
    exports edu.kje.address.util to com.sum.xml.bind;
}
