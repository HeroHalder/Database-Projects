package com.hero.finalsmartstudentportal.model;

import javafx.beans.property.SimpleBooleanProperty;

public class Settings {
    private final SimpleBooleanProperty darkMode;
    private final SimpleBooleanProperty notifications;

    public Settings(boolean darkMode, boolean notifications) {
        this.darkMode = new SimpleBooleanProperty(darkMode);
        this.notifications = new SimpleBooleanProperty(notifications);
    }

    public boolean isDarkMode() { return darkMode.get(); }
    public boolean isNotifications() { return notifications.get(); }

    public SimpleBooleanProperty darkModeProperty() { return darkMode; }
    public SimpleBooleanProperty notificationsProperty() { return notifications; }
}