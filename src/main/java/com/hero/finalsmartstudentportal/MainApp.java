package com.hero.finalsmartstudentportal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.hero.finalsmartstudentportal.db.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.net.URL;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {

        // ------------------- Database connection test -------------------
        try (Connection conn = DBConnection.getConnection()) {
            System.out.println("✅ Database connected successfully!");
        } catch (SQLException e) {
            System.err.println("❌ Database connection failed!");
            e.printStackTrace();
            // DB connect না হলে অ্যাপ বন্ধ
            return;
        }

        // ------------------- Load Login.fxml -------------------
        try {
            URL fxmlLocation = getClass().getResource("/fxml/Login.fxml");
            if (fxmlLocation == null) {
                System.err.println("❌ Login.fxml not found!");
                System.err.println("👉 Ensure path: src/main/resources/fxml/Login.fxml");
                return;
            }

            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            Parent root = loader.load();

            Scene scene = new Scene(root, 1000, 650);

            stage.setTitle("Smart Student Portal");
            stage.setScene(scene);

            // ------------------- Window behavior -------------------
            stage.setResizable(true);       // Resizable
            stage.setMinWidth(900);         // Minimum width
            stage.setMinHeight(600);        // Minimum height
            stage.setMaximized(true);       // Start maximized

            stage.show();

        } catch (Exception e) {
            System.err.println("❌ Failed to load Login.fxml!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
