package me.hitit.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.hitit.api.domains.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long>{

}
