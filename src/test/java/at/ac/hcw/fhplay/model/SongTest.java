package at.ac.hcw.fhplay.model;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SongTest {

    private Song songWithDuration(Duration duration) {
        return new Song(Path.of("test.mp3"), "Titel", "Künstler", "Album", duration);
    }

    @Test
    void formattedDurationPadsSeconds() {
        assertEquals("3:07", songWithDuration(Duration.ofSeconds(187)).formattedDuration());
    }

    @Test
    void formattedDurationUnderOneMinute() {
        assertEquals("0:45", songWithDuration(Duration.ofSeconds(45)).formattedDuration());
    }

    @Test
    void formattedDurationOverOneHour() {
        assertEquals("61:00", songWithDuration(Duration.ofMinutes(61)).formattedDuration());
    }
}
