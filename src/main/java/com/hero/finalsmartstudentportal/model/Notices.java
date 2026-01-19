package com.hero.finalsmartstudentportal.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Notices {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty title;
    private final SimpleStringProperty message;
    private final SimpleStringProperty createdAt;

    public Notices(int id, String title, String message, String createdAt) {
        this.id = new SimpleIntegerProperty(id);
        this.title = new SimpleStringProperty(title);
        this.message = new SimpleStringProperty(message);
        this.createdAt = new SimpleStringProperty(createdAt);
    }

    // --- Getters ---
    public int getId() { return id.get(); }
    public String getTitle() { return title.get(); }
    public String getMessage() { return message.get(); }
    public String getCreatedAt() { return createdAt.get(); }

    // --- Property methods (needed for TableView binding) ---
    public SimpleIntegerProperty idProperty() { return id; }
    public SimpleStringProperty titleProperty() { return title; }
    public SimpleStringProperty messageProperty() { return message; }
    public SimpleStringProperty createdAtProperty() { return createdAt; }
}