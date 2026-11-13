package at.ac.hcw.fhplay.controller;

import at.ac.hcw.fhplay.model.Song;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import java.util.Collection;
import javafx.scene.control.TableRow;
import java.util.function.Consumer;

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
    // Speichert die Songs für die Titelliste
private final ObservableList<Song> songs =
        FXCollections.observableArrayList();

        private Consumer<Song> onPlayRequested;

    @FXML
    private void initialize() {
        titleColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().title()));
        artistColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().artist()));
        albumColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().album()));
        durationColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().formattedDuration()));
        nowPlayingLabel.setText("Nichts wird abgespielt");
        // Songliste sortierbar machen
        SortedList<Song> sortedSongs = new SortedList<>(songs);

        sortedSongs.comparatorProperty().bind(
                songTable.comparatorProperty());

        songTable.setItems(sortedSongs);

        // Standardmäßig alphabetisch nach Titel sortieren
        titleColumn.setSortType(TableColumn.SortType.ASCENDING);
        songTable.getSortOrder().add(titleColumn);


        songTable.setRowFactory(table -> {
            TableRow<Song> row = new TableRow<>();

            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    Song selectedSong = row.getItem();

                    
                if (onPlayRequested != null) {
                    onPlayRequested.accept(selectedSong);
}

                }
            });

            return row;
        });


            }

            // Übernimmt importierte Songs in die Titelliste
        public void setSongs(Collection<Song> importedSongs) {
            songs.setAll(importedSongs);
}
        public void setOnPlayRequested(Consumer<Song> handler) {
            this.onPlayRequested = handler;
        }
}