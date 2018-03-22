package me.hitit.api.repositories;

import me.hitit.api.domains.TimelineComment;
import me.hitit.api.repositories.querydsls.interfaces.TimelineCommentQuerydslInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimelineCommentRepository extends JpaRepository<TimelineComment, Long>,TimelineCommentQuerydslInterface{

}
