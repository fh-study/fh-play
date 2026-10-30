package at.ac.hcw.fhplay.controller;

import at.ac.hcw.fhplay.model.Song;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Controller für das Hauptfenster (main-view.fxml).
 * Bibliothek, Wiedergabe usw. kommen in eigenen Tickets dazu.
 */
public class MainController {

    @FXML private TableView<Song> songTable;
    @FXML private TableColumn<Song, String> titleColumn;
    @FXML private TableColumn<Song, String> artistColumn;
    @FXML private TableColumn<Song, String> albumColumn;
    @FXML private TableColumn<Song, String> durationColumn;
    @FXML private Label nowPlayingLabel;

    @FXML
    private void initialize() {
        titleColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().title()));
        artistColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().artist()));
        albumColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().album()));
        durationColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().formattedDuration()));
        nowPlayingLabel.setText("Nichts wird abgespielt");
    }
}
