module org.example.nxtvvapelounge {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.nxtvvapelounge to javafx.fxml;
    exports org.example.nxtvvapelounge;
    exports org.example.nxtvvapelounge.Controllers;
    opens org.example.nxtvvapelounge.Controllers to javafx.fxml;
}