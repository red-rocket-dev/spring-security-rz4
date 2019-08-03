package pl.sda.springsecurity.sectest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.springsecurity.sectest.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByLogin(String login);
}
