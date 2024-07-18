package org.generation.italy.reshare.model.repositories.abstractions;

import org.generation.italy.reshare.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
