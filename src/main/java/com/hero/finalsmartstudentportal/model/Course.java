package com.hero.finalsmartstudentportal.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Course {
    private final SimpleIntegerProperty courseId;
    private final SimpleStringProperty courseName;
    private final SimpleIntegerProperty credit;
    private final SimpleIntegerProperty teacherId;

    public Course(int courseId, String courseName, int credit, int teacherId) {
        this.courseId = new SimpleIntegerProperty(courseId);
        this.courseName = new SimpleStringProperty(courseName);
        this.credit = new SimpleIntegerProperty(credit);
        this.teacherId = new SimpleIntegerProperty(teacherId);
    }

    // --- Getters ---
    public int getCourseId() { return courseId.get(); }
    public String getCourseName() { return courseName.get(); }
    public int getCredit() { return credit.get(); }
    public int getTeacherId() { return teacherId.get(); }

    // --- Property methods (needed for TableView binding) ---
    public SimpleIntegerProperty courseIdProperty() { return courseId; }
    public SimpleStringProperty courseNameProperty() { return courseName; }
    public SimpleIntegerProperty creditProperty() { return credit; }
    public SimpleIntegerProperty teacherIdProperty() { return teacherId; }
}