# DHBW.LHC_6439456
## Hinweis zum Ausführen
Da die Datenbank zu groß für das Repository ist, muss die `Configuration.java` wie folgt eingestellt sein:
```
21      public Boolean loadFromDataBase = false;
```
So versucht der **Detector** nicht die Daten aus der Datenbank zu laden, welche gerade noch nicht existiert.
Um die Datenbank zu Erstellen muss in der `Main.java` die Methode `createDB()` ausgeführt werden.

An den wichtigen Stellen (z.B. in den Tests und DataAnalyticsEngine) wird vor der Detector-Erstellung das Flag
zum Laden von der Datenbank auf `false` gesetzt, damit diese richtig durchlaufen.
