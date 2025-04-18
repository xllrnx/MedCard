module org.example.medcard {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires org.slf4j;


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
    opens org.example.medcard.Views.Doctor.CellFactories;
    exports org.example.medcard.Controllers.Doctor.CellsControllers;
    opens org.example.medcard.Controllers.Doctor.CellsControllers to javafx.fxml;
    exports org.example.medcard.Controllers.Doctor.WindowsControllers;
    opens org.example.medcard.Controllers.Doctor.WindowsControllers to javafx.fxml;
    opens org.example.medcard.Models.Records;
    opens org.example.medcard.Utils;
    exports org.example.medcard.Controllers.Doctor.WindowsControllers.ListviewWindows;
    opens org.example.medcard.Controllers.Doctor.WindowsControllers.ListviewWindows to javafx.fxml;
    exports org.example.medcard.Controllers.Doctor.RecordsControllers.DiagnosisRecord;
    opens org.example.medcard.Controllers.Doctor.RecordsControllers.DiagnosisRecord to javafx.fxml;
    exports org.example.medcard.Controllers.Doctor.RecordsControllers.Patient;
    opens org.example.medcard.Controllers.Doctor.RecordsControllers.Patient to javafx.fxml;
    exports org.example.medcard.Controllers.Doctor.RecordsControllers.TemperatureSheetRecord;
    opens org.example.medcard.Controllers.Doctor.RecordsControllers.TemperatureSheetRecord to javafx.fxml;
    exports org.example.medcard.Controllers.Doctor.RecordsControllers.TreatmentRecord;
    opens org.example.medcard.Controllers.Doctor.RecordsControllers.TreatmentRecord to javafx.fxml;
}