package com.hero.finalsmartstudentportal.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.hero.finalsmartstudentportal.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label lblMessage;

    @FXML
    private void handleLogin() {
        String username = txtUsername.getText().trim();
        String password = txtPassword.getText().trim();

        // ✅ Empty field check
        if (username.isEmpty() || password.isEmpty()) {
            lblMessage.setText("⚠ Please enter username and password");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {

            if (conn == null) {
                lblMessage.setText("❌ Database connection failed!");
                return;
            }

            // ✅ Query user table
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // ✅ Login successful
                lblMessage.setText("✅ Login successful!");

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdminDashboard.fxml"));
                    Parent root = loader.load();

                    Stage stage = (Stage) txtUsername.getScene().getWindow();
                    stage.setScene(new Scene(root, 800, 600)); // bigger dashboard window
                    stage.setTitle("Smart Student Portal - Admin Dashboard");
                    stage.show();

                } catch (Exception e) {
                    e.printStackTrace();
                    lblMessage.setText("❌ Failed to load Dashboard: " + e.getMessage());
                }

            } else {
                lblMessage.setText("❌ Invalid username or password");
            }

        } catch (Exception e) {
            e.printStackTrace();
            lblMessage.setText("❌ Error occurred during login: " + e.getMessage());
        }
    }
}