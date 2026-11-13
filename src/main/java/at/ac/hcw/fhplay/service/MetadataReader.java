package at.ac.hcw.fhplay.service;
import at.ac.hcw.fhplay.model.Song;
import java.nio.file.Path;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

public class MetadataReader {
     // jaudiotagger schreibt sonst sehr viele Meldungen in die Konsole
    private static final Logger LIBRARY_LOG = Logger.getLogger("org.jaudiotagger");
    static {
        LIBRARY_LOG.setLevel(Level.OFF);
    }

    public Song read(Path file) {
        String fallbackTitle = titleFromFileName(file);
        try {
            AudioFile audio = AudioFileIO.read(file.toFile());
            Tag tag = audio.getTag();
            Duration duration = Duration.ofSeconds(audio.getAudioHeader().getTrackLength());

            String title = field(tag, FieldKey.TITLE);
            if (title.isBlank()) {
                title = fallbackTitle; // fehlende Tags -> Dateiname als Titel
            }
            return new Song(file, title, field(tag, FieldKey.ARTIST), field(tag, FieldKey.ALBUM), duration);
        } catch (Exception e) {
            // defekte Datei -> kein Absturz
            return new Song(file, fallbackTitle, "", "", Duration.ZERO);
        }
    }

    private String field(Tag tag, FieldKey key) {
        if (tag == null) {
            return "";
        }
        String value = tag.getFirst(key);
        return value == null ? "" : value.trim();
    }

    private String titleFromFileName(Path file) {
        String name = file.getFileName().toString();
        int dot = name.lastIndexOf('.');
        return dot > 0 ? name.substring(0, dot) : name;
    }
}
    

