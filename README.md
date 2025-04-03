#  Bookstore API

Dies ist ein Java Spring Boot-Projekt, das eine einfache REST-API für die Verwaltung von Büchern und deren Bewertungen (Reviews) bereitstellt. Es wurde im Rahmen des Moduls üK 295, der Noser Young, entwickelt.

##  Projektziele

- Umsetzung einer CRUD-API mit Spring Boot
- Nutzung von PostgreSQL mit UUID als Primärschlüssel
- Zwei Entitäten: `Book` (vollständig) und `Review` (spezifisch)
- Validierung, Fehlerbehandlung und saubere REST-Struktur

---

##  Technologien

- Java 17+
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- PostgreSQL
- Jakarta Validation
- Lombok
- (optional) Swagger / OpenAPI
- Docker (Beispiel)
- Postman (Beispiel)

---

##  Setup

1. **PostgreSQL-Datenbank einrichten**
   - Erstelle eine Datenbank z. B. `bookstore`
   - Passe die `application.properties` an:
     ```
     spring.datasource.url=jdbc:postgresql://localhost:5432/bookstore
     spring.datasource.username=deinuser
     spring.datasource.password=deinpass
     spring.jpa.hibernate.ddl-auto=update
     ```

2. **Projekt starten**
   - `./mvnw spring-boot:run` oder über IDE starten

3. **Swagger UI (optional)**
   - Wenn eingebaut: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

##  API-Endpunkte (Auszug)

###  Bücher

| Methode | Pfad                | Beschreibung            |
|--------|---------------------|--------------------------|
| GET    | `/api/books`        | Alle Bücher abrufen      |
| GET    | `/api/books/{id}`   | Ein Buch nach ID         |
| POST   | `/api/books`        | Neues Buch erstellen     |
| PUT    | `/api/books/{id}`   | Buch aktualisieren       |
| DELETE | `/api/books/{id}`   | Buch löschen             |
| GET (Sortiert) | `/api/books/price/ascending`   | Bücher nach Preis sortieren             |

###  Bewertungen

| Methode | Pfad                          | Beschreibung                     |
|--------|-------------------------------|----------------------------------|
| GET    | `/api/books/reviews`          | Alle Reviews abrufen             |
| GET    | `/api/books/reviews/{id}`     | Einzelnes Review abrufen         |
| POST   | `/api/books/reviews`          | Neues Review hinzufügen          |
| POST   | `/api/books/{bookId}/reviews` | Review zu einem Buch hinzufügen  |
| PUT    | `/api/books/reviews/{id}`     | Review aktualisieren             |
| DELETE | `/api/books/reviews/{id}`     | Review löschen                   |

---

##  Validierung

- `Review.numStars`: nur Werte von **1 bis 10**
- Fehler werden als JSON-Objekt mit Feld → Fehlermeldung zurückgegeben

---

##  Fehlerbehandlung (Beispiel)

```json
{
  "numStars": "muss kleiner oder gleich 10 sein",
}
