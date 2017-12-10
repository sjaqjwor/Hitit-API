package me.hitit.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.hitit.api.domains.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
