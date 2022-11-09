package kodlamaioJPADevs.entities.concretes;

import lombok.*;

import javax.persistence.*;

@Table (name = "technologies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Technology{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;
}
