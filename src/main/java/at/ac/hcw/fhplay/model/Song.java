package at.ac.hcw.fhplay.model;

import java.nio.file.Path;
import java.time.Duration;

/**
 * Ein Song in der Bibliothek.
 *
 * @param file     Pfad zur Audiodatei
 * @param title    Titel (aus den Metadaten, sonst Dateiname)
 * @param artist   Künstler, kann leer sein
 * @param album    Album, kann leer sein
 * @param duration Länge des Songs
 */
public record Song(Path file, String title, String artist, String album, Duration duration) {

    /** Dauer im Format m:ss, z. B. 3:07. */
    public String formattedDuration() {
        long seconds = duration.toSeconds();
        return String.format("%d:%02d", seconds / 60, seconds % 60);
    }
}
