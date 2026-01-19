package com.hero.finalsmartstudentportal.model;

import javafx.beans.property.SimpleIntegerProperty;

public class Enrollment {
    private SimpleIntegerProperty enrollId;
    private SimpleIntegerProperty studentId;
    private SimpleIntegerProperty courseId;

    public Enrollment(int enrollId, int studentId, int courseId) {
        this.enrollId = new SimpleIntegerProperty(enrollId);
        this.studentId = new SimpleIntegerProperty(studentId);
        this.courseId = new SimpleIntegerProperty(courseId);
    }

    public int getEnrollId() { return enrollId.get(); }
    public int getStudentId() { return studentId.get(); }
    public int getCourseId() { return courseId.get(); }
}
