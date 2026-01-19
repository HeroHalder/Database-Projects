package com.hero.finalsmartstudentportal.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Attendance {
    private SimpleIntegerProperty attId;
    private SimpleIntegerProperty studentId;
    private SimpleIntegerProperty courseId;
    private SimpleStringProperty date;
    private SimpleStringProperty status;

    public Attendance(int attId, int studentId, int courseId, String date, String status) {
        this.attId = new SimpleIntegerProperty(attId);
        this.studentId = new SimpleIntegerProperty(studentId);
        this.courseId = new SimpleIntegerProperty(courseId);
        this.date = new SimpleStringProperty(date);
        this.status = new SimpleStringProperty(status);
    }

    public int getAttId() { return attId.get(); }
    public int getStudentId() { return studentId.get(); }
    public int getCourseId() { return courseId.get(); }
    public String getDate() { return date.get(); }
    public String getStatus() { return status.get(); }
}
