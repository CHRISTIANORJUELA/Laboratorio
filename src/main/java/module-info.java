module com.example.laboratory {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.laboratory to javafx.fxml;
    exports com.example.laboratory;
    exports com.example.laboratory.controllers;
    opens com.example.laboratory.controllers to javafx.fxml;
    opens com.example.laboratory.models to javafx.base;
}