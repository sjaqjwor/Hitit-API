package me.hitit.api.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coordinates {
    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;
}
