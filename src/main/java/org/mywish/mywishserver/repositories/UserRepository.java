package org.mywish.mywishserver.repositories;


import org.mywish.mywishserver.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
