package pl.ramzessoo.travelagency.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Length(max = 90)
    private String name;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @NotNull
    @Length(max = 5)
    private String standard;

    @NotNull
    @Length(max = 299)
    private String description;

}

