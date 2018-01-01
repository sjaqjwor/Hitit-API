package me.hitit.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.hitit.api.domains.Hit;

@Repository
public interface HitRepository extends JpaRepository<Hit, Long> {

}