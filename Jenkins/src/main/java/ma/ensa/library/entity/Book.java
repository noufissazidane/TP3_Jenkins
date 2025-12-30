package ma.ensa.library.entity;

import jakarta.persistence.*;
import lombok.Data; // Génère getters/setters auto
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String genre;
    private boolean isAvailable = true; // Pour savoir si le livre est dispo
}