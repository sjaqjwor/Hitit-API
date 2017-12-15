package me.hitit.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.hitit.api.domains.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

}
