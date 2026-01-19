package com.hero.finalsmartstudentportal.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import com.hero.finalsmartstudentportal.db.DBConnection;
import com.hero.finalsmartstudentportal.model.*;

import java.sql.Connection;
import java.sql.ResultSet;

public class AdminDashboardController {

    @FXML private VBox contentArea;
    @FXML private Label lblWelcome;
    @FXML private Button btnDashboard, btnStudents, btnCourses, btnResults, btnFees, btnNotices, btnSettings, btnLogout;

    // ------------------- Dashboard -------------------
    //------------Dashboard------------
    
    @FXML
    private void loadDashboard() {
    contentArea.getChildren().clear();

    VBox dashboardBox = new VBox(15);
    dashboardBox.setStyle("-fx-padding: 20; -fx-alignment: CENTER_LEFT;");

    Label lblTitle = new Label("📊 Admin Dashboard");
    lblTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
    contentArea.getChildren().clear();
    lblWelcome.setText("Welcome Admin 👋");
    Label lblCreator = new Label("Created and Controlled by Hero Halder");
    lblCreator.setStyle("-fx-font-size: 12px; -fx-text-fill: gray;");

    dashboardBox.getChildren().addAll(lblTitle, lblCreator);
    contentArea.getChildren().add(dashboardBox);
}

    // ------------------- Students -------------------
   @FXML
private void loadStudents() {
    contentArea.getChildren().clear();

    TableView<Student> table = new TableView<>();

    TableColumn<Student, Number> colId = new TableColumn<>("Student ID");
    colId.setCellValueFactory(cellData -> cellData.getValue().studentIdProperty());

    TableColumn<Student, String> colName = new TableColumn<>("Name");
    colName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

    TableColumn<Student, String> colDept = new TableColumn<>("Department");
    colDept.setCellValueFactory(cellData -> cellData.getValue().departmentProperty());

    TableColumn<Student, String> colSem = new TableColumn<>("Semester");
    colSem.setCellValueFactory(cellData -> cellData.getValue().semesterProperty());

    TableColumn<Student, String> colEmail = new TableColumn<>("Email");
    colEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

    table.getColumns().addAll(colId, colName, colDept, colSem, colEmail);
    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    ObservableList<Student> students = FXCollections.observableArrayList();

    try (Connection conn = DBConnection.getConnection()) {
        ResultSet rs = conn.createStatement().executeQuery(
            "SELECT student_id, name, department, semester, email FROM students"
        );
        while (rs.next()) {
            students.add(new Student(
                rs.getInt("student_id"),
                rs.getString("name"),
                rs.getString("department"),
                rs.getString("semester"),
                rs.getString("email")
            ));
        }
        System.out.println("Loaded students: " + students.size()); // Debug print
    } catch (Exception e) {
        showError("Failed to load students.");
        e.printStackTrace();
    }

    table.setItems(students);
    contentArea.getChildren().add(table);
}

    // ------------------- Courses -------------------
   @FXML
private void loadCourses() {
    contentArea.getChildren().clear();

    TableView<Course> table = new TableView<>();

    TableColumn<Course, Number> colId = new TableColumn<>("Course ID");
    colId.setCellValueFactory(cellData -> cellData.getValue().courseIdProperty());

    TableColumn<Course, String> colName = new TableColumn<>("Course Name");
    colName.setCellValueFactory(cellData -> cellData.getValue().courseNameProperty());

    TableColumn<Course, Number> colCredit = new TableColumn<>("Credit");
    colCredit.setCellValueFactory(cellData -> cellData.getValue().creditProperty());

    TableColumn<Course, Number> colTeacher = new TableColumn<>("Teacher ID");
    colTeacher.setCellValueFactory(cellData -> cellData.getValue().teacherIdProperty());

    table.getColumns().addAll(colId, colName, colCredit, colTeacher);
    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    ObservableList<Course> courses = FXCollections.observableArrayList();

    try (Connection conn = DBConnection.getConnection()) {
        ResultSet rs = conn.createStatement().executeQuery(
            "SELECT course_id, course_name, credit, teacher_id FROM courses"
        );
        while (rs.next()) {
            courses.add(new Course(
                rs.getInt("course_id"),
                rs.getString("course_name"),
                rs.getInt("credit"),
                rs.getInt("teacher_id")
            ));
        }
        System.out.println("Loaded courses: " + courses.size()); // Debug print
    } catch (Exception e) {
        showError("Failed to load courses.");
        e.printStackTrace();
    }

    table.setItems(courses);
    contentArea.getChildren().add(table);
}

    // ------------------- Results -------------------
   @FXML
private void loadResults() {
    contentArea.getChildren().clear();

    TableView<Results> table = new TableView<>();

    TableColumn<Results, Number> colId = new TableColumn<>("Result ID");
    colId.setCellValueFactory(cellData -> cellData.getValue().idProperty());

    TableColumn<Results, Number> colStudentId = new TableColumn<>("Student ID");
    colStudentId.setCellValueFactory(cellData -> cellData.getValue().studentIdProperty());

    TableColumn<Results, Number> colCourseId = new TableColumn<>("Course ID");
    colCourseId.setCellValueFactory(cellData -> cellData.getValue().courseIdProperty());

    TableColumn<Results, String> colGrade = new TableColumn<>("Grade");
    colGrade.setCellValueFactory(cellData -> cellData.getValue().gradeProperty());

    table.getColumns().addAll(colId, colStudentId, colCourseId, colGrade);
    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    ObservableList<Results> resultList = FXCollections.observableArrayList();

    try (Connection conn = DBConnection.getConnection()) {
        ResultSet rs = conn.createStatement().executeQuery(
            "SELECT id, student_id, course_id, grade FROM results"
        );
        while (rs.next()) {
            resultList.add(new Results(
                rs.getInt("id"),
                rs.getInt("student_id"),
                rs.getInt("course_id"),
                rs.getString("grade")
            ));
        }
        System.out.println("Loaded results: " + resultList.size()); // Debug print
    } catch (Exception e) {
        showError("Failed to load results.");
        e.printStackTrace();
    }

    table.setItems(resultList);
    contentArea.getChildren().add(table);
}

