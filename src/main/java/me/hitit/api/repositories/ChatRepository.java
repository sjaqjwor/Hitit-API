package me.hitit.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.hitit.api.domains.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long> {

}
