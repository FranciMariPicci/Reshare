package org.generation.italy.reshare.model.repositories.abstractions;

import org.generation.italy.reshare.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
