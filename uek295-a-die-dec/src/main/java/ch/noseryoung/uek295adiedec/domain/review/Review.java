package ch.noseryoung.uek295adiedec.domain.review;

import ch.noseryoung.uek295adiedec.domain.bookstore.Book;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Review {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private int numStars;
    private String comment;
    private boolean isVerified;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;
}
