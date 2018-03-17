package me.hitit.api.repositories;

import me.hitit.api.domains.User;
import me.hitit.api.repositories.querydsls.interfaces.UserQuerydslInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserQuerydslInterface {
}
