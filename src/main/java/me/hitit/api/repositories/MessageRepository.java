package me.hitit.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.hitit.api.domains.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{

}
