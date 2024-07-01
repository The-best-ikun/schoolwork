package com.suep.demo06_25;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends Application {
    public static void main(String[] args) throws ClassNotFoundException {
        launch(args);
    }

    private static Stage stage;

    //    重写启动方法
    @Override
    public void start(Stage stage) throws Exception {
        Main.stage = stage;
        stage.setTitle("教务管理系统登录界面");
        changeView("admin/admin-index-right/student-crud-view.fxml");
    }

    //    写一个便于切换界面的方法
    public static void changeView(String fxml_url) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Main.class.getResource(fxml_url));
        } catch (IOException e) {

            throw new RuntimeException(e);

        }
        stage.setScene(new Scene(root));
        stage.show();
    }

    //    方法重载
    public static void changeView(String fxml_url, String userID) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Main.class.getResource(fxml_url));
        } catch (IOException e) {

            throw new RuntimeException(e);

        }
        stage.setScene(new Scene(root));
        stage.show();
    }
    public static void loadRightFXML(String fxmlPath, ScrollPane scrollPane) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxmlPath));
            Node pane = loader.load();
            // 清除旧的内容
            scrollPane.setContent(null);
            scrollPane.setContent(pane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
