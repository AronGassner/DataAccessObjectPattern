module ch.bbw.basisgui {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;

    opens ch.bbw.jokedb to javafx.fxml;
    exports ch.bbw.jokedb;
}