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
- **Framework Backend:** Spring Boot 3.3.x (inkl. Spring Web, Lombok) <!-- TODO: genaue Version -->
- **Framework Frontend:** Angular 18.x.x <!-- TODO: genaue Version -->
- **API-Spezifikation:** OpenAPI Specification x.x.x <!-- TODO: genaue Version -->

## 3. Projektstruktur

- `/design-first`: Enthält die vertragsgetriebene Implementierung.
- `/code-first`: Enthält die codegetriebene Implementierung
