module com.hero.finalsmartstudentportal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    // Main package
    exports com.hero.finalsmartstudentportal;
    opens com.hero.finalsmartstudentportal to javafx.graphics, javafx.fxml;

    // Controller package
    exports com.hero.finalsmartstudentportal.controller;
    opens com.hero.finalsmartstudentportal.controller to javafx.fxml;

    // DB package
    exports com.hero.finalsmartstudentportal.db;
}