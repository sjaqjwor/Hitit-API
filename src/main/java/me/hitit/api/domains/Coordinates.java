package me.hitit.api.domains;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Embeddable
@Data
@AllArgsConstructor
public class Coordinates {
	@Column(name = "latitude")
	private double latitude;

	@Column(name = "longitude")
	private double longitude;
}