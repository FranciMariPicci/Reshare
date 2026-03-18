package org.generation.italy.reshare.model.services.abstractions;

import org.generation.italy.reshare.exceptions.EntityNotFoundException;
import org.generation.italy.reshare.model.AppUser;
import org.generation.italy.reshare.model.Category;
import org.generation.italy.reshare.model.City;
import org.generation.italy.reshare.model.Item;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ItemService {
    Item saveItem(Item item);

    Category findCategoryByName(String name);

    City findCityByName(String name);

    Item findItemById(long id) throws EntityNotFoundException;

    String saveItemCover(MultipartFile file) throws IOException;
}
