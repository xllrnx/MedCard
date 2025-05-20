module org.example.medcard {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires org.slf4j;
    requires jbcrypt;


    opens org.example.medcard to javafx.fxml;
    exports org.example.medcard;
    exports org.example.medcard.Controllers;
    opens org.example.medcard.Controllers to javafx.fxml;
    exports org.example.medcard.Controllers.Doctor;
    opens org.example.medcard.Controllers.Doctor to javafx.fxml;
    opens org.example.medcard.Models;
    opens org.example.medcard.Views;
    opens org.example.medcard.Views.Doctor.CellFactories;
    exports org.example.medcard.Controllers.Doctor.CellControllers;
    opens org.example.medcard.Controllers.Doctor.CellControllers to javafx.fxml;
    exports org.example.medcard.Controllers.Doctor.WindowControllers;
    opens org.example.medcard.Controllers.Doctor.WindowControllers to javafx.fxml;
    opens org.example.medcard.Models.Records;
    exports org.example.medcard.Controllers.Doctor.WindowControllers.ListviewWindows;
    opens org.example.medcard.Controllers.Doctor.WindowControllers.ListviewWindows to javafx.fxml;
    exports org.example.medcard.Controllers.Doctor.WindowControllers.DialogWindows.DiagnosisRecord;
    opens org.example.medcard.Controllers.Doctor.WindowControllers.DialogWindows.DiagnosisRecord to javafx.fxml;
    exports org.example.medcard.Controllers.Doctor.WindowControllers.DialogWindows.Patient;
    opens org.example.medcard.Controllers.Doctor.WindowControllers.DialogWindows.Patient to javafx.fxml;
    exports org.example.medcard.Controllers.Doctor.WindowControllers.DialogWindows.TemperatureSheetRecord;
    opens org.example.medcard.Controllers.Doctor.WindowControllers.DialogWindows.TemperatureSheetRecord to javafx.fxml;
    exports org.example.medcard.Controllers.Doctor.WindowControllers.DialogWindows.TreatmentRecord;
    opens org.example.medcard.Controllers.Doctor.WindowControllers.DialogWindows.TreatmentRecord to javafx.fxml;
    exports org.example.medcard.Utils.Logger;
    opens org.example.medcard.Utils.Logger to javafx.fxml;
    exports org.example.medcard.Utils.Enums;
    opens org.example.medcard.Utils.Enums;
}