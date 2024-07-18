package org.generation.italy.reshare.model.services.abstractions;

import org.generation.italy.reshare.exceptions.EntityNotFoundException;
import org.generation.italy.reshare.model.AppUser;
import org.generation.italy.reshare.model.Category;
import org.generation.italy.reshare.model.ItemType;

import java.util.List;
import java.util.Optional;

public interface WishlistService {
    boolean addItemTypeById(long userId, long itemTypeId) throws EntityNotFoundException;
    boolean removeItemTypeById(long userId, long itemTypeId) throws EntityNotFoundException;
    boolean clearWishlist(long userId);
    AppUser getUserById(long id) throws EntityNotFoundException;
    Optional<ItemType> getItemTypeById(long id);
    List<ItemType> getAllItemType();
    List<ItemType> getAllItemTypeByCategory(long id);
    List<ItemType> getAllItemTypeByCity(long id);
    boolean addItemType(long userId, ItemType itemType) throws EntityNotFoundException;
    List<ItemType> getWishlistByUserId(long id) throws EntityNotFoundException;
    Category findCategoryByName(String name);
}
