# Evaluation von API-Automatisierungsansätzen

Dieses Repository enthält das begleitende Beispielprojekt zur Bachelorarbeit "Ein Vergleich von Design-First- und Code-First-Ansätzen in der Entwicklung von Web-APIs".

## 1. Allgemeine Angaben (W-Fragen)

- **Was:** Prototypische Implementierung eines Bestandsmanagements zur qualitativen und quantitativen Evaluation der API-Entwicklungsansätze "Design-First" und "Code-First".
- **Wofür:** Untersuchung der Aufwandsverringerung bei API-Modifikationen durch automatisierte Toolchains.
- **Methode:** Kontrolliertes Software-Experiment mit zwei definierten Änderungsszenarien: Erweiterung des ArticleWDTO & optionaler Query-Parameter zur Filterung.
- **Sprache:** Deutsch (Dokumentation), Englisch (Quellcode).
- **Autor:** Sebastian Koch
- **Institution:** Hochschule für Technik und Wirtschaft (HTW) Berlin
- **Lizenz:** MIT-Lizenz

## 2. Technische Laufzeitumgebung (Werkzeuge & Versionen)

Um die Replizierbarkeit der Builds zu garantieren, wurden folgende Toolchains verwendet:

- **Betriebssystem:** Microsoft Windows 11 Home (Build 26200, v64-basiert)
- **Java SDK:** Oracle OpenJDK 17.0.2 (LTS)
- **Build-Tool:** Apache Maven 3.9.9
- **Framework Backend:** Spring Boot 3.5.16 (inkl. Spring Web, Lombok 1.18.46, MapStruct 1.6.3)
- **API-Spezifikation:** OpenAPI Specification 3.0.4 (Design-First) bzw. 3.0.1 (Code-First)
- **Codegenerierung:** OpenAPI-Generator 7.23.0
- **Spezifikationsgenerierung:** SpringDoc-OpenAPI 2.8.17

## 3. Projektstruktur
Das Repository ist in zwei isolierte Workflows unterteilt, um die Unabhängigkeit der Messungen zu garantieren:

- `/design-first`: Die vertragsgetriebene Implementierung
  - `/src/main/java/de/htwberlin/wi/designfirst`: Java-Dateien zur Implementierung der Design-First-API
    - `/article`: Domänen-Schicht für den Artikel mit API-Controller, Service, Mapper-Interface
      - `/articleCategory`: Artikelbezogenes Enum zur Kategorisierung inkl. Mapper-Interface
  - `/target/generated-sources`: Dateien, die während des Maven-Build generiert wurden
    - `/annotations/de/htwberlin/wi/designfirst/mapper`: Die durch MapStruct generierten Mapper-Implementierungen
    - `/openapi/src/main/java/de/htwberlin/wi/designfirst`: Die durch OpenAPI-Generator generierten Java-Dateien zur Verwendung in der Java-Implementierung
      - `/api`: Die APIs, als Interfaces. Getrennt nach Tags und zur Implementierung in den Java-API-Controllern
      - `/model`: Die WDTOs der API
- `/code-first`: Die codegetriebene Implementierung
  - `/src/main/java/de/htwberlin/wi/codefirst`: Java-Dateien zur Implementierung der Design-First-API
    - `/article`: Domänen-Schicht für den Artikel mit API-Controller, Service, Mapper-Interface sowie API-Interface und WDTO
      - `/articleCategory`: Artikelbezogenes Enum zur Kategorisierung inkl. Mapper-Interface sowie WDTO
  - `/target/generated-sources`: Dateien, die während des Maven-Build generiert wurden
    - `/annotations/de/htwberlin/wi/codefirst/mapper`: Die durch MapStruct generierten Mapper-Implementierungen
    - `/openapi`: Die durch SpringDoc-OpenAPI generierte API-Spezifikation