    // ------------------- Fees -------------------
    @FXML
private void loadFees() {
    contentArea.getChildren().clear();

    TableView<Fees> table = new TableView<>();

    TableColumn<Fees, Number> colId = new TableColumn<>("Fee ID");
    colId.setCellValueFactory(cellData -> cellData.getValue().idProperty());

    TableColumn<Fees, Number> colStudentId = new TableColumn<>("Student ID");
    colStudentId.setCellValueFactory(cellData -> cellData.getValue().studentIdProperty());

    TableColumn<Fees, Number> colAmount = new TableColumn<>("Amount");
    colAmount.setCellValueFactory(cellData -> cellData.getValue().amountProperty());

    TableColumn<Fees, String> colStatus = new TableColumn<>("Status");
    colStatus.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

    table.getColumns().addAll(colId, colStudentId, colAmount, colStatus);
    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    ObservableList<Fees> feesList = FXCollections.observableArrayList();

    try (Connection conn = DBConnection.getConnection()) {
        ResultSet rs = conn.createStatement().executeQuery(
            "SELECT id, student_id, amount, status FROM fees"
        );
        while (rs.next()) {
            feesList.add(new Fees(
                rs.getInt("id"),
                rs.getInt("student_id"),
                rs.getDouble("amount"),
                rs.getString("status")
            ));
        }
        System.out.println("Loaded fees: " + feesList.size()); // Debug print
    } catch (Exception e) {
        showError("Failed to load fees.");
        e.printStackTrace();
    }

    table.setItems(feesList);
    contentArea.getChildren().add(table);
}

    // ------------------- Notices -------------------
    @FXML
private void loadNotices() {
    contentArea.getChildren().clear();

    TableView<Notices> table = new TableView<>();

    TableColumn<Notices, Number> colId = new TableColumn<>("Notice ID");
    colId.setCellValueFactory(cellData -> cellData.getValue().idProperty());

    TableColumn<Notices, String> colTitle = new TableColumn<>("Title");
    colTitle.setCellValueFactory(cellData -> cellData.getValue().titleProperty());

    TableColumn<Notices, String> colMessage = new TableColumn<>("Message");
    colMessage.setCellValueFactory(cellData -> cellData.getValue().messageProperty());

    TableColumn<Notices, String> colCreated = new TableColumn<>("Created At");
    colCreated.setCellValueFactory(cellData -> cellData.getValue().createdAtProperty());

    table.getColumns().addAll(colId, colTitle, colMessage, colCreated);
    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    ObservableList<Notices> noticeList = FXCollections.observableArrayList();

    try (Connection conn = DBConnection.getConnection()) {
        ResultSet rs = conn.createStatement().executeQuery(
            "SELECT id, title, message, created_at FROM notices"
        );
        while (rs.next()) {
            noticeList.add(new Notices(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("message"),
                rs.getString("created_at")
            ));
        }
        System.out.println("Loaded notices: " + noticeList.size()); // Debug print
    } catch (Exception e) {
        showError("Failed to load notices.");
        e.printStackTrace();
    }

    table.setItems(noticeList);
    contentArea.getChildren().add(table);
}

    // ------------------- Settings -------------------
private void showInfo(String message) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Information");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
}

@FXML
private void loadSettings() {
    contentArea.getChildren().clear();

    lblWelcome.setText("⚙ Settings");

    VBox settingsBox = new VBox(10);
    settingsBox.setStyle("-fx-padding: 20; -fx-alignment: CENTER_LEFT;");

    Label lblTitle = new Label("Application Settings");
    lblTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

    // ✅ একবারই declare করো
    CheckBox darkMode = new CheckBox("Enable Dark Mode");
    CheckBox notifications = new CheckBox("Enable Notifications");

    darkMode.setOnAction(e -> {
        if (darkMode.isSelected()) {
            // Dark Mode CSS apply করো
            contentArea.getScene().getStylesheets().clear();
            contentArea.getScene().getStylesheets().add(
                getClass().getResource("/css/dark-theme.css").toExternalForm()
            );
        } else {
            // Light Mode CSS apply করো
            contentArea.getScene().getStylesheets().clear();
            contentArea.getScene().getStylesheets().add(
                getClass().getResource("/css/light-theme.css").toExternalForm()
            );
        }
    });

    Button btnSave = new Button("Save Settings");
    btnSave.setOnAction(e -> {
        showInfo("Settings saved successfully!");
    });

    settingsBox.getChildren().addAll(lblTitle, darkMode, notifications, btnSave);
    contentArea.getChildren().add(settingsBox);
}

    // ------------------- Logout -------------------
    @FXML
    private void handleLogout() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
            Parent loginRoot = loader.load();
            Stage stage = (Stage) contentArea.getScene().getWindow();
            stage.setScene(new Scene(loginRoot, 600, 400));
            stage.setTitle("Smart Student Portal - Login");
            stage.show();
        } catch (Exception e) {
            showError("Failed to logout.");
            e.printStackTrace();
        }
    }

    // ------------------- Utility -------------------
    private <T> TableColumn<T, ?> createColumn(String title, String property) {
        TableColumn<T, Object> col = new TableColumn<>(title);
        col.setCellValueFactory(new PropertyValueFactory<>(property));
        return col;
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
