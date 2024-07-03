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
//    requires rt;
//    requires jfxrt;

    opens com.suep.demo06_25 to javafx.fxml;
    exports com.suep.demo06_25;
    exports com.suep.demo06_25.controller;
    opens com.suep.demo06_25.controller to javafx.fxml;
    // 打开pojo包给javafx.base模块
    opens com.suep.demo06_25.pojo to javafx.base;




    exports com.suep.demo06_25.controller.admin;
    // 如果需要反射访问，则使用opens而不是exports
    // opens com.suep.demo06_25.controller.admin to javafx.fxml;
    // 使用opens而不是exports，以允许反射访问
    opens com.suep.demo06_25.controller.admin to javafx.fxml;
    exports com.suep.demo06_25.controller.student;
    opens com.suep.demo06_25.controller.student to javafx.fxml;
    exports com.suep.demo06_25.controller.teacher;
    opens com.suep.demo06_25.controller.teacher to javafx.fxml;
}