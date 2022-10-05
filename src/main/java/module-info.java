module pack1.viewsLoad {
    requires javafx.controls;
    requires javafx.fxml;


    opens pack1 to javafx.fxml;
    exports pack1;
    exports  ControllerPersons;
    exports ControllerRun;
    exports ControllersLoad;
    opens ControllerRun to javafx.fxml;
}