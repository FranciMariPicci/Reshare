package org.generation.italy.reshare.model.repositories.abstractions;

import org.generation.italy.reshare.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
