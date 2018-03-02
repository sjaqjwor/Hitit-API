package me.hitit.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.hitit.api.domains.Timeline;

@Repository
public interface TimelineRepository extends JpaRepository<Timeline, Long>{
    Timeline findByIdx(Long idx);
}
