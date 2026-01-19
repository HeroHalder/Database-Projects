package com.hero.finalsmartstudentportal.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Fees {
    private final SimpleIntegerProperty id;
    private final SimpleIntegerProperty studentId;
    private final SimpleDoubleProperty amount;
    private final SimpleStringProperty status;

    public Fees(int id, int studentId, double amount, String status) {
        this.id = new SimpleIntegerProperty(id);
        this.studentId = new SimpleIntegerProperty(studentId);
        this.amount = new SimpleDoubleProperty(amount);
        this.status = new SimpleStringProperty(status);
    }

    // --- Getters ---
    public int getId() { return id.get(); }
    public int getStudentId() { return studentId.get(); }
    public double getAmount() { return amount.get(); }
    public String getStatus() { return status.get(); }

    // --- Property methods (needed for TableView binding) ---
    public SimpleIntegerProperty idProperty() { return id; }
    public SimpleIntegerProperty studentIdProperty() { return studentId; }
    public SimpleDoubleProperty amountProperty() { return amount; }
    public SimpleStringProperty statusProperty() { return status; }
}