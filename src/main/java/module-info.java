module org.example.medcard {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens org.example.medcard to javafx.fxml;
    exports org.example.medcard;
    exports org.example.medcard.Controllers;
    opens org.example.medcard.Controllers to javafx.fxml;
    exports org.example.medcard.Controllers.Doctor;
    opens org.example.medcard.Controllers.Doctor to javafx.fxml;
    exports org.example.medcard.Controllers.Nurse;
    opens org.example.medcard.Controllers.Nurse to javafx.fxml;
    opens org.example.medcard.Models;
    opens org.example.medcard.Views;
    exports org.example.medcard.Utils;
    opens org.example.medcard.Utils to javafx.fxml;
    opens org.example.medcard.Views.CellFactories;
    exports org.example.medcard.Controllers.Doctor.CellControllers;
    opens org.example.medcard.Controllers.Doctor.CellControllers to javafx.fxml;
    exports org.example.medcard.Controllers.Doctor.DashboardsControllers;
    opens org.example.medcard.Controllers.Doctor.DashboardsControllers to javafx.fxml;
    exports org.example.medcard.Controllers.Doctor.AddRecordsControllers;
    opens org.example.medcard.Controllers.Doctor.AddRecordsControllers to javafx.fxml;
}