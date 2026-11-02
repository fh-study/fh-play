# fh-play

Lokaler Musik-Player im Stil von Spotify: Projekt der FH Gruppe 4 (Programmieren 1).

Die App spielt Musikdateien von der eigenen Festplatte ab. Streaming, Benutzerkonten und
Empfehlungen sind bewusst **nicht** Teil des Projekts (siehe User Story Map).

## Tech-Stack

| | |
|---|---|
| Sprache | Java 25 |
| GUI | JavaFX 25 (Controls, FXML, Media) |
| Build | Gradle (Wrapper liegt im Repo) |
| Tests | JUnit 5 |

## Starten

Voraussetzung: JDK 25 ist installiert. Gradle muss nicht installiert sein, der Wrapper lädt es selbst.

```bash
./gradlew run      # App starten (Windows: gradlew.bat run)
./gradlew test     # Tests ausführen
./gradlew build    # Kompilieren + Tests
```

In IntelliJ: Projekt öffnen → als Gradle-Projekt importieren → `Launcher` starten
oder den Gradle-Task `application > run` verwenden.

## Projektstruktur

```
src/main/java/at/ac/hcw/fhplay/
├── Launcher.java          Einstiegspunkt (main)
├── App.java               JavaFX-Application, lädt das Hauptfenster
├── controller/            FXML-Controller (UI-Logik)
├── model/                 Datenklassen (Song, Playlist, …)
└── service/               Logik ohne UI (Import, Player, Speichern, …)
src/main/resources/at/ac/hcw/fhplay/
├── main-view.fxml         Layout des Hauptfensters
└── style.css              Styles
src/test/java/…            JUnit-Tests
```

## Zusammenarbeit

**Board:** Alle Aufgaben sind Issues im Repo und liegen im
[Kanban-Board](https://github.com/orgs/fh-study/projects/1)
(Todo → In Progress → Review → Test → Done).

**Branches:**
- `main` ist immer lauffähig. Niemand pusht direkt auf `main`.
- Pro Issue ein Branch: `feature/<issue-nr>-<kurzname>`, z. B. `feature/5-play-pause`.
  Für Bugfixes `fix/<issue-nr>-<kurzname>`.

**Ablauf pro Ticket:**
1. Issue dir selbst zuweisen und auf *In Progress* ziehen.
2. Branch von aktuellem `main` erstellen: `git switch main && git pull && git switch -c feature/5-play-pause`
3. Kleine, sinnvolle Commits, z. B. `Play/Pause-Button eingebaut (#5)`.
4. Pull Request gegen `main` öffnen, im Text `Closes #5` schreiben → Ticket auf *Review*.
5. Mindestens eine andere Person reviewt und testet → *Test* → Merge → *Done*.

**Testmusik:** Musikdateien kommen **nie** ins Repo (Lizenzen). Jede Person legt sich
lokal einen Ordner `music/` im Projekt-Root an und kopiert dort ein paar Songs hinein,
z. B. lizenzfreie Musik von [Pixabay Music](https://pixabay.com/music/) oder
[Free Music Archive](https://freemusicarchive.org/). Der Ordner und alle Audiodateien
(`.mp3`, `.wav`, `.flac`, `.m4a`, `.ogg`) sind in der `.gitignore`. In der App wählt man
`music/` einfach beim Import aus.
