# Evaluation von API-Automatisierungsansätzen

Dieses Repository enthält das begleitende Beispielprojekt zur Bachelorarbeit "Ein Vergleich von Design-First- und Code-First-Ansätzen in der Entwicklung von Web-APIs".

## 1. Allgemeine Angaben (W-Fragen)

- **Was:** Prototypische Implementierung eines Bestandsmanagements zur qualitativen und quantitativen Evaluation von API-Entwicklungsansätzen.
- **Wofür:** Untersuchung der Aufwandsverringerung bei API-Modifikationen durch automatisierte Toolchains.
- **Methode:** Kontrolliertes Software-Experiment mit definierten Änderungsszenarien.
- **Sprache:** Deutsch (Dokumentation), Englisch (Quellcode).
- **Autor:** Sebastian Koch
- **Lizenz:** MIT-Lizenz

## 2. Technische Laufzeitumgebung (Werkzeuge & Versionen)

Um die Replizierbarkeit der Builds zu garantieren, wurden folgende Toolchains verwendet:

- **Betriebssystem:** Microsoft Windows 11 Home (Build 26200, v64-basiert)
- **Java SDK:** Oracle OpenJDK 17.0.2 (LTS)
- **Build-Tool:** Apache Maven 3.9.9
- **Framework Backend:** Spring Boot 3.5.16 (inkl. Spring Web, Lombok 1.18.46, MapStruct 1.6.3)
- **Framework Frontend:** Angular 18.x.x <!-- TODO: genaue Version -->
- **API-Spezifikation:** OpenAPI Specification 3.0.4

## 3. Projektstruktur

- `/design-first`: Die vertragsgetriebene Implementierung
  - `/src/main/java/de/htwberlin/wi/designfirst`: Java-Dateien zur Implementierung der Design-First-API
    - `/article`: Domänen-Schicht für den Artikel mit Controller, Service etc.
      - `/articleCategory`: Artikelbezogenes Enum zur Kategorisierung
  - `/target/generated-sources`: Dateien, die während des Maven-Build generiert wurden
    - `/annotations/de/htwberlin/wi/designfirst/mapper`: Die durch MapStruct generierten Mapper-Implementierungen
    - `/openapi/src/main/java/de/htwberlin/wi/designfirst`: Die durch OpenAPI-Generator erstellten Java-Dateien zur Verwendung in der Java-Implementierung
      - `/api`: Die APIs, als Interfaces. Getrennt nach Tags und zur Implementierung in den Java-API-Controllern
      - `/model`: Die WDTOs der API
- `/code-first`: Die codegetriebene Implementierung
  - `/src/main/java/de/htwberlin/wi/codefirst`: Java-Dateien zur Implementierung der Design-First-API
