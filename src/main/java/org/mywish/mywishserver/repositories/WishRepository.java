package org.mywish.mywishserver.repositories;

import org.mywish.mywishserver.entities.WishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishRepository extends JpaRepository<WishEntity, Long> {
}
