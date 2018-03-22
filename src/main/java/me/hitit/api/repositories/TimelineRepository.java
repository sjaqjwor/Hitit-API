package me.hitit.api.repositories;

import me.hitit.api.domains.Timeline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimelineRepository extends JpaRepository<Timeline, Long> {
    Timeline findByIdx(Long idx);
}
