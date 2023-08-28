package pl.ramzessoo.travelagency.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "airports")
public class Airport {
    @Id
    @Column(name = "IATA")
    private String iata;
    @NotNull
    private String name;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

}
