package me.hitit.api.utils.location;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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