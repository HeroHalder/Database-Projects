package com.hero.finalsmartstudentportal.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {
    private final SimpleIntegerProperty studentId;
    private final SimpleStringProperty name;
    private final SimpleStringProperty department;
    private final SimpleStringProperty semester;
    private final SimpleStringProperty email;

    public Student(int studentId, String name, String department, String semester, String email) {
        this.studentId = new SimpleIntegerProperty(studentId);
        this.name = new SimpleStringProperty(name);
        this.department = new SimpleStringProperty(department);
        this.semester = new SimpleStringProperty(semester);
        this.email = new SimpleStringProperty(email);
    }

    // --- Getters ---
    public int getStudentId() { return studentId.get(); }
    public String getName() { return name.get(); }
    public String getDepartment() { return department.get(); }
    public String getSemester() { return semester.get(); }
    public String getEmail() { return email.get(); }

    // --- Property methods (needed for TableView binding) ---
    public SimpleIntegerProperty studentIdProperty() { return studentId; }
    public SimpleStringProperty nameProperty() { return name; }
    public SimpleStringProperty departmentProperty() { return department; }
    public SimpleStringProperty semesterProperty() { return semester; }
    public SimpleStringProperty emailProperty() { return email; }
}