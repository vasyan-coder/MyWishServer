package org.mywish.mywishserver.repositories;

import org.mywish.mywishserver.entities.WishlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<WishlistEntity, Long> {
}
