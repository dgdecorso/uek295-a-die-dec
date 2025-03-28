package ch.noseryoung.uek295adiedec.domain.bookstore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

@Entity
public class Book {

    @Column(name = "id", nullable = false)

    @Id
    @GeneratedValue
    private UUID id;
    private  String title;
    private   String language;
    private double price;

    public Book(String title, String language, double price) {
        this.title = title;
        this.language = language;
        this.price = price;
        this.id = UUID.randomUUID();  // Assign a random UUID
    }
}
