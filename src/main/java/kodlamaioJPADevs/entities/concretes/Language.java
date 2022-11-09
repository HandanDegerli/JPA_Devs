package kodlamaioJPADevs.entities.concretes;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "languages")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Language{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private int id;

    @Column(name="name")
    private String name;


    @OneToMany(mappedBy ="language")
    private List<Technology> technologies;

}
