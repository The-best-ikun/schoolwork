module com.suep.demo06_25 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.desktop;
    requires mysql.connector.j;
    requires java.sql;

    opens com.suep.demo06_25 to javafx.fxml;
    exports com.suep.demo06_25;
    exports com.suep.demo06_25.controller;
    opens com.suep.demo06_25.controller to javafx.fxml;
}