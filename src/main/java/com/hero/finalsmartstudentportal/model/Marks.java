package com.hero.finalsmartstudentportal.model;

import javafx.beans.property.SimpleIntegerProperty;

public class Marks {
    private SimpleIntegerProperty marksId;
    private SimpleIntegerProperty studentId;
    private SimpleIntegerProperty courseId;
    private SimpleIntegerProperty marks;

    public Marks(int marksId, int studentId, int courseId, int marks) {
        this.marksId = new SimpleIntegerProperty(marksId);
        this.studentId = new SimpleIntegerProperty(studentId);
        this.courseId = new SimpleIntegerProperty(courseId);
        this.marks = new SimpleIntegerProperty(marks);
    }

    public int getMarksId() { return marksId.get(); }
    public int getStudentId() { return studentId.get(); }
    public int getCourseId() { return courseId.get(); }
    public int getMarks() { return marks.get(); }
}
