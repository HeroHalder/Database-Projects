package com.hero.finalsmartstudentportal.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Teacher {
    private SimpleIntegerProperty teacherId;
    private SimpleStringProperty name;
    private SimpleStringProperty email;
    private SimpleStringProperty department;

    public Teacher(int teacherId, String name, String email, String department) {
        this.teacherId = new SimpleIntegerProperty(teacherId);
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
        this.department = new SimpleStringProperty(department);
    }

    public int getTeacherId() { return teacherId.get(); }
    public String getName() { return name.get(); }
    public String getEmail() { return email.get(); }
    public String getDepartment() { return department.get(); }
}
