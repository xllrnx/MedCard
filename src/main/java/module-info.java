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
    exports org.example.medcard.Controllers.Doctor.CellControllers;
    opens org.example.medcard.Controllers.Doctor.CellControllers to javafx.fxml;
    exports org.example.medcard.Controllers.Doctor.WindowControllers;
    opens org.example.medcard.Controllers.Doctor.WindowControllers to javafx.fxml;
    opens org.example.medcard.Models.Records;
    opens org.example.medcard.Utils;
    exports org.example.medcard.Controllers.Doctor.WindowControllers.ListviewWindows;
    opens org.example.medcard.Controllers.Doctor.WindowControllers.ListviewWindows to javafx.fxml;
    exports org.example.medcard.Controllers.Doctor.RecordControllers.DiagnosisRecord;
    opens org.example.medcard.Controllers.Doctor.RecordControllers.DiagnosisRecord to javafx.fxml;
    exports org.example.medcard.Controllers.Doctor.RecordControllers.Patient;
    opens org.example.medcard.Controllers.Doctor.RecordControllers.Patient to javafx.fxml;
    exports org.example.medcard.Controllers.Doctor.RecordControllers.TemperatureSheetRecord;
    opens org.example.medcard.Controllers.Doctor.RecordControllers.TemperatureSheetRecord to javafx.fxml;
    exports org.example.medcard.Controllers.Doctor.RecordControllers.TreatmentRecord;
    opens org.example.medcard.Controllers.Doctor.RecordControllers.TreatmentRecord to javafx.fxml;
}