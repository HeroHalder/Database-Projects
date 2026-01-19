package com.hero.finalsmartstudentportal.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Results {
    private final SimpleIntegerProperty id;
    private final SimpleIntegerProperty studentId;
    private final SimpleIntegerProperty courseId;
    private final SimpleStringProperty grade;

    public Results(int id, int studentId, int courseId, String grade) {
        this.id = new SimpleIntegerProperty(id);
        this.studentId = new SimpleIntegerProperty(studentId);
        this.courseId = new SimpleIntegerProperty(courseId);
        this.grade = new SimpleStringProperty(grade);
    }

    // --- Getters ---
    public int getId() { return id.get(); }
    public int getStudentId() { return studentId.get(); }
    public int getCourseId() { return courseId.get(); }
    public String getGrade() { return grade.get(); }

    // --- Property methods (needed for TableView binding) ---
    public SimpleIntegerProperty idProperty() { return id; }
    public SimpleIntegerProperty studentIdProperty() { return studentId; }
    public SimpleIntegerProperty courseIdProperty() { return courseId; }
    public SimpleStringProperty gradeProperty() { return grade; }
}